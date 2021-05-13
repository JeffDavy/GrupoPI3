<%-- 
    Document   : cadastrarVeiculo
    Created on : 13 de mai de 2021, 10:36:21
    Author     : Jeferson Davi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Veículo</title>
    </head>
    <body>
        <h1>Cadastro de Veículo</h1>
        
        <form action="VeiculoCadastroServlet" method="POST">
            
            <label for="marca">Marca:</label>
            <input type="text" name="marca" />
            <br><br>
            
            <label for="modelo">Modelo:</label>
            <input type="text" name="modelo" />
            <br><br>
            
            <label for="ano">Ano:</label>
            <input type="number" name="ano" />
            <br><br>
            
            <label for="placa">Placa:</label>
            <input type="text" name="placa" />
            <br><br>
            
            <label for="cor">Cor:</label>
            <input type="text" name="cor" />
            <br><br>
            
            <label for="km">KM:</label>
            <input type="number" name="km" />
            <br><br>
            
            <label for="valor">Valor:</label>
            <input type="number" name="valor" />
            <br><br>
            
            <button type="button" onclick="location.href='../index.jsp'">Cancelar</button>
            <button type="submit" ">Enviar</button>
            
        </form>
        
    </body>
</html>
