package me.jiatao.ssm.spring.A_LifeCycle;

public class LifeCycleBean {
    //定义构造方法
    public LifeCycleBean() {
        System.out.println("LifeCycleBean构造器调用了");
    }

    //初始化后自动调用方法：方法名随意，但也不能太随便，一会要配置
    public void init(){
        System.out.println("LifeCycleBean-init初始化时调用");
    }

    //bean销毁时调用的方法
    public void destroy(){
        System.out.println("LifeCycleBean-destroy销毁时调用");
    }

}
