package academia.controller;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class AlumnoController
 */
@WebServlet("/privado/alumno")
public class AlumnoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(AlumnoController.class);

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String redireccion="alumno.jsp";
		
		CursoDAO daoCurso=CursoDAOImpl.getInstance();
		
		
		
		String idCursoP=request.getParameter("cursoApuntarse");
		//Sacar el id del alumno del usuario de sesion;
		Usuario usu=(Usuario) request.getSession().getAttribute("usuario");
		
		//cargar los cursos en los que esta apuntado el alumno
		ArrayList<Curso>cursosInscrito=new ArrayList<Curso>();
		ArrayList<Curso>ofertaCursos=new ArrayList<Curso>();
		
		
		try {
			if (idCursoP!=null) {
				int idCurso=Integer.parseInt(idCursoP);
				
				int idGenerada=daoCurso.inscribirCurso(idCurso,usu.getId());
				if (idGenerada>0) {
					request.setAttribute("mensaje", new Alerta("Se dio de alta correctamente", "alert-success"));					
				}else {
					request.setAttribute("mensaje", new Alerta("Ocurrio un error al dar de alta", "alert-danger"));
				}
			}
			
			cursosInscrito=daoCurso.getByIdAlumno(usu.getId(),Boolean.TRUE);
			ofertaCursos=daoCurso.getByIdAlumno(usu.getId(),Boolean.FALSE);
		} catch (Exception e) {
			
			LOG.error(e);
		}finally {
			request.setAttribute("listaCursos", cursosInscrito);
			request.setAttribute("ofertaCursos", ofertaCursos);
			request.getRequestDispatcher(redireccion).forward(request, response);
		}
		
		
	}

}
