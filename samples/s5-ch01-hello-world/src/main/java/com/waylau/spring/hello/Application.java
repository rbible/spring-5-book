/**
 * Welcome to https://waylau.com
 */
package com.waylau.spring.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;


/**
 * Application Main.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2018年1月25日
 */

/**
 * studynote: ComponentScan
 */
@ComponentScan
public class Application {

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);

        MessagePrinter printer = context.getBean(MessagePrinter.class);
        printer.printMessage();
    }

}
