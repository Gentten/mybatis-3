package org.gentten.mybatis.learning.domain;


import java.io.Serializable;
import java.util.List;

/**
 * 用户
 *
 * @author : duanzhiqiang
 * @date : 2021-03-08 21:11
 */

public class User implements Serializable {

  private String id;

  private String name;

  private List<Role> roles;

  public User() {
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

  public List<Role> getRoles() {
    return roles;
  }

  public void setRoles(List<Role> roles) {
    this.roles = roles;
  }

  @Override
  public String toString() {
    return "User{" +
      "id='" + id + '\'' +
      ", name='" + name + '\'' +
      ", roles=" + roles +
      '}';
  }
}
