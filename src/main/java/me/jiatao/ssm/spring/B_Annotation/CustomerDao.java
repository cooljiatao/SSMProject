package me.jiatao.ssm.spring.B_Annotation;

import org.springframework.stereotype.Repository;

@Repository("customerDao")
public class CustomerDao {
    public void save() {
        System.out.println("CustomerDao层被调用了");
    }
}
