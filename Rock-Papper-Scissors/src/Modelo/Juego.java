/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexion.Conexion;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import rock.papper.scissors.Torneo;

/**
 *
 * @author Lucia
 */
public class Juego {

    public Juego() {
        juego = new ArrayList<Torneo>();
    }

    public Juego(ArrayList<Torneo> juego) {
        this.juego = juego;
    }

    public void setJuego(ArrayList<Torneo> juego) {
        this.juego = juego;
    }

    public ArrayList<Torneo> getJuego() {
        return juego;
    }

    //metodo que llama a los demas para completar la dinamica del juego
    public Jugador principal() {
        Jugador nuevoJugador = new Jugador();
        //  nuevoJugador.EliminarJugadores();
        Juego nuevoJuego = cargarJuego();

        Partida part;

        Torneo auxTorneo = new Torneo();

        while (!nuevoJuego.getJuego().isEmpty()) {

            if (nuevoJuego.getJuego().get(0).getTorneo().get(0).getPartida()[1] == null) {
                if (nuevoJuego.getJuego().size() == 1) {
                    nuevoJugador.diezMejores();
                    nuevoJugador.EliminarJugadores();
                    return nuevoJuego.getJuego().get(0).getTorneo().get(0).getPartida()[0];
                }
                if (nuevoJuego.getJuego().size() > 1) {
                    if (nuevoJuego.getJuego().size() % 2 == 0) {
                        int var = nuevoJuego.getJuego().size();
                        for (int j = 0; j < var / 2; j++) {

                            part = new Partida();
                            auxTorneo = new Torneo();

                            part.getPartida()[0] = nuevoJuego.getJuego().get(0).getTorneo().get(0).getPartida()[0];
                            part.getPartida()[1] = nuevoJuego.getJuego().get(1).getTorneo().get(0).getPartida()[0];
                            auxTorneo.getTorneo().add(part);
                            nuevoJuego.getJuego().add(auxTorneo);
                            nuevoJuego.getJuego().remove(0);
                            nuevoJuego.getJuego().remove(0);

                        }
                    } else {
                        for (int i = 0; i < nuevoJuego.getJuego().size(); i++) {
                            if ((nuevoJuego.getJuego().get(0).getTorneo().get(0).getPartida()[1]) == null && (nuevoJuego.getJuego().get(1).getTorneo().get(1).getPartida()[1] != null)) {
                                part = new Partida();
                                auxTorneo = new Torneo();

                                part = nuevoJuego.getJuego().get(i).getTorneo().get(0);
                                auxTorneo.getTorneo().add(part);
                                nuevoJuego.getJuego().add(auxTorneo);

                            }

                        }
                    }

                }
            }
            Torneo torneo = jugarTorneo(nuevoJuego.getJuego().get(0));
            nuevoJuego.getJuego().add(torneo);
            nuevoJuego.getJuego().remove(0);

        }
        nuevoJugador.diezMejores();
        nuevoJugador.EliminarJugadores();
        return nuevoJugador;
    }

    //resulve todo un torneo
    public Torneo jugarTorneo(Torneo tor) {
        Jugador nuevoJugador = new Jugador();
        Partida part = new Partida();
        while (!tor.getTorneo().isEmpty()) {
            if (tor.getTorneo().get(0).getPartida()[1] == null) {
                if (tor.getTorneo().size() == 1) { //fin lance el janador
                    part = new Partida();
                    nuevoJugador = tor.getTorneo().get(0).getPartida()[0];
                    part.getPartida()[0] = nuevoJugador;
                    tor.getTorneo().add(part);
                    tor.getTorneo().remove(0);
                    break;
                }
                if (tor.getTorneo().size() > 1) {
                    if (tor.getTorneo().size() % 2 == 0) {
                        int var = tor.getTorneo().size();
                        for (int j = 0; j < var / 2; j++) {
                            part = new Partida();
                            part.getPartida()[0] = tor.getTorneo().get(0).getPartida()[0];
                            part.getPartida()[1] = tor.getTorneo().get(1).getPartida()[0];
                            tor.getTorneo().add(part);
                            tor.getTorneo().remove(0);
                            tor.getTorneo().remove(0);

                        }
                    } else {
                        int var2 = (tor.getTorneo().size() / 2) + 1;
                        for (int i = 0; i < var2; i++) {
                            part = new Partida();
                            if ((tor.getTorneo().get(0).getPartida()[1]) == null && (tor.getTorneo().get(1).getPartida()[1] != null)) {
                                part = tor.getTorneo().get(0);
                                tor.getTorneo().add(part);
                                tor.getTorneo().remove(0);

                                break;
                            } else {
                                part.getPartida()[0] = tor.getTorneo().get(0).getPartida()[0];
                                part.getPartida()[1] = tor.getTorneo().get(1).getPartida()[0];
                                tor.getTorneo().add(part);
                                tor.getTorneo().remove(0);
                                tor.getTorneo().remove(0);
                            }
                        }

                    }
                }

            } else {
                int var1 = tor.getTorneo().size();
                for (int i = 0; i < var1; i++) {
                    part = new Partida();
                    boolean band = true;
                    if (tor.getTorneo().get(0).getPartida()[1] == null) {
                        band = false;
                    }
                    nuevoJugador = tor.getTorneo().get(0).logica(tor.getTorneo().get(0));
                    part.getPartida()[0] = nuevoJugador;

                    if (band) {
                        nuevoJugador.setPuntaje();
                        nuevoJugador.actualizarPuntaje(nuevoJugador.getPuntaje(), nuevoJugador.getNombre());
                        band = true;
                    }
                    tor.getTorneo().add(part);
                    tor.getTorneo().remove(0);
                }

            }
        }
        return tor;
    }

