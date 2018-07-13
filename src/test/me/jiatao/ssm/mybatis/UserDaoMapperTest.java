package me.jiatao.ssm.mybatis;

import me.jiatao.ssm.mybatis.B_CURD.IUserDao;
import me.jiatao.ssm.mybatis.B_CURD.UserDaoImpl;
import me.jiatao.ssm.mybatis.B_Mapper.UserDaoMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Date;
import java.util.List;

public class UserDaoMapperTest {
    UserDaoMapper userDaoMapper;
    SqlSession sqlSession;

    @Before //在执行Test方法之前执行该方法
    public void setUp() throws Exception {

        //1、得到SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        //2、得到sqlSession
        sqlSession = sqlSessionFactory.openSession();

        //3.通过sqlSession获取mapper的动态代理类
        userDaoMapper = sqlSession.getMapper(UserDaoMapper.class);

        /**
         *  Mapper接口开发需要遵循以下规范：
         *  1、 Mapper.xml文件中的namespace与mapper接口的类路径相同。
         *  2、 Mapper接口方法名和Mapper.xml中定义的每个statement的id相同
         *  3、 Mapper接口方法的输入参数类型和mapper.xml中定义的每个sql 的parameterType的类型相同
         *  4、 Mapper接口方法的输出参数类型和mapper.xml中定义的每个sql的resultType的类型相同
         *
         */
    }

    @Test
    public void testQueryAllUser() {
        List<User> users = this.userDaoMapper.queryAllUser();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testQueryUserById() {
        User user = userDaoMapper.queryUserById(2l);
        System.out.println(user);
    }

    /**
     * 插入操作
     */
    @Test
    public void testSaveUser() {
        User user = new User();
        user.setAge(18);
        user.setBirthday(new Date(System.currentTimeMillis()));
        user.setName("妞儿2");
        user.setPassword("123456");
        user.setSex(1);
        user.setUserName("你好2");
        userDaoMapper.saveUser(user);
        sqlSession.commit();

        System.out.println(user.getId());
    }

    /**
     * 更新操作
     */
    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setId(9l);
        user.setName("宝宝");
        //TODO 先查询在修改
        userDaoMapper.updateUser(user);
        sqlSession.commit();
    }

    /**
     * 删除测试
     */
    @Test
    public void testDeleteUserById() {
        userDaoMapper.deleteUserById(8l);
        sqlSession.commit();
    }

    /**
     * 返回 int 类型
     */
    @Test
    public void testQueryCount() {
        Integer count = userDaoMapper.queryCount();
        System.out.println(count);
    }


    /**
     * 使用 #{ } 传递参数
     */
    @Test
    public void testWhere() {
        User user = userDaoMapper.selectByNameAndAge("zhangsan", 30);
        System.out.println(user);
    }


    /**
     * 使用 ${ } 拼接字符串
     */
    @Test
    public void testQueryUserByTableName() {
        List<User> users = userDaoMapper.queryUserByTableName("tb_user");
        for (User user : users) {
            System.out.println(user);
        }
    }


    /**
     * 自定义resultMap
     * 用于解析数据库字段 与 jave属性
     */
    @Test
    public void testQueryAllUserUseResultMap() {
        List<User> users = this.userDaoMapper.queryAllUserUseResultMap();
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 使用本地预定于sql
     */
    @Test
    public void testQueryAllUserUseSql() {
        List<User> users = this.userDaoMapper.queryAllUserUseSQL();
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 引入外部sql
     */
    @Test
    public void testQueryAllUserUseSql2() {
        List<User> users = this.userDaoMapper.queryAllUserUseSQL2();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
