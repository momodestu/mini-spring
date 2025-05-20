package org.springframework.beans.factory.support;

import org.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * 默认的单例bean注册器
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    // 单例对象的容器
    private Map<String, Object> singletonObjects = new HashMap<>();

    // 获取单例bean
    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    // 注册单例bean
    protected void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }
}
