package org.springframework.beans.factory.support;

import org.springframework.beans.BeanException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;

/**
 * 抽象的bean工厂
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) throws BeanException {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeanException {
        return doGetBean(name, args);
    }

    /**
     * 获取bean
     *
     * @param name bean名称
     * @param args 构造方法参数
     * @return bean对象
     * @param <T> bean类型
     */
    protected <T> T doGetBean(final String name, final Object[] args) {
        // 先从单例对象容器中获取bean
        Object bean = getSingleton(name);
        if (bean != null) {
            // 如果单例对象容器中已经存在，则直接返回
            return (T) bean;
        }

        // 如果单例对象容器中没有，则创建bean
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name, beanDefinition, args);
    }


    protected abstract BeanDefinition getBeanDefinition(String name) throws BeanException;

    protected abstract Object createBean(String name, BeanDefinition beanDefinition, Object[] arg) throws BeanException;

}
