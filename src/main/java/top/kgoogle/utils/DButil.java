package top.kgoogle.utils;

import java.sql.*;

public class DButil {
	private static String userName = "root";
	private static String password = "64204127@" ;
	private static String url = "jdbc:mysql://localhost:3306/kgoogle_top?serverTimezone=GMT";
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private void init() {
		
	}
	public static Connection getConnection(){
	    Connection con=null;
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e2) {
            System.out.println("DButil_update(sql,arg)_ClassNotFound_Class.forName(driver)错误");
            e2.printStackTrace();
        }
        try {
            con =DriverManager.getConnection(url, userName, password);
        } catch (SQLException e1) {
            System.out.println("DButil_update(sql,arg)_SQLException_DriverManager.getConnection(url, userName, password)错误");
            e1.printStackTrace();
        }
        return con;
    }
	public DButil()  {
		init();
	}
	public static void  update(String sql,Object [] arg)   {
		Connection con = null;
		PreparedStatement pstmt = null;
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e2) {
				System.out.println("DButil_update(sql,arg)_ClassNotFound_Class.forName(driver)错误");
				e2.printStackTrace();
			}
			try {
				con =DriverManager.getConnection(url, userName, password);
			} catch (SQLException e1) {
				System.out.println("DButil_update(sql,arg)_SQLException_DriverManager.getConnection(url, userName, password)错误");
				e1.printStackTrace();
			}
			try {
				pstmt = con.prepareStatement(sql);
			} catch (SQLException e1) {
				System.out.println("DButil_update(sql,arg)_SQLException_Connection.prepareStatement(sql)错误");
				e1.printStackTrace();
			}
			for (int a = 0; a < arg.length; a++) {
				try {
					pstmt.setObject(a + 1, arg[a]);
				} catch (SQLException e) {
					System.out.println("DButil_update(sql,arg)_SQLException_PreparedStatement.setObject("+a+"+1,arg["+a+"])错误");
					e.printStackTrace();
				}
			}
			try {
				pstmt.execute();
			} catch (SQLException e1) {
				System.out.println("DButil_update(sql,arg)_SQLException_PreparedStatement.excute()错误");
				e1.printStackTrace();
			}
			try {
				pstmt.close();
			} catch (SQLException e) {
				System.out.println("DButil_update(sql,arg)_SQLException_PreparedStatement.close()错误");
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("DButil_update(sql,arg)_SQLException_Connection.close()错误");
				e.printStackTrace();
			}
	}
	
	public static void update(String sql)  {
		Connection con = null;
		PreparedStatement pstmt = null;
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e2) {
				System.out.println("DButil_update(sql)_ClassNotFound_Class.forName(driver)错误");
				e2.printStackTrace();
			}
			try {
				con =DriverManager.getConnection(url, userName, password);
			} catch (SQLException e1) {
				System.out.println("DButil_update(sql)_SQLException_DriverManager.getConnection()错误");
				e1.printStackTrace();
			}
			try {
				pstmt = con.prepareStatement(sql);
			} catch (SQLException e1) {
				System.out.println("DButil_update(sql)_SQLException_Connection.prepareStatement(sql)错误");
				e1.printStackTrace();
			}
			try {
				pstmt.execute();
			} catch (SQLException e1) {
				System.out.println("DButil_update(sql)_SQLException_PreparedStatement.excute()错误");
				e1.printStackTrace();
			}
			try {
				pstmt.close();
			} catch (SQLException e) {
				System.out.println("DButil_update(sql)_SQLException_PreparedStatement.close()错误");
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("DButil_update(sql)_SQLException_Connection.close()错误");
				e.printStackTrace();
			}
	}
	public static ResultSet select(String sql,Object []arg) {
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pstmt = null;
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				System.out.println("DButil_select(sql,arg)_ClassNotFoundException_Class.forName(driver)错误");
				e.printStackTrace();
			}
			try {
				con = DriverManager.getConnection(url, userName, password);
			} catch (SQLException e) {
				System.out.println("DButil_select(sql,arg)_SQLException_DriverManager.getConnection(url, userName, password)错误");
				e.printStackTrace();
			}
			try {
				pstmt = con.prepareStatement(sql);
			} catch (SQLException e1) {
				System.out.println("DButil_select(sql,arg)_SQLException_Connection.prepareStatement(sql)错误");
				e1.printStackTrace();
			}
			for (int a = 0; a < arg.length; a++) {
				try {
					pstmt.setObject(a + 1, arg[a]);
				} catch (SQLException e) {
					System.out.println("DButil_select(sql,arg)_SQLException_PreparedStatement.setObject("+a+"+1,arg["+a+"])错误");
					e.printStackTrace();
				}
			}
			try {
				rs = pstmt.executeQuery();
			} catch (SQLException e) {
				System.out.println("DButil_select(sql,arg)_SQLException_PreparedStatement.excuteQuery()错误");
				e.printStackTrace();
			}
		return rs;
	}
	public static ResultSet select(String sql)  {
		Connection con=null;
		ResultSet rs=null;
		PreparedStatement stmt = null;
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				System.out.println("DButil_select(sql)_ClassNotFoundException_Class.forName(driver)错误");
				e.printStackTrace();
			}
			try {
				con =DriverManager.getConnection(url, userName, password);
			} catch (SQLException e) {
				System.out.println("DButil_select(sql)_SQLException_DriverManager.getConnection(url, userName, password)错误");
				e.printStackTrace();
			}
			try {
				stmt = con.prepareStatement(sql);
			} catch (SQLException e) {
				System.out.println("DButil_select(sql)_SQLException_Connection.prepareStatement(sql)错误");
				e.printStackTrace();
			}
			try {
				rs = stmt.executeQuery();
			} catch (SQLException e) {
				System.out.println("DButil_select(sql)_SQLException_PreparedStatement.excuteQuery()错误");
				e.printStackTrace();
			}
		return rs;
	}
	
}
