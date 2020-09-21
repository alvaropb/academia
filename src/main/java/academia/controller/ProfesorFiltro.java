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
 * Servlet Filter implementation class ProfesorFiltro
 */
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD
		}
					, urlPatterns = { "/privado/profesor" })
public class ProfesorFiltro implements Filter {

	private final static Logger LOG = Logger.getLogger(ProfesorFiltro.class);
    /**
     * Default constructor. 
     */
    public ProfesorFiltro() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest httpReq=(HttpServletRequest) request;
		HttpSession httpSesion=httpReq.getSession();
		Usuario usu=(Usuario) httpSesion.getAttribute("usuario");
		
		HttpServletResponse httpRes=(HttpServletResponse) response;
		if (usu!=null) {
			if (Usuario.ROL_PROFESOR == usu.getRol()) {
				// pass the request along the filter chain
				chain.doFilter(request, response);
				
			}else if (Usuario.ROL_USUARIO == usu.getRol()) {
				LOG.warn("alumno intento ir a seccion profesores");
				httpRes.sendRedirect(httpReq.getContextPath()+"/privado/alumno");
			}
		}else {
			LOG.warn("Se intento entrar a zona de profesor sin permisos");
			httpRes.sendRedirect(httpReq.getContextPath()+"/login.jsp");
		}
		
		

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
