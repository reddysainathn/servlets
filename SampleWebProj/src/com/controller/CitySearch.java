package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import com.dao.CityDAO;
import com.vo.City;


@WebServlet(value="/CitySearch",initParams={@WebInitParam(name="driver",value="com.gjt.mm.mysql.driver"),
@WebInitParam(name="url",value="jdbc:mysql://localhost:3333/world")})
public class CitySearch extends GenericServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       @Override
    public void init(ServletConfig config) throws ServletException {

    	ServletContext servletContext = config.getServletContext();   
    	   
       String driverclass = config.getInitParameter("driver");
       String urlclass = config.getInitParameter("url");
       
       String username=servletContext.getInitParameter("username");
       String password=servletContext.getInitParameter("password");
       }
   
    public CitySearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		//We get the servletContext from init ,we can get by request in servcie method()
		ServletContext context = request.getServletContext();
		
		
		int id =Integer.parseInt(request.getParameter("cityID"));
	CityDAO cityDAO = new CityDAO();
	
	City city = cityDAO.getCityById(id);
	
	PrintWriter out = response.getWriter();
	
	out.println("<html><body>");
	out.println("<h2 align='center'>City Record</h2>");
	out.println("<table border =2 align='center'>");
	out.println("<tr><th>id</th><th>name</th><th>countrycode</th><th>district</th><th>population</th></tr>");
	
	out.println("<tr>");
	
	out.println("<td>"+city.getId()+"</td>");
	out.println("<td>"+city.getName()+"</td>");
	out.println("<td>"+city.getCountryCode()+"</td>");
	out.println("<td>"+city.getDistrict()+"</td>");
	out.println("<td>"+city.getPoulation()+"</td>");
	
	out.println("<tr>");
	

	out.println("</table>");
	out.println("</body></html>");
	
	}
}


