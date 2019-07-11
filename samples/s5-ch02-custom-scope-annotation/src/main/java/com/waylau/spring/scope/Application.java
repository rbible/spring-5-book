/**
 * Welcome to https://waylau.com
 */
package com.waylau.spring.scope;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.waylau.spring.scope.service.MessageService;

/**
 * Application Main.
 * bean scope: 线程
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2019年2月13日
 */
public class Application {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        @SuppressWarnings("resource")
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		/*
		MessageService messageService = context.getBean(MessageService.class);
		messageService.getMessage();
 
		MessageService messageService2 = context.getBean(MessageService.class);
		messageService2.getMessage();
		*/

        CompletableFuture<String> task1 = getAndRunService(context);

        CompletableFuture<String> task2 = getAndRunService(context);

        task1.get();
        task2.get();
    }

    private static CompletableFuture<String> getAndRunService(ApplicationContext context) {
        return CompletableFuture.supplyAsync(() -> {
            //模拟执行耗时任务
            MessageService messageService = context.getBean(MessageService.class);
            messageService.getMessage();

            MessageService messageService2 = context.getBean(MessageService.class);
            messageService2.getMessage();
            //返回结果
            return "result";
        });
    }

}
