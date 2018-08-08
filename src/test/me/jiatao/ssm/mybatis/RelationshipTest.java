package me.jiatao.ssm.mybatis;

import me.jiatao.ssm.mybatis.C_Relationship.OrderMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

public class RelationshipTest {

    OrderMapper orderMapper;
    SqlSession sqlSession ;
    SqlSessionFactory sqlSessionFactory ;

    @Before
    public void setUp() throws Exception {
        //获取到mapper的动态代理实现类
        String resource = "mybatis-config.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        sqlSession = sqlSessionFactory.openSession();
        orderMapper = sqlSession.getMapper(OrderMapper.class);
    }

    @Test
    public void testQueryOrderAndUserByOrderNumber() {
        Order order =this.orderMapper.queryOrderAndUserByOrderNumber("20140921001");
        System.out.println(order);
    }

    @Test
    public void queryOrderAndUserAndDetailByOrderNumber() {
        Order order =this.orderMapper.queryOrderAndUserAndDetailByOrderNumber("20140921001");
        System.out.println(order);
    }

    @Test
    public void queryOrderAndUserAndDetailAndItemByOrderNumber() {
        Order order =this.orderMapper.queryOrderAndUserAndDetailAndItemByOrderNumber("20140921001");
        System.out.println(order);
    }
    @Test
    public void queryOrderAndUserLazy(){
		/*Order order =this.orderMapper.queryOrderAndUserLazy("20140921001");
		System.out.println("=============================");
		User user = order.getUser();*/
        Order order =new Order();
        order.getUser();
    }
}