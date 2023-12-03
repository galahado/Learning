package com.hspedu.ajax.entity;

/**
 * User类就是一个javabean/pojo/entity/domain
 */
public class User {
    private Integer id;
    private String username;
    private String pwd;
    private String email;

    //必须提供一个无参构造器, 是给我们的反射使用

    public User() {
    }

    public User(Integer id, String username, String pwd, String email) {
        this.id = id;
        this.username = username;
        this.pwd = pwd;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
