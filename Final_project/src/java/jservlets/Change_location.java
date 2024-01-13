package jservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

public class Change_location extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            String name = request.getParameter("name");
            String loc = request.getParameter("loc");
            if(name != null && loc != null){
                try{
                    Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Shreyas", "Shreyas", "3899");
                    Statement stat = con.createStatement();
                    String query_usr = ("Update users set loaction='"+loc+"' WHERE name='"+name+"'");
                    int rs = stat.executeUpdate(query_usr);
                    if(rs == 1){
                        RequestDispatcher rd = request.getRequestDispatcher("/Login_user.jsp");
                        rd.forward(request, response);
                    }
                    else{
                        out.println("Invalid user");
                    }
                }
                catch(SQLException e){
                    out.println(e);
                }
            }
        }
    }

}
