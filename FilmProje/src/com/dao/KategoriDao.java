package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import com.entity.Kategori;



public class KategoriDao {
	
	public ArrayList<Kategori> butunKategorileriGetir(){
		
		
			
			ArrayList<Kategori> kategoriler = new ArrayList<Kategori>();
			
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/film", "root", "root");
				String query = "select * from kategori ";
				PreparedStatement psmt = conn.prepareStatement(query);
				ResultSet rs = psmt.executeQuery();
				while(rs.next()){
					Kategori kategori = new Kategori(rs.getInt("id"), rs.getString("ad"));
				
					kategoriler.add(kategori);
				}
				
			}/* catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			catch (Exception e) {
				// TODO: handle exception
			}
			return kategoriler;
		}
	
}
