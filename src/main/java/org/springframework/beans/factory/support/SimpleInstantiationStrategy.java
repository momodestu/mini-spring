package org.springframework.beans.factory.support;

import org.springframework.beans.factory.config.BeanDefinition;
import java.lang.reflect.Constructor;

public class SimpleInstantiationStrategy implements InstantiationStrategy {

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String name, Constructor constructor, Object[] args) throws Exception {
        Class<?> beanClass = beanDefinition.getBeanClass();
        if (constructor != null) {
            // 使用带参数的构造器
            return beanClass.getDeclaredConstructor(constructor.getParameterTypes()).newInstance(args);
        } else {
            // 使用默认构造器
            return beanClass.getDeclaredConstructor().newInstance();
        }
    }
}
