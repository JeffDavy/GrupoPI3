<%-- 
    Document   : cadastrarCliente
    Created on : 13 de mai de 2021, 14:11:22
    Author     : Jeferson Davi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cliente</title>
    </head>
    <body>
        <h1>Cadastrar Cliente</h1>
        <br>
        
        <form action="ClienteCadastroServlet" method="POST">
            
            <label for="nome">Nome:</label>
            <input type="text" name="nome" />
            <br><br>
            
            <label for="cpf">CPF:</label>
            <input type="text" name="cpf" />
            <br><br>
            
            <label for="data">Data de nascimento:</label>
            <input type="text" name="data" />
            <br><br>
            
            <label for="sexo">Sexo:&emsp;</label>
            
            <input type="radio" name="sexoRadio" id="sexMasc" value="m">
            <label for="sexMasc">Masculino &emsp;</label>

            <input type="radio" name="sexoRadio" id="sexFem" value="f">
            <label for="sexFem">Feminino &emsp;</label>

            <input type="radio" name="sexoRadio" id="sexOut" value="o">
            <label for="sexOut">Outro &emsp;</label>
            <br><br>
            
            <label for="email">E-mail:</label>
            <input type="text" name="email" />
            <br><br>
            
            <label for="contato1">Contato 1:</label>
            <input type="text" name="contato1" />
            <br><br>
            
            <label for="contato2">Contato 2:</label>
            <input type="text" name="contato2" />
            <br><br>
            
            <h3>Endereço </h3>
            <br>
            
            <label for="rua">Rua:</label>
            <input type="text" name="rua" />
            <br><br>
            
            <label for="numero">Número:</label>
            <input type="number" name="numero" />
            <br><br>
            
            <label for="bairro">Bairro:</label>
            <input type="text" name="bairro" />
            <br><br>
            
            <label for="cidade">Cidade:</label>
            <input type="text" name="cidade" />
            <br><br>
            
            <label for="estado">Estado:</label>
            <input type="text" name="estado" />
            <br><br>
            
            <label for="complemento">Complemento:</label>
            <input type="text" name="complemento" />
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
