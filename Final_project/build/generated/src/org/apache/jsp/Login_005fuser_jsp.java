package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class Login_005fuser_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 String usr; String pwd; String loc; 
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>User Login</title>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    <body style=\"margin: 0%; font-size: 30px; background-color: white; color:white;\">\n");
      out.write("        <div class=\"Nav_bar\" style='background-color: #6b1d22; width: 100%; height: 10%; margin-bottom: 20px'>\n");
      out.write("            <p style=\"text-align: center; padding-top: 20px; font-family: cursive; font-size: 40px; \"> Contingent Worker Finder </p>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        ");
      out.write("\n");
      out.write("        <div style=\"display:flex; color: darkslategrey\">\n");
      out.write("        ");
 
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
        
      out.write("\n");
      out.write("        \n");
      out.write("        <div style=\"position: fixed; width:70px; height: 55px; bottom: 0; right: 0\">\n");
      out.write("            <form>\n");
      out.write("                <button  onclick=\"popup()\">\n");
      out.write("                    <img style=\"position: fixed; width:70px; height: 55px; bottom: 7; right: 7\" src=\"kisspng-employ-r-solutions-inc-google-maps-google-logo-g-map-logo-5ae34871b9a028.0622093815248446577604.png\">\n");
      out.write("                </button>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <div id=\"pop\" style=\"font-size: 25px; z-index: 1; position: fixed; width:300px; height: 250px; bottom: 10; right: 16; border-radius: 10px; background-color: #EFCFA0\">\n");
      out.write("            <p style=\"text-align: center\"> Change Location </p>\n");
      out.write("            <form action='Change_location' style=\"padding-left: 10px; padding-top: 4px \" method=\"GET\">\n");
      out.write("                <label for=\"name\">Name: </label>\n");
      out.write("                <input type=\"text\" name=\"name\"><br><br>\n");
      out.write("                <label for=\"name\">Location: </label>\n");
      out.write("                <input type=\"text\" name=\"loc\"><br><br>\n");
      out.write("                <input type=\"submit\" value=\"confirm\">\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <script>\n");
      out.write("            function popup() {\n");
      out.write("                var x = document.getElementById(\"pop\")\n");
      out.write("                x.style.display = \"block\";\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
