<%-- 
    Document   : updCourse
    Created on : Nov 20, 2014, 3:25:31 AM
    Author     : Sara
--%>

<%@page import="Business.SectionsDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Course</title>
    </head>
   <body bgcolor="#E6E6FA">
         <img src = "chattahoochee.png" alt = "" width ="200" height="200"/>
        <h1><font color="#4B8A08">Updating Sections</font></h1>
         <form name="section" method="post" action="http://localhost:8084/StudentRegistration/AddSection">
             
              <% 
               String courseId, time, room;
             int id, in;
            try{SectionsDB s4 = (SectionsDB)session.getAttribute("s1");
                id=s4.getCoursecrn();
               courseId=s4.getCourid();
               time=s4.getTimed();
               room=s4.getRoom();
               in=s4.getInstr();
            }
            catch(Exception e)
            {
            id=0;
            courseId="";
            time="";
            room="";
            in=0;
            }
           %>
         <table border="3">
                <tr>
                    <td><font color="#4B8A08">CRN</font></td>
                    <td><input type="text" name="crn" value="<%=id%>"></td>
                </tr>
                <tr>
                    <td><font color="#4B8A08">Course ID</font></td>
                    <td><input type="text" name="curid" value="<%=courseId%>"></td>
                </tr>
                <tr>
                    <td><font color="#4B8A08">Time Days</font></td>
                    <td><input type="text" name="days" value="<%=time%>"></td>
                </tr>
                <tr>
                    <td><font color="#4B8A08">Room No</font></td>
                    <td><input type="text" name="room" value="<%=room%>"></td>
                </tr>
                <tr>
                    <td><font color="#4B8A08">Instructor</font></td>
                    <td><input type="text" name="ins" value="<%=in%>"></td>
                </tr>  
            </table>
        <br>
          
            <a href="AddCourse.jsp">Back to Course page</a>
        <br>
        <a href="mainAdmin.jsp">Back to main page</a>
         </form>
    </body>
</html>
