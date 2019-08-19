/**
 * Welcome to https://waylau.com
 */
package com.waylau.spring.scope.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Message Service Impl.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2019年2月13日
 */

/**
 * mynote: bean scope 设置
 */
@Scope("threadScope")
@Service
public class MessageServiceImpl implements MessageService {

    public String getMessage() {
        System.out.println("thread:" + Thread.currentThread().getName() + ", Hello World!");
        return "Hello World!";
    }
}
