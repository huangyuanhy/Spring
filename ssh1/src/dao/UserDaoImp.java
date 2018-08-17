package dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import entity.User;

public class UserDaoImp implements UserDao {
	
	//�õ�hibernatetempalte ����
	private HibernateTemplate hibernateTemplate;
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	@Override
	public void add() {
		
		//��仰�������ļ���  localsession factory ����ʵ��
		//HibernateTemplate hibernateTemplate=new HibernateTemplate(sessionFactory);
		
		User user= new User();
		user.setPassword("123123");
		user.setAddress("sichuang");
		user.setUsername("huangyuan");
		
		//hibernateTemplate.save(entity);
		hibernateTemplate.save(user);
		
	}
	
	//����id��ѯ  get and load����  
	public void query() {
		User user = hibernateTemplate.get(User.class, 1);
		System.out.println(user);
	}
	public void find() {
		//��ѯ���м�¼
		List<User> find = (List<User>) hibernateTemplate.find("from User");
		//����������ѯ
		List<?> find2 = hibernateTemplate.find("from User where id=?", 2);
	}

}
