<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <title>User Login</title>
    </head>
    
    <body style="margin: 0%; font-size: 30px; background-color: white; color:white;">
        <div class="Nav_bar" style='background-color: #6b1d22; width: 100%; height: 10%; margin-bottom: 20px'>
            <p style="text-align: center; padding-top: 20px; font-family: cursive; font-size: 40px; "> Contingent Worker Finder </p>
        </div>
        
        <%! String usr; String pwd; String loc; %>
        <div style="display:flex; color: darkslategrey">
        <% 
            usr = "Shreyas";
            pwd = "3899";
            if(usr != null && pwd != null){
                try{
                    Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Shreyas", "Shreyas", "3899");
                    Statement stat = con.createStatement();
                    String query_usr = ("SELECT LOACTION FROM USERS WHERE NAME='"+usr+"' AND PASSWORD='"+pwd+"'");
                    ResultSet rs = stat.executeQuery(query_usr);
                    if(rs.next()){
                        loc = rs.getString("LOACTION");
                    }
                    else{
                        out.println("<div style='text-align:center'>Invalid user</div>");
                    }
                    if(loc != null){
                        String query = ("SELECT NAME, OCCUPATION, MOBILE FROM WORKERS WHERE LOACTION='"+loc+"'");
                        rs = stat.executeQuery(query);
                        if(rs.next()){
                            String name = rs.getString("name");
                            String Occupation = rs.getString("occupation");
                            String Mobile = rs.getString("mobile");
                            out.println("<div style='border: 3px solid black; border-radius:10px; height:20%; margin: 20px;background-color: #EFCFA0'>"+
                                    "<img src='kisspng-computer-icons-user-iconfinder-symbol-account-profile-icon-5ab1460b053e92.2060138315215672430215.png' style='width: 300px; height:300px'><br><br><br>"
                                    +"&nbspName: "+name+"<br><br>&nbspService: "+Occupation+"<br><br>&nbspTel: "+Mobile+
                                    "<br><br></div>");
                            while(rs.next()){
                                name = rs.getString("name");
                                Occupation = rs.getString("occupation");
                                Mobile = rs.getString("mobile");
                                out.println("<div style='border: 3px solid black; border-radius:10px; height:20%; margin: 20px;background-color: #EFCFA0'>"+
                                    "<img src='kisspng-computer-icons-user-iconfinder-symbol-account-profile-icon-5ab1460b053e92.2060138315215672430215.png' style='width: 300px; height:300px'><br><br><br>"
                                    +"&nbspName: "+name+"<br><br>&nbspService: "+Occupation+"<br><br>&nbspTel: "+Mobile+
                                    "<br><br></div>");
                            }
                        }
                        else{
                            out.println("No Workers Found in this Location !!");
                        }
                    }
                }
                catch(SQLException e){
                    out.println(e);
                }
            }
        %>
        
        <div style="position: fixed; width:70px; height: 55px; bottom: 0; right: 0">
            <form>
                <button  onclick="popup()">
                    <img style="position: fixed; width:70px; height: 55px; bottom: 7; right: 7" src="kisspng-employ-r-solutions-inc-google-maps-google-logo-g-map-logo-5ae34871b9a028.0622093815248446577604.png">
                </button>
            </form>
        </div>
        
        <div id="pop" style="font-size: 25px; z-index: 1; position: fixed; width:300px; height: 250px; bottom: 10; right: 16; border-radius: 10px; background-color: #EFCFA0">
            <p style="text-align: center"> Change Location </p>
            <form action='Change_location' style="padding-left: 10px; padding-top: 4px " method="GET">
                <label for="name">Name: </label>
                <input type="text" name="name"><br><br>
                <label for="name">Location: </label>
                <input type="text" name="loc"><br><br>
                <input type="submit" value="confirm">
            </form>
        </div>
        
        
        <script>
            function popup() {
                var x = document.getElementById("pop")
                x.style.display = "block";
            }
        </script>
        
    </body>
</html>
