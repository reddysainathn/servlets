package com.listener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class SampleListener implements ServletContextListener {

   
    public SampleListener() {
    }

    public void contextInitialized(ServletContextEvent contextEvent)  { 
    	
    	System.out.println("**************** SampleListener:contextInitialized ****************");
    	Connection connection = null;
		try {
			
			//Step1: Load Drivers
			Class.forName("org.gjt.mm.mysql.Driver");
			
			//Step-2:Establishing Connection
			
			 connection =DriverManager.getConnection("jdbc:mysql://localhost:3333/world","root","root");
			 
			 ServletContext servletContext = contextEvent.getServletContext();
			 
			 servletContext.setAttribute("connection", connection);
			
		
 } catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    	
    }
    public void contextDestroyed(ServletContextEvent contextEvent)  {
    	
    	System.out.println("**************** SampleListener:contextDestroyed ****************");
    	
    	ServletContext servletContext = contextEvent.getServletContext();
    	try{
    	Connection connection = (Connection) servletContext.getAttribute("connection");
    	connection.close();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
	
}
