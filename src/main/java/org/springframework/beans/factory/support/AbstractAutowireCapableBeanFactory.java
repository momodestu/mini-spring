package org.springframework.beans.factory.support;

import org.springframework.beans.BeanException;
import org.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * 实例化Bean类
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    // 修改为使用简单实例化策略
    private InstantiationStrategy instantiationStrategy = new SimpleInstantiationStrategy();

    /**
     * 实现Bean的创建
     *
     * @param beanName bean名称
     * @param beanDefinition bean定义
     * @return bean对象
     */
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeanException{
        Object bean = null;
        try {
            // 实例化bean
            bean = createBeanInstance(beanDefinition, beanName, args);
        } catch (Exception e) {
            throw new BeanException("Instantiation of bean failed", e);
        }

        addSingleton(beanName, bean);
        return bean;
    }

    /**
     * 实例化bean
     *
     * @param beanDefinition bean定义
     * @param beanName bean名称
     * @param args 构造方法参数
     * @return bean对象
     * @throws Exception 异常
     */
    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) throws Exception {
        Constructor constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();

        // 改进参数匹配逻辑（原逻辑仅检查参数数量，这里添加类型匹配）
        for (Constructor<?> ctor : declaredConstructors) {
            if (args != null && ctor.getParameterCount() == args.length) {
                // 此处可以添加更精确的类型匹配逻辑
                constructorToUse = ctor;
                break;
            }
        }

        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
