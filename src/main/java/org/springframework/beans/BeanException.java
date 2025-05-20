package org.springframework.beans;

/**
 * Bean异常
 */
public class BeanException extends RuntimeException{

    /**
     * 构造函数
     *
     * @param msg 异常信息
     */
    public BeanException(String msg) {
        super(msg);
    }

    /**
     * 构造函数
     *
     * @param msg 异常信息
     * @param cause 异常原因
     */
    public BeanException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
