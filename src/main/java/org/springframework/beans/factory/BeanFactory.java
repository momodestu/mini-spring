package org.springframework.beans.factory;

/**
 * Bean工厂
 */
public interface BeanFactory {

    // 获取bean
    Object getBean(String name);
}
