package org.springframework.beans.factory;

import org.springframework.beans.BeanException;

/**
 * Bean工厂
 */
public interface BeanFactory {

    // 获取bean
    Object getBean(String name);

    /**
     * 获取bean
     *
     * @param name bean名称
     * @param args 构造方法参数
     * @return bean对象
     * @throws BeanException bean异常
     */
    Object getBean(String name, Object... args) throws BeanException;
}
