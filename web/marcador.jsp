<%-- 
    Document   : juego
    Created on : 30/11/2015, 01:17:21 PM
    Author     : Lucia
--%>
<%@page import="Modelo.Jugador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="marc" uri="/WEB-INF/tlds/marcadores" %>
<!DOCTYPE html>
<html>
    <head>
         <link href="estilo.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="dependencias/bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

        <!-- Optional theme -->
        <link href="dependencias/bootstrap-3.3.5-dist/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>

        <!-- Latest compiled and minified JavaScript -->
        <script src="dependencias/bootstrap-3.3.5-dist/js/bootstrap.min.js" type="text/javascript"></script>
        <title>rock-papper-scissor</title>
    </head>
    <body>
        
        <header><h1 class="text-center"><img class="img-circle" id="imgHeader" src="imagenes/papel.gif" alt="" height="120" width="250"/></header>

        <div id="wrapper">
            
             <ul class="nav nav-pills">
                <li role="presentation" ><a href="index.jsp">Incio</a></li>
                <li role="presentation" class="active"><a href="marcador.jsp">Marcadores</a></li>
           
            </ul>
            
            <h1>Marcadores</h1>

            <jsp:useBean id="tablaMarcadores" class="Modelo.Jugador" scope="session"></jsp:useBean>
            ${marc: MostrarMarcadores1(tablaMarcadores)}
            
        </div>
    </body>
</html>
