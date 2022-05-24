package com.ty.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dao.HospitalDao;
import com.ty.dto.HospitalDto;

@WebServlet(value="/createHospital")
public class CreateHospitalServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HospitalDto hospital=new HospitalDto();
		
		String name=req.getParameter("hospitalName");
		String website=req.getParameter("hospitalWebsite");
		String gst=req.getParameter("gst");
		
		hospital.setHospital_name(name);
		hospital.setWebsite(website);
		hospital.setGst(gst);
		
		HospitalDao dao=new HospitalDao();
		dao.saveHospital(hospital);
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("create_hospital.jsp");
		dispatcher.forward(req, resp);
	}
}
