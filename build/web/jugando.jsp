<%-- 
    Document   : cargar
    Created on : 29/11/2015, 12:34:32 PM
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
        <title>Juego</title>
    </head>
    <body>

        <header><h1 class="text-center"><img class="img-circle" id="imgHeader" src="imagenes/papel.gif" alt="" height="120" width="250"/></header>
   <ul class="nav nav-pills">
            <li role="presentation" ><a href="index.jsp">Incio</a></li>
            <li role="presentation"><a href="marcador.jsp">Marcadores</a></li>

        </ul>
        <h1>ROCK-PAPPER-SCISSORS</h1>
        <p id="parrafo" class="text-primary">Upload a text file (.txt) containing the definition
            of a championship. A file can only contain 1 championship</p>

        <div id="archivo">
            <form method="post" action="Upload" enctype="multipart/form-data">
                <table>
                    <tr><td>
                            <input class="btn btn-primary" type="file" name="file" value="Seleccione un archivo" />
                            <br/>
                        </td>
                    </tr>
                    <tr><td>
                            <input class="btn btn-primary" type="submit" value="Cargar Archivo" />
                        </td>
                        

                    </tr>
                </table>
            </form>

        </div>

    </body>
</html>