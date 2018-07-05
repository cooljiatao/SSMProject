package me.jiatao.ssm.spring.A_Bean;

import org.springframework.beans.factory.FactoryBean;

public class Bean4FactoryBean implements FactoryBean<Bean4> {
    @Override
    public Bean4 getObject() throws Exception {
        return new Bean4();
    }

    @Override
    public Class<?> getObjectType() {
        return Bean4.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
