<%-- 
    Document   : DisplayChangeStud
    Created on : Nov 11, 2014, 5:08:05 PM
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
          <img src = "chattahoochee.png" alt = "" width ="200" height="200"/>
        <form name="changeinfo" method="post" 
         action="http://localhost8084/StudentRegistration/StudentInfoDB">
        <h1>Change your Information was successfully update</h1>
       <% StudentInfoDB s1;
           s1=(StudentInfoDB)request.getAttribute("p");
           StudentInfoDB s2;
           s2=(StudentInfoDB)request.getAttribute("fname");
           StudentInfoDB s3;
           s3=(StudentInfoDB)request.getAttribute("last");
           StudentInfoDB s4;
           s4=(StudentInfoDB)request.getAttribute("st");
           StudentInfoDB s5;
           s5=(StudentInfoDB)request.getAttribute("ct");
           StudentInfoDB s6;
           s6=(StudentInfoDB)request.getAttribute("sta");
           StudentInfoDB s7;
           s7=(StudentInfoDB)request.getAttribute("zip");
           StudentInfoDB s8;
           s8=(StudentInfoDB)request.getAttribute("em");
           s2.updateDB();%>
       
           <table cellspacing="5" border="3">  
            <tr>
                <td align="left"> Password:</td>  
               <td> <%=s1.getPassw()%> </td> 

            </tr>
            <tr>
                <td align="left">First Name:</td>
                 <td> <%= s2.getFirstN()%></td>
            </tr>
            <tr>
                <td align="left"> Last Name:</td>
                  <td><%= s3.getLastN()%></td>  
            </tr>  
             <tr>
                <td align="left">Street:  </td>
                  <td><%=s4.getStreet()%> </td>  
            </tr> 
             <tr>
                <td align="left"> City:</td>
                  <td><%=s5.getCity()%></td>  
            </tr>
             <tr>
                <td align="left">State:</td>
                  <td><%= s6.getState()%></td>  
            </tr> 
             <tr>
                <td align="left">Zip:</td>
                  <td><%= s1.getZipCode()%></td>  
                  
            </tr> 
             <tr>
                <td align="left">EMail:</td>
                  <td><%= s1.getEMail()%></td>  
            </tr> 
        </table>
        <br/>
        <input type ="submit" name ="sb" value ="Submit">
        </form> 
    </body>
</html>