    //lee el archivo de text
    public Juego cargarJuego() {

        int contador = 0;

        String bufferIn;
        Juego nuevoJuego = new Juego(); //inicializar el juego completo
        try {
            String direccion1 = obtenerDireccion();
            DataInputStream in = new DataInputStream(new FileInputStream(direccion1));
            try {

                Torneo nuevoTorneo = new Torneo(); //inicializar un torneo
                while ((bufferIn = in.readLine()) != null) { //leer linea del archivo

                    int indiceCaracteres = 0; //contador para leer caracter por caracter
                    String cad1 = bufferIn.trim(); //eliminar los espacios en blanco
                    String cad = (cad1.replaceAll("\\s+", ""));

                    Partida nuevaPartida = new Partida(); // inicializar una partida
                    Jugador primerJugador = new Jugador(); //inicializar el primer jugador
                    Jugador segundoJugador = new Jugador(); //inicializar el segundo jugador

                    int cuentaString = 0; // saber la cantidad de comillas leidas en la linea

                    while (indiceCaracteres < cad.length()) {
                        //char caracterActual = cad.charAt(indiceCaracteres);
                        //String textoActual = "";
                        //textoActual += caracterActual;

                        int j = indiceCaracteres;  //manejar una varible de nombre más pequeño

                        String atributo = "";
                        if ((contador == 0) && (cad.length() != 1)) {

                            while (Character.isLetterOrDigit(cad.charAt(j)) || cad.charAt(j) == '"' || cad.charAt(j) == ','
                                    || cad.charAt(j) == '[' || cad.charAt(j) == ']') {
                                if (cad.charAt(j) == '"') {
                                    cuentaString++;
                                    if (cuentaString == 2) {
                                        primerJugador.setNombre(atributo);
                                        atributo = "";
                                    }
                                    if (cuentaString == 4) {
                                        primerJugador.setEstrategia(atributo);
                                        primerJugador.insertarNuevoJugador(primerJugador.getNombre(), primerJugador.getEstrategia(), 0);
                                        atributo = "";
                                        nuevaPartida.getPartida()[0] = primerJugador;
                                    }
                                    if (cuentaString == 6) {
                                        segundoJugador.setNombre(atributo);
                                        atributo = "";
                                    }
                                    if (cuentaString == 8) {
                                        segundoJugador.setEstrategia(atributo);
                                        segundoJugador.insertarNuevoJugador(segundoJugador.getNombre(), segundoJugador.getEstrategia(), 0);
                                        atributo = "";
                                        nuevaPartida.getPartida()[1] = segundoJugador;
                                        nuevoTorneo.getTorneo().add(nuevaPartida);
                                        nuevoJuego.getJuego().add(nuevoTorneo);
                                    }

                                } else {
                                    if (Character.isLetterOrDigit(cad.charAt(j))) {
                                        atributo += cad.charAt(j);
                                    }

                                }

                                if (j == cad.length()) {
                                    break;
                                }
                                j++;
                            }
                        } //fin if primer caso [[],[]]
                        else {
                            if (cad.charAt(j) == '[' && (cad.length() == 1)) {
                                contador++;
                            } else {

                                if (cad.charAt(j) == ']' && (contador == 2)) {
                                    nuevoJuego.getJuego().add(nuevoTorneo);
                                    nuevoTorneo = new Torneo();
                                    contador--;
                                    break;
                                }
                                if (cad.charAt(j) == ']' && (contador == 1)) {
                                    // nuevoJuego.getJuego().add(nuevoTorneo);
                                    break;
                                }

                                if (cad.length() > 2) {
                                    while (Character.isLetterOrDigit(cad.charAt(j)) || cad.charAt(j) == '"' || cad.charAt(j) == ','
                                            || cad.charAt(j) == '[' || cad.charAt(j) == ']') {
                                        if (cad.charAt(j) == '"') {
                                            cuentaString++;
                                            if (cuentaString == 2) {
                                                primerJugador.setNombre(atributo);
                                                atributo = "";
                                            }
                                            if (cuentaString == 4) {
                                                primerJugador.setEstrategia(atributo);
                                                primerJugador.insertarNuevoJugador(primerJugador.getNombre(), primerJugador.getEstrategia(), 0);
                                                atributo = "";
                                                nuevaPartida.getPartida()[0] = primerJugador;
                                            }
                                            if (cuentaString == 6) {
                                                segundoJugador.setNombre(atributo);
                                                atributo = "";
                                            }
                                            if (cuentaString == 8) {
                                                segundoJugador.setEstrategia(atributo);
                                                segundoJugador.insertarNuevoJugador(segundoJugador.getNombre(), segundoJugador.getEstrategia(), 0);
                                                atributo = "";
                                                nuevaPartida.getPartida()[1] = segundoJugador;
                                                nuevoTorneo.getTorneo().add(nuevaPartida);
                                            }

                                        } else {
                                            if (Character.isLetterOrDigit(cad.charAt(j))) {
                                                atributo += cad.charAt(j);
                                            }

                                        }

                                        if ((j + 1) == cad.length()) {
                                            break;
                                        }
                                        j++;
                                    } //fin while caracteres
                                } //fin if length > 2

                            }

                        }//fin else[ [ [[],[]], [[],[]] ], [ [[],[]], [[],[]] ] ]
                        j++;
                        indiceCaracteres = j;
                    }// fin while linea

                }//fin while archivo

            } catch (Exception ed) {
            }
        } catch (IOException e) {
        }
        //  this.setJuego(nuevoJuego.getJuego());
        return nuevoJuego;
    }

