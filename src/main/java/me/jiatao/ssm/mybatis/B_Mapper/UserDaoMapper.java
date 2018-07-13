package me.jiatao.ssm.mybatis.B_Mapper;

import me.jiatao.ssm.mybatis.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDaoMapper {
    /**
     * 查询所有用户信息
     */
    public List<User> queryAllUser();

    /**
     * 根据id查询用户信息
     */
    public User queryUserById(Long id);

    /**
     * 添加用户信息
     * <p>
     * 如果需要数据库影响的行数，可以直接在接口上定义返回值integer 即可
     */
    public Integer saveUser(User user);

    /**
     * 修改用户信息,根据id修改用户信息
     */
    public void updateUser(User user);

    /**
     * 根据id删除用户信息
     *
     * @param id
     */
    public void deleteUserById(Long id);

    /**
     * 查询用户总量
     *
     * @return
     */
    Integer queryCount();

    User selectByNameAndAge(@Param("userName") String userName, @Param("age") int age);

    List<User> queryUserByTableName(@Param("tableName") String tableName);
}
