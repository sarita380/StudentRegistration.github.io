<%-- 
    Document   : AddCourse
    Created on : Nov 17, 2014, 11:44:53 AM
    Author     : Sara
--%>

<%@page import="Business.CoursesDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Courses</title>
    </head>
    <body bgcolor="#E6E6FA">
          <img src = "chattahoochee.png" alt = "" width ="200" height="200"/>
        <h1><font color="#4B8A08">Courses Page</font></h1>
       <form name="course" method="post" 
         action="http://localhost:8084/StudentRegistration/AddCourseServlet"> 
           
           <% String coourseId, courseName, description;
            int hour;
            
            try{CoursesDB s1 = (CoursesDB)session.getAttribute("s1");
            
               coourseId=s1.getCurId();
               courseName=s1.getCname();
               description=s1.getDescr();
               hour=s1.getCred();
            
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
            <input type ="submit" name ="ac" value ="Find">
            <input type ="submit" name ="ac" value ="Insert">
            <input type ="submit" name ="ac" value ="Update">
            <input type ="submit" name ="ac" value ="Delete">
            <input type ="reset" name ="ex" value ="clear">
       </form>
    </body>
</html>
