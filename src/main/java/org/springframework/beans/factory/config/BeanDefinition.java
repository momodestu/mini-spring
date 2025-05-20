package org.springframework.beans.factory.config;

/**
 * BeanDefinition实例保存bean的信息，包括class类型、方法构造参数、bean属性、bean的scope等
 * 此处简化只包含class类型和bean属性
 */
public class BeanDefinition {

    // bean的class类型
    private Class beanClass;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
