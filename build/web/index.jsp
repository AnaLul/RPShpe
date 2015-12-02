<%-- 
    Document   : index
    Created on : 28/11/2015, 09:10:23 PM
    Author     : Lucia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <style >

        </style>
        <link href="estilo.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="dependencias/bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

        <!-- Optional theme -->
        <link href="dependencias/bootstrap-3.3.5-dist/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>

        <!-- Latest compiled and minified JavaScript -->
        <script src="dependencias/bootstrap-3.3.5-dist/js/bootstrap.min.js" type="text/javascript"></script>
        <title>Incio</title>
    </head>
    <body>

        <header><h1 class="text-center"><img class="img-circle" id="imgHeader" src="imagenes/papel.gif" alt="" height="120" width="250"/></header>




        <ul class="nav nav-pills">
            <li role="presentation" class="active"><a href="#">Incio</a></li>
            <li role="presentation"><a href="marcador.jsp">Marcadores</a></li>

        </ul>
        <h1>ROCK-PAPPER-SCISSORS</h1>
        <p id="parrafo" class="text-primary">In a game of rock-paper-scissors, each player chooses to play Rock (R),
            Paper (P), or Scissors (S). The rules are: Rock beats Scissors, Scissors beats Paper, but Paper beats Rock. 
        </p>


        <div id="play">
             <a href="jugando.jsp">
            <button type="button" class="btn btn-primary btn-lg" aria-label="Left Align">
                <span  class="glyphicon glyphicon-play-circle" aria-hidden="true"></span>
            </button></a> </div> <p id="jugar"><strong> Jugar </strong> </p>
            
        



    </body>
</html>
