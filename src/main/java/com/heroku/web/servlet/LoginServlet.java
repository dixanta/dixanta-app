/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heroku.web.servlet;

import com.heroku.web.dao.UserDAO;
import com.heroku.web.dao.impl.UserDAOImpl;
import com.heroku.web.entity.User;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "login", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private UserDAO userDAO = new UserDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/views/login.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            User user = userDAO.login(userName, password);
            if (user != null) {
                HttpSession session = request.getSession(true);
                session.setAttribute("user", "true");
                response.sendRedirect(request.getContextPath()
                        + "/admin/dashboard");
            } else {
                response.sendRedirect(request.getContextPath()
                        + "/login?error");
            }
        } catch (Exception se) {
            System.out.println(se.getMessage());
        }
    }

}
