package academia.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import academia.modelo.dao.CursoDAO;
import academia.modelo.dao.CursoDAOImpl;
import academia.modelo.pojo.Curso;
import academia.modelo.pojo.Usuario;
import academia.utilidades.Alerta;

/**
 * Servlet implementation class ProfesorController
 */
@WebServlet("/privado/profesor")
public class ProfesorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(ProfesorController.class);
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idCursoP = request.getParameter("id");
		Usuario usu = (Usuario) request.getSession().getAttribute("usuario");
		CursoDAO daoCurso = CursoDAOImpl.getInstance();
		String redireccion = "";
		try {
			if (idCursoP!=null) {
				int id = Integer.parseInt(idCursoP);
				
				// recuperar el curso
				Curso curso = daoCurso.getById(id);
				
				// comprobar que el curso pertenece al profesor
				if (curso.getProfesor().getId() == usu.getId()) {
					curso = daoCurso.delete(curso.getId());
					request.setAttribute("mensaje", new Alerta("Eliminacion correcta", "alert-success"));	
				}
				
			}
			
			request.setAttribute("listaCursos", daoCurso.listarPorProfesor(usu.getId()));

		} catch (Exception e) {
			LOG.error(e);
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
		CursoDAO daoCurso = CursoDAOImpl.getInstance();
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
				request.setAttribute("mensaje", new Alerta("Insercion correcta", "alert-success"));			
			}

			redireccion = "profesor.jsp";
			request.setAttribute("listaCursos", daoCurso.listarPorProfesor(usu.getId()));
		} catch (Exception e) {
			request.setAttribute("mensaje", new Alerta("Ocurrio un error", "alert-danger"));
			LOG.error(e);
		} finally {
			request.getRequestDispatcher(redireccion).forward(request, response);
		}

	}

}
