package cn.net.trimmer.jdbc.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import cn.net.trimmer.jdbc.entity.User;
import cn.net.trimmer.jdbc.service.UserService;
import cn.net.trimmer.jdbc.util.Factory;

public class UserServiceImplTest {
	private Factory<UserService> f = new Factory<>();
	private UserService us = f.createBean("userService");
	
	@Test
	public void testRegister() {
		User user = new User("百晓生","123456","男",new Date());
		us.register(user );
	}
	
	@Test
	public void testLogin() {
		boolean login = us.login("百晓生", "123456");
		System.out.println(login);
	}

	

	@Test
	public void testShowUser() {
		List<User> list = us.showUser();
		for (User user : list) {
			System.out.println(user);
		}
	}

	@Test
	public void testRemove() {		
		us.remove(42);
	}

	@Test
	public void testModify() {
		User user = new User("张无忌","121212","男",new Date());
		user.setId(41);
		us.modify(user);
	}

	@Test
	public void testQuery() {
		User user = us.query(41);
		System.out.println(user);
	}

}
