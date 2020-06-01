package cn.net.trimmer.jdbc.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 简单工厂,用于管理类的创建
 * 
 * @author wl
 *
 * @param <T> 被工厂管理的类的类型
 */
public class Factory<T> {
	private static final Properties p = new Properties();
	static {
		InputStream is = null;
		try {
			// 加载并解析工厂配置文件
			is = JdbcUtils.class.getResourceAsStream("/cn/net/trimmer/jdbc/conf/factory.properties");
			p.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 通过类名创建类
	 * 
	 * @param className 类名称
	 * @return 类加载后的实例
	 */
	@SuppressWarnings("unchecked")
	public T createBean(String className) {
		T object = null;
		try {
			// 从配置文件中读取该类名称对应的全类名,通过反射获取类对象
			Class<?> c = Class.forName(p.getProperty(className));
			// 实例化类对象
			object = (T) c.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return object;
	}
}
