package me.jiatao.ssm.spring;

import me.jiatao.ssm.spring.B_Annotation.CustomerService2;
import me.jiatao.ssm.spring.D_AspectJXML.ICustomerService;
import me.jiatao.ssm.spring.D_AspectJXML.ProductService;
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
@ContextConfiguration(locations = "classpath:applicationContextD.xml")
public class SpringJunitD {

    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ProductService productService;


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
        System.out.println("aspectJXMLTest end。。。");
    }

}
