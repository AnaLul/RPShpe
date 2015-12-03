/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import rock.papper.scissors.Torneo;

/**
 *
 * @author Lucia
 */
public class Partida {

    //constructor
    public Partida() {
        this.partida = new Jugador[2];
    }

    public Jugador[] getPartida() {
        return this.partida;
    }

    //metodo de que valida que la partida pueda iniciar partida
    public boolean validarInicio(Partida part) {
        if (part.getPartida()[1] != null) { //validar la cantidad de jugadores sea igual a 2
            //Expresion Regular para validar la estrategia del jugador
            for (int i = 0; i < 2; i++) {
                String caractEstrategia = "^[pPrRsS]$";
                Pattern pattern = Pattern.compile(caractEstrategia);
                Matcher m = pattern.matcher(part.getPartida()[i].getEstrategia());
                if (!m.matches()) {
                    System.err.print("La estrategía de " + part.getPartida()[i].getNombre() + " es incorrecta");
                }
            }
            //Validar si la estrategia de ambos jugadores es igual
            if (part.getPartida()[0].getEstrategia().equals(part.getPartida()[1].getEstrategia())) {
                ganador(part.getPartida()[0]);
                return true;
            }

        } else {
            System.err.print("Solo puede ser partidas de DOS jugadores");
            return false;
        }
        return true;
    }


    public Jugador logica(Partida partida) {

        boolean bandera = true;

        if (!validarInicio(partida)) {

            bandera = false;

        }
        Jugador nuevoJugador = partida.getPartida()[0];
        //segundo definir ganador
        if (bandera) {
            // Partida nuevaPartida = new Partida();
            for (int i = 0; i <= partida.getPartida().length; i++) {

                switch (i) { //determina quien gana la partida en todas las posibles soluciones
                    
                    case 0:
                        if (((partida.getPartida()[0].getEstrategia()).toUpperCase()).equals("R")) {
                            if (((partida.getPartida()[1].getEstrategia()).toUpperCase()).equals("P")) {
                                nuevoJugador = partida.getPartida()[1];
                            } else {
                                nuevoJugador = partida.getPartida()[0];
                            }
                        }
                        break;
                    case 1:
                        if (((partida.getPartida()[0].getEstrategia()).toUpperCase()).equals("S")) {
                            if (((partida.getPartida()[1].getEstrategia()).toUpperCase()).equals("R")) {
                                nuevoJugador = partida.getPartida()[1];
                            } else {
                                nuevoJugador = partida.getPartida()[0];
                            }
                        }
                        break;
                        
                    case 2:
                        if (((partida.getPartida()[0].getEstrategia()).toUpperCase()).equals("P")) {
                            if (((partida.getPartida()[1].getEstrategia()).toUpperCase()).equals("R")) {
                                nuevoJugador = partida.getPartida()[0];
                            } else {
                                nuevoJugador = partida.getPartida()[1];
                                partida.getPartida()[1] = null;
                            }
                        }
                        break;

                }

            }
        }
        return nuevoJugador;
    }

    public void ganador(Jugador ganador) {
    }

    //Atributos
    private Jugador[] partida;

}
