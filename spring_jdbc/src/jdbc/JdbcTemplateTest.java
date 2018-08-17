package jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcTemplateTest {
	static JdbcTemplate jdbcTemplate;
	static DriverManagerDataSource dataSource;
	static {
		dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///spring");
		dataSource.setPassword("925925");
		dataSource.setUsername("root");
	}
	
	//查询结果返回list集合
			@Test
			public void query3() {
				String sql="select * from user ";
				jdbcTemplate=new JdbcTemplate(dataSource);
				List<User> list = jdbcTemplate.query(sql,  
						new org.springframework.jdbc.core.RowMapper<User>() {

							@Override
							public User mapRow(ResultSet rs, int arg1) throws SQLException {
								String name=rs.getString("name");
								int age=rs.getInt("age");
								User user=new User();
								user.setAge(age);
								user.setName(name);
								return user;
							}	
					}							
					);
				System.out.println(list);
			}
	
	
	//查询结果返回一个对象
		@Test
		public void query2() {
			String sql="select * from user where name=?";
			jdbcTemplate=new JdbcTemplate(dataSource);
			User queryForObject = jdbcTemplate.queryForObject(sql,  
					new org.springframework.jdbc.core.RowMapper<User>() {

						@Override
						public User mapRow(ResultSet rs, int arg1) throws SQLException {
							String name=rs.getString("name");
							int age=rs.getInt("age");
							User user=new User();
							user.setAge(age);
							user.setName(name);
							return user;
						}	
				}							
					,"mike");
			System.out.println(queryForObject);
		}
	//查询有的多少记录数
	@Test
	public void query1() {
		String sql="select * from user where name=?";
		jdbcTemplate=new JdbcTemplate(dataSource);
		int queryForObject = jdbcTemplate.queryForObject(sql, Integer.class);
		System.out.println(queryForObject);
	}
	
	
	
	@Test
	public void update() {
		jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="update user set name=? where id=?";
		int update = jdbcTemplate.update(sql, "mike" , 1);
		System.out.println(update);
	}
	
	
	
	@Test
	public void add() throws  Exception {
		
		
		/*Properties properties=new Properties();
		InputStream in =JdbcTemplateTest.class.getResourceAsStream("/db.properties");
		properties.load(in);
		dataSource.setConnectionProperties(properties);*/
		//创建jdbctemplate
		jdbcTemplate=new JdbcTemplate(dataSource);
		
		//调用方法
		String sql="insert into user (name,age) values(?,?)";
		int row=jdbcTemplate.update(sql, "tom",23);
		System.out.println(row);
	}
}
