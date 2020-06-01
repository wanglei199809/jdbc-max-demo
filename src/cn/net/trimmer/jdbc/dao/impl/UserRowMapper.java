package cn.net.trimmer.jdbc.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.net.trimmer.jdbc.entity.User;
import cn.net.trimmer.jdbc.util.RowMapper;

/**
 * 用户表映射
 * 
 * @author wl
 */
public class UserRowMapper implements RowMapper<User> {
	
	// 结果集处理
	@Override
	public User mapRow(ResultSet rs) {
		User user = new User();
		try {
			user.setId(rs.getInt(1));
			user.setName(rs.getString(2));
			user.setPassword(rs.getString(3));
			user.setSex(rs.getString(4));
			user.setBirthday(rs.getDate(5));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

}
