<%-- 
    Document   : findStud
    Created on : Nov 17, 2014, 11:59:03 PM
    Author     : Sara
--%>

<%@page import="Business.StudentInfoDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Find Student</title>
    </head>
    <body>
          <img src = "chattahoochee.png" alt = "" width ="200" height="200"/>
          <form name="studReg" action ="http://localhost:8084/StudentRegistration/addStudServlet" method="post">
                <% StudentInfoDB ac;
                ac = (StudentInfoDB)session.getAttribute("s1");
                ac.display();
                %>
                <table cellspacing="5" border="3">
            <tr>
                <td align="left"> 
                ID Number:</td>
                <td><%= ac.getStuId()%></td>              
            </tr>
            <tr>
                <td align="left"> 
                Password:</td>
                <td><%= ac.getPassw()%></td>              
            </tr>
            <tr>
                <td align="left">
                    First Name:</td>
                 <td><%=ac.getFirstN()%></td>
            </tr>
            <tr>
                <td align="left">
                    Last Name:</td>
                  <td><%= ac.getLastN()%></td>  
            </tr>  
             <tr>
                <td align="left">
                    Street:  </td>
                <td><%=ac.getStreet() %> </td>  
            </tr> 
             <tr>
                <td align="left">
                    City:</td>
                <td><%=ac.getCity()%></td>  
            </tr>
             <tr>
                <td align="left">
                    State:</td>
                <td><%=ac.getState()%></td>  
            </tr> 
             <tr>
                <td align="left">
                    Zip:</td>
                <td><%=ac.getZipCode()%></td>  
            </tr> 
             <tr>
                <td align="left">EMail:</td>
                <td><%=ac.getEMail() %></td>  
            </tr>
        </table>
        </form>
    </body>
</html>
