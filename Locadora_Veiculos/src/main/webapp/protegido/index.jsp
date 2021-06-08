<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <!--<body>-->
        <br>

     <body class="container">
        <!--<h1>Locadora de Veículos</h1>-->
        <c:import url="/header.jsp"/>
        <c:if test="${param.erroLogin}">
            <div class="alert alert-danger" role="alert">
               Erro de Login!
            </div>
        </c:if>
       
        <form action="LoginServlet" method="POST">
            <p>Usuario</p>
            <input type="text" name="login"  class="form-control"/>
            <p>Senha</p>
            <input type="password" name="senha" class="form-control"/>
            <br/><br/>
            <button type="submit"  class="btn btn-primary">Enviar</button>
        </form>

    <!--</body>-->
        <a href="Administrador.jsp">Locadora</a>
            
      
    </body>
</html>
