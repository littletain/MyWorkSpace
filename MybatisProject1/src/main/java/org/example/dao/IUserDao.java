package org.example.dao;

import org.example.domain.QueryVo;
import org.example.domain.User;

import java.util.List;

/**
 * 用户的持久层接口
 */
public interface IUserDao {
    /**
     * 查询所有操作
     * @return
     */
    public List<User> findall();
    public void saveUser(User user);
    public void updateUser(User user);
    public void deleteUser(Integer id);
    public List<User> findByName(String name);
    public List<User> findUserByVo(QueryVo vo);
}
