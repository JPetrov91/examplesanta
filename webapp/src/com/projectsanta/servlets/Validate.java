package com.projectsanta.servlets;

import database.DBConnector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by User on 2016.08.15..
 */
@WebServlet(name = "/Validate")
public class Validate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        String user_name, user_password;
        user_name = request.getParameter("user_name").toString();
        user_password = request.getParameter("user_password").toString();

        try {
            Connection conn = DBConnector.connectDb();
            String sql = "select * from users where user_name='" + user_name + "' and user_password='" + user_password + "'";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
                rd.forward(request, response);
            } else {
                out.println("Invalid login");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
