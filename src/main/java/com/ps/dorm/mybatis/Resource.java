package com.ps.dorm.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;


public class Resource {

    private static Reader reader;
    private static SqlSessionFactory sqlSessionFactory;
    static SqlSession sq;
    private Resource(){
        try {
            reader=Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static Resource re=null;

    public static SqlSession  resource(){
        if(re==null){
            synchronized (Resource.class){
                if(re==null){
                    re=new Resource();
                    sq= sqlSessionFactory.openSession();
                }
            }
        }
        return sq;
    }


}
