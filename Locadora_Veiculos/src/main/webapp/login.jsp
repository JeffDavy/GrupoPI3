
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body class="container">
        <c:import url="header.jsp"/>
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
            <button type="submit" class="btn btn-primary">Enviar</button>
        </form>

    </body>
</html>
