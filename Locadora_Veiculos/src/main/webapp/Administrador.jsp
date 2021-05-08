<%-- 
    Document   : Administrador
    Created on : 8 de mai de 2021, 16:36:28
    Author     : Administrador
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

        <title>Locadora de Veículos</title>

    </head>

    <body>

        <!-- MENU SUPERIOR -->
        <nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
            <a class="navbar-brand" href="#">Locadora</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarsExampleDefault">

                <ul class="navbar-nav mr-auto">

                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Locação</a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" >Realizar</a>
                            <a class="dropdown-item" href="#">Consultar</a>
                            <a class="dropdown-item" href="#">Cancelar</a>
                            <a class="dropdown-item" href="#">Listar</a>
                            <a class="dropdown-item" href="#">Devolução</a>
                        </div>
                    </li>

                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Clientes</a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" data-toggle="modal" data-target="#ModalCliente">Cadastrar</a>
                            <a class="dropdown-item" data-toggle="modal" data-target="#EditarCliente">Editar</a>
                            <a class="dropdown-item" href="#">Desativar</a>
                            <a class="dropdown-item" href="#">Listar</a>
                        </div>
                    </li>

                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Veículos</a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" data-toggle="modal" data-target="#ModalVeiculo">Cadastrar</a>
                            <a class="dropdown-item" data-toggle="modal" data-target="#EditarVeiculo">Editar</a>
                            <a class="dropdown-item" href="#">Desativar</a>
                            <a class="dropdown-item" href="#">Ativar</a>
                            <a class="dropdown-item" href="#">Listar</a>
                        </div>
                    </li>

                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Funcionários</a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" data-toggle="modal" data-target="#ModalFuncionario">Cadastrar</a>
                            <a class="dropdown-item" data-toggle="modal" data-target="#EditarFuncionario">Editar</a>
                            <a class="dropdown-item" href="#">Desativar</a>
                            <a class="dropdown-item" href="#">Listar</a>
                        </div>
                    </li>

                </ul>

            </div>

        </nav>

        <!-- Modal das telas -->

        <!-- CLIENTES -->
        <div class="modal fade" id="ModalCliente" tabindex="-1" role="dialog" aria-labelledby="TituloModalCliente" aria-hidden="true">

            <div class="modal-dialog" role="document">

                <div class="modal-content">

                    <div class="modal-header">

                        <h5 class="modal-title" id="TituloModalCliente">Cliente</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                            <span aria-hidden="true">&times;</span>
                        </button>

                    </div>

                    <div class="modal-body">

                        <div class="form-group">

                            <form action="ClienteServlet" method="POST">

                                <label for="nomeCliente">Nome Completo</label>
                                <input type="text" name="nome" class="form-control" id="nomeCliente" placeholder="Informe o nome completo">
                                <br>

                                <label for="cpfCliente">CPF</label>
                                <input type="text" name="cpf" class="form-control" id="cpfCliente" placeholder="Informe o número de CPF">
                                <br>

                                <label for="nascimentoCliente">Data Nascimento</label>
                                <input type="text" name="data" class="form-control" id="nascimentoCliente" placeholder="Informe a data de nascimento">
                                <br>

                                <label for="sexo">Sexo:&emsp;</label>
                                <div class="form-check form-check-inline">

                                    <input class="form-check-input" type="radio" name="sexoRadio" id="sexMasc" value="m">
                                    <label class="form-check-label" for="sexMasc">
                                        Masculino &emsp;
                                    </label>

                                    <input class="form-check-input" type="radio" name="sexoRadio" id="sexFem" value="f">
                                    <label class="form-check-label" for="sexFem">
                                        Feminino &emsp;
                                    </label>

                                    <input class="form-check-input" type="radio" name="sexoRadio" id="sexOut" value="o">
                                    <label class="form-check-label" for="sexOut">
                                        Outro &emsp;
                                    </label>

                                </div>
                                <br>

                                <label for="emailCliente">Endereço de email</label>
                                <input type="email" name="email" class="form-control" id="emailCliente" placeholder="nome@exemplo.com">
                                <br>

                                <label for="contato1Cliente">Contato 1</label>
                                <input type="text" name="contato1" class="form-control" id="contato1Cliente" placeholder="Informe um número de contato">
                                <br>

                                <label for="contato2Cliente">Contato 2</label>
                                <input type="text" name="contato2" class="form-control" id="contato2Cliente" placeholder="Informe um número de contato">
                                <br>

                                <h6>Endereço</h6>

                                <label for="ruaCliente">Rua</label>
                                <input type="text" name="rua" class="form-control" id="ruaCliente" placeholder="Informe a rua">
                                <br>

                                <label for="numeroCliente">Número</label>
                                <input type="number" name="numero" class="form-control" id="numeroCliente" placeholder="Informe o número">
                                <br>

                                <label for="bairroCliente">Bairro</label>
                                <input type="text" name="bairro" class="form-control" id="bairroCliente" placeholder="Informe o bairro">
                                <br>

                                <label for="cidadeCliente">Cidade</label>
                                <input type="text" name="cidade" class="form-control" id="cidadeCliente" placeholder="Informe a cidade">
                                <br>

                                <label for="estadoCliente">Estado</label>
                                <input type="text" name="estado" class="form-control" id="estadoCliente" placeholder="Informe o estado">
                                <br>

                                <label for="complementoCliente">Complemento</label>
                                <input type="text" name="complemento" class="form-control" id="complementoCliente" placeholder="Informe o complemento">
                                <br>

                                <h6>Login de acesso</h6>

                                <label for="usuario">Usuário</label>
                                <input type="text" name="usuario" class="form-control" id="usuario" placeholder="Informe um nome de usuário">
                                <br>

                                <label for="senha">Senha</label>
                                <input type="password" name="senha" class="form-control" id="senha" placeholder="Informe a senha">
                                <br>

                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                                <button type="submit" class="btn btn-primary">Enviar</button>

                            </form>

                        </div>

                    </div>

                </div>

            </div>

        </div>

        <!-- CONFIRMAÇÃO DE EDIÇÃO CLIENTE-->
        <div class="modal fade" id="EditarCliente" tabindex="-1" role="dialog" aria-labelledby="TituloModalEdicaoCliente" aria-hidden="true">

            <div class="modal-dialog modal-dialog-centered" role="document">

                <div class="modal-content">

                    <div class="modal-header">

                        <h5 class="modal-title" id="TituloModalEdicaoCliente">Informe o CPF do cliente</h5>

                        <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                            <span aria-hidden="true">&times;</span>
                        </button>

                    </div>

                    <div class="modal-body">

                        <label for="cpfCliente">CPF</label>
                        <input type="text" class="form-control" id="cpfCliente" onkeypress="$(this).mask('000.000.000-00');" placeholder="Número de CPF">

                    </div>

                    <div class="modal-footer">

                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
                        <button type="button" class="btn btn-primary">Confirmar</button>

                    </div>

                </div>

            </div>

        </div>

        <!-- VEÍCULOS -->
        <div class="modal fade" id="ModalVeiculo" tabindex="-1" role="dialog" aria-labelledby="TituloModalVeiculo" aria-hidden="true">

            <div class="modal-dialog" role="document">

                <div class="modal-content">

                    <div class="modal-header">

                        <h5 class="modal-title" id="TituloModalVeiculo">Veículo</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                            <span aria-hidden="true">&times;</span>
                        </button>

                    </div>

                    <div class="modal-body">

                        <div class="form-group">

                            <form action="VeiculoServlet" method="POST">
                                <label for="marcaVeiculo">Marca</label>
                                <input type="text" name="marca" class="form-control" id="marcaVeiculo" placeholder="Informe a marca do veículo">
                                <br>

                                <label for="modeloVeiculo">Modelo</label>
                                <input type="text" name="modelo" class="form-control" id="modeloVeiculo" placeholder="Informe o modelo do veículo">
                                <br>

                                <label for="anoVeiculo">Ano</label>
                                <input type="number" name="ano" class="form-control" id="anoVeiculo" onkeypress="$(this).mask('0000')" placeholder="Informe o ano de fabricação do veículo">
                                <br>

                                <label for="placaVeiculo">Placa</label>
                                <input type="text" name="placa" class="form-control" id="placaVeiculo" onkeypress="$(this).mask('AAA9999')" placeholder="Informe a placa do veículo">
                                <br>

                                <label for="corVeiculo">Cor</label>
                                <input type="text" name="cor" class="form-control" id="corVeiculo" placeholder="Informe a cor do veículo">
                                <br>

                                <label for="kmVeiculo">KM</label>
                                <input type="number" name="km" class="form-control" id="kmVeiculo" placeholder="Informe a quilometragem do veículo">
                                <br>

                                <label for="valorVeiculo">Valor</label>
                                <input type="text" name="valor" class="form-control" id="valorVeiculo" placeholder="Informe o valor diário de locação">
                                <br>

                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                                <button type="submit" class="btn btn-primary">Enviar</button>

                            </form>

                        </div>

                    </div>

                </div>

                <div class="modal-footer">

                </div>

            </div>

        </div>

    </div>

    <!-- CONFIRMAÇÃO DE EDIÇÃO VEÍCULO-->
    <div class="modal fade" id="EditarVeiculo" tabindex="-1" role="dialog" aria-labelledby="TituloModalEdicaoVeiculo" aria-hidden="true">

        <div class="modal-dialog modal-dialog-centered" role="document">

            <div class="modal-content">

                <div class="modal-header">

                    <h5 class="modal-title" id="TituloModalEdicaoVeiculo">Informe a placa do veículo</h5>

                    <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                        <span aria-hidden="true">&times;</span>
                    </button>

                </div>

                <div class="modal-body">

                    <label for="placaVeiculo">Placa</label>
                    <input type="text" class="form-control" id="placaVeiculo" onkeypress="$(this).mask('AAA-9999')" placeholder="Placa do veículo">

                </div>

                <div class="modal-footer">

                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
                    <button type="button" class="btn btn-primary">Confirmar</button>

                </div>

            </div>

        </div>

    </div>

    <!-- FUNCIONÁRIOS -->
    <div class="modal fade" id="ModalFuncionario" tabindex="-1" role="dialog" aria-labelledby="TituloModalFuncionario" aria-hidden="true">

        <div class="modal-dialog" role="document">

            <div class="modal-content">

                <div class="modal-header">

                    <h5 class="modal-title" id="TituloModalFuncionario">Funcionário</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                        <span aria-hidden="true">&times;</span>
                    </button>

                </div>

                <div class="modal-body">

                    <div class="form-group">

                        <form action="FuncionarioCadastroServlet" method="POST">

                            <label for="nomeFuncionario">Nome Completo</label>
                            <input type="text" name="nomeFuncionario" class="form-control" id="nomeFuncionario" placeholder="Informe o nome completo">
                            <br>

                            <label for="emailFuncionario">Endereço de email</label>
                            <input type="email" name="emailFuncioanrio" class="form-control" id="emailFuncionario" placeholder="nome@exemplo.com">
                            <br>
                            
                            <label for="tipo">Tipo:&emsp;</label>
                            <div class="form-check form-check-inline">

                                <input class="form-check-input" type="radio" name="tipo" id="adm" value="a">
                                <label class="form-check-label" for="adm">
                                    Administrador &emsp;
                                </label>

                                <input class="form-check-input" type="radio" name="tipo" id="funcionario" value="f">
                                <label class="form-check-label" for="funcionario">
                                    Funcionário &emsp;
                                </label>

                            </div>


                            <label><h6>Informações de acesso:</h6></label>
                            <br>

                            <label for="usuarioFuncionario">Usuário</label>
                            <input type="text" name="usuarioFuncionario" class="form-control" id="usuarioFuncionario" placeholder="Informe o usuário">
                            <br>

                            <label for="senhaFuncionario">Senha</label>
                            <input type="password" name="senhaFuncionario" class="form-control" id="senhaFuncionario" placeholder="Informe a senha">
                            <br>

                            <label for="senhaConfFuncionario">Confirmação</label>
                            <input type="password" class="form-control" id="senhaConfFuncionario" placeholder="Confirme a senha">
                            <br>

                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                            <button type="submit" class="btn btn-primary">Enviar</button>

                        </form>

                    </div>

                </div>

            </div>

        </div>

    </div>

    <!-- CONFIRMAÇÃO DE EDIÇÃO FUNCIONÁRIO-->
    <div class="modal fade" id="EditarFuncionario" tabindex="-1" role="dialog" aria-labelledby="TituloModalEdicaoFuncionario" aria-hidden="true">

        <div class="modal-dialog modal-dialog-centered" role="document">

            <div class="modal-content">

                <div class="modal-header">

                    <h5 class="modal-title" id="TituloModalEdicaoFuncionario">Informe o usuário do funcionário</h5>

                    <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                        <span aria-hidden="true">&times;</span>
                    </button>

                </div>

                <div class="modal-body">

                    <label for="usuarioFuncionario">Usuário</label>
                    <input type="text" class="form-control" id="usuarioFuncionario" placeholder="Usuário do funcionário">

                </div>

                <div class="modal-footer">

                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
                    <button type="submit" class="btn btn-primary">Enviar</button>

                </div>

            </div>

        </div>

    </div>

    <main role="main" class="container">

        <div class="starter-template">
            <h1><br>Relatório mensal</h1>
            <p class="lead">Será exibido o relatório de locações do mês.</p>
        </div>

    </main><!-- /.container -->

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
    <script src="../../assets/js/vendor/popper.min.js"></script>
    <script src="../../dist/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>

</body>

</html>
