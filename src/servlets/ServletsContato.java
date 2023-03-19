package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoContatos;
import model.Contatos;

@WebServlet("/ServletsContato")
public class ServletsContato extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DaoContatos daoContatos = new DaoContatos();

	public ServletsContato() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String acao = request.getParameter("acao");
			String cont = request.getParameter("cont");

			if (acao.equalsIgnoreCase("delete")) {

				daoContatos.delete(cont);

				RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrar.jsp");
				request.setAttribute("contatos", daoContatos.listarContatos());
				dispatcher.forward(request, response);

			}

			else if (acao.equalsIgnoreCase("listartodos")) {

				RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrar.jsp");
				request.setAttribute("contatos", daoContatos.listarContatos());
				dispatcher.forward(request, response);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String id = request.getParameter("id");
			String nome = request.getParameter("nome");
			String telefone = request.getParameter("telefone");
			String email = request.getParameter("email");
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");

			Contatos contatos = new Contatos();

			contatos.setId(id != null && !id.isEmpty() ? Long.parseLong(id) : null);
			contatos.setNome(nome);
			contatos.setTelefone(telefone);
			contatos.setEmail(email);
			contatos.setLogin(login);
			contatos.setSenha(senha);

			if (id == null || id.isEmpty()) {

				daoContatos.salvarContatos(contatos);
			}

			RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrar.jsp");
			request.setAttribute("contatos", daoContatos.listarContatos());
			dispatcher.forward(request, response);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
