package com.ty.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dao.BranchDao;
import com.ty.dto.BranchDto;

@WebServlet("/createbranch")
public class CreateBranchServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int hospitalId=Integer.parseInt(req.getParameter("hospitalid"));
		String name=req.getParameter("branchName");
		String phone=req.getParameter("branchPhoneNumber");
		String email=req.getParameter("branchEmail");
		
		BranchDto branch=new BranchDto();
		branch.setBranch_name(name);
		branch.setBranch_phone(Long.parseLong(phone));
		branch.setEmail(email);
		
		BranchDao dao=new BranchDao();
		dao.saveBranch(hospitalId, branch);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("create_branch.jsp");
		dispatcher.forward(req, resp);
	}
}
