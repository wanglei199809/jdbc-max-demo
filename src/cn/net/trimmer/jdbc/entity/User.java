package cn.net.trimmer.jdbc.entity;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * 用户表
 * 
 * @author wl
 */
public class User {
	private int id;
	private String name;
	private String password;
	private String sex;
	private Date birthday;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public java.sql.Date getBirthday() {
		//时间处理
		if (birthday != null) {
			return new java.sql.Date(birthday.getTime());
		}
		return null;
	}

	public void setBirthday(String birthday) {
		//时间格式化
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.birthday = sdf.parse(birthday);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public User() {
		super();
	}

	public User(String name, String password, String sex, Date birthday) {
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", sex=" + sex + ", birthday="
				+ birthday + "]";
	}
	
}
