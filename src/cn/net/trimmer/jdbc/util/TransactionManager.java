package cn.net.trimmer.jdbc.util;

import java.sql.Connection;

/**
 * 事务管理类
 * 
 * @author wl
 */
public class TransactionManager {
	/**
	 * 关闭自动提交
	 */
	public static void begin() {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConn();
			conn.setAutoCommit(false);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 提交事务
	 */
	public static void commit() {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConn();
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.release(null, null, conn);
		}
	}

	/**
	 * 回滚事务
	 */
	public static void rollback() {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConn();
			conn.rollback();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.release(null, null, conn);
		}
	}
}
