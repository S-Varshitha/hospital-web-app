package com.ty.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.dao.EncounterDao;
import com.ty.dto.EncounterDto;

@WebServlet(value = "/createencounter")
public class CreateEncounterServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession();
		Integer branchId = (Integer) httpSession.getAttribute("branchid");
		String name = (String) httpSession.getAttribute("name");
		String date = req.getParameter("date");
		String time = req.getParameter("time");
		LocalDate admitDate = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
		LocalTime admitTime = LocalTime.parse(time, DateTimeFormatter.ISO_TIME);
		String reason = req.getParameter("reason");
		// int personId=Integer.parseInt((String)req.getAttribute("personid"));
		int personId = Integer.parseInt(req.getParameter("personid"));
		EncounterDto encounter = new EncounterDto();
		encounter.setReason(reason);
		encounter.setDate(admitDate);
		encounter.setTime(admitTime);
		encounter.setCreatorName(name);

		EncounterDao dao = new EncounterDao();
		dao.saveEncounter(personId, branchId, encounter);

		RequestDispatcher dispatcher = req.getRequestDispatcher("create_encounter.jsp");
		dispatcher.forward(req, resp);
	}
}
