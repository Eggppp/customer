package com.eggp.customer.controller;

import com.eggp.customer.bean.Customer;
import com.eggp.customer.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/customerEdit")
public class CustomerEditController extends HttpServlet {
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

        String idStr = req.getParameter("id");
        if(idStr==null||idStr==""){
            // 新建用户
            req.setAttribute("createOrEdit","新建");
            req.getRequestDispatcher("/WEB-INF/view/customer_edit.jsp").forward(req,resp);
        }else {
            // 更新用户
            long id = Long.parseLong(idStr);
            Customer customer = customerService.getCustomer(id);
            req.setAttribute("createOrEdit","编辑");
            req.setAttribute("customer",customer);
            req.getRequestDispatcher("/WEB-INF/view/customer_edit.jsp").forward(req,resp);
        }
    }
}
