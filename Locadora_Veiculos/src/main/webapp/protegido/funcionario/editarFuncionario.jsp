<%-- 
    Document   : editarFuncionario
    Created on : 13 de mai de 2021, 10:37:52
    Author     : Jeferson Davi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Funcionário</title>
    </head>
    <body>
        <h1>Editar Funcionário</h1>
        
        <form action="FuncionarioCadastroServlet" method="POST">
            
            <label for="nomeFuncionario">Nome:</label>
            <input type="text" name="nomeFuncionario" />
            <br><br>
            
            <label for="emailFuncionario">E-mail:</label>
            <input type="text" name="emailFuncionario" />
            <br><br>
            
            <label for="sexo">Tipo de usuário:&emsp;</label>
            
            <input type="radio" name="tipoFunc" id="adm" value="a">
            <label for="adm">Administrador &emsp;</label>

            <input type="radio" name="tipoFunc" id="func" value="f">
            <label for="func">Funcionário &emsp;</label>
            <br><br>
            
            <h3>Informações de acesso</h3>
            <br>
            
            <label for="usuario">Usuário:</label>
            <input type="text" name="usuario" />
            <br><br>
            
            <label for="usuario">Senha</label>
            <input type="password" name="usuario" />
            <br><br>
            
            <button type="button" onclick="location.href='../index.jsp'">Cancelar</button>
            <button type="submit" ">Enviar</button>
            
        </form>
        
    </body>
</html>
