package me.jiatao.ssm.mybatis;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import me.jiatao.ssm.mybatis.C_Sentence.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class SentenceMapperTest {
    UserMapper userMapper;
    SqlSession sqlSession ;
    SqlSessionFactory sqlSessionFactory ;

    @Before
    public void setUp() throws Exception {
        //获取到mapper的动态代理实现类
        String resource = "mybatis-config.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        sqlSession = sqlSessionFactory.openSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void testQueryAll(){

        //在需要分页的查询之前书写

        /**
         * 注意问题：
         * 1、分页只有在PageHelper.startPage 第一个查询才会开启
         */

        /**
         * 第一个参数，标识当前页
         * 第二个参数：每页记录数
         */
        PageHelper.startPage(3, 5);
        List<User> users = this.userMapper.queryAllUser();
        for(User user : users){
            System.out.println(user);
        }
        //可以获取更多的分页信息，例如总计路数，总页数
        //pageInfo包含了分页需要的绝大多数数据
        PageInfo<User> pageInfo = new PageInfo<User>(users);

        System.out.println("最后一页的页数：" +pageInfo.getLastPage());
        System.out.println("总页数：" + pageInfo.getPages());
        System.out.println("每页最大记录数：" + pageInfo.getPageSize());
        System.out.println("总计路数：" + pageInfo.getTotal());
        System.out.println("当前页的实际记录数" + pageInfo.getSize());
        pageInfo.getList();
    }

    @Test
    public void testqueryUserLikeName(){
        List<User> users = this.userMapper.queryUserLikeName("%张%");
        for(User user : users){
            System.out.println(user);
        }


        List<User> users2 = this.userMapper.queryUserLikeName("%张1%");
        for(User user1 : users2){
            System.out.println(user1);
        }
    }
    @Test
    public void testqueryUserLikeNameOrAge(){
        List<User> users = this.userMapper.queryUserLikeNameOrAge(null,19);
        for(User user : users){
            System.out.println(user);
        }
    }

    @Test
    public void testqueryUserLikeNameOrAge2(){
        List<User> users = this.userMapper.queryUserLikeNameOrAge2(null,null);
        for(User user : users){
            System.out.println(user);
        }
    }

    @Test
    public void testUpdateUser(){
		/*User user = new User();
		user.setName("张三");
		user.setPassword(null);
		user.setUserName("zhangsanna");

		user.setId(15l);
		this.userMapper.updateUser(user);
		this.sqlSession.commit();*/
    }

    @Test
    public void testqueryIds(){
        List<Long> ids = new ArrayList<Long>();
        ids.add(1l);
        ids.add(2l);
        List<User> users = this.userMapper.queryUserByIds(ids);
        for(User user : users){
            System.out.println(user);
        }
    }

}