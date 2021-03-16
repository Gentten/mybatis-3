package org.gentten.mybatis.learning;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.gentten.mybatis.learning.domain.User;
import org.gentten.mybatis.learning.mapper.UserMapper;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author : duanzhiqiang
 * @date : 2021-03-16 22:33
 */
public class MybatisTest {
  SqlSessionFactory sqlSessionFactory;
  SqlSession sqlSession;

  @Before
  public void init() throws IOException {
    InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
    sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    sqlSession = sqlSessionFactory.openSession();
  }


  @Test
  public void cache1Find() throws Exception {
    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
    User byId = userMapper.findById("123");
    System.out.println(byId);

    User byId2 = userMapper.findById("123");
    System.out.println(byId);
    //结果返回true 且日志只有一条查询语句  证明第二次查询时拿缓存
    System.out.println(byId2 == byId);
    //一级缓存 key statementId、params、rowBounds、BoundSql
  }
}
