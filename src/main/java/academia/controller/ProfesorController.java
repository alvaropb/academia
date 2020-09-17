package academia.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import academia.modelo.dao.CursoDAO;
import academia.modelo.dao.CursoDAOImpl;
import academia.modelo.pojo.Curso;
import academia.modelo.pojo.Usuario;

/**
 * Servlet implementation class ProfesorController
 */
@WebServlet("/privado/profesor")
public class ProfesorController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idCursoP = request.getParameter("id");
		Usuario usu = (Usuario) request.getSession().getAttribute("usuario");
		CursoDAO daoCurso = new CursoDAOImpl();
		String redireccion = "";
		try {
			int id = Integer.parseInt(idCursoP);

			// recuperar el curso
			Curso curso = daoCurso.getById(id);

			// comprobar que el curso pertenece al profesor
			if (curso.getProfesor().getId() == usu.getId()) {
				curso = daoCurso.delete(curso.getId());

			}
			request.setAttribute("listaCursos", daoCurso.listarPorProfesor(usu.getId()));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			redireccion = "profesor.jsp";
			request.getRequestDispatcher(redireccion).forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String redireccion = "";
		CursoDAO daoCurso = new CursoDAOImpl();
		Usuario usu = (Usuario) request.getSession().getAttribute("usuario");

		Curso curso = new Curso();

		String nombreCurso = request.getParameter("nombreCurso");
		String identificador = request.getParameter("identificador");
		String horas = request.getParameter("horas");

		try {
			// setear curso y profesor
			if (null!=horas) {
				curso.setHoras(Integer.parseInt(horas));
				curso.setIdentificador(identificador);
				curso.setNombre(nombreCurso);
				curso.setProfesor(usu);
				
				curso=daoCurso.insert(curso);
				request.setAttribute("mensaje", "Insercion correcta");			
			}

			redireccion = "profesor.jsp";
			request.setAttribute("listaCursos", daoCurso.listarPorProfesor(usu.getId()));
		} catch (Exception e) {
			request.setAttribute("mensaje", "Ocurrio un error");
			e.printStackTrace();
		} finally {
			request.getRequestDispatcher(redireccion).forward(request, response);
		}

	}

}
