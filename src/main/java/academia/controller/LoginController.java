package academia.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import academia.modelo.dao.UsuarioDAO;
import academia.modelo.dao.UsuarioDAOImpl;
import academia.modelo.pojo.Usuario;
import academia.utilidades.Alerta;

/**
 * Servlet implementation class LoginController
 */
@WebServlet(description = "Controlador para gestionar el login de usuarios", urlPatterns = { "/login" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nomUsu=request.getParameter("usuario");
		String pass=request.getParameter("password");
		
		String redireccion="login.jsp";
		
		Usuario usuarioLogeado=null;
		
		UsuarioDAO dao=new UsuarioDAOImpl();
		
		try {
			usuarioLogeado=dao.buscarUsuario(nomUsu, pass);
			
			if (usuarioLogeado!=null) {
				request.getSession().setAttribute("usuario", usuarioLogeado);	
				//request.setAttribute("usuario", usuarioLogeado);
				if (usuarioLogeado.getRol()==Usuario.ROL_PROFESOR ) {
					redireccion="privado/profesor";
					
				}else if(usuarioLogeado.getRol()==Usuario.ROL_USUARIO) {
					redireccion="privado/alumno";
				}
			}else {//si falla el pasword, se mantiene el nombre
				request.setAttribute("nombre", nomUsu);
				request.setAttribute("mensaje", new Alerta("Login incorrecto","alert-danger"));
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			request.getRequestDispatcher(redireccion).forward(request, response);
		}
		
		
		
		
	}

}
