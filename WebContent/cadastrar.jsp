<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

		<form action="ServletsContato" method="post">

			<table border="1" cellpadding="5">

				<input type="hidden" name="id" value="" />

				<tr>
					<th>ID:</th>
					<td><input type="text" name="nome" id="id"placeholder="ID" size="45" value="${cont.id }" /></td>
				</tr>
				<tr>
					<th>Nome:</th>
					<td><input type="text" name="nome" size="45" value="${cont.nome }" /></td>
				</tr>
				<tr>
					<th>Telefone:</th>
					<td><input type="text" name="telefone" size="45" value="${cont.telefone }" /></td>
				</tr>
				<tr>
					<th>E-mail:</th>
					<td><input type="email" name="email" size="45" value="${cont.email }"/></td>
				</tr>
				<tr>
					<th>Login:</th>
					<td><input type="text" name="login" size="45" value="${cont.login }" /></td>
				</tr>
				<tr>
					<th>Senha:</th>
					<td><input type="password" name="senha" size="45" value="${cont.senha }" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Cadastrar" />
				</tr>
			</table>
		</form>
	</div>

	<br />
	<br />

	<div align="center">
		<table border="1" clellpadding="5">

			<caption>
				<h2>Lista de Livros</h2>
			</caption>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Telefone</th>
				<th>E-mail</th>
				<th>Ações</th>
			</tr>

			<c:forEach items="${contatos }" var="cont">

				<tr>

					<td><c:out value="${cont.id }"></c:out></td>
					<td><c:out value="${cont.nome }"></c:out></td>
					<td><c:out value="${cont.telefone }"></c:out></td>
					<td><c:out value="${cont.email }"></c:out></td>

					<td><a href="ServletsContato?acao=editar&cont=${cont.id }">Editar</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="ServletsContato?acao=delete&cont=${cont.id }"
						onclick="return confirm('Tem certeza que deseja excluir ?')">Deletar</a>
					</td>

				</tr>

			</c:forEach>

		</table>

	</div>


</body>
</html>