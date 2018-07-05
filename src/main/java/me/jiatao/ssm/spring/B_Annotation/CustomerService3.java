package me.jiatao.ssm.spring.B_Annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "customerService3")
public class CustomerService3 {

//    使用@Resource注解，则按照名称注入，会到spring容器中查找customerDao的名称，
//    对应<bean id=””>，id的属性值，如果找到，可以匹配。
//    如果没有找到，抛出异常。
    @Resource
    private CustomerDao customerDao;

    public void save() {
        System.out.println("CustomerService业务层被调用了。。。");
        customerDao.save();
    }
}
