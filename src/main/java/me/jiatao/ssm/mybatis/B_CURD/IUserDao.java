package me.jiatao.ssm.mybatis.B_CURD;

import me.jiatao.ssm.mybatis.User;

import java.util.List;

public interface IUserDao {
    /**
     *  查询所有用户信息
     */
    public List<User> queryAllUser();

    /**
     * 根据id查询用户信息
     *
     */
    public User queryUserById(Long id);

    /**
     * 添加用户信息
     */
    public void saveUser(User user);

    /**
     * 修改用户信息,根据id修改用户信息
     */
    public void updateUser(User user);

    /**
     * 根据id删除用户信息
     * @param id
     */
    public void deleteUserById(Long id);

}
