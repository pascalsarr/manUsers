<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajout d'un utilisateur</title>
<link rel="stylesheet" href="<c:url value='/css/style.css'/>">
</head>
<body>
	<c:import url="inc/entete.jsp"/>
	<c:import url="inc/menu.jsp"/>
	<h1>Ajout d'un utilisateur</h1>
	<form method="post">
		<fieldset>
			<legend>Ajout d'un utilisateur</legend>
			<span class="${ form.isValid() ? 'succes':'erreur' }">${ form.statusMessage }</span><br><br>
			<label>Nom</label>
			<input type="text" name="nom" value="${ form.utilisateur.nom }">
			<span>${ form.messageErreur.nom }</span><br>
			<label>Prénom</label>
			<input type="text" name="prenom"value="${ form.utilisateur.prenom }">
			<span>${ form.messageErreur.prenom }</span><br>
			<label>Login</label>
			<input type="text" name="login"value="${ form.utilisateur.login }">
			<span>${ form.messageErreur.login }</span><br>
			<label>Password</label>
			<input type="password" name="password">
			<span>${ form.messageErreur.password }</span><br>
			<input type="submit" value="Enregistrer">
		</fieldset>
	</form>
</body>
</html>