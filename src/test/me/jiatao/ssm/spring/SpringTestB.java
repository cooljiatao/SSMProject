package me.jiatao.ssm.spring;

import me.jiatao.ssm.spring.B_Annotation.CustomerService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTestB {
    @Test
    public void annotationTest(){
        //spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextB.xml");
        //获取bean
        CustomerService customerService=(CustomerService) applicationContext.getBean("customer");
        customerService.save();

    }
}
