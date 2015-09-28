package com.manju.learn;
 
import com.paango.dao.CoursesDAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
 * Servlet implementation class Courses
 */
@WebServlet("/Courses")
public class Courses extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpServletResponse response;
	/**
	 * Default constructor.
	 */
	CoursesDAO course=new CoursesDAO();
	
  
	  
	public Courses() {
		System.out.println("Main");
 
 
 
 
 /*
PrintWriter pw = response.getWriter();
pw.println("fghfg");*/


		// TODO Auto-generated constructor stub
	}
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//doGet(request, response);
		 
		
		PrintWriter pw = response.getWriter();

		// Below lines used to print a value in a Apache browser or in a browser
		pw.println("<h1>Course Name</h1>" + request.getParameter("cname"));
		pw.println("<h1>Course Description </h1>" + request.getParameter("cdesc"));
		
		pw.println("<h1>level</h1>" + request.getParameter("level"));
		
		pw.println("<h2>Who should do this course?:</h2>" + request.getParameter("tarea1"));
		pw.println("<h2>What are the prerequisites?:</h2>" + request.getParameter("tarea2"));
		pw.println("<h2>Skills acquired in this course </h2>" + request.getParameter("tarea3"));

		// Below lines used to print a value in a console
		System.out.println("<h1>Course Name</h1>" +request.getParameter("cname"));
		System.out.println("<h1>Course Description </h1>" +request.getParameter("cdesc"));
		System.out.println("<h1>level</h1>" +request.getParameter("level"));
		System.out.println("<h2>Who should do this course?:</h2>" +request.getParameter("tarea1"));
		System.out.println("<h2>What are the prerequisites?:</h2>"+request.getParameter("tarea2"));
		System.out.println("<h2>Skills acquired in this course </h2>" +request.getParameter("tarea3"));

		
 
		course.setCourseDescription(request.getParameter("cdesc"));
		course.setCourseName(request.getParameter("cname"));
		course.setLevel(request.getParameter("level"));
		course.setPrerequisites(request.getParameter("tarea2"));
		course.setSkillsAcquired(request.getParameter("tarea3"));
		course.setWhoShouldDoThisCourse(request.getParameter("tarea1"));
		
		course.insert("http://localhost:5984/courses");
		
		
		doGet(request, response);
		
	}
	
	 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		
		PrintWriter pw = response.getWriter();
		   
	try {
			  
			 
			String s= course.getAllCourses();
		  
			 
				 
				
				pw.println(s);	
			 
		 
			//pw.println(s);
			 
			 //pw.println(s);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
		
		 
		
		/*
		
		  URL obj = new URL("http://localhost:5984/courses/_design/lms/_view/mycourses");
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/json");
			con.setDoInput(true);
			 
			 	   
			
			BufferedReader in = new BufferedReader(new
					InputStreamReader(con.getInputStream()));
			
			String inputLine;
			String send="";
		 
		
	 
	  
	 
		pw.println("<TABLE>");
		while ((inputLine = in.readLine()) != null) {
		 pw.println("<TR>");
		 pw.println("<TD>"+inputLine+"</TD>");
		 pw.println("</TR>");
			
		 
			  pw.println("<td>"+inputLine+"<td>");
		 
			 	} 
			 
		}
		 
		
		
		
		
		
		
		
		
		
		
		
		
 

	/** 
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}