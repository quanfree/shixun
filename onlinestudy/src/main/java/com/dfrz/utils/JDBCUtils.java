package com.dfrz.utils;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class JDBCUtils {
		
		public static Connection getConn() {
			Connection conn=null;
			try {
				//步骤0：加载驱动程序
				Class.forName("com.mysql.jdbc.Driver");
				//步骤1：与数据库建立连接
				String url="jdbc:mysql://127.0.0.1:3306/onlinestudy?useUnicode=true&characterEncoding=UTF-8";
				conn = (Connection) DriverManager.getConnection(url, "root", "root");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conn;
		}

	
}

