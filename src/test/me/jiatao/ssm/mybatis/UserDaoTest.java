package me.jiatao.ssm.mybatis;

import me.jiatao.ssm.mybatis.B_CURD.IUserDao;
import me.jiatao.ssm.mybatis.B_CURD.UserDaoImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Date;
import java.util.List;

public class UserDaoTest {
    IUserDao userDao;
    SqlSession sqlSession;

    @Before //在执行Test方法之前执行该方法
    public void setUp() throws Exception {

        //1、得到SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //2、得到sqlSession
        sqlSession = sqlSessionFactory.openSession();
        userDao = new UserDaoImpl(sqlSession);
    }

    @Test
    public void testQueryAllUser() {
        List<User> users = this.userDao.queryAllUser();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testQueryUserById() {
        User user = userDao.queryUserById(2l);
        System.out.println(user);
    }

    @Test
    public void testSaveUser() {
        User user = new User();
        user.setAge(18);
        user.setBirthday(new Date(System.currentTimeMillis()));
        user.setName("妞儿");
        user.setPassword("123456");
        user.setSex(1);
        user.setUserName("你好1");
        userDao.saveUser(user);
        sqlSession.commit();
    }

    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setId(9l);
        user.setName("宝宝");
        //TODO 先查询在修改
        userDao.updateUser(user);
        sqlSession.commit();
    }

    @Test
    public void testDeleteUserById() {
        userDao.deleteUserById(8l);
        sqlSession.commit();
    }

}
