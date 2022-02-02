<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<body>
<h2>Hello World!</h2>
<div style="width: 50%;">
  <p>
      <q id="hitokoto"></q>
      <br>
      <span id="from_who" style="float: right;"></span>
      <span id="from" style="float: right;"></span>
  </p>
</div>
<%
    response.sendRedirect(request.getContextPath()+"/pages/main.jsp");
%>
<script>
    var xhr = new XMLHttpRequest();
    xhr.open('get', 'https://v1.hitokoto.cn');
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            var data = JSON.parse(xhr.responseText);
            console.log(data);
            var hitokoto = document.getElementById('hitokoto');
            hitokoto.innerText = data.hitokoto;
            var from = document.getElementById('from');
            from.innerText = "——《" + data.from + "》";
            var from_who = document.getElementById('from_who');
            if(data.from_who != null && data.from_who != "null"){
                from_who.innerText = data.from_who;
            }
        }
    }
    xhr.send();
</script>
</body>
</html>
