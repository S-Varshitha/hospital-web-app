package com.ty.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dao.AdressDao;
import com.ty.dto.AdressDto;

@WebServlet(value="/createaddress")
public class CreateAddressServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int branchId=Integer.parseInt(req.getParameter("branchId"));
		System.out.println(branchId);
		String state=req.getParameter("state");
		String district=req.getParameter("district");
		String pincode=req.getParameter("pincode");
		String address=req.getParameter("address");
		
		AdressDto adress=new AdressDto();
		adress.setAddress(address);
		adress.setDistrict(district);
		adress.setState(state);
		adress.setPincode(Long.parseLong(pincode));
		
		AdressDao dao=new AdressDao();
		dao.saveAddress(branchId, adress);
		RequestDispatcher dispatcher = req.getRequestDispatcher("create_address.jsp");
		dispatcher.forward(req, resp);
	}
}
