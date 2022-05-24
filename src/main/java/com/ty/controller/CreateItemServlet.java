package com.ty.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.dao.ItemDao;
import com.ty.dto.ItemDto;

@WebServlet("/createitem")
public class CreateItemServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String message = req.getParameter("message");
		int cost = Integer.parseInt(req.getParameter("cost"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		int orderId = Integer.parseInt(req.getParameter("orderId"));
		ItemDto items = new ItemDto();
		items.setMessage(message);
		items.setItem_name(name);
		items.setCost(cost);
		items.setQuantity(quantity);

		ItemDao dao = new ItemDao();
		dao.saveItem(orderId, items);

		PrintWriter printWriter = resp.getWriter();
		printWriter.print("<html><body><h1>Item created</h1></body></html>");

		RequestDispatcher dispatcher = req.getRequestDispatcher("create_item.jsp");
		dispatcher.include(req, resp);
	}
}
