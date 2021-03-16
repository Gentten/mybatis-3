package org.gentten.mybatis.learning.domain;


import java.io.Serializable;
import java.util.List;

/**
 * 角色一个角色对应多个用户
 *
 * @author : duanzhiqiang
 * @date : 2021-03-08 21:11
 */

public class Role implements Serializable {

  private String id;

  private String name;

  private String roleDsc;

  List<User> roleUsers;

  public Role() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getRoleDsc() {
    return roleDsc;
  }

  public void setRoleDsc(String roleDsc) {
    this.roleDsc = roleDsc;
  }

  public List<User> getRoleUsers() {
    return roleUsers;
  }

  public void setRoleUsers(List<User> roleUsers) {
    this.roleUsers = roleUsers;
  }

  @Override
  public String toString() {
    return "Role{" +
      "id='" + id + '\'' +
      ", name='" + name + '\'' +
      ", roleDsc='" + roleDsc + '\'' +
      ", roleUsers=" + roleUsers +
      '}';
  }
}
