<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>将夜</title>
  </head>
  <script>
      function suibian() {
              fetch("http://localhost:8080/crossdomain", {
                  method: 'get'
              }).then(function (value) {
                  value.text().then(console.log);
              })
      }
  </script>
  <body>
    <button onclick="suibian()">发送</button>
  </body>
</html>
