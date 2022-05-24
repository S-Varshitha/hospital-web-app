package com.ty.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dao.PersonDao;
import com.ty.dto.PersonDto;

@WebServlet(value="/displaypersons")
public class GetPersonsServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PersonDao dao=new PersonDao();
		List<PersonDto> persons = dao.getAllPerson();
		req.setAttribute("personsList", persons);
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("display_persons.jsp");
		dispatcher.forward(req, resp);
	}
}
