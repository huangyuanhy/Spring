package jdbc_service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Test {
	 @org.junit.Test
	public void testdemo() {
		ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
		UserService bean =  (UserService) context.getBean("userservice");
		bean.add();
	}
}
