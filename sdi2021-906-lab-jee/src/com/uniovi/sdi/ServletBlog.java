package com.uniovi.sdi;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/blog")
public class ServletBlog extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public ServletBlog() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
//		HttpSession session = request.getSession();
//		HashMap<String, Integer> comentarios = (HashMap<String, Integer>) request.getSession().getAttribute("carrito");
//		if (comentarios == null) {
//			comentarios = new HashMap<String, Integer>();
//			request.getSession().setAttribute("comentarios", comentarios);
//		}
//		request.setAttribute("paresComentario", comentarios);
//		getServletContext().getRequestDispatcher("/vista-blog.jsp").forward(request,response);
		
		request.setAttribute("comentarios", new ComentariosService().getComentarios());
		getServletContext().getRequestDispatcher("/vista-blog.jsp").forward(request, response);
		
	
		
		
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}
}
