package me.jiatao.ssm.spring.E_AspectJAnnotation;

import org.springframework.stereotype.Service;

@Service("customerService")
public class CustomerServiceImpl implements ICustomerService {

    @Override
    public void save() {
        System.out.println("客户保存了。。。。。");
    }

    @Override
    public int find() {
        System.out.println("客户查询数量了。。。。。");
        return 100;
    }


    //子类扩展方法
    public void update() {
        System.out.println("客户更新了。。。新增方法。。。");
    }

}
