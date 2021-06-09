<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <br>
        <ul class="menu">
            <c:import url="../header.jsp"/>
            <p>Usuário Logado: ${sessionScope.usuario.nome} | ${sessionScope.usuario.filial}</p>  
            <li><a>Locação</a>
                <ul>
                    <li><a href="locacao/realizarLocacao.jsp">Realizar Locação</a></li>
                </ul>
            </li>

            <li><a>Veículo</a>
                <ul>
                    <li><a href="veiculo/cadastrarVeiculo.jsp">Cadastrar</a></li>
                    <li><a href="veiculo/editarVeiculo.jsp">Editar</a></li>
                    <li><a href="veiculo/removerVeiculo.jsp">Remover</a></li>
                    <li><a href="veiculo/listarVeiculo.jsp">Listar</a></li>
                </ul>
            </li>

            <li><a>Cliente</a>
                <ul>
                    <li><a href="clientes/cadastrarCliente.jsp">Cadastrar</a></li>
                    <li><a href="clientes/editarCliente.jsp">Editar</a></li>
                    <li><a href="clientes/removerCliente.jsp">Remover</a></li>
                    <li><a href="clientes/listarCliente.jsp">Listar</a></li>
                </ul>
            </li>

            <li><a>Funcionário</a>
                <ul>
                    <li><a href="funcionario/cadastrarFuncionario.jsp">Cadastrar</a></li>
                    <li><a href="funcionario/editarFuncionario.jsp">Editar</a></li>
                    <li><a href="funcionario/removerFuncionario.jsp">Remover</a></li>
                    <li><a href="funcionario/listarFuncionario.jsp">Listar</a></li>
                </ul>
            </li>

            <li><a>Relatório</a>
                <ul>
                    <li><a href="relatorio/exibirRelatorio.jsp">Exibir</a></li>
                </ul>

            </li>
        </ul>-->

        <a href="Administrador.jsp">Locadora</a>
    </body>
</html>