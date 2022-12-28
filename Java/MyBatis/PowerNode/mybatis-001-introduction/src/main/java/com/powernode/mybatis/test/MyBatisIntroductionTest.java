package com.powernode.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class MyBatisIntroductionTest {
    public static void main(String[] args) throws IOException {

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        var is = Resources.getResourceAsStream("mybatis-config.xml");
        var factory = builder.build(is);

        SqlSession sqlSession = factory.openSession();
        int insertCar = sqlSession.insert("insertCar");

        sqlSession.commit();

        System.out.println("insert count: " + insertCar);
    }

}
