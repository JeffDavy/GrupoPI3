<%-- 
    Document   : cadastrarVeiculo
    Created on : 8 de mai de 2021, 16:11:07
    Author     : Administrador
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
        <br>
        
        <form action="VeiculoServlet" method="POST">
            
            <p>Marca</p>
            <input type="text" name="marca"/>
            
            <p>Modelo</p>
            <input type="text" name="modelo"/>
            
            <p>Ano</p>
            <input type="text" name="ano"/>
            
            <p>Placa</p>
            <input type="text" name="placa"/>
            
            <p>Cor</p>
            <input type="text" name="cor"/>
            
            <p>KM</p>
            <input type="text" name="km"/>
            
            <p>Valor mensal</p>
            <input type="text" name="valor"/>
            
            <br/>
            
            <button type="submit">Enviar</button>
            
        </form>
        
    </body>
</html>
