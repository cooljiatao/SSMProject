package me.jiatao.ssm.spring.A_Ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceImpl implements IUserService {

    public void login() {
        System.out.println("UserServiceImpl-service层被调用了。。。");
//        实例化dao层
//        传统方式
//        IUserDao userDao = new UserDaoImpl();
//        userDao.findByUsernameAndPassword();



        //spring的配置方式，IOC控制反转
        //构建一个spring的工厂，使用applicationContext.xml（spring的核心配置文件）获取对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContextA.xml");
        //从spring工厂中使用对象的标识获取对象
        IUserDao userDao = (IUserDao) ac.getBean("userDao");
        userDao.findByUsernameAndPassword();

    }
}
