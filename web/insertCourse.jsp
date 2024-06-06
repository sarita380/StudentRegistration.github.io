<%-- 
    Document   : insertCourse
    Created on : Nov 20, 2014, 12:47:47 AM
    Author     : Sara
--%>

<%@page import="Business.CoursesDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert Course</title>
    </head>
    <body bgcolor="#E6E6FA">
          <img src = "chattahoochee.png" alt = "" width ="200" height="200"/>
        <h1><font color="#4B8A08">Courses Inserted!</font></h1>
       <form name="course" method="post" 
         action="http://localhost:8084/StudentRegistration/AddCourseServlet"> 
           
           <% String coourseId, courseName, description;
            int hour;
            
            try{CoursesDB s2 = (CoursesDB)session.getAttribute("s1");
            
               coourseId=s2.getCurId();
               courseName=s2.getCname();
               description=s2.getDescr();
               hour=s2.getCred();
            
            }
            catch(Exception e)
            {
            coourseId="";
            courseName="";
            description="";
            hour=0;
            }
           %>
           
        <table border="3">
                <tr>
                    <td><font color="#4B8A08">Course ID</font></td>
                    <td><input type="text" name="crid" value="<%=coourseId%>"></td>
                </tr>
                <tr>
                    <td><font color="#4B8A08">Course Name</font></td>
                    <td><input type="text" name="cnm" value="<%=courseName%>"></td>
                </tr>
                <tr>
                    <td><font color="#4B8A08">Description</font></td>
                    <td><input type="text" name="descp" value="<%=description%>"></td>
                </tr>
                <tr>
                    <td><font color="#4B8A08">Credit Hour</font></td>
                    <td><input type="text" name="hour" value="<%=hour%>"></td>
                </tr>
                
        </table>
           <br>
            <a href="AddCourse.jsp">Back to Course page</a>
        <br>
        <a href="mainAdmin.jsp">Back to main page</a>
       </form>
    </body>
</html>
