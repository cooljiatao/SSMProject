package me.jiatao.ssm.spring.B_LifeCycle;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("lifeCycleBean")
@Scope("singleton")
public class LifeCycleBean {

    public LifeCycleBean() {
        System.out.println("LifeCycleBean构造器调用了");
    }

    //初始化后自动调用方法：方法名随意，但也不能太随便，一会要配置
    //初始化的方法
    @PostConstruct
    public void init() {
        System.out.println("LifeCycleBean-init初始化时调用");
    }

    //bean销毁时调用的方法
    @PreDestroy
    public void destroy() {
        System.out.println("LifeCycleBean-destroy销毁时调用");
    }
}
