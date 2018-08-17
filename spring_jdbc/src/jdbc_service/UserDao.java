package jdbc_service;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public void add() {
	
		
		//调用方法
		String sql="insert into user (name,age) values(?,?)";
		int row=jdbcTemplate.update(sql, "huan",25);
		System.out.println(row);
	}
}
