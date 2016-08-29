<%@page import="com.dao.KategoriDao"%>
<%@page import="com.entity.Kategori"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%
    	ArrayList<Kategori> kategoriler = new KategoriDao().butunKategorileriGetir();	
    	request.setAttribute("kategoriler", kategoriler);
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Film Sitesi</title>
<link rel="stylesheet" href="style.css"/>
</head>
<body>
<div id="main">
	<div id="header"><h2>Film Sitesi</h2>
		<img  src="images/logo_images.jpg" style="position: absolute; right: 100px; top: 20px;"/>
	</div>
	<div>
		<a href="index.jsp">Ana Sayfa</a>&nbsp;&nbsp;&nbsp;
		<a href="hakkimizda.jsp">Hakkimizda</a>&nbsp;&nbsp;&nbsp;
		<c:if test="${empty kullanici}">
				<a href="uyegiris.jsp">Uye Girisi</a>&nbsp;&nbsp;&nbsp;
		</c:if>
		<c:if test="${not empty kullanici}">
				<a href="uyecikis">Üye Çıkış</a>&nbsp;&nbsp;&nbsp;
				<a href="guvenli/filmekle.jsp">Film Ekle</a>&nbsp;&nbsp;&nbsp;
		</c:if>
		&nbsp;&nbsp;&nbsp;
		<c:if test="${not empty kullanici}">
 			<span style="color: red;">Merhaba ${kullanici}</span>
 		</c:if>
	</div>
	<div id="contentmain">
		<div id="menu">
			<h4>Kategoriler</h4>
			<c:forEach items="${kategoriler}" var="kategori">
				<a href="filmler?katid=${kategori.id}">${kategori.ad}</a></br>
			</c:forEach>
		<hr/>
		<c:if test="${not empty favoriler}">
		<h4>Favoriler</h4>
		<c:forEach items="${favoriler}" var="film">
				<a href="filmldetay?filmid=${film.id}">${film.ad}</a></br>
			</c:forEach>
		</c:if>
		
		</div>
		<div id="content">