package miu.cs472;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import miu.cs472.model.BeerExpert;

/**
 * Servlet implementation class SimplestServlet
 */
@WebServlet("/BeerSelect")
public class BeerSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public BeerSelect() {
        // TODO Auto-generated constructor stub
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("Beer Selection Advice<br>");
			String c = request.getParameter("color");
			out.println("Got beer color " + c);
			
			BeerExpert be = new BeerExpert();
			List<String> result = be.getBrands(c);
			Iterator<String> it = result.iterator();
			while(it.hasNext()) {
			out.print("<br>try: " + it.next());
		}
    }
}
