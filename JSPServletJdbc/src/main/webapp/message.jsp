<html>
   
   <head>
      <title>Using JavaBeans in JSP</title>
   </head>
   
   <body>
      <center>
         <h2>Using JavaBeans in JSP</h2>
         <jsp:useBean id = "msg" class = "com.sparc.entity.Message" />
         <!-- Message.setText("Hello JSP.." -->
         
         <jsp:setProperty name = "msg"  property = "text" 
            value = "Hello JSP..." />
            
         <p>Got message....</p>
         <jsp:getProperty name = "msg" property = "text" />
      </center>
   </body>
</html>