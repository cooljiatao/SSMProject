package me.jiatao.ssm.spring;

import me.jiatao.ssm.spring.B_Annotation.CustomerService;
import me.jiatao.ssm.spring.B_Annotation.CustomerService1;
import me.jiatao.ssm.spring.B_Annotation.CustomerService2;
import me.jiatao.ssm.spring.B_Annotation.CustomerService3;
import me.jiatao.ssm.spring.B_LifeCycle.LifeCycleBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Method;

public class SpringTestB {
    @Test
    public void annotationTest() {
//          spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextB.xml");


//        CustomerService customerService=(CustomerService) applicationContext.getBean("customerService");
//        customerService.save();

//        使用@Value 结合SpEL获取bean
//        CustomerService1 customerService1=(CustomerService1) applicationContext.getBean("customerService1");
//        customerService1.save();

//        使用@Autowired 结合 @Qualifier
//        CustomerService2 customerService2 = (CustomerService2) applicationContext.getBean("customerService2");
//        customerService2.save();

//        JSR-250标准（基于jdk） 提供注解@Resource
        CustomerService3 customerService3 = (CustomerService3) applicationContext.getBean("customerService3");
        customerService3.save();

    }

    @Test
    public void testLifeCycle() throws Exception{
        //spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextB.xml");
        //单例；此时初始化的方法已经被调用
        LifeCycleBean lifeCycleBean = (LifeCycleBean)applicationContext.getBean("lifeCycleBean");
        //方案一：
        //((ClassPathXmlApplicationContext)applicationContext).close();


        //方案二：
        //反射的机制调用close方法。
        //接口只是引用了一个对象。对象本身有这个方法。
        //目标：通过接口引用，调用对象本来的拥有的方法
        //1。获取对象具体类的某个方法:参数1方法名，参数2：方法里面的参数类型
        Method method = applicationContext.getClass().getMethod("close");
        //参数1：拥有该方法的对象的名字,参数2：方法里面的参数的值
        method.invoke(applicationContext);

    }
}
