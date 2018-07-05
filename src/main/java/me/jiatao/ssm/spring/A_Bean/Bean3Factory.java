package me.jiatao.ssm.spring.A_Bean;

public class Bean3Factory {
    //普通的方法，非静态方法
    public Bean3 getBean3() {
        //初始化实例对象返回
        return new Bean3();
    }

}
