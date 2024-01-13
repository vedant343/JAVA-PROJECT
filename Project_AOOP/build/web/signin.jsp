
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
        <title>Sign up</title>
    </head>
    <body>
        <%
            
            String name = request.getParameter("name");
            String occupation = request.getParameter("occupation");;
            String location = request.getParameter("location");
            String password = request.getParameter("password");
            String mob = request.getParameter("mobile");
            
            
            try {
                        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Shreyas", "Shreyas", "3899");
                        Statement stat = con.createStatement();
                        //int rs = stat.executeUpdate("insert into workers (name, loaction, occupation, password) values "+(name, occupation, location, password));
                        String queryString = "INSERT INTO workers(Name,occupation, loaction, password, mobile) VALUES (?, ?, ?, ?, ?)";
              	      
                        PreparedStatement pstatement = con.prepareStatement(queryString);
                        pstatement.setString(1, name);
			pstatement.setString(2, occupation);
                        pstatement.setString(3, location);
                        pstatement.setString(4, password);
                        pstatement.setString(5, mob);
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
