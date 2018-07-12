package me.jiatao.ssm.spring;


import me.jiatao.ssm.spring.G_TransactionAnnotation.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


//junit整合spring的测试
// 立马开启了spring的注解
@RunWith(SpringJUnit4ClassRunner.class)
//加载核心配置文件，自动构建spring容器
//@ContextConfiguration(locations = "classpath:applicationContextG.xml")
@ContextConfiguration(locations = "classpath:applicationContextGAnn.xml")
public class SpringJunitG {

    @Autowired
    @Qualifier("accountService")
    private IAccountService accountService;

    //需求：账号转账，Tom账号取出1000元，存放到Jack账号上
    @Test
    public void testTransfer(){
        accountService.transfer("Tom", "Jack", 1000d);
        System.out.println("转账成功！");
    }

}
