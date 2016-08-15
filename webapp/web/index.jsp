<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2016.08.15.
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Project Santa</title>
  </head>
  <body>

  <h3>Merry Christmas + <%= new java.util.Date()%>></h3>
  <form action="Validate" method="post">
      <input type="text" name="user_name" placeholder="Login"/><br>
      <input type="password" name="user_password" placeholder="Password"/><br>
      <input type="submit" value="Go"/>
  </form>

  </body>
</html>
