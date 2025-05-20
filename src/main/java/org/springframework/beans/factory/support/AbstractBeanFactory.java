package org.springframework.beans.factory.support;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;

/**
 * 抽象的bean工厂
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    /**
     * 获取bean
     *
     * @param name bean的名称
     * @return bean对象
     */
    @Override
    public Object getBean(String name) {

        // 先从单例对象容器中获取bean
        Object singletonObject = getSingleton(name);
        if (singletonObject != null) {
            // 如果单例对象容器中已经存在，则直接返回
            return singletonObject;
        }

        // 如果单例对象容器中没有，则创建bean
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }


    protected abstract BeanDefinition getBeanDefinition(String name);

    protected abstract Object createBean(String name, BeanDefinition beanDefinition);
}
