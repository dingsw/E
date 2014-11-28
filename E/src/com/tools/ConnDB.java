package com.tools;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class ConnDB {
	
	public Connection conn = null;
	public Statement stmt = null;
	public ResultSet rs = null;
	//private static String PropFileName = "C:/connDB.properties";
	//private static Properties prop = new Properties();
	
	private static String dbClassName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; 
	private static String dbUrl = "jdbc:sqlserver://localhost:1433;DataBaseName=db_E";
	private static String dbUser = "sa";
	private static String dbPwd = "sa";
	/*
	// 此方法是为了直接连接C盘的Property文件
	private static void loadProperty() {

		try {
			prop.load(new FileInputStream(PropFileName));
			dbClassName = prop.getProperty("DB_CLASS_NAME");
			dbUrl = prop.getProperty("DB_URL",
					"jdbc:sqlserver://localhost:1433;DatabaseName=shucheng");
			dbUser = prop.getProperty("DB_USER", "sa");
			dbPwd = prop.getProperty("DB_PWD", "sa");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	*/
	/*
	 * 数据库的链接
	 */
	public static Connection getConnection(){
		Connection conn = null;
		//loadProperty();
		
		try{
			Class.forName(dbClassName);
			conn = DriverManager.getConnection(dbUrl,dbUser,dbPwd);	
		} catch(Exception e){
			e.printStackTrace();
		}
		
		if(conn == null){
			System.err.println("警告: DBConnectionManager.getConnection() 获得数据库链接失败.\r\n\r\n链接类型:"
					+ dbClassName
					+ "\r\n链接位置:"
					+ dbUrl
					+ "\r\n用户/密码"
					+ dbUser + "/" + dbPwd);
		}
		return conn;
	}
	
	/*
	 * 执行查询功能
	 */
	 
	public ResultSet executeQuery(String sql){
		try {
			conn = ConnDB.getConnection();
			stmt = conn.createStatement();
			rs= stmt.executeQuery(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;		
	}
	
	/*
	 * 执行更新操作
	 */
	public boolean executeUpdate(String sql){
		try {
			conn = ConnDB.getConnection();
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public int executeUpdate_id(String sql){
		int result = 0;
		try {
			conn = ConnDB.getConnection();
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
			String ID = "select @@IDENTITY as id";
			rs = stmt.executeQuery(ID);
			if(rs.next()){
				int autoID = rs.getInt("ID");
				result = autoID;
			}
		} catch (SQLException e) {
			result = 0;
		}
		
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	/*
	 * 关闭数据库
	 */
	public void close(){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(stmt != null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
