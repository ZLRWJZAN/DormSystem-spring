package com.ps.dorm.Utils;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 连接数据库工具类
 * @author Administrator
 *
 */
public class GetJoin {
	
	private static BasicDataSource dataSource = null;//定义连接池对象
	/**
	 * 私有构造方法
	 */
	private GetJoin() {	
	}
	/**
	 * 初始化 Connection 值
	 * @return  返回连接
	 */
	public static synchronized Connection getConnection() {
		if (null == dataSource) {
			dataSource = new BasicDataSource();//初始化连接池对象
			Properties properties = new Properties();//创建配置文件对象
			try {
				properties.load(GetJoin.class.getClassLoader().getResourceAsStream("org\\url"));//读取配置文件
				dataSource = BasicDataSourceFactory.createDataSource(properties);//应用配置文件
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		Connection conn = null;//数据连接对象 
		try {
			conn = dataSource.getConnection();//获取连接对象
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}


