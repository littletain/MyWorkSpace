package dao;

import org.example.dao.JdbcUserDao;
import org.example.dao.JdbcUserDao1;
import org.example.domain.User;
import org.junit.Test;

public class JdbcJdbcUserDaoTest {
    @Test
    public void work(){
        String userName = "zhangsan";
        String password = "123";
        //JdbcUserDao userDao = new JdbcUserDao();
        //User user = userDao.login(userName,password);
        User user = JdbcUserDao1.login(userName,password);
        System.out.println(user.toString());
    }
}
