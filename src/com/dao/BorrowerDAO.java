package com.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import com.domain.Borrower;
import com.util.ConnectionFactory;

public class BorrowerDAO {
	
	SqlSession session = ConnectionFactory.getSqlSessionFactory().openSession();

	public List<Borrower> getBwrList() {
		List<Borrower> bwrList = new ArrayList<Borrower>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rst = null;
		String URL = "jdbc:oracle:thin:@dataserv.mscs.mu.edu:1521:orcl";

		try {
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch(ClassNotFoundException e){
				System.out.println("Could not load the driver"+e.getMessage());
			}
			String user = "kachar";
			String pwd = "005929907";
			conn = DriverManager.getConnection(URL, user, pwd);
			stmt = conn.createStatement();

			String query = "select * from Borrower";

			rst = stmt.executeQuery(query);
			//int counter = 0;
			while (rst.next()) {
				//double salary = rst.getDouble("salary");
				//System.out.println(rst.getString(1)+" "+rst.getString(2)+" "+salary);
				Borrower b = new Borrower(rst.getString("cardNO"),rst.getString("name"), rst.getString("address"), rst.getString("phone"), rst.getString("Password"));
				bwrList.add(b);
				//counter++;
			}
			rst.close();
			stmt.close();
			conn.close();
			System.out.println("\nQuery executed. Connection closed");
		} catch(SQLException e) {
			System.out.println("Exception at the end of main try block ");
			while (e != null) {
				System.out.println(e.getSQLState());
				System.out.println(e.getMessage());
				System.out.println(e.getErrorCode());
				e = e.getNextException();
			}
		} finally {
			if (conn != null) {
				try {
					rst.close();
					stmt.close();
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return bwrList;
	}


	public List<HashMap<String,Object>> getBookList() {
		List<HashMap<String,Object>> deptList = new ArrayList<HashMap<String,Object>>();



		try {
			deptList = session.selectList("com.mapper.CompanyMapper.selectAllDepts");
		} finally {
			session.close();
		}
		return deptList;
	}

	public void insert(Borrower bwr) {		
		SqlSession session = ConnectionFactory.getSqlSessionFactory().openSession();

		try {
			session.insert("com.mapper.CompanyMapper.insertBorrower",bwr);
			session.commit();
		} finally {
			session.close();
		}
	}


	public Borrower getBorrower(String cardNO) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rst = null;
		String URL = "jdbc:oracle:thin:@dataserv.mscs.mu.edu:1521:orcl";
		Borrower b = null;
		
		try {
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch(ClassNotFoundException e){
				System.out.println("Could not load the driver"+e.getMessage());
			}
			String user = "kachar";
			String pwd = "005929907";
			conn = DriverManager.getConnection(URL, user, pwd);
			stmt = conn.createStatement();

			String query = "select * from Borrower where CardNO = " +cardNO;
			rst = stmt.executeQuery(query);
			while (rst.next()) {
				b = new Borrower(rst.getString("cardNO"),rst.getString("name"), rst.getString("address"), rst.getString("phone"), rst.getString("Password"));
			}
			rst.close();
			stmt.close();
			conn.close();
			System.out.println("\nQuery executed. Connection closed");
		} catch(SQLException e) {
			System.out.println("Exception at the end of main try block ");
			while (e != null) {
				System.out.println(e.getSQLState());
				System.out.println(e.getMessage());
				System.out.println(e.getErrorCode());
				e = e.getNextException();
			}
		} finally {
			if (conn != null) {
				try {
					rst.close();
					stmt.close();
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
			
		return b;
	}
}
