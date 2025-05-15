package org.springframework;

import java.util.HashMap;
import java.util.Map;

/**
 * Bean工厂
 */
public class BeanFactory {

    // 保存bean的Map容器
    private Map<String,Object> beanMaps = new HashMap<>();

    /**
     * 获取Bean
     *
     * @param name bean名称
     * @return bean名称
     */
    public Object getBean(String name) {
        return beanMaps.get(name);
    }

    /**
     * 注册Bean
     *
     * @param name bean名称
     * @param bean bean对象
     */
    public void registerBean(String name,Object bean) {
        beanMaps.put(name, bean);
    }
}
