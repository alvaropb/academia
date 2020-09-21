package academia.controller;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import academia.modelo.pojo.Usuario;

/**
 * Servlet Filter implementation class AlumnoFiltro
 */
@WebFilter(dispatcherTypes = { DispatcherType.REQUEST, DispatcherType.FORWARD }, urlPatterns = { "/privado/alumno" })
public class AlumnoFiltro implements Filter {
	
	private final static Logger LOG = Logger.getLogger(AlumnoFiltro.class);
	/**
	 * Default constructor.
	 */
	public AlumnoFiltro() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession sesion = req.getSession();
		Usuario usu = (Usuario) sesion.getAttribute("usuario");
		
		HttpServletResponse res=(HttpServletResponse) response;

		if (usu == null) {
			LOG.trace("Usuario intento entrar sin permisos");
			res.sendRedirect(req.getContextPath()+"/login.jsp");
		} else {
			if (Usuario.ROL_USUARIO == usu.getRol()) {
				chain.doFilter(request, response);
			}else {
				LOG.trace("profesor intentó entrar a seccion de alumnos");
				res.sendRedirect(req.getContextPath()+"/privado/profesor");
			}
		}

		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
