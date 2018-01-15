<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="renderer" content="webkit">
        <title>幸运大抽奖</title>
    </head>
    <body>
        <div id="model">
            <label><input name="model" type="radio" value="1" checked/>抽中放回 </label>
            <label><input name="model" type="radio" value="2"/>抽中不放回 </label>
        </div>
        <br>
        <div id="operation">
            <label>组名：<input id="groups" value="1024组" disabled></label><br>
            <label>组员：<input id="num" value="陈伯利" disabled></label><br>
            <button id="start">开始抽奖</button>
            <button id="stop">停止</button>
        </div>
        <div id="result">
            <label>中奖名单：</label>
        </div>
        <script src="resource/jquery/jquery-3.2.0.min.js"></script>
        <script src="js/index.js"></script>
    </body>
</html>

