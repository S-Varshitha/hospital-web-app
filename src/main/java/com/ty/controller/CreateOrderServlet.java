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

import com.ty.dao.MedOrderDao;
import com.ty.dto.MedOrderDto;

@WebServlet(value="/createorder")
public class CreateOrderServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int encounterId=Integer.parseInt(req.getParameter("encounterid"));
		String date=req.getParameter("date");
		String time=req.getParameter("time");
		String message=req.getParameter("message");
		HttpSession httpSession = req.getSession();
		String name = (String) httpSession.getAttribute("name");
		
		LocalDate orderDate = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
		LocalTime orderTime = LocalTime.parse(time, DateTimeFormatter.ISO_TIME);
		MedOrderDto order=new MedOrderDto();
		order.setDate(orderDate);
		order.setTime(orderTime);
		order.setMessage(message);
		order.setCreatorName(name);
		
		MedOrderDao dao=new MedOrderDao();
		dao.saveOrder(encounterId, order);
		RequestDispatcher dispatcher = req.getRequestDispatcher("create_encounter.jsp");
		dispatcher.forward(req, resp);
	}
}
