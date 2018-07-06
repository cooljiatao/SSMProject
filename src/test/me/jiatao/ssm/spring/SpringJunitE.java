package me.jiatao.ssm.spring;


import me.jiatao.ssm.spring.E_AspectJAnnotation.CustomerServiceImpl;
import me.jiatao.ssm.spring.E_AspectJAnnotation.ICustomerService;
import me.jiatao.ssm.spring.E_AspectJAnnotation.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//目标：测试一下spring的bean的某些功能

//junit整合spring的测试
// 立马开启了spring的注解
@RunWith(SpringJUnit4ClassRunner.class)
//加载核心配置文件，自动构建spring容器
@ContextConfiguration(locations = "classpath:applicationContextE.xml")
public class SpringJunitE {

    @Autowired
    @Qualifier("customerServiceE")
    CustomerServiceImpl customerService;

    @Autowired
    @Qualifier("productServiceE")
    ProductService productService;

    //测试
    @Test
    public void aspectJXMLTest() {
        //基于接口
        customerService.save();
        customerService.find();
        //基于类的
        productService.save();
        int res = productService.find();
        System.out.println("productService.find------>"+res);

        //扩展方法执行:customerService是一个动态代理对象，原因，该对象是接口的子类型的对象
        //com.sun.proxy.$Proxy19 cannot be cast to me.jiatao.ssm.spring.E_AspectJAnnotation.CustomerServiceImpl
        ((CustomerServiceImpl)customerService).update();


        System.out.println("aspectJXMLTest end。。。");

    }

}
