<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Usuário</title>
</head>
<body>

<center>
		<h1>Cadastro de Usuários</h1>
		
	</center>
	<div align="center">

		<form action="ServletLivros" method="post">

			<table border="1" cellpadding="5">
			
					<input type="hidden" name="id" value="" />
				
				<tr>
					<th>Nome:</th>
					<td><input type="text" name="nome" size="45" /></td>
				</tr>
				<tr>
					<th>Telefone:</th>
					<td><input type="text" name="telefone" size="45" />
					</td>
				</tr>
				<tr>
					<th>E-mail:</th>
					<td><input type="email" name="email" size="45" />
					</td>
				</tr>
				<tr>
					<th>Login:</th>
					<td><input type="text" name="login" size="45" />
					</td>
				</tr>
				<tr>
					<th>Senha:</th>
					<td><input type="password" name="senha" size="45" />
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Cadastrar" /> 
				</tr>
			</table>
		</form>
	</div>



</body>
</html>