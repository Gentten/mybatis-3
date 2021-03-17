/**
 * Copyright 2009-2019 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.ibatis.binding;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.ibatis.binding.MapperProxy.MapperMethodInvoker;
import org.apache.ibatis.session.SqlSession;

/**
 * 每个mapper的动态代理工厂
 * MapperProxyFactory 创建 Mapper的JDK动态代理  MapperProxy则是mapper动态代理增强逻辑
 *
 * @author Lasse Voss
 */
public class MapperProxyFactory<T> {
  /**
   * mapper 接口类
   */
  private final Class<T> mapperInterface;

  /**
   * 每个方法对应MapperMethodInvoker 缓存 线程安全 mapper 即同一个MapperProxyFactory 共用一个methodCache
   * 在每个mapperProxy 更新缓存
   */
  private final Map<Method, MapperMethodInvoker> methodCache = new ConcurrentHashMap<>();

  public MapperProxyFactory(Class<T> mapperInterface) {
    this.mapperInterface = mapperInterface;
  }

  public Class<T> getMapperInterface() {
    return mapperInterface;
  }

  public Map<Method, MapperMethodInvoker> getMethodCache() {
    return methodCache;
  }

  @SuppressWarnings("unchecked")
  protected T newInstance(MapperProxy<T> mapperProxy) {
    return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[]{mapperInterface}, mapperProxy);
  }

  /**
   * 创建动态代理对象  需要sqlSession去执行
   *
   * @param sqlSession 需要sqlSession
   * @return mapper动态代理对象
   */
  public T newInstance(SqlSession sqlSession) {
    //独立
    //创建代理增强类 注意此处传递了methodCache 也就是后面创建的MapperProxy 公用用缓存 且由mapperProxy去更新缓存
    final MapperProxy<T> mapperProxy = new MapperProxy<>(sqlSession, mapperInterface, methodCache);
    return newInstance(mapperProxy);
  }

}
