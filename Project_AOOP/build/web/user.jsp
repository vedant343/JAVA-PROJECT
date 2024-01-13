
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            
            String uname = request.getParameter("uname");
            String location = request.getParameter("location");
            String password = request.getParameter("password");
            
            
            try {
                        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Shreyas", "Shreyas", "3899");
                        Statement stat = con.createStatement();
                        String queryString = "INSERT INTO users(Name, password, loaction) VALUES (?, ?, ?)";
                        PreparedStatement pstatement = con.prepareStatement(queryString);
                        pstatement.setString(1, uname);
			pstatement.setString(2, password);
                        pstatement.setString(3, location);
                        int rs = pstatement.executeUpdate();
                        if (rs == 1) {
                            out.println("Elements added successfully");
                        }
                        else{
                                out.println("Error");
                            }
             } 
            catch (SQLException e) {
                        out.println(e);
                    }
            %>
    </body>
</html>
