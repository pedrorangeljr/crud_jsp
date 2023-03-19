<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

	<div align="center">

		<form action="servletsLogin" method="post">

			<table border="1" cellpadding="5">

				<br/>
				
				<h2>Login Usuário Sistema JSP</h2>
				
				<br/>

				<tr>
					<th>Login:</th>
					<td><input type="text" name="login" size="45" /></td>
				</tr>
				<tr>
					<th>Senha:</th>
					<td><input type="password" name="senha" size="45" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Logar" />
				</tr>
			</table>
		</form>
	</div>


</body>
</html>