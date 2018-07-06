package me.jiatao.ssm.spring;

import me.jiatao.ssm.spring.C_Proxy.CustomerServiceImpl;
import me.jiatao.ssm.spring.C_Proxy.ICustomerService;
import me.jiatao.ssm.spring.C_Proxy.JdkProxyFactory;
import me.jiatao.ssm.spring.C_cglib.CglibProxyFactory;
import me.jiatao.ssm.spring.C_cglib.ProductService;
import org.junit.Test;

public class SpringTestC {

    /**
     	Jdk代理：基于接口的代理，一定是基于接口，会生成目标对象的接口类型的子对象。
     	Cglib代理：基于类的代理，不需要基于接口，会生成目标对象类型的子对象。
     	Spring AOP 优先对接口进行代理 （使用Jdk动态代理）
     	如果目标对象没有实现任何接口，才会对类进行代理 （使用cglib动态代理）

     代理知识总结：

     	spring在运行期，生成动态代理对象，不需要特殊的编译器.
     	spring有两种代理方式：
         1.若目标对象实现了若干接口，spring使用JDK的java.lang.reflect.Proxy类代理。
         2.若目标对象没有实现任何接口，spring使用CGLIB库生成目标对象的子类。
     	使用该方式时需要注意:
         1.对接口创建代理优于对类创建代理，因为会产生更加松耦合的系统，所以spring默认是使用JDK代理。
         对类代理是让遗留系统或无法实现接口的第三方类库同样可以得到通知，这种方式应该是备用方案。
         2.标记为final的方法不能够被通知。spring是为目标类产生子类。任何需要被通知的方法都被复写，将通知织入。final方法是不允许重写的。
         3.spring只支持方法连接点：不提供属性接入点，spring的观点是属性拦截破坏了封装。
         面向对象的概念是对象自己处理工作，其他对象只能通过方法调用的得到的结果。
     **/


    /**
     * 目标：使用动态代理，对原来的方法进行功能增强,而无需更改原来的代码。
     * JDK动态代理：基于接口的（对象的类型，必须实现接口！）
     */

    @Test
    public void testJdkProxy() {
        //target（目标对象）
        ICustomerService target = new CustomerServiceImpl();
        //实例化注入目标对象
        JdkProxyFactory jdkProxyFactory = new JdkProxyFactory(target);
        //获取Proxy Object代理对象:基于目标对象类型的接口的类型的子类型的对象
        ICustomerService proxy = (ICustomerService) jdkProxyFactory.getProxyObject();
        //调用目标对象的方法
        proxy.save();
        System.out.println("————————————————————————————————————————");
        proxy.find();
    }


    /**
     * cglib动态代理：可以基于类（无需实现接口）生成代理对象
     */

    @Test
    public void testCglibProxy() {
        //target目标：
        ProductService target = new ProductService();
        //weave织入，生成proxy代理对象
        //代理工厂对象，注入目标
        CglibProxyFactory cglibProxyFactory = new CglibProxyFactory(target);
        //获取proxy:思考：对象的类型
        //代理对象，其实是目标对象类型的子类型
        ProductService proxy = (ProductService) cglibProxyFactory.getProxyObject();
        //调用代理对象的方法
        proxy.save();
        System.out.println("————————————————————————————————————————");
        proxy.find();
    }

}
