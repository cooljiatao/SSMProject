package me.jiatao.ssm.spring;

import me.jiatao.ssm.spring.A_Bean.Bean1;
import me.jiatao.ssm.spring.A_Bean.Bean2;
import me.jiatao.ssm.spring.A_Bean.Bean3;
import me.jiatao.ssm.spring.A_Bean.Bean4;
import me.jiatao.ssm.spring.A_Ioc.IUserService;
import me.jiatao.ssm.spring.A_Ioc.UserServiceImpl;
import me.jiatao.ssm.spring.A_LifeCycle.LifeCycleBean;
import me.jiatao.ssm.spring.A_Property.Car;
import me.jiatao.ssm.spring.A_Property.Person;
import me.jiatao.ssm.spring.A_Scope.PrototypeBean;
import me.jiatao.ssm.spring.A_Scope.SingletonBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTestA {
    @Test
    //模拟表现层
    public void iocTest() {
        IUserService userService = new UserServiceImpl();
        userService.login();


        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContextA.xml");
        IUserService userService2 = (IUserService) ac.getBean("userServiceImpl2");
        userService2.login();
    }

    @Test
    public void beanCreate() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContextA.xml");

        Bean1 bean1 = (Bean1) ac.getBean("bean1");
        System.out.println(bean1);

        Bean2 bean2 = (Bean2) ac.getBean("bean2");
        System.out.println(bean2);

        Bean3 bean3 = (Bean3) ac.getBean("bean3");
        System.out.println(bean3);

        Bean4 bean4 = (Bean4) ac.getBean("bean4");
        System.out.println(bean4);
        Bean4 bean42 = (Bean4) ac.getBean("bean4");
        System.out.println(bean42);
    }

    @Test
    public void scopeTest() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContextA.xml");
        SingletonBean singletonBean = (SingletonBean) ac.getBean("singletonBean");
        System.out.println(singletonBean);
        SingletonBean singletonBean2 = (SingletonBean) ac.getBean("singletonBean");
        System.out.println(singletonBean2);

        PrototypeBean prototypeBean = (PrototypeBean) ac.getBean("prototypeBean");
        System.out.println(prototypeBean);
        PrototypeBean prototypeBean2 = (PrototypeBean) ac.getBean("prototypeBean");
        System.out.println(prototypeBean2);
    }

    @Test
    public void lifeCycleTest() {
        //先获取spring的容器，工厂，上下文
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextA.xml");
        //对于单例此时已经被初始化
        //获取bean
        LifeCycleBean lifeCycleBean = (LifeCycleBean) applicationContext.getBean("lifeCycleBean");
        System.out.println(lifeCycleBean);
        //为什么没有销毁方法调用。
        //原因是：使用debug模式jvm直接就关了，spring容器还没有来得及销毁对象。
        //解决：手动关闭销毁spring容器，自动销毁单例的对象
        ((ClassPathXmlApplicationContext) applicationContext).close();
    }

    @Test
    public void PropertyTest() {
        //spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextA.xml");
        //获取car
        Car car = (Car) applicationContext.getBean("car");
        System.out.println(car);

        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);

        Person person2 = (Person) applicationContext.getBean("person2");
        System.out.println(person2);

        Person person3 = (Person) applicationContext.getBean("person3");
        System.out.println(person3);

        Person person4 = (Person) applicationContext.getBean("person4");
        System.out.println(person4);
    }
}