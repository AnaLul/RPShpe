<%-- 
    Document   : cargado
    Created on : 28/11/2015, 09:42:17 PM
    Author     : Lucia
--%>
<%@page import="Modelo.Juego"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="ganador" uri="/WEB-INF/tlds/ganador" %>
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
            <li role="presentation" ><a href="index">Incio</a></li>
            <li role="presentation"><a href="jugando.jsp">Atras</a></li>
            <li role="presentation"><a href="marcador.jsp">Marcadores</a></li>

        </ul>
        <h1>ROCK-PAPPER-SCISSORS</h1>
        <h2>¡FELICIDADES!</h2>
          <jsp:useBean id="ganadores" class="Modelo.Juego" scope="session"></jsp:useBean>
            ${ganador: MostrarGanador1(ganadores)}


        <div id="play">
            
            
            <form method="post" action="ResetDB" enctype="multipart/form-data">
                <table>
                    <tr>
                        <td> <input class="btn btn-primary" type="submit" value="Reiniciar"/>
                        </td>

                    </tr>
                </table>
            </form>
        
        </div>


    </body>
</html>
