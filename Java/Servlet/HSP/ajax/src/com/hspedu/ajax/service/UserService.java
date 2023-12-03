package com.hspedu.ajax.service;


import com.hspedu.ajax.dao.UserDAO;
import com.hspedu.ajax.entity.User;

/*
老韩解读 UserService 提供业务方法
，比如 getUserByName
 */
public class UserService {

    //属性userDao, 方便操作数据库
    private UserDAO userDAO = new UserDAO();

    public User getUserByName(String username) {
        //这里老师在讲解jdbc 和 满汉楼时，说的非常清楚.
        User user = userDAO.querySingle
                ("select * from `user` where username=?", User.class, username);
        return user;
    }
}
