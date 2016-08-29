package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.FilmDao;
import com.entity.Film;

/**
 * Servlet implementation class FilmAyrintiServlet
 */
@WebServlet("/filmdetay")
public class FilmAyrintiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		int filmid = Integer.valueOf(request.getParameter("filmid"));
		Film film = new FilmDao().filmAyrintiGetir(filmid);
		request.setAttribute("film", film);
		request.getRequestDispatcher("filmayrinti.jsp").forward(request, response);
	}

}
