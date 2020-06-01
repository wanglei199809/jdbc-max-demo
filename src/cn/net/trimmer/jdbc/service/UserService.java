package cn.net.trimmer.jdbc.service;


import java.util.List;

import cn.net.trimmer.jdbc.entity.User;

public interface UserService {
	/**
	 * 登录
	 * @param name 用户名
	 * @param password 密码
	 * @return 是否登录成功标识
	 */
	boolean login(String name,String password);
	/**
	 * 注册
	 * @param user 用户信息
	 */
	void register(User user);
	/**
	 * 展示用户
	 * @return 用户信息集合
	 */
	List<User> showUser();
	/**
	 * 注销
	 * @param id 用户编号
	 */
	void remove(int id);
	/**
	 * 更改用户信息
	 * @param user 用户信息
	 */
	void modify(User user);
	/**
	 * 查询用户
	 * @param id 用户编号
	 * @return 用户信息
	 */
	User query(int id);
}	
