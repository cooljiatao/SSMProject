package me.jiatao.ssm;

import me.jiatao.ssm.spring.E_AspectJAnnotation.CustomerServiceImpl;
import me.jiatao.ssm.spring.E_AspectJAnnotation.ProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HelloServlet", urlPatterns = "/HelloServlet")
public class HelloServlet extends HttpServlet {
    private Logger LOGGER = LogManager.getLogger(getClass());

    @Autowired
//    @Qualifier("customerServiceE")
            CustomerServiceImpl customerService;

    @Autowired
//    @Qualifier("productServiceE")
            ProductService productService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("This is get method!");

//        每次获取的都是一个spring容器
//        ApplicationContext applicationContext = (ApplicationContext) this.getServletContext()
//                .getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);

//        WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
//        CustomerService2 customerService2 = (CustomerService2) applicationContext.getBean("customerService2");
//        customerService2.save();

        WebApplicationContextUtils
                .getWebApplicationContext(getServletContext())
                .getAutowireCapableBeanFactory().autowireBean(this);

        //基于接口
        customerService.save();
        customerService.find();
        //基于类的
        productService.save();
        int res = productService.find();
        System.out.println("productService.find------>" + res);

        //扩展方法执行:customerService是一个动态代理对象，原因，该对象是接口的子类型的对象
        //com.sun.proxy.$Proxy19 cannot be cast to me.jiatao.ssm.spring.E_AspectJAnnotation.CustomerServiceImpl
        ((CustomerServiceImpl) customerService).update();


        System.out.println("aspectJXMLTest end。。。");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}
