<%-- 
    Document   : LoginStudent
    Created on : Nov 3, 2014, 7:23:17 PM
    Author     : Sara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Login</title>
    </head>
    <body  bgcolor="#E6E6FA">
         
        <h1><font color="#4B8A08">Student Registration</font></h1>
        <img src = "chattahoochee.png" alt = "" width ="100" height="100"/>
        <form name ="student" action = "http://localhost:8084/StudentRegistration/studentInfoServlet" method= "post">
            <table cellspacing="5"  border="0">  
                <tr>
                    <td align="right">ID :</td>
                    <td><input type="text" name="id"  /></td>
                </tr>
                <tr>
                    <td align="right">Password:</td>
                    <td><input type="password" name="pw"  /></td>
                </tr>
            </table> 
            <input type="submit" name ="lgn" value="login">
            <input type="reset"  name="cl" value="clear">
        </form>
    </body>
</html>
