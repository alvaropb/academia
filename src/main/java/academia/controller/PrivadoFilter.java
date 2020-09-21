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
 * Servlet Filter implementation class PrivadoFilter
 */
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD
		}
					, urlPatterns = { "/privado/*" })
public class PrivadoFilter implements Filter {

	private final static Logger LOG = Logger.getLogger(PrivadoFilter.class);
	
    /**
     * Default constructor. 
     */
    public PrivadoFilter() {
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
		
		
		HttpServletRequest reqHttp=(HttpServletRequest)request;
		HttpSession sesion=reqHttp.getSession();		
		Usuario usuSesion=(Usuario) sesion.getAttribute("usuario");
		
		if (usuSesion==null) {
			LOG.trace("usuario intenta entrar sin permisos o sesion");
			HttpServletResponse resHttp=(HttpServletResponse) response;
			resHttp.sendRedirect(reqHttp.getContextPath()+"/login.jsp");
			
		}else {
			chain.doFilter(request, response);	
		}

		// pass the request along the filter chain
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
