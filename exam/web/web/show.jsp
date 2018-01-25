<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="bean.Money" %>
<%
    List<Money> list = (List<Money>) request.getAttribute("monies");
%>
<html>
<head>
    <title>展示</title>
</head>
<body>
    <%
        Integer sum = 0;
        for(Money money : list){
            sum += money.getMoney();
        }
        String userName = list.get(0).getName();
        out.print(userName + "您好<h1>您的总资产为：" + sum + "</h1><br>其中：");
        for(Money money : list){
            out.print("<p>" + money.getBankName() + "为：" + money.getMoney() + "元</p>");
        }
    %>
</body>
</html>
