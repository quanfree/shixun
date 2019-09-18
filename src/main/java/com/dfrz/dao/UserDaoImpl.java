package com.dfrz.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dfrz.beans.User;
import com.dfrz.utils.JDBCUtils;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class UserDaoImpl implements UserDao{
	public List<User>data;
	public UserDaoImpl() {
		//
		}
		
		
		public boolean login1(User user) {
			boolean flag=false;
			for(User t : data) {
				if(user.getUname().equals(t.getUname()) && user.getUpass().equals(t.getUpass()))
					System.out.println(user.getUname()+"登陆成功");
					flag=true;
					break;
			}
		
		return flag;
	}


		public boolean login(User user) {
			boolean flag=false;
			try {
				Connection conn=JDBCUtils.getConn();
				String sql="select * from User where uname=? and upass=?";
				PreparedStatement pstmt=conn.clientPrepareStatement(sql);
				pstmt.setString(1,user.getUname());
				pstmt.setString(2,user.getUpass());
				ResultSet rs=pstmt.executeQuery();
				if(rs.next()) {
					flag=true;
					
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			// TODO Auto-generated method stub
			return false;
		}
}

