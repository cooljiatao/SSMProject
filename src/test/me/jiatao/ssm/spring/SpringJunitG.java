package me.jiatao.ssm.spring;


import me.jiatao.ssm.spring.F_JdbcTemplate.Book;
import me.jiatao.ssm.spring.F_JdbcTemplate.BookDao;
import me.jiatao.ssm.spring.G_TransactionXml.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

//目标：测试一下spring的bean的某些功能

//junit整合spring的测试
// 立马开启了spring的注解
@RunWith(SpringJUnit4ClassRunner.class)
//加载核心配置文件，自动构建spring容器
@ContextConfiguration(locations = "classpath:applicationContextG.xml")
public class SpringJunitG {

    @Autowired
    private IAccountService accountService;

    //需求：账号转账，Tom账号取出1000元，存放到Jack账号上
    @Test
    public void testTransfer(){
        accountService.transfer("Tom", "Jack", 1000d);
        System.out.println("转账成功！");
    }

}
