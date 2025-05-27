package org.springframework.beans.factory.support;

import org.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * 实例化策略接口
 */
public interface InstantiationStrategy {

    /**
     * 根据bean定义创建bean实例
     *
     * @param beanDefinition bean定义
     * @param name bean名称
     * @param constructor 构造器
     * @param args 构造器参数
     * @return bean实例
     * @throws Exception 异常
     */
    Object  instantiate(BeanDefinition beanDefinition , String name , Constructor constructor ,Object[] args) throws Exception;
}
