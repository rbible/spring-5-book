/**
 * Welcome to https://waylau.com
 */
package com.waylau.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Fighter.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2018年2月1日
 */
@Aspect
public class Fighter {

    /**
     * mynote: pointcut 为空方法,内部的逻辑不执行
     */
    @Pointcut("execution(* com.waylau.spring.aop.Tiger.walk())")
    public void foundTiger() {
        System.out.println("foundTiger...");
    }

    @Before(value = "foundTiger()")
    public void foundBefore() {
        System.out.println("Before：Fighter wait for tiger...");
    }

    @After(value = "foundTiger()")
    public void foundAfter() {
        System.out.println("After：Fighter after for tiger...");
    }

    @AfterReturning("foundTiger()")
    public void foundAfterReturn() {
        System.out.println("AfterReturn：Fighter fight with tiger...");
    }

    @Around("foundTiger()")
    public void around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("AroundBefore：Fighter around before with tiger...");
        point.proceed();
        System.out.println("AroundAfter：Fighter around after with tiger...");
    }
}
