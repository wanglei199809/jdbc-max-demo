package cn.net.trimmer.jdbc.service.impl;

import java.util.List;

import cn.net.trimmer.jdbc.dao.UserDAO;
import cn.net.trimmer.jdbc.entity.User;
import cn.net.trimmer.jdbc.service.UserService;
import cn.net.trimmer.jdbc.util.Factory;
import cn.net.trimmer.jdbc.util.TransactionManager;

public class UserServiceImpl implements UserService {
	Factory<UserDAO> f = new Factory<UserDAO>();
	UserDAO userDAO = f.createBean("userDAO");

	@Override
	public boolean login(String name, String password) {
		boolean flag = false;
		try {
			flag = userDAO.queryUser(name, password);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return flag;
	}

	@Override
	public void register(User user) {
		try {
			TransactionManager.begin();
			userDAO.save(user);
			TransactionManager.commit();
		} catch (Exception e) {
			e.printStackTrace();
			TransactionManager.rollback();
		}
	}

	@Override
	public List<User> showUser() {
		List<User> list = null;
		try {
			TransactionManager.begin();
			list = userDAO.queryAllUser();
			TransactionManager.commit();
		} catch (Exception e) {
			e.printStackTrace();
			TransactionManager.rollback();
		}
		return list;
	}

	@Override
	public void remove(int id) {
		try {
			TransactionManager.begin();
			userDAO.deleteById(id);
			TransactionManager.commit();
		} catch (Exception e) {
			e.printStackTrace();
			TransactionManager.rollback();
		}
	}

	@Override
	public void modify(User user) {
		try {
			TransactionManager.begin();
			userDAO.update(user);
			TransactionManager.commit();
		} catch (Exception e) {
			e.printStackTrace();
			TransactionManager.rollback();
		}

	}

	@Override
	public User query(int id) {
		User user = null;
		try {
			TransactionManager.begin();
			user = userDAO.querUserById(id);
			TransactionManager.commit();
		} catch (Exception e) {
			e.printStackTrace();
			TransactionManager.rollback();
		}
		return user;
	}

}
