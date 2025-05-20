package org.springframework.beans.factory.config;

/**
 * 定义了一个获取单例对象的接口
 */
public interface SingletonBeanRegistry {

    // 注册单例bean
    Object getSingleton(String beanName);
}
