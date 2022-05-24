package com.ty.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dao.MedOrderDao;
import com.ty.dto.MedOrderDto;


@WebServlet(value="/displayorder")
public class GetOrderServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MedOrderDao dao=new MedOrderDao();
		List<MedOrderDto> ordersList=dao.getAllOrder();
		req.setAttribute("ordersList", ordersList);
		RequestDispatcher dispatcher=req.getRequestDispatcher("display_order.jsp");
		dispatcher.forward(req, resp);
	}
}
