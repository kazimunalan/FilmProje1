package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GirisServlet
 */
@WebServlet("/giris")
public class GirisServlet extends HttpServlet {
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
		String kullanici = request.getParameter("kullaniciadi");
		String sifre = request.getParameter("sifre");
		
		
		if(sifre.equals("1234") && kullanici.equals("kazim")){
			request.getSession().setAttribute("kullanici", kullanici);
			response.sendRedirect("index.jsp");			
		}else{
			String mesaj = "Kullanýcý Adý veya Þifre hatalý";
			request.setAttribute("mesaj", mesaj);
			request.getRequestDispatcher("uyegiris.jsp").forward(request, response);
			
		}
	}

}
