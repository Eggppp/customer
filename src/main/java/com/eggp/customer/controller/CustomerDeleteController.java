package com.eggp.customer.controller;

import com.eggp.customer.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/customerDelete")
public class CustomerDeleteController extends HttpServlet {
    private CustomerService customerService;

    @Override
    public void init() throws ServletException {
        // 避免多个customerService实例
        customerService = new CustomerService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        long id = Long.parseLong(req.getParameter("id"));
        customerService.deleteCustomer(id);
        resp.sendRedirect("customerList");
    }

}
