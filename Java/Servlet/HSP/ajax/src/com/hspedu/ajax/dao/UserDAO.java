package com.hspedu.ajax.dao;

import com.hspedu.ajax.entity.User;

//老韩解读
//我们的UserDAO 继承 BaiscDAO , 并指定了User
//这时我们就可以使用BasicDAO 中的方法.
public class UserDAO extends BasicDAO<User> {
}
