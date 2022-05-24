package com.ty.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dao.AdressDao;
import com.ty.dao.BranchDao;
import com.ty.dto.AdressDto;
import com.ty.dto.BranchDto;

@WebServlet(value="/displayaddress")
public class GetAddressServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AdressDao dao= new AdressDao();
		int branchId=Integer.parseInt(req.getParameter("branchid"));
		System.out.println(branchId);
		List<AdressDto> adsressList=dao.getAllAddress(branchId);
		req.setAttribute("adsressList", adsressList);
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("display_address.jsp");
		dispatcher.forward(req, resp);
	}
}
