package com.example.demofinalpro;

import Model.User;
import PasswordHashing.HashPassword;
import service.UserService;

import java.io.*;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
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
        if (page.equalsIgnoreCase("register")) {
            User user = new User();  // blank model

            user.setUserName(req.getParameter("userName"));
            user.setEmail(req.getParameter("email"));
            user.setAddress(req.getParameter("address"));
//            user.setPassword(req.getParameter("password"));
            user.setPassword(HashPassword.passwordHashing(req.getParameter("password")));

            new UserService().insertUser(user);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(req, resp);
        }

        if (page.equalsIgnoreCase("login")) {
            // form data:
            String name = req.getParameter("userName");
            String password = HashPassword.passwordHashing(req.getParameter("password"));

            // call service:
            User user = new UserService().getUserLogin(name, password);

            if (user != null) {
                HttpSession session = req.getSession();
                session.setAttribute("sn", name);

                Cookie cookie = new Cookie("cn", name);
                resp.addCookie(cookie);

                RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/dashboard.jsp");
                requestDispatcher.forward(req, resp);

            } else {
                req.setAttribute("message", "invalid username or password: ");
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
                requestDispatcher.include(req, resp);
            }

        }

        ///
        if (page.equalsIgnoreCase("newUser")) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/register.jsp");
            requestDispatcher.forward(req, resp);
        }

        if (page.equalsIgnoreCase("loginUser")) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(req, resp);
        }

        if (page.equalsIgnoreCase("dashboard")) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/dashboard.jsp");
            requestDispatcher.forward(req, resp);
        }

        if (page.equalsIgnoreCase("userList")) {
            User user = new User();
            List<User> userList = new UserService().getUserList();

            req.setAttribute("user", user);
            req.setAttribute("userList", userList);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/userList.jsp");
            requestDispatcher.forward(req, resp);
        }

        if (page.equalsIgnoreCase("userDetails")) {
            int id = Integer.parseInt(req.getParameter("id"));
            User user = new UserService().getUserRow(id);

            req.setAttribute("user", user);
            req.setAttribute("id", id);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/userDetails.jsp");
            requestDispatcher.forward(req, resp);
        }

        if (page.equalsIgnoreCase("deleteUser")) {
            int id = Integer.parseInt(req.getParameter("id"));
            new UserService().deleteUser(id);

            List<User> userList = new UserService().getUserList();
            req.setAttribute("userList", userList);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/userList.jsp");
            requestDispatcher.forward(req, resp);
        }

        if (page.equalsIgnoreCase("editUser")) {

            // ID:
            int id = Integer.parseInt(req.getParameter("id"));
            User user = new UserService().getUserRow(id);

            req.setAttribute("user", user);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/updateUser.jsp");
            requestDispatcher.forward(req, resp);
        }

        if (page.equalsIgnoreCase("updateUser")) {

            //step 1:
            User user = new User();

            int id = Integer.parseInt(req.getParameter("id"));

            user.setUserName(req.getParameter("userName"));
            user.setAddress(req.getParameter("address"));
            user.setEmail(req.getParameter("email"));
            user.setPassword(req.getParameter("password"));

            try {
                new UserService().editUser(id, user);

            } catch (SQLException e) {
                e.printStackTrace();
            }

            List<User> userList = new UserService().getUserList();
            req.setAttribute("userList", userList);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/userList.jsp");
            requestDispatcher.forward(req, resp);

        }

    }

}