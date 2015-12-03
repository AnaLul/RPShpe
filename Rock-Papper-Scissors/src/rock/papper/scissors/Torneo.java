/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rock.papper.scissors;

import Modelo.Partida;
import java.util.ArrayList;

/**
 *
 * @author Lucia
 */
public class Torneo {

    public Torneo(ArrayList<Partida> torneo) {
        this.torneo = torneo;
    }

    public Torneo() {
        this.torneo = new ArrayList<Partida>();
    }

    public ArrayList<Partida> getTorneo() {
        return torneo;
    }

    private ArrayList<Partida> torneo;
}
