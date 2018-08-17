package action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;

import service.UserService;

public class UserAction extends ActionSupport {

	@Override
	public String execute() throws Exception {
		System.out.println("action--------");
		// TODO Auto-generated method stub
		ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
		UserService bean = context.getBean("userservice", UserService.class);
		bean.add();
		return NONE;
	}
	

}
