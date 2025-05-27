package org.springframework.beans.factory.support;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * CGLIB 子类化实例化策略
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy{

    /**
     * 根据bean定义创建bean实例
     *
     * @param beanDefinition bean定义
     * @param name           bean名称
     * @param constructor    构造器
     * @param args           构造器参数
     * @return bean实例
     * @throws Exception 异常
     */
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String name, Constructor constructor, Object[] args) throws Exception {
        // 创建CGLIB增强器（用于生成子类代理）
        Enhancer enhancer = new Enhancer();
        // 设置父类（即要代理的类）
        enhancer.setSuperclass(beanDefinition.getBeanClass());

        // 添加以下两行配置解决Java模块系统问题
        enhancer.setUseFactory(false);
        enhancer.setClassLoader(beanDefinition.getBeanClass().getClassLoader());

        // 设置回调（这里使用NoOp回调，即不做任何操作）
        enhancer.setCallback(new NoOp() {
            // 重写hashCode方法，确保生成的子类的hashCode方法与父类相同
            // 这是为了避免在使用子类代理时出现hashCode不一致的问题
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        // 创建子类代理实例
        if (constructor == null) {
            // 如果没有指定构造器，则使用默认构造器创建实例
            return enhancer.create();
        }
        // 如果指定了构造器，则使用指定的构造器创建实例
        return enhancer.create(constructor.getParameterTypes(), args);
    }
}
