package cn.net.trimmer.jdbc.dao.impl;

import java.util.List;

import cn.net.trimmer.jdbc.dao.UserDAO;
import cn.net.trimmer.jdbc.entity.User;
import cn.net.trimmer.jdbc.util.jdbcTemplate;

/**
 * 用户信息dao
 * 
 * @author wl
 *
 */
public class UserDAOImpl implements UserDAO {
	private jdbcTemplate<User> jdbcTemplate = new jdbcTemplate<User>();

	@Override
	public boolean queryUser(String name, String password) {
		String sql = "select * from t_user where name = ? and password = ?";
		User user = jdbcTemplate.query(sql, new UserRowMapper(), name, password);
		if (user == null) {
			return false;
		}
		return true;
	}

	@Override
	public void save(User user) {
		String sql = "insert into t_user (id,name,password,sex,birthday) values( seq_user.nextval,?,?,?,?)";
		jdbcTemplate.update(sql, user.getName(), user.getPassword(), user.getSex(), user.getBirthday());
	}

	@Override
	public List<User> queryAllUser() {
		String sql = "select id,name,password,sex,birthday from t_user";
		List<User> lists = jdbcTemplate.queryAll(sql, new UserRowMapper());
		return lists;
	}

	@Override
	public void deleteById(int id) {
		String sql = "delete from t_user where id = ? ";
		jdbcTemplate.update(sql, id);
	}

	@Override
	public void update(User user) {
		String sql = "update t_user set name =?,password=?,sex=?,birthday=? where id = ? ";
		jdbcTemplate.update(sql, user.getName(), user.getPassword(), user.getSex(), user.getBirthday(), user.getId());
	}

	@Override
	public User querUserById(int id) {
		String sql = "select id,name,password,sex,birthday from t_user where id =?";
		User user = jdbcTemplate.query(sql, new UserRowMapper(), id);
		return user;
	}

}
