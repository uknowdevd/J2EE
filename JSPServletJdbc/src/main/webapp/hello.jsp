<html>
   <head>
      <title>Using  POST Method to Read Form Data</title>
   </head>
   
   <body>
      <center>
      <h1>Using Post Method to Read Form Data</h1>
      
      <ul>
         <li><p><b>First Name:</b>
            <%= request.getParameter("first_name")%>
         </p></li>
         <li><p><b>Last  Name:</b>
            <%= request.getParameter("last_name")%>
         </p></li>
      </ul>
   
    <jsp:include page = "date.jsp" flush = "true" />
   </body>
</html>