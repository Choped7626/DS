package e2;


import java.util.List;

public class Juego {

    public int simularAtaque(Personaje atacante, Personaje defensor) {
        List<ObjetosAtaque>objetosAtaques = atacante.getObjetosAtaques();
        if (objetosAtaques.isEmpty())
            throw new IllegalArgumentException("El atacante no tiene objetos de ataque");
        else {
            ObjetosAtaque objetoActual = objetosAtaques.get(0);
            if (objetoActual.getUsosRestantes() > 0) {
                if (atacante.getMana() < objetoActual.getMinMana()) {
                    throw new IllegalArgumentException("El atacante " + atacante.getName() + " no tiene suficiente maná para usar este objeto de ataque");

                }
                int danoTotal = objetoActual.getDano() - defensor.ProteccionTotal();
                if (danoTotal < 0)
                    danoTotal = 0;

                return danoTotal;
            }
            else
                return 0;
        }
    }

    public Personaje simularCombate(Personaje jugador1, Personaje jugador2, int maxTurnos) {
        int turnos = 1;

        System.out.println("Jugador1: " +jugador1.getName()+", vida: "+jugador1.getSalud()+", proteccion: " +jugador1.ProteccionTotal()
        +"\nLista objetos de ataque: "+jugador1.getObjetosAtaques()+"\nLista objetos de defensa: "+jugador1.getObjetosDefensas()+"\n");
        System.out.println("Jugador2: " +jugador2.getName()+", vida: "+jugador2.getSalud()+", proteccion: " +jugador2.ProteccionTotal()
                +"\nLista objetos de ataque: "+jugador2.getObjetosAtaques()+"\nLista objetos de defensa: "+jugador2.getObjetosDefensas()+"\n");

        while (turnos <= maxTurnos) {

            if (turnos > 1) {
                System.out.println("Jugador 1: " +jugador1.getName()+", vida: "+jugador1.getSalud()+", proteccion: " +jugador1.ProteccionTotal());
                System.out.println("Jugador 2: " +jugador2.getName()+", vida: "+jugador2.getSalud()+", proteccion: "+jugador2.ProteccionTotal()+"\n");
            }

            int danoAJugador2 = simularAtaque(jugador1, jugador2);
            jugador1.getObjetosAtaques().get(0).decrementarUso();
            if (jugador1.getObjetosAtaques().get(0).getUsosRestantes() == 0)
                jugador1.getObjetosAtaques().remove(0);
            jugador2.quitarSalud(danoAJugador2);


            if (jugador2.getSalud() <= 0) {
                System.out.println(jugador2.getName() + " ha sido derrotado");
                return jugador1;
            }

            System.out.println("Jugador 1: " +jugador1.getName()+", vida: "+jugador1.getSalud()+", proteccion: " +jugador1.ProteccionTotal());
            System.out.println("Jugador 2: " +jugador2.getName()+", vida: "+jugador2.getSalud()+", proteccion: "+jugador2.ProteccionTotal()+"\n");

            int danoAJugador1 = simularAtaque(jugador2, jugador1);
            jugador2.getObjetosAtaques().get(0).decrementarUso();
            if (jugador2.getObjetosAtaques().get(0).getUsosRestantes() == 0)
                jugador2.getObjetosAtaques().remove(0);
            jugador1.quitarSalud(danoAJugador1);

            if (jugador1.getSalud() <= 0) {
                System.out.println(jugador1.getName() + " ha sido derrotado");
                return jugador2;
            }
            turnos++;
        }
        System.out.println("El combate terminó en empate después de " + maxTurnos + " turnos");
        return null;
    }




}

