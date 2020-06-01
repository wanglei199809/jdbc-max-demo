package cn.net.trimmer.jdbc.util;


import java.sql.ResultSet;

/**
 * 行映射接口
 * @author wl
 *
 * @param <T> 映射类类型
 */
public interface RowMapper<T> {
	public T mapRow(ResultSet rs);
}
