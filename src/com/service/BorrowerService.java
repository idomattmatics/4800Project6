package com.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dao.BorrowerDAO;
import com.domain.Borrower;
import com.util.ConnectionFactory;

public class BorrowerService {
	
	public BorrowerService() {
		
	}
	
	public List<Borrower> getbwrList() {
		List<Borrower> bwrList = new ArrayList<Borrower>();
		BorrowerDAO bwrDAO = new BorrowerDAO();
		//bwrList = bwrDAO.getBwrList();		
		return bwrList;
		
	}
	/*
	public List<HashMap<String,Object>> getAllDepts() {
		List<HashMap<String,Object>> deptList = new ArrayList<HashMap<String,Object>>();
		BorrowerDAO empDAO = new BorrowerDAO();
		deptList = empDAO.getAllDepts();		
		return deptList;
	}
	*/
	public Borrower getBorrower(String cardNO){
		BorrowerDAO bwrDAO = new BorrowerDAO();
		Borrower b = bwrDAO.getBorrower(cardNO);
		return b;
	}
	public void insert(Borrower Borrower) {
		BorrowerDAO bwrDAO = new BorrowerDAO();
		bwrDAO.insert(Borrower);		
	}
	
	

}
