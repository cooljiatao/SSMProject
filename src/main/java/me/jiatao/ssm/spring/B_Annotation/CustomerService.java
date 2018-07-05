package me.jiatao.ssm.spring.B_Annotation;

import org.springframework.stereotype.Component;


/**
 * @Component注解放置到类上
 * 相当于spring容器中定义：<bean id="customerService" class="cn.itcast.spring.a_ioc.CustomerService">
 * 其中id属性默认bean的名字是类名的小写
 * ——————————————————————————————————————————————————————
 * @Component(value="customer")//自定义bean的名字
 * 相当于spring容器中定义：<bean id="customer" class="cn.itcast.spring.a_ioc.CustomerService">
 * ——————————————————————————————————————————————————————
 */



@Component(value="customer")
public class CustomerService {
    //保存业务方法
    public void save(){
        System.out.println("CustomerService业务层被调用了。。。");
    }

}
