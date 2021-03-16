package org.gentten.mybatis.learning.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.gentten.mybatis.learning.domain.User;

/**
 * 用户mapper
 *
 * @author : duanzhiqiang
 * @date : 2021-03-08 21:32
 */
@Mapper
public interface UserMapper {


  /**
   * 查询某一个
   *
   * @param id 用户id
   * @return User
   */
  @Options(useCache = true, flushCache = Options.FlushCachePolicy.FALSE)
  User findById(String id);

  /***
   * 更新 用户 by id
   * @param id id
   * @param user 用户
   */
  @Update("update user set  name =#{user.name} where id =#{id}")
  void updateById(@Param("id") String id, @Param("user") User user);
}
