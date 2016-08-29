package com.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.FilmDao;
import com.entity.Film;

/**
 * Servlet implementation class FavoriEkleServlet
 */
@WebServlet("/favoriekle")
public class FavoriEkleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		int filmid = Integer.valueOf(request.getParameter("filmid"));
		Film film = new FilmDao().filmAyrintiGetir(filmid);
		
		ArrayList<Film> favoriler = new ArrayList<Film>();
		if(request.getSession().getAttribute("favoriler")!=null){
			favoriler=(ArrayList<Film>)request.getSession().getAttribute("favoriler");
		}
		
		favoriler.add(film);
		request.getSession().setAttribute("favoriler", favoriler);
		
		request.getRequestDispatcher("filmdetay?filmid="+filmid).forward(request, response);
		
	}

}
