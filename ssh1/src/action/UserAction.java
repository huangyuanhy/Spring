package action;

import com.opensymphony.xwork2.ActionSupport;

import service.UserService;

public class UserAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService userService;
	
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	public String execute() {
		System.out.println("action-----------------");
		userService.add();
		return NONE;
		
	}
}
