package me.jiatao.ssm.spring.B_Annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service(value = "customerService1")
public class CustomerService1 {

    //简单类型的成员变量
    //参数的值简单类型
    @Value("Rose")
    private String name="Jack";

    //在属性声明上面注入，底层自动还是生成setCustomerDao()
    //第一种： 使用@Value 结合SpEL  ---- spring3.0 后用
    //其中customerDao表示<bean>节点id的属性值
    @Value("#{customerDao}")
    private CustomerDao customerDao;

    public void save() {
        System.out.println("CustomerService业务层被调用了。。。");
        System.out.println("name:"+name);
        customerDao.save();
    }
}
