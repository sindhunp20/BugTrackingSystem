package com.code.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.code.bean.Bug;

import com.code.exception.ErrorInExecutionException;
import com.code.service.BugTrackService;
import com.code.service.BugTrackServiceImpl;

//@WebServlet("/AddRemarks")
public class AddRemarks extends HttpServlet {
	private static final long serialVersionUID = 1L;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		BugTrackService bugTrackService = new BugTrackServiceImpl();
		String role = (String) session.getAttribute("type");

		if (role != null && (role.toLowerCase()).equals("developer")) {

			int bugId = Integer.parseInt(request.getParameter("bugId"));

			String remarks = request.getParameter("remarks");

			try {

				bugTrackService.addRemarks(bugId, remarks);

				RequestDispatcher rd = request.getRequestDispatcher("Developer.jsp");
				rd.forward(request, response);
				out.println("Bug has been marked for closing");

			} catch (ErrorInExecutionException e) {
				out.println(e.getMessage());
				RequestDispatcher rd = request.getRequestDispatcher("Developer.jsp");
				rd.include(request, response);
			}
		} else {
			out.println("you are not authorized user");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			session.invalidate();
			rd.include(request, response);

		}

	}

}
