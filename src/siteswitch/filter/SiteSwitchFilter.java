package siteswitch.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import siteswitch.config.SwitchConfigurationReader;


/**
 * Servlet Filter implementation class SiteSwitchFilter
 */
public class SiteSwitchFilter implements Filter {

    private SwitchConfigurationReader config = null;
	
	/**
     * Default constructor. 
     */
    public SiteSwitchFilter() {
        
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		String uri = ((HttpServletRequest)request).getRequestURI();
		
		if(!getConfig().isComponentOn(uri)){
			throw new ServletException("Requested URI is currently switched off: " + uri);
		}
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		setConfig(SwitchConfigurationReader.getInstance());
	}

	public SwitchConfigurationReader getConfig() {
		return config;
	}

	public void setConfig(SwitchConfigurationReader config) {
		this.config = config;
	}

}
