package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.entity.Film;
import com.entity.Kategori;
import com.entity.Yonetmen;


public class YonetmenDao {
public ArrayList<Yonetmen> butunYonetmenleriGetir(){
		
		ArrayList<Yonetmen> yonetmenler = new ArrayList<Yonetmen>();
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/film", "root", "root");
			
			String query = "select * from yonetmen ";
			
			PreparedStatement psmt = conn.prepareStatement(query);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()){
				Yonetmen yonetmen = new Yonetmen(rs.getInt("id"), rs.getString("ad"));
				
				yonetmenler.add(yonetmen);
			}
			
		}/* catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		catch (Exception e) {
			// TODO: handle exception
		}
		return yonetmenler;
	}
}
