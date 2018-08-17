package service;

import org.springframework.transaction.annotation.Transactional;

import dao.UserDao;

public class UserService {
	
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	@Transactional
	public void add() {
		System.out.println("service------");
		userDao.add();
	}

}
