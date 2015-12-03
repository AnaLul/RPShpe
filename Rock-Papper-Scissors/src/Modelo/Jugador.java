/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Lucia
 */
public class Jugador implements Comparable<Jugador>, Comparator<Jugador> {

//constructor con parametros   
    public Jugador(String nombre, String estrategia, int puntaje) {
        this.nombre = nombre;
        this.estrategia = estrategia;
        this.puntaje = puntaje;
    }

//constructor sin parametros
    public Jugador() {

    }

    @Override
    public String toString() {
        return "[" + nombre + "," + puntaje + ']';
    }

//Metodos get
    public String getNombre() {
        return nombre;
    }

    public String getEstrategia() {
        return estrategia;
    }

    //Atributs
    public int getPuntaje() {
        return puntaje;
    }
//Metodos set

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public void setPuntaje() {
        this.puntaje = this.puntaje + 3;
    }

    public void setEstrategia(String estrategia) {
        this.estrategia = estrategia;
    }

    //Insertar un jugador en la base de datos
    public void insertarNuevoJugador(String pNombre, String pEstrategia, int pPuntaje) {
        Conexion conexion = Conexion.getInstancia();
        Connection conn = null;
        PreparedStatement preparedStmt = null;
        try {

            conn = conexion.getConnection();

            String query = "insert into Jugadores(nombre, estrategia, puntaje) values (?, ?, ?)";
            preparedStmt = conn.prepareStatement(query);

            preparedStmt.setString(1, pNombre);
            preparedStmt.setString(2, pEstrategia);
            preparedStmt.setInt(3, pPuntaje);

            preparedStmt.execute();
            preparedStmt.close();
            conn.close();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }

    //obtener los jugadores
    public static ArrayList<Jugador> getJugadores() {//devuelve un array de String con la lista usuarios
        Conexion conexion = Conexion.getInstancia();
        Statement st = null;
        Connection conn = null;

        ArrayList<Jugador> Jugadores = new ArrayList<>();
        try {

            conn = conexion.getConnection();
            st = conexion.getStatement(conn);
            String query = "SELECT* FROM JUGADORES";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Jugador aux = new Jugador();
                String nombre = rs.getString("nombre");
                int puntaje = rs.getInt("puntaje");

                aux.setPuntaje(puntaje);
                aux.setNombre(nombre);
                Jugadores.add(aux);
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
            try {
                st.close();
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
        }
        return Jugadores;
    }

    //reiniciar la base de datos
    public void reset() {
        EliminarMarcadores();
        EliminarJugadores();
    }

    public static void reset1(Jugador jug) {
        jug.reset();
    }

    //"reset" Jugadores de la base de datos

    public void EliminarJugadores() {
        Conexion conexion = Conexion.getInstancia();
        Connection conn = null;
        PreparedStatement preparedStmt = null;
        try {

            conn = conexion.getConnection();

            String query = "DELETE FROM JUGADORES";
            preparedStmt = conn.prepareStatement(query);

            preparedStmt.execute(query);
            preparedStmt.execute();
            preparedStmt.close();
            conn.close();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }

    public void EliminarMarcadores() {
        Conexion conexion = Conexion.getInstancia();
        Connection conn = null;
        PreparedStatement preparedStmt = null;
        try {

            conn = conexion.getConnection();

            String query = "DELETE FROM MARCADORES";
            preparedStmt = conn.prepareStatement(query);

            preparedStmt.execute(query);
            preparedStmt.execute();
            preparedStmt.close();
            conn.close();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }

    public void actualizarPuntaje(int puntaje, String nombre) {
        Conexion conexion = Conexion.getInstancia();
        Connection conn = null;
        PreparedStatement preparedStmt = null;
        try {

            conn = conexion.getConnection();

            String query = "UPDATE MARCADORES SET puntMarcador='" + puntaje + "' WHERE nomJugador='" + nombre + "'";
            preparedStmt = conn.prepareStatement(query);

            preparedStmt.execute(query);
            preparedStmt.execute();
            preparedStmt.close();
            conn.close();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }

    //obtener los jugadores
    public static ArrayList<Jugador> getMarcadors() {  //devuelve un array de String con la lista usuarios
        Conexion conexion = Conexion.getInstancia();
        Statement st = null;
        Connection conn = null;

        ArrayList<Jugador> Jugadores = new ArrayList<>();
        try {

            conn = conexion.getConnection();
            st = conexion.getStatement(conn);
            String query = "SELECT* FROM MARCADORES";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Jugador aux = new Jugador();
                String nombre = rs.getString("nomJugador");
                int puntaje = rs.getInt("puntMarcador");

                aux.setPuntaje(puntaje);
                aux.setNombre(nombre);
                Jugadores.add(aux);
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
            try {
                st.close();
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
        }
        return Jugadores;
    }

  
    public void insertarMarcadores(String pNombre, int pPuntaje) {
        Conexion conexion = Conexion.getInstancia();
        Connection conn = null;
        PreparedStatement preparedStmt = null;
        try {

            conn = conexion.getConnection();

            String query = "INSERT INTO MARCADORES(nomJugador, puntMarcador) VALUES(?, ?)";
            preparedStmt = conn.prepareStatement(query);

            preparedStmt.setString(1, pNombre);
            preparedStmt.setInt(2, pPuntaje);

            preparedStmt.execute();
            preparedStmt.close();
            conn.close();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }

    //Seleccionar los 10 mejores marcadores
    public ArrayList<Jugador> diezMejores() {
        ArrayList<Jugador> Jugadores = getJugadores();

        Collections.sort(Jugadores, new Jugador());

        for (int i = 0; i < Jugadores.size(); i++) {
            insertarMarcadores(Jugadores.get(i).getNombre(), Jugadores.get(i).getPuntaje());

        }

        return Jugadores;
    }

    public ArrayList<Jugador> ObtenerMarcadores() {
        getJugadores();

        return diezMejores();
    }

    public static String MostrarMarcadores1(Jugador marcadores) {
        return marcadores.MostrarMarcadores();
    }

    //mostrar los 10 mejores puntaje
    public String MostrarMarcadores() {
        // guardarDiezMejores();
        ArrayList<Jugador> marcador = getMarcadors();
        Collections.sort(marcador, new Jugador());
        StringBuilder toHtml = new StringBuilder();
        if (!marcador.isEmpty()) {
            toHtml.append(" <table  class='table table-striped' id='tablaMarcadores'  width='25%'>");
            toHtml.append("<thead>");
            toHtml.append("<th>#</th>");
            toHtml.append("<th>Nombre</th>");
            toHtml.append("<th>Puntaje</th>");
            toHtml.append("</thead>");
            toHtml.append("<tbody>");

            for (int i = 0; i < 10; i++) {
                toHtml.append("<tr>");

                toHtml.append("<td>");
                toHtml.append(i + 1);
                toHtml.append("</td>");
                toHtml.append("<td>");
                toHtml.append(marcador.get(i).getNombre());
                toHtml.append("</td>");
                toHtml.append("<td>");
                toHtml.append(marcador.get(i).getPuntaje());
                toHtml.append("</td>");

                toHtml.append("</tr>");

            }

            toHtml.append("</tbody>");
            toHtml.append("</table>");

        } else {
            String mens = "No hay marcadores";
            toHtml.append("<p>");
            toHtml.append(mens);
            toHtml.append("<p>");
        }
        return toHtml.toString();
    }
    //ATRIBUTOS
    private String nombre;
    private String estrategia;
    private int puntaje;

    @Override
    public int compareTo(Jugador o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int compare(Jugador o1, Jugador o2) {
        return o2.puntaje - o1.puntaje;
    }
}
