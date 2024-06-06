<%-- 
    Document   : insertInstructor
    Created on : Nov 19, 2014, 7:22:01 PM
    Author     : Sara
--%>

<%@page import="Business.InstructorsDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert Instructor</title>
    </head>
    <body bgcolor="#E6E6FA">
         <img src = "chattahoochee.png" alt = "" width ="200" height="200"/>
    <form name="instructor" method="post"  action="http://localhost:8084/StudentRegistration/AddInstructorServlet"> 
        <h1><font color="#4B8A08">Instructor information Inserted!</font></h1>     
           <%
            String fname, lname, street, city, state, office,email;
            int id, zip;
            
            try
            {InstructorsDB s2 = (InstructorsDB)session.getAttribute("s1");
             
               id=s2.getInId();
                fname=s2.getIname();
                lname=s2.getLastname();
                street=s2.getInstreet();
                
                city=s2.getIncity();
                state=s2.getInstate();
                zip=s2.getInzip();
                office=s2.getInoff();
                email=s2.getInemail();
            }
            
             
            catch(Exception e){
                id=0;
                fname="";
                lname="";
                street="";
                city="";
                state="";
                zip=0;
                office="";
                email="";
                
            }
           
            
            %>  
        <table border="3">
                <tr>
                    <td><font color="#4B8A08">ID:</font></td>
                    <td><input type="text" name="iid" value="<%=id%>"></td>
                </tr>
                <tr>
                    <td><font color="#4B8A08">First Name:</font></td>
                    <td><input type="text" name="fnm" value="<%=fname %>"></td>
                </tr>
                <tr>
                    <td><font color="#4B8A08">Last Name:</font></td>
                    <td><input type="text" name="lastn" value="<%=lname %>"></td>
                </tr>
                <tr>
                    <td><font color="#4B8A08">Street:</font></td>
                    <td><input type="text" name="stre" value="<%=street %>"></td>
                </tr>
                <tr>
                    <td><font color="#4B8A08">City:</font></td>
                    <td><input type="text" name="ct" value="<%=city %>"></td>
                </tr>
                <tr>
                    <td><font color="#4B8A08">State:</font></td>
                    <td><input type="text" name="ste" value="<%=state %>"></td>
                </tr>
                <tr>
                    <td><font color="#4B8A08">Zip Code:</font></td>
                    <td><input type="text" name="zp" value="<%=zip%>"></td>
                </tr>
                <tr>
                    <td><font color="#4B8A08">Office:</font></td>
                    <td><input type="text" name="of" value="<%=office %>"></td>
                </tr>
                <tr>
                    <td><font color="#4B8A08">Email:</font></td>
                    <td><input type="text" name="email" value="<%=email %>"></td>
                </tr>
        </table>
           <br>
           <a href="mainAdmin.jsp">Back to the main  page</a>
       </form>
    </body>
</html>
