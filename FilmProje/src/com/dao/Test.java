package com.dao;

import java.sql.*;
public class Test {
	
	private String Host;
	private String User;
	private String Password;
	
	public static void main(String[] args) {
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/film","root","root");
			Statement myStmt = conn.createStatement();
			ResultSet myRs = myStmt.executeQuery("select * from kategori");
			while (myRs.next()) {
				System.out.println(myRs.getInt("id")+ myRs.getString("ad"));
				Testi test= new Testi();
				test.setAd(myRs.getString("first_name"));
				test.setSoyad(myRs.getString("last_name"));
				System.out.println(test.getAd());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}
class Testi{
	public String ad;
	public String soyad;
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public String getSoyad() {
		return soyad;
	}
	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}
	
}
	
