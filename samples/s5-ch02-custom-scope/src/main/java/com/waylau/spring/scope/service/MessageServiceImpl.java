/**
 * Welcome to https://waylau.com
 */
package com.waylau.spring.scope.service;

/**
 * Message Service Impl.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2018年1月28日
 */
public class MessageServiceImpl implements MessageService {

    private String username;
    private int age;

    public MessageServiceImpl(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public String getMessage() {
        return "Hello World! " + username + ", age is " + age;
    }

}
