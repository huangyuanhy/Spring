package service;

import javax.annotation.Resource;

import dao.UserDao;

public class UserService {
	@Resource(name="userdao")
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void add() {
		System.out.println("service------");
		userDao.add();
	}
}
