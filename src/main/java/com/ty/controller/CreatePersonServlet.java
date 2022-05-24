package com.ty.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dao.PersonDao;
import com.ty.dto.PersonDto;

@WebServlet(value="/createperson")
public class CreatePersonServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PersonDto person=new PersonDto();
		
		String name=req.getParameter("name");
		String phone=req.getParameter("phone");
		String age=req.getParameter("age");
		String gender=req.getParameter("gender");
		String email=req.getParameter("personEmail");
		String password=req.getParameter("personPassword");
		
		person.setName(name);
		person.setPhone(Long.parseLong(phone));
		person.setAge(Integer.parseInt(age));
		person.setGender(gender);
		person.setEmail(email);
		person.setPassword(password);
		
		PersonDao dao=new PersonDao();
		dao.savePerson(person);
		
		PrintWriter pw = resp.getWriter();
		pw.print("<html><body><h1>Person Created</h1></body></html>");
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("create_person.jsp");
		dispatcher.forward(req, resp);
	}
}
