<%-- 
    Document   : index
    Created on : 22 de abr de 2021, 21:04:02
    Author     : Administrador
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

    <head>
        <title>Locadora de Veículos</title>
        <meta charset="utf-8">

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

    </head>

    <body>

        <div id="align-middle">

            <h3 class="text-center text-info pt-5">Locadora de Veículos</h3>

            <div class="container">

                <div id="login-row" class="row justify-content-center align-items-center">

                    <div id="login-column" class="col-md-6">

                        <div id="login-box" class="col-md-12">

                            <form id="login-form" class="form" action="" method="post">

                                <h3 class="text-center text-info">Login</h3>

                                <div class="form-group">
                                    <label for="username" class="text-info">Usuário:</label><br>
                                    <input type="text" name="username" id="username" class="form-control">
                                </div>

                                <div class="form-group">
                                    <label for="password" class="text-info">Senha:</label><br>
                                    <input type="password" name="password" id="password" class="form-control">
                                </div>

                                <div class="form-group">
                                    <input type="submit" name="submit" class="btn btn-info btn-md" value="Acessar">
                                </div>

                            </form>

                        </div>

                    </div>

                </div>

            </div>

        </div>

    </body>

</html>