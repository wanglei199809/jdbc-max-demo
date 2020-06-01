package cn.net.trimmer.jdbc.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * jdbc模板,封装增删改查方法
 * 
 * @author wl
 *
 * @param <T> 对象类型
 */
public class jdbcTemplate<T> {
	
	/**
	 * 查询一条
	 * @param sql sql集
	 * @param rowMapper 结果集映射对象
	 * @param args 参数表
	 * @return 结果集对象
	 */
	public T query(String sql, RowMapper<T> rowMapper, Object... args) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		T list = null;
		try {
			//获取连接			
			conn = JdbcUtils.getConn();
			//创建操作对象
			pst = conn.prepareStatement(sql);
			//给占位符赋值
			if (hasUpdateParam(args)) {
				for (int i = 0; i < args.length; i++) {
					pst.setObject(i + 1, args[i]);
				}
			}
			//执行sql
			rs = pst.executeQuery();
			//处理结果集
			if (rs.next()) {
				list = rowMapper.mapRow(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			//释放资源
			JdbcUtils.release(rs, pst, null);
		}
		return list;
	}

	/**
	 * 修改一条数据
	 * @param sql sql语句
	 * @param args 参数集
	 */
	public void update(String sql, Object... args) {
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			//获取连接对象
			conn = JdbcUtils.getConn();
			//创建sql操作对象
			pst = conn.prepareStatement(sql);
			//给占位符赋值
			if (hasUpdateParam(args)) {
				for (int i = 0; i < args.length; i++) {
					pst.setObject(i + 1, args[i]);
				}
			}
			//执行sql
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			//释放资源
			JdbcUtils.release(null, pst, null);
		}
	}

	/**
	 * 查询所有
	 * @param sql sql语句
	 * @param rowMapper 结果集映射对象
	 * @param args 参数集
	 * @return 结果集集合
	 */
	public List<T> queryAll(String sql, RowMapper<T> rowMapper, Object... args) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<T> lists = null;
		try {
			//获取连接
			conn = JdbcUtils.getConn();
			//创建操作对象
			pst = conn.prepareStatement(sql);
			//给占位符赋值
			if (hasUpdateParam(args)) {
				for (int i = 0; i < args.length; i++) {
					pst.setObject(i + 1, args[i]);
				}
			}
			//执行sql
			rs = pst.executeQuery();
			//处理结果集
			lists = new ArrayList<>();
			while (rs.next()) {
				T list = rowMapper.mapRow(rs);				
				lists.add(list);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			//释放资源
			JdbcUtils.release(rs, pst, null);
		}
		return lists;
	}
	
	//参数长度判断
	private boolean hasUpdateParam(Object... args) {
		return args.length != 0;
	}

}
