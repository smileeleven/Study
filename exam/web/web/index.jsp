<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>资产查询</title>
  </head>
  <body>
    <form action="/queryMoneyServlet" method="get">
        <label>用户编号 <input type="text" name="userId"></label><br>
        <input type="submit" value="提交查询">
    </form>
  </body>
</html>
