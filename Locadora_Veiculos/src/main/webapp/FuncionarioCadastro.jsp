<%-- 
    Document   : FuncionarioCadastro
    Created on : 04/05/2021, 16:12:48
    Author     : dilaz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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

              <label for="nomeCliente">Nome Completo</label>
              <input type="text" class="form-control" id="nomeCliente" placeholder="Informe o nome completo">
              <br>

              <label for="cpfCliente">CPF</label>
              <input type="text" class="form-control" id="cpfCliente" onkeypress="$(this).mask('000.000.000-00');" placeholder="Informe o número de CPF">
              <br>

              <label for="nascimentoCliente">Data Nascimento</label>
              <input type="text" class="form-control" id="nascimentoCliente" onkeypress="$(this).mask('00/00/0000')" placeholder="Informe a data de nascimento">
              <br>

              <label for="sexo">Sexo:&emsp;</label>
              <div class="form-check form-check-inline">
              
                <input class="form-check-input" type="radio" name="sexoRadio" id="sexMasc" value="opcao1">
                <label class="form-check-label" for="sexMasc">
                  Masculino &emsp;
                </label>

                <input class="form-check-input" type="radio" name="sexoRadio" id="sexFem" value="opcao2">
                <label class="form-check-label" for="sexFem">
                  Feminino &emsp;
                </label>

                <input class="form-check-input" type="radio" name="sexoRadio" id="sexOut" value="option3">
                <label class="form-check-label" for="sexOut">
                  Outro &emsp;
                </label>

              </div>
              <br>

              <label for="emailCliente">Endereço de email</label>
              <input type="email" class="form-control" id="emailCliente" placeholder="nome@exemplo.com">
              <br>

              <label for="contato1Cliente">Contato 1</label>
              <input type="text" class="form-control" id="contato1Cliente" onkeypress="$(this).mask('(00) 0000-00009')" placeholder="Informe um número de contato">
              <br>

              <label for="contato2Cliente">Contato 2</label>
              <input type="text" class="form-control" id="contato2Cliente" onkeypress="$(this).mask('(00) 00000-0000')" placeholder="Informe um número de contato">
              <br>

              <h6>Endereço</h6>

              <label for="ruaCliente">Rua</label>
              <input type="text" class="form-control" id="ruaCliente" placeholder="Informe a rua">
              <br>

              <label for="numeroCliente">Número</label>
              <input type="number" class="form-control" id="numeroCliente" placeholder="Informe o número">
              <br>

              <label for="bairroCliente">Bairro</label>
              <input type="text" class="form-control" id="bairroCliente" placeholder="Informe o bairro">
              <br>

              <label for="cidadeCliente">Cidade</label>
              <input type="text" class="form-control" id="cidadeCliente" placeholder="Informe a cidade">
              <br>

              <label for="estadoCliente">Estado</label>
              <input type="text" class="form-control" id="estadoCliente" placeholder="Informe o estado">
              <br>



            </div>

          </div>

          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
            <button type="button" class="btn btn-primary">Salvar</button>
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

              <label for="marcaVeiculo">Marca</label>
              <input type="text" class="form-control" id="marcaVeiculo" placeholder="Informe a marca do veículo">
              <br>

              <label for="modeloVeiculo">Modelo</label>
              <input type="text" class="form-control" id="modeloVeiculo" placeholder="Informe o modelo do veículo">
              <br>

              <label for="anoVeiculo">Ano</label>
              <input type="number" class="form-control" id="anoVeiculo" onkeypress="$(this).mask('0000')" placeholder="Informe o ano de fabricação do veículo">
              <br>

              <label for="placaVeiculo">Placa</label>
              <input type="text" class="form-control" id="placaVeiculo" onkeypress="$(this).mask('AAA-9999')" placeholder="Informe a placa do veículo">
              <br>

              <label for="corVeiculo">Cor</label>
              <select class="form-control">

                <option>Branca</option>
                <option>Preta</option>
                <option>Vermelha</option>
                <option>Prata</option>
                <option>Azul</option>

              </select>
              <br>

              <label for="kmVeiculo">Ano</label>
              <input type="number" class="form-control" id="kmVeiculo" placeholder="Informe a quilometragem do veículo">
              <br>

              <label for="revisaoVeiculo">Revisado? &emsp; </label>
              <div class="form-check form-check-inline">
              
                <input class="form-check-input" type="radio" name="revisaoRadio" id="sim" value="opcao1">
                <label class="form-check-label" for="sim">
                  Sim &emsp;
                </label>

                <input class="form-check-input" type="radio" name="revisaoRadio" id="nao" value="opcao2">
                <label class="form-check-label" for="nao">
                  Não &emsp;
                </label>

              </div>
              <br>

              <label for="valorVeiculo">Valor</label>
              <input type="text" class="form-control" id="valorVeiculo" onkeypress="$(this).mask('R$ 990,00')" placeholder="Informe o valor diário de locação">
              <br>

              <label for="statusVeiculo">Situação atual: &emsp;</label>
              <div class="form-check form-check-inline">
              
                <input class="form-check-input" type="radio" name="statusRadio" id="disponivel" value="opcao1" checked>
                <label class="form-check-label" for="disponivel">
                  Disponível &emsp;
                </label>

                <input class="form-check-input" type="radio" name="statusRadio" id="alugado" value="opcao1">
                <label class="form-check-label" for="alugado">
                  Alugado &emsp;
                </label>

                <input class="form-check-input" type="radio" name="statusRadio" id="manutencao" value="opcao2">
                <label class="form-check-label" for="manutencao">
                  Indisponível &emsp;
                </label>

              </div>

            </div>

          </div>

          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
            <button type="button" class="btn btn-primary">Salvar</button>
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

              <label for="nomeFuncionario">Nome Completo</label>
              <input type="text" class="form-control" id="nomeFuncionario" placeholder="Informe o nome completo">
              <br>

              <label for="emailFuncionario">Endereço de email</label>
              <input type="email" class="form-control" id="emailFuncionario" placeholder="nome@exemplo.com">
              <br>
           
              <label for="statusFuncionario">Situação atual:&emsp;</label>
              <div class="form-check form-check-inline">
              
                <input class="form-check-input" type="radio" name="funcionarioRadio" id="ativo" value="opcao1" checked>
                <label class="form-check-label" for="ativo">
                  Ativo &emsp;
                </label>

                <input class="form-check-input" type="radio" name="funcionarioRadio" id="desativado" value="opcao2">
                <label class="form-check-label" for="desativado">
                  Desativado &emsp;
                </label>
                <br>

              </div>
              <br><br>

              <label><h6>Informações de acesso:</h6></label>
              <br>

              <label for="usuarioFuncionario">Usuário</label>
              <input type="text" class="form-control" id="usuarioFuncionario" placeholder="Informe o usuário">
              <br>

              <label for="senhaFuncionario">Senha</label>
              <input type="password" class="form-control" id="senhaFuncionario" placeholder="Informe a senha">
              <br>

              <label for="senhaConfFuncionario">Confirmação</label>
              <input type="password" class="form-control" id="senhaConfFuncionario" placeholder="Confirme a senha">
              <br>

            </div>

          </div>

          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
            <button type="button" class="btn btn-primary">Salvar</button>
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
            <button type="button" class="btn btn-primary">Confirmar</button>

          </div>

        </div>

      </div>

    </div>

     <main role="main" class="container">

      <div class="starter-template">
        <h1><br>Funcionário</h1>
        <p class="lead">Tela de Login</p>
        <div class ="login">
            <section class="login1">
                <h2>Login</h2>
                
                    <input type="search">
        
                    
                    <div class ="senha">
            <section class="senha1">
                <h2>Senha</h2>
               
                    <input type="search">
                    <button>Entrar</button>
                    
                     <nav class = "menu-opcoes">
                <ul>
                    <li><a href="#">Esqueceu a Senha</a></li>
                    <li><a href="FuncionarioCadastro.jsp">Realizar Cadastro</a></li>
                </ul>
            </nav>
      </div>

    </main><!-- /.container -->

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
    <script src="../../assets/js/vendor/popper.min.js"></script>
    <script src="../../dist/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>

        
    </body>
    </body>
</html>