    public static String MostrarGanador1(Juego jug) {
        return jug.MostrarGanador();
    }

    //mostrar los 10 mejores puntaje
    public String MostrarGanador() {
        // guardarDiezMejores();
        Jugador jug = principal();
        StringBuilder toHtml = new StringBuilder();

        toHtml.append("<h2 id='ganador'>");
        toHtml.append("['");
        toHtml.append(jug.getNombre());
        toHtml.append("', '");
        toHtml.append(jug.getEstrategia());
        toHtml.append("']");
        toHtml.append("<tbody>");

        return toHtml.toString();
    }

 //direccion del archivo a leer
    public void EliminarDireccion() {
        Conexion conexion = Conexion.getInstancia();
        Connection conn = null;
        PreparedStatement preparedStmt = null;
        try {

            conn = conexion.getConnection();

            String query = "DELETE FROM ARCHIVO";
            preparedStmt = conn.prepareStatement(query);

            preparedStmt.execute(query);
            preparedStmt.execute();
            preparedStmt.close();
            conn.close();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }

    public void insertarDireccion(String direccion) {
        EliminarDireccion();
        Conexion conexion = Conexion.getInstancia();
        Connection conn = null;
        PreparedStatement preparedStmt = null;
        try {

            conn = conexion.getConnection();

            String query = "INSERT INTO ARCHIVO(direccion) VALUES(?)";
            preparedStmt = conn.prepareStatement(query);

            preparedStmt.setString(1, direccion);

            preparedStmt.execute();
            preparedStmt.close();
            conn.close();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }

    public String obtenerDireccion() {  //devuelve un array de String con la lista usuarios
        Conexion conexion = Conexion.getInstancia();
        Statement st = null;
        Connection conn = null;
        String direccion1 = "";
        // ArrayList<Jugador> Jugadores = new ArrayList<>();
        try {

            conn = conexion.getConnection();
            st = conexion.getStatement(conn);
            String query = "SELECT * FROM ARCHIVO";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {

                direccion1 = rs.getString("direccion");

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
        return direccion1;
    }
    
//atributos
    private ArrayList<Torneo> juego;
}
