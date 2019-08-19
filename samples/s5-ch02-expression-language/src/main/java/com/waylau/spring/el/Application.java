/**
 * Welcome to https://waylau.com
 */
package com.waylau.spring.el;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Application Main.
 *
 * @since 1.0.0 2018年2月4日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class Application {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

		getBeanAndPrint(ctx, "list");
		getBeanAndPrint(ctx, "list2");
		getBeanAndPrint(ctx, "list3");
		getBeanAndPrint(ctx, "list4");
		getBeanAndPrint(ctx, "list5");
		getBeanAndPrint(ctx, "list6");
		getBeanAndPrint(ctx, "list7");
		getBeanAndPrint(ctx, "list8");
		getBeanAndPrint(ctx, "list9");
		getBeanAndPrint(ctx, "list10");
		getBeanAndPrint(ctx, "list11");
		getBeanAndPrint(ctx, "list12");

	}

	private static void getBeanAndPrint(ApplicationContext ctx, String listId) {
		ShopList list;
		list = (ShopList) ctx.getBean(listId);
		System.out.println(listId +": "+ list);
	}

}
