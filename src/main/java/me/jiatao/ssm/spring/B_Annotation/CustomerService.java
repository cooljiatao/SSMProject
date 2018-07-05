package me.jiatao.ssm.spring.B_Annotation;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


/**
 * @Component注解放置到类上 相当于spring容器中定义：<bean id="customerService" class="cn.itcast.spring.a_ioc.CustomerService">
 * 其中id属性默认bean的名字是类名的小写
 * ——————————————————————————————————————————————————————
 * @Component(value="customer")//自定义bean的名字 相当于spring容器中定义：<bean id="customer" class="cn.itcast.spring.a_ioc.CustomerService">
 * ——————————————————————————————————————————————————————
 * @Service用于标注业务层组件、（如Service层）
 * @Controller用于标注控制层组件（如struts中的action层）
 * @Repository用于标注数据访问组件，（如DAO层组件）。
 * 而@Component泛指组件，当组件不好归类的时候，我们可以使用这个注解进行标注。
 */


@Service(value = "customerService")
public class CustomerService {
    //保存业务方法
    public void save() {
        System.out.println("CustomerService业务层被调用了。。。");
    }

}
