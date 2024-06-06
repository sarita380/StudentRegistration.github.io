<%-- 
    Document   : addNewSection
    Created on : Nov 17, 2014, 11:24:01 AM
    Author     : Sara
--%>

<%@page import="Business.SectionsDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sections page</title>
    </head>
    <body bgcolor="#E6E6FA">
          <img src = "chattahoochee.png" alt = "" width ="200" height="200"/>
        <h1><font color="#4B8A08">Adding a new Section</font></h1>
         <form name="section" method="post" action="http://localhost:8084/StudentRegistration/AddSection">
             
              <% 
               String courseId, time, room;
             int id, in;
            try{SectionsDB s1 = (SectionsDB)session.getAttribute("s1");
                id=s1.getCoursecrn();
               courseId=s1.getCourid();
               time=s1.getTimed();
               room=s1.getRoom();
               in=s1.getInstr();
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
         <input type ="submit" name ="ac" value ="Find">
         <input type ="submit" name ="ac" value ="Insert">
         <input type ="submit" name ="ac" value ="Update">
         <input type ="submit" name ="ac" value ="Delete">
        <input type ="reset" name ="ex" value ="clear">
         </form>
    </body>
</html>
