
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
     <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Enter firstName and lastName</title>
    </head>
    <body>
     <form:form id="personForm"  action="addPerson" method="POST" acceptCharset="UTF-8">
     <table align="center">
                    <tr>
                        <td>
                            <form:label path="firstName">FirstName: </form:label>
                        </td>
                        <td>
                            <form:input path="firstName" name="firstName" id="firstName" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="lastName">LastName:</form:label>
                        </td>
                        <td>
                            <form:input path="lastName" name="lastName" id="lastName" />
                        </td>
                    </tr>
           </table>         
     
     
        <table align="center">
            <tr>
                <td> <input type = "submit" value = "Submit"/>
                </td>
                
            </tr>
        </table>
        </form:form>
    </body>
    </html>