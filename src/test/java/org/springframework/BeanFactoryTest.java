package org.springframework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BeanFactoryTest {

    /**
     * 测试获取bean
     */
    @Test
    public void testGetBean() {
        // 创建bean工厂
        BeanFactory beanFactory = new BeanFactory();
        // 注册bean
        beanFactory.registerBean("userService",new UserService());
        // 获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        // 判空断言
        assertNotNull(userService);
        assertEquals("查询用户信息", userService.queryUserInfo());
    }

    /**
     * 生产测试bean
     */
    class UserService {
        public String queryUserInfo() {
            System.out.println("查询用户信息");
            return "查询用户信息";
        }
    }
}