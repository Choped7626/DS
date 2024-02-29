package e4;

import java.util.ArrayList;
import java.util.List;

public class MesaBillar {

    public boolean partida;  //Iniciar una partida
    public List<BolaBillar> BolasMesa;  //Bolas que hay en la mesa
    public List<BolaBillar> BolasCajetin; //Bolas que entran en los huecos de la mesa
    public int totalBolas = 15;

    //CONSTRUCTOR

    public MesaBillar() {
        partida = false;
        BolasMesa = new ArrayList<>();
        BolasCajetin = new ArrayList<>();
        //Ponemos todas las bolas en el cajetin
        BolasCajetin.add(BolaBillar.BLANCO);
        for (int i = 1; i <= totalBolas; i++) {
            BolasCajetin.add(BolaBillar.valueOf("BOLA" + i));
        }
    }

    //METODOS
    public boolean iniciarPartida() {
        partida = true;  //La partida comienza
        BolasMesa.clear();
        BolasMesa.add(BolaBillar.BLANCO);  //Metemos la bola blanca (hace falta para jugar)
        for (int i = 1; i <= totalBolas; i++) {
            BolasMesa.add(BolaBillar.valueOf("BOLA" + i));  //Metemos las bolas en la mesa
        }
        BolasCajetin.clear();  //Vaciamos el cajetín pues todas las bolas están en la mesa
        return partida;
    }

    public boolean esPartidaIniciada() {
        return partida;
    }

    public List<BolaBillar> bolasMesa() {
        return BolasMesa;
    }

    public List<BolaBillar> bolasCajetin() {
        return BolasCajetin;
    }

    public void meterBola(BolaBillar bola) {
        if (!partida){
            System.out.println("No se ha iniciado la partida , ninguna bola en mesa\n");
        }
        else {

            if (bola.numero >= 1 && bola.numero <= 15 && bola.numero != 8 && !BolasCajetin.contains(bola)) {
                BolasCajetin.add(bola);
                BolasMesa.remove(bola);  //Si metes una bola en el cajetín, la sacas de la mesa
                System.out.println("Se ha añadido la bola numero " + bola.numero + " de color " + bola.color + " y tipo " + bola.tipo + " en el cajetín.\n");
            }
            else if (bola == BolaBillar.BLANCO) {

                if (!BolasMesa.isEmpty()) {
                    System.out.println("Devolvemos la bola blanca a la mesa\n");
                }

            }
            else if (bola == BolaBillar.BOLA8) {
                BolasMesa.remove(bola);
                BolasCajetin.add(bola);
                BolasMesa.remove(BolaBillar.BLANCO);
                BolasCajetin.add(BolaBillar.BLANCO);
                partida = false;
                System.out.println("Final de la partida\n");

            }
            else
                throw new IllegalArgumentException("La bola indicada no es váida\n");
        }
    }

    public String obtenerGanador() {

        int jugadorLisas = 0;
        int jugadorRayadas = 0;

        for (BolaBillar bola : BolasMesa) {
            if(bola.numero >= 1 && bola.numero <= 7)
                jugadorLisas++;
            else if(bola.numero >= 9 && bola.numero <= 15)
                jugadorRayadas++;
        }

        if(!partida) {
            if (jugadorLisas < jugadorRayadas)
                return "Ganador: Jugador Bolas Lisas\n";
            else if(jugadorRayadas < jugadorLisas)
                return "Ganador : Jugador Bolas Rayadas\n";
            else
                return "Empate\n";

        }
        else {

            if (jugadorLisas < jugadorRayadas)
                return "Va ganando el jugador de las bolas Lisas\n";
            else if(jugadorRayadas < jugadorLisas)
                return "Va ganando el jugador de las bolas Rayadas\n";
            else
                return "Estan empatados actualmente\n";
        }
    }

}