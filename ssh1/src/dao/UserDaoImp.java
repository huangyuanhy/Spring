package dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import entity.User;

public class UserDaoImp implements UserDao {
	
	//得到hibernatetempalte 对象
	private HibernateTemplate hibernateTemplate;
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	@Override
	public void add() {
		
		//这句话由配置文件中  localsession factory 进行实现
		//HibernateTemplate hibernateTemplate=new HibernateTemplate(sessionFactory);
		
		User user= new User();
		user.setPassword("123123");
		user.setAddress("sichuang");
		user.setUsername("huangyuan");
		
		//hibernateTemplate.save(entity);
		hibernateTemplate.save(user);
		
	}
	
	//根据id查询  get and load方法  
	public void query() {
		User user = hibernateTemplate.get(User.class, 1);
		System.out.println(user);
	}
	public void find() {
		//查询所有记录
		List<User> find = (List<User>) hibernateTemplate.find("from User");
		//根据条件查询
		List<?> find2 = hibernateTemplate.find("from User where id=?", 2);
	}

}
