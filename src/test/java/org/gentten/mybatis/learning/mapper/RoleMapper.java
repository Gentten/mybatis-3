package org.gentten.mybatis.learning.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.gentten.mybatis.learning.domain.Role;

/**
 * 用户mapper
 *
 * @author : duanzhiqiang
 * @date : 2021-03-08 21:32
 */
@Mapper
public interface RoleMapper {


  /**
   * 查询某一个
   *
   * @param id 用户id
   * @return User
   */
  Role findById(String id);
}
