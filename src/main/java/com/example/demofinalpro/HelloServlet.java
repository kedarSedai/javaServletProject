package com.example.demofinalpro;

import Model.User;
import service.UserService;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", urlPatterns = "/user")
public class HelloServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        doPost(request, response);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String page = req.getParameter("page");
        if(page.equalsIgnoreCase("register")){
            User user = new User();  // blank model

            user.setUserName(req.getParameter("userName"));
            user.setEmail(req.getParameter("email"));
            user.setAddress(req.getParameter("address"));
            user.setPassword(req.getParameter("password"));

            new UserService().insertUser(user);


        }



    }

}