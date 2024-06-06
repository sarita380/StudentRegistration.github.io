<%-- 
    Document   : findSection
    Created on : Nov 20, 2014, 1:58:40 AM
    Author     : Sara
--%>

<%@page import="Business.SectionsDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Find Section</title>
    </head>
    <body bgcolor="#E6E6FA">
          <img src = "chattahoochee.png" alt = "" width ="200" height="200"/>
        <h1><font color="#4B8A08">Section Inserted!</font></h1>
       <form name="course" method="post" 
         action="http://localhost:8084/StudentRegistration/AddSectionServlet"> 
           
           <% 
               String courseId, time, room;
          int crn,inst;
            
            try{SectionsDB s1 = (SectionsDB)session.getAttribute("s1");
            
               crn=s1.getCoursecrn();
               courseId=s1.getCourid();
               time=s1.getTimed();
               room=s1.getRoom();
               inst=s1.getInstr();
            
            }
            catch(Exception e)
            {
            crn=0;
            courseId="";
            time="";
            room="";
            inst=0;
            }
           %>
           
        <table border="3">
                <tr>
                    <td><font color="#4B8A08">CRN</font></td>
                    <td><input type="text" name="cr" value="<%=crn%>"></td>
                </tr>
            
                <tr>
                    <td><font color="#4B8A08">Course ID</font></td>
                    <td><input type="text" name="crid" value="<%=courseId%>"></td>
                </tr>
                <tr>
                    <td><font color="#4B8A08">Time Days</font></td>
                    <td><input type="text" name="cnm" value="<%=time%>"></td>
                </tr>
                <tr>
                    <td><font color="#4B8A08">Room No</font></td>
                    <td><input type="text" name="descp" value="<%=room%>"></td>
                </tr>
                <tr>
                    <td><font color="#4B8A08"> Instructor</font></td>
                    <td><input type="text" name="hour" value="<%=inst%>"></td>
                </tr>
                
        </table>
           <br>
            <a href="AddCourse.jsp">Back to Course page</a>
        <br>
        <a href="mainAdmin.jsp">Back to main page</a>
       </form>
    </body>
</html>
