
package me.jiatao.ssm.spring.E_AspectJAnnotation;

import org.springframework.stereotype.Service;

@Service("productServiceE")
public class ProductService {
    public void save() {
        System.out.println("商品保存了。。。。。");
    }

    public int find() {
        System.out.println("商品查询数量了。。。。。");
        return 99;
    }
}
