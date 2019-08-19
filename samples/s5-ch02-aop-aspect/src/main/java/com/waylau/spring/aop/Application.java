/**
 * Welcome to https://waylau.com
 */
package com.waylau.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Application Main.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2018年1月28日
 */
public class Application {

    public static void main(String[] args) {
        /**
         * mynote：使用 xml 加载 applicationcontext
         */
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Tiger tiger = context.getBean(Tiger.class);
        tiger.walk();
    }

}
