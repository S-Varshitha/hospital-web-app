package com.ty.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dao.BranchDao;
import com.ty.dto.BranchDto;

@WebServlet(value="/displaybranches")
public class GetBranchesServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BranchDao dao= new BranchDao();
		int hospitalId=Integer.parseInt(req.getParameter("hospitalid"));
		List<BranchDto> branchesList=dao.getAllBranch(hospitalId);
		req.setAttribute("branchesList", branchesList);
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("display_branch.jsp");
		dispatcher.forward(req, resp);
	}
}
