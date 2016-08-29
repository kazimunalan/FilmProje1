package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.entity.Film;
import com.entity.Kategori;
import com.entity.Yonetmen;

public class FilmDao {
	
	public Film filmAyrintiGetir(int filmid){
		
		Film f = new Film();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/film", "root", "root");
			
			String query = "select f.id, f.ad, f.sene, k.id as katid, k.ad as katad, y.id as yonid, y.ad as yonad " + 
							"from film f inner join kategori k on f.kategori_id=k.id inner join "+
							"yonetmen y on f.yonetmen_id=y.id where f.id=? ";
			
			PreparedStatement psmt = conn.prepareStatement(query);
			psmt.setInt(1, filmid);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()){
				Yonetmen yonetmen = new Yonetmen(rs.getInt("yonid"), rs.getString("yonad"));
				Kategori kategori = new Kategori(rs.getInt("katid"),rs.getString("katad"));
				f = new Film(rs.getInt("id"),rs.getInt("sene"), rs.getString("ad"), yonetmen, kategori);
				
			}
			
		}/* catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return f;
		
		
	}
	
	public ArrayList<Film> kategoriyeAitFilmleriGetir(int katid){
		
		ArrayList<Film> filmler = new ArrayList<Film>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/film", "root", "root");
			
			String query = "select f.id, f.ad, f.sene, k.id as katid, k.ad as katad, y.id as yonid, y.ad as yonad " + 
							"from film f inner join kategori k on f.kategori_id=k.id inner join "+
							"yonetmen y on f.yonetmen_id=y.id where kategori_id=? ";
			
			PreparedStatement psmt = conn.prepareStatement(query);
			psmt.setInt(1, katid);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()){
				Yonetmen yonetmen = new Yonetmen(rs.getInt("yonid"), rs.getString("yonad"));
				Kategori kategori = new Kategori(rs.getInt("katid"),rs.getString("katad"));
				Film film = new Film(rs.getInt("id"),rs.getInt("sene"), rs.getString("ad"), yonetmen, kategori );
				filmler.add(film);
			}
			
		}/* catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return filmler;
		
	}
	
	public ArrayList<Film> butunFilmleriGetir(){
		
		ArrayList<Film> filmler = new ArrayList<Film>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/film", "root", "root");
			
			String query = "select f.id, f.ad, f.sene, k.id as katid, k.ad as katad, y.id as yonid, y.ad as yonad " + 
							"from film f inner join kategori k on f.kategori_id=k.id inner join "+
							"yonetmen y on f.yonetmen_id=y.id ";
			
			PreparedStatement psmt = conn.prepareStatement(query);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()){
				Yonetmen yonetmen = new Yonetmen(rs.getInt("yonid"), rs.getString("yonad"));
				Kategori kategori = new Kategori(rs.getInt("katid"),rs.getString("katad"));
				Film film = new Film(rs.getInt("id"),rs.getInt("sene"), rs.getString("ad"), yonetmen, kategori );
				filmler.add(film);
			}
			
		}/* catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return filmler;
	}
	
	

	
	public boolean yeniFilmKaydet(Film yeniFilm){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/film", "root", "root");
			
			String query = "insert into film(ad,sene,yonetmen_id,kategori_id) values(????) ";
			
			PreparedStatement psmt = conn.prepareStatement(query);
			psmt.setString(1, yeniFilm.getAd());
			psmt.setInt(2, yeniFilm.getSene());
			psmt.setInt(3, yeniFilm.getYonetmen().getId());
			psmt.setInt(4, yeniFilm.getKategori().getId());
			
			psmt.executeUpdate();
			return true;
			
		}/* catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
	}
	
}
