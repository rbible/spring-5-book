/**
 * Welcome to https://waylau.com
 */
package com.waylau.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Fighter.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2018年2月1日
 */
public class Fighter {

    public void foundBefore() {
        System.out.println("Before: Fighter wait for tiger...");
    }

    public void foundAfterReturn() {
        System.out.println("AfterReturn: Fighter fight with tiger...");
    }

    public void foundAround(ProceedingJoinPoint point) throws Throwable {
        System.out.println("AroundBefore: Fighter wait for tiger...");
        point.proceed();
        System.out.println("AroundAfter: Fighter wait for tiger...");
    }

    public void foundAfter() {
        System.out.println("After: Fighter after for tiger...");
    }

}
