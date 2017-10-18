package com.domain;

import java.math.BigDecimal;

public class Borrower {

	private String cardNO;
	private String name;
	private String addr;
	private String phone;
	private String password;

	/**
	 * 
	 */
	public Borrower() {
		super();
	}
	/**
	 * @param cardNO
	 * @param name
	 * @param address
	 * @param phone
	 */
	public Borrower(String cardNO, String name, String addr, String phone, String passwd) {
		super();
		this.cardNO = cardNO;
		this.name = name;
		this.addr = addr;
		this.phone = phone;
		this.password = passwd;
	}
	/**
	 * @return the cardNO
	 */
	public String getcardNO() {
		return cardNO;
	}
	/**
	 * @param cardNO the cardNO to set
	 */
	public void setcardNO(String cardNO) {
		this.cardNO = cardNO;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param fname the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the address
	 */
	public String getAddr() {
		return addr;
	}
	/**
	 * @param lname the address to set
	 */
	public void setAddr(String addr) {
		this.addr = addr;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param salary the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param salary the password to set
	 */
	public void setPassword(String passwd) {
		this.password = passwd;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Borrower [cardNO=" + cardNO + "|| name=" + name + "|| address=" + addr + "|| phone=" + phone + "]";
	}





}
