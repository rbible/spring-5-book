/**
 * Welcome to https://waylau.com
 */
package com.waylau.spring.scope;

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
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        MessagePrinter printer = context.getBean("messagePrinter", MessagePrinter.class);
        printer.printMessage();

        /**
         * mynote: getBean 使用，可用 id、class
         */
        MessagePrinter messagePrinter2 = context.getBean("messagePrinter2", MessagePrinter.class);
        messagePrinter2.printMessage();
    }

}
