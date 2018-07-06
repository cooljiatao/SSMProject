
package me.jiatao.ssm.spring.D_AspectJXML;

public class ProductService {
    public void save() {
        System.out.println("商品保存了。。。。。");
    }

    public int find() {
        System.out.println("商品查询数量了。。。。。");
        int x = 1 / 0;
        return 99;
    }
}
