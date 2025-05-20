package org.springframework.beans.factory.support;

import org.springframework.beans.factory.config.BeanDefinition;

/**
 * BeanDefinition注册器
 */
public interface BeanDefinitionRegistry {

    /**
     * 向注册表中注册 BeanDefinition
     *
     * @param beanName bean名称
     * @param beanDefinition bean定义
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
