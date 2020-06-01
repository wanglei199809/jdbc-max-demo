package cn.net.trimmer.jdbc.dao;


import java.util.List;

import cn.net.trimmer.jdbc.entity.User;

public interface UserDAO {
	/**
	 * 根据用户名和密码查询用户信息
	 * @param name 用户名
	 * @param password 密码
	 * @return 是否查询成功标识符
	 */
	public boolean queryUser(String name,String password);
	/**
	 * 保存用户信息
	 * @param user 用户信息
	 */
	public void save(User user);
	/**
	 * 查询所有用户信息
	 * @return 用户信息集合
	 */
	public List<User> queryAllUser();
	/**
	 * 通过id删除用户信息
	 * @param id 用户编号
	 */
	public void deleteById(int id);
	/**
	 * 修改用户信息
	 * @param user 用户信息
	 */
	public void update(User user);
	/**
	 * 通过id查询用户信息
	 * @param id 用户编号
	 * @return 用户信息
	 */
	public User querUserById(int id);
}
