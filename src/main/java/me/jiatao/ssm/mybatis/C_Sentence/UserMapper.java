package me.jiatao.ssm.mybatis.C_Sentence;

import java.util.List;

import me.jiatao.ssm.mybatis.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

	public List<User> queryAllUser();
	
	/**
	 * 需求1：查询男性用户，如果输入了姓名，进行模糊查找。
	 * select * from tb_user where sex = 1
	 * select * from tb_user where sex = 1 and name like '%?%'
	 */
	public List<User> queryUserLikeName(@Param("name") String name);
	/**
	 * 查询男性用户，如果输入了姓名则按照姓名模糊查找，否则如果输入了年龄则按照年龄查找。  如果两个都输入，按照年龄查找
	 */
	public List<User> queryUserLikeNameOrAge(@Param("name") String name, @Param("age") Integer age);
	/**
	 * 练习：查询所有用户，如果输入了姓名按照姓名进行模糊查询，如果输入年龄，按照年龄进行查询。
	 * 两个条件 不互斥。
	 * @return
	 */
	public List<User> queryUserLikeNameOrAge2(@Param("name") String name, @Param("age") Integer age);
	
	/**
	 * 根据用户id修改用户信息，如果User中的某个字段是null 不进行修改
	 */
	public void updateUser(User user);
	/**
	 * 按照多个id查询用户信息
	 */
	public List<User> queryUserByIds(@Param("ids") List<Long> ids);
}
