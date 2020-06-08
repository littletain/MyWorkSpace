package org.example.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.dao.IUserDao;
import org.example.domain.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * mybatis入门案例
 */
public class MybatisTest1 {
    public static void main(String[] args) throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession session = factory.openSession();
        IUserDao mapper = session.getMapper(org.example.dao.IUserDao.class);
        List<User> users = mapper.findall();
        for (User user : users) {
            System.out.println(user);
        }
        in.close();
        session.close();

    }
}
