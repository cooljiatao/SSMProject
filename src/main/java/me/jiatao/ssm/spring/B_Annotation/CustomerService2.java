package me.jiatao.ssm.spring.B_Annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service(value = "customerService2")
public class CustomerService2 {

    //单独使用@Autowired ，
    // 表示按照类型注入，会到spring容器中查找CustomerDao的类型，
    // 对应<bean class=””>，class的属性值，如果找到，可以匹配。
    @Autowired
    private CustomerDao customerDao;

    @Autowired
    @Qualifier("customerDao")
    private CustomerDao customerDao2;

    public void save() {
        System.out.println("CustomerService业务层被调用了。。。");
        customerDao.save();
        customerDao2.save();
    }
}
