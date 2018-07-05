package me.jiatao.ssm.spring;

import me.jiatao.ssm.spring.B_Annotation.CustomerService2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//目标：测试一下spring的bean的某些功能

//junit整合spring的测试
// 立马开启了spring的注解
@RunWith(SpringJUnit4ClassRunner.class)
//加载核心配置文件，自动构建spring容器
@ContextConfiguration(locations = "classpath:applicationContextB.xml")
public class SpringJunit {

    @Autowired
    private CustomerService2 customerService2;

    @Test
    public void customerTest() {
        customerService2.save();
    }
}
