package academia.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import academia.modelo.dao.CursoDAO;
import academia.modelo.dao.CursoDAOImpl;
import academia.modelo.pojo.Curso;

/**
 * Servlet implementation class CursoController
 */
@WebServlet("/cursos")
public class CursoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CursoDAO dao=new CursoDAOImpl();
		ArrayList<Curso>cursos=new ArrayList<Curso>();
		
		try {
			cursos=dao.listar();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		request.setAttribute("cursos", cursos);
		
		request.getRequestDispatcher("/listaCursos.jsp").forward(request, response);
		
	}

}
