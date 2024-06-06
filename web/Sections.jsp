<%-- 
    Document   : Sections
    Created on : Nov 11, 2014, 6:10:20 PM
    Author     : Sara--%>

<%@page import="Business.SectionsDB"%>
<%@page import="Business.InstructorsDB"%>
<%@page import="Business.CoursesDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sections</title>
    </head>
    <body bgcolor="#A9F5E1">
          <img src = "chattahoochee.png" alt = "" width ="200" height="200"/>
      <form name ="section" method="post" action="http://localhost:8084/StudentRegistration/SectionServlet">
        <h1>Section</h1>
        <p>Enter the CRN number of the course that you want to add to your Schedule</p>
            <table border="3">
                <tr>
                    <td align="right">CRN :</td>
                    <td><input type="text" name="crn"  /></td>
                </tr>
               <tr>
                    <td align="right">CourseID :</td>
                    <td><input type="text" name="cd"  /></td>
                </tr>
            </table> 
         <br>
            <input type="submit" name ="lgn" value="login">
            <input type="reset"  name="cl" value="clear">
               
                
      </form>
    </body>
</html>
