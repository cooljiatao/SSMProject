package me.jiatao.ssm.mybatis.A_Simple;

import me.jiatao.ssm.mybatis.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class HelloMybatis {
    public static void main(String[] args) throws IOException {

        /**
         * 1、创建配置文件，mybatis-config , mapper.xml
         * 2、构建sqlSessionFactory
         * 3、获取sqlsession对象
         * 4、通过sqlsession 去执行crud操作
         * 5、提交事务。
         * 6、关闭sqlSession
         */


        String resource = "mybatis-config.xml";//指定全局配置文件的路径
        //默认会从classes目录去寻找配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        System.out.println(sqlSessionFactory);
        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        System.out.println(sqlSession);

        //sqlSession.selectOne("sql的id", "sql中需要的参数");
        //sql的id的书写方式：名称空间.statment的id
        User user = sqlSession.selectOne("abc.selectUser",1l);
        System.out.println(user);

        //关闭session
        sqlSession.close();
    }
}
