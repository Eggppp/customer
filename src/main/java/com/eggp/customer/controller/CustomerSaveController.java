package com.eggp.customer.controller;

import com.eggp.customer.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 客户列表
 */
@WebServlet("/customerSave")
public class CustomerSaveController extends HttpServlet {

    private CustomerService customerService;

    @Override
    public void init() throws ServletException {
        // 避免多个customerService实例
        customerService = new CustomerService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String idStr = req.getParameter("id");
        String name = req.getParameter("name");
        String contact = req.getParameter("contact");
        String telephone = req.getParameter("telephone");
        String email = req.getParameter("email");
        String remark = req.getParameter("remark");

        Map<String,Object> map = new HashMap<>();
        map.put("name",name);
        map.put("contact",contact);
        map.put("telephone",telephone);
        map.put("email",email);
        map.put("remark",remark);
        if(idStr==null || idStr==""){
            customerService.createCustomer(map);
        }else{
            long id = Long.parseLong(idStr);
            customerService.updateCustomer(id,map);
        }
        resp.sendRedirect("customerList");
    }
}
