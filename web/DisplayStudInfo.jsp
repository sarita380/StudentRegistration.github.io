
<%-- Document   : changeStudInfo
    Created on : Nov 10, 2014, 1:36:43 PM
    Author     : Sara
--%>
<%@page import="Business.StudentInfoDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change Student Information</title>
    </head>
    
    <Body bgcolor="#A9F5E1">
        <h1>Student main page</h1>
          <img src = "chattahoochee.png" alt = "" width ="200" height="200"/>
            <form name="studReg" action ="http://localhost:8084/StudentRegistration/studentInfoServlet" method="post">
                <% StudentInfoDB ac;
                ac = (StudentInfoDB)session.getAttribute("s1");
                ac.display();
                %>
                <table cellspacing="5" border="0">
            <tr>
                <td align="left"> 
                ID Number:</td>
                <td><%= ac.getStuId()%></td>              
            </tr>
            <%-- <tr>
                <td align="left"> 
                Password:</td>
                <td><%= ac.getPassw()%></td>              
            </tr>--%>
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
            <%-- <tr>
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
            </tr>--%>
        </table>
        </form>
      <br/>
      <%-- <p>Click the link below to update your information</p>
      <a href="viewAndchangeStudInfo.jsp">Update Information</a>
      <br>--%>
      <p>Click the link below to review and update your information</p>
      <a href="studentUp.jsp">Update Information</a>
      <br>
      <p>Click the link below to review your Schedule</p>
      <a href="ViewSchedule.jsp">View Schedule</a> 
      <br>
      <%--<p>Click the link below to add a Section</p>
      <a href="Sections.jsp">Add sections to Schedule</a> 
      <br>
      <p>Click the link below drop a course</p>
      <a href="DropSections.jsp">Drop sections from Schedule</a> --%>
    </body>
</html>
