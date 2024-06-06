<%-- 
    Document   : changeStudInfo
    Created on : Nov 10, 2014, 8:43:11 PM
    Author     : Sara
--%>
<%@page import = "Business.StudentInfoDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change Student Info</title>
    </head>
    <Body bgcolor="#A9F5E1">
          <img src = "chattahoochee.png" alt = "" width ="200" height="200"/>
        <form name="changeinfo" method="post" action="http://localhost:8084/StudentRegistration/lookupStudInfo">
            <% StudentInfoDB ac;
                ac = (StudentInfoDB)session.getAttribute("s1");
                ac.display();
                %>
        <h1>Change your Information</h1>
        
           <table cellspacing="5" border="3"> 
                <tr>
                <td align="left"> 
                ID Number:</td>
                <td><input  name="i" value="<%= ac.getStuId()%>"></td>              
            </tr>
            <tr>
                <td align="left"> Password:</td>
                <td><input type ="text" name="p" value="<%= ac.getPassw()%>" ></td>
                
            </tr>
            <tr>
                <td align="left">First Name:</td>
                <td><input type ="text" name="fname" value="<%= ac.getFirstN()%>" ></td>
                 
            </tr>
            <tr>
                <td align="left"> Last Name:</td>
                <td><input type ="text" name="last" value="<%=ac.getLastN()%>" ></td>
                  
            </tr>  
             <tr>
                <td align="left">Street:  </td>
                <td><input type ="text" name="st" value="<%=ac.getStreet() %> " > </td>
                 
            </tr> 
             <tr>
                <td align="left"> City:</td>
                 <td><input type ="text" name="ct" value="<%=ac.getCity()%>" ></td> 
                 
            </tr>
             <tr>
                <td align="left">State:</td>
                <td><input type ="text" name="sta" value="<%=ac.getState()%>" ></td> 
                
            </tr> 
             <tr>
                <td align="left">Zip:</td>
                <td><input type ="text" name="zip" value="<%=ac.getZipCode()%>" ></td>
               
            </tr> 
             <tr>
                <td align="left">EMail:</td>
                <td><input type ="text" name="em" value="<%=ac.getEMail()%>" ></td>
                 
            </tr> 
        </table>
        <br/>
        <input type ="submit" name ="sb" value ="Submit">
        <input type ="reset" name ="ex" value ="clear">
        </form>
        
    </body>
</html>
