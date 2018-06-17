package com.mvinovacao.cadastro.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class Corconfig implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletResponse res = (HttpServletResponse) response;
		// configuração do CORS

		res.setHeader("Access-Control-Allow-Origin", "*");
		res.setHeader("Access-Control-Allow-Methods", "POST,PUT,DELETE,GET,PATCH,OPTIONS");
		res.setHeader("Access-Control-Allow-Headers", "*");
		res.setHeader("Access-Control-Expose-Headers", "Autorization, Location");
		res.setHeader("Access-Control-Max-Age", "3600");

		chain.doFilter(request, response);

	}

	@Override
	public void destroy() {
	}

}
