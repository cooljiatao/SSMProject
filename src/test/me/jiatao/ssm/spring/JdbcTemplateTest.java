package me.jiatao.ssm.spring;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcTemplateTest {
    @Test
    public void test(){
        //目标：使用jdbctemplate执行一段sql
        //1.构建数据源
        //spring内置了一个数据源
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///student");
        dataSource.setUsername("root");
        dataSource.setPassword("jia");

        //2.创建jdbctemplate实例
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        //等同于
//		jdbcTemplate.setDataSource(dataSource)

        //3.执行sql，创建表test001
        jdbcTemplate.execute("create table test001(id int,name varchar(20))");

    }
}
