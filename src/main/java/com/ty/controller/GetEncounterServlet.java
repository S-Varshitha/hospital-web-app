package com.ty.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dao.EncounterDao;
import com.ty.dto.EncounterDto;
@WebServlet(value="/displayencounter")
public class GetEncounterServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EncounterDao dao= new EncounterDao();
		int personId=Integer.parseInt(req.getParameter("personid")); 
		List<EncounterDto> encounterList=dao.getEncounterByPersonId(personId);
		req.setAttribute("encounterList", encounterList);
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("display_encounter.jsp");
		dispatcher.forward(req, resp);
	}
}
