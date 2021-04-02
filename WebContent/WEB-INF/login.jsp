<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page de connexion</title>
</head>
<body>
	<h1>Authentification</h1>
	<form method="post">
		<fieldset>
			<legend>Connexion</legend>
			Login <input type="text" name="login" value="${ utilisateur.login }">
			Password <input type="password" name="password">
			<input type="submit" value="Se connecter">
		</fieldset>
	</form>
</body>
</html>