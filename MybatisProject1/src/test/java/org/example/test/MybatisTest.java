package org.example.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.dao.IUserDao;
import org.example.domain.QueryVo;
import org.example.domain.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * mybatis入门案例
 */
public class MybatisTest {

    private SqlSession session = null;
    private InputStream in = null;
    private IUserDao userDao;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        userDao = session.getMapper(org.example.dao.IUserDao.class);
    }
    @After
    public void destory() throws IOException {
        session.commit();
        session.close();
        in.close();
    }

    @Test
    public void findallTest(){
        List<User> users = userDao.findall();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void saveUserTest(){
        User user = new User();
        user.setUsername("wtybill");
        user.setSex("男");
        user.setAddress("美国");
        user.setBirthday(new Date());
        System.out.println("新增前："+user);
        userDao.saveUser(user);
        System.out.println("新增后："+user);
    }

    @Test
    public void updateUserTest(){
        User user = new User();
        user.setId(7);
        user.setBirthday(new Date());
        user.setUsername("老王");
        user.setAddress("加拿大");
        user.setSex("男");
        userDao.updateUser(user);
    }

    @Test
    public void deleteUserTest(){
        Integer id = 5;
        userDao.deleteUser(id);
    }

    @Test
    public void findByNameTest(){
        String name = "%王%";//模糊查询，sql语法是like #{}，正则详情百度
        List<User> users = userDao.findByName(name);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void findUserByVoTest(){
        String name = "%王%";
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUsername(name);
        vo.setUser(user);
        List<User> users = userDao.findUserByVo(vo);
        for (User user1 : users) {
            System.out.println(user1);
        }
    }

    @Test
    public void findByConditionTest(){
        User u = new User();
        u.setUsername("方丈");
        u.setSex("男");
        List<User> users = userDao.findByCondition(u);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void findUserIdsTest(){
        QueryVo vo = new QueryVo();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        vo.setIds(ids);
        List<User> users = userDao.findUserIds(vo);
        for (User user : users) {
            System.out.println(user);
        }
    }
}
