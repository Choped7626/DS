package e4;

import org.junit.jupiter.api.Test;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class MesaTest {

    @Test
    void IniciarPartidaTest(){
        MesaBillar mesa1 = new MesaBillar();
        boolean partidaIniciada = true;
        boolean partidaNoIniciada = false;
        assertEquals(partidaNoIniciada , mesa1.partida);
        assertEquals(partidaIniciada , mesa1.iniciarPartida());
    }

    @Test
    void esPartidaIniciadaTest(){
        MesaBillar mesa1 = new MesaBillar();
        boolean partidaIniciada = true;
        boolean partidaNoIniciada = false;
        assertEquals(partidaNoIniciada , mesa1.esPartidaIniciada());
        mesa1.iniciarPartida();
        assertEquals(partidaIniciada , mesa1.esPartidaIniciada());
    }

    @Test
    void bolasMesaTest(){
        MesaBillar mesa1 = new MesaBillar();
        ArrayList<BolaBillar> bolaEnMesaEsperada = new ArrayList<>();
        assertEquals(bolaEnMesaEsperada , mesa1.bolasMesa());                       //comprobar mesa vacia

        mesa1.iniciarPartida();                                                     //al iniciar partida metemos todas las bolas en mesa
        bolaEnMesaEsperada.add(BolaBillar.BLANCO);
        for (int i = 1; i <= 15; i++) {                                             //metemos todas las bolas en expected
            bolaEnMesaEsperada.add(BolaBillar.valueOf("BOLA" + i));
        }

        assertEquals(bolaEnMesaEsperada, mesa1.bolasMesa());

    }

    @Test
    void bolasCajetinTest(){
        MesaBillar mesa1 = new MesaBillar();

        ArrayList<BolaBillar> bolaEnCajetinEsperada = new ArrayList<>();
        bolaEnCajetinEsperada.add(BolaBillar.BLANCO);

        for (int i = 1; i <= 15; i++) {                                 //metemos todas las bolas en expected
            bolaEnCajetinEsperada.add(BolaBillar.valueOf("BOLA" + i));
        }

        assertEquals(bolaEnCajetinEsperada , mesa1.bolasCajetin());
        bolaEnCajetinEsperada.clear();
        mesa1.iniciarPartida();
        assertEquals(bolaEnCajetinEsperada , mesa1.bolasCajetin());
    }

    @Test
    void meterBolaTest(){
        MesaBillar mesa1 = new MesaBillar();
        ArrayList<BolaBillar> bolaEnCajetinEsperada = new ArrayList<>();
        bolaEnCajetinEsperada.add(BolaBillar.BLANCO);

        for (int i = 1; i <= 15; i++) {                                 //metemos todas las bolas en expected
            bolaEnCajetinEsperada.add(BolaBillar.valueOf("BOLA" + i));
        }
        ArrayList<BolaBillar> bolaEnMesaEsperada = new ArrayList<>();

        assertEquals(bolaEnCajetinEsperada , mesa1.BolasCajetin);
        assertEquals(bolaEnMesaEsperada, mesa1.BolasMesa);

        mesa1.iniciarPartida();
        bolaEnCajetinEsperada.clear();
        bolaEnMesaEsperada.add(BolaBillar.BLANCO);
        for (int i = 1; i <= 15; i++) {                                 //metemos todas las bolas en expected
            bolaEnMesaEsperada.add(BolaBillar.valueOf("BOLA" + i));
        }

        assertEquals(bolaEnCajetinEsperada ,mesa1.BolasCajetin);
        mesa1.meterBola(BolaBillar.BLANCO);
        assertEquals(bolaEnCajetinEsperada ,mesa1.BolasCajetin);
        assertEquals(bolaEnMesaEsperada ,mesa1.BolasMesa);


        for (int i = 1; i <= 15; i++) {
            if(i!=8){
                mesa1.meterBola(BolaBillar.valueOf("BOLA" + i));
                bolaEnCajetinEsperada.add(BolaBillar.valueOf("BOLA" + i));
                bolaEnMesaEsperada.remove(BolaBillar.valueOf("BOLA" + i));
                assertEquals(bolaEnCajetinEsperada ,mesa1.BolasCajetin);
                assertEquals(bolaEnMesaEsperada ,mesa1.BolasMesa);
            }
        }

        assertThrows(IllegalArgumentException.class , ()->mesa1.meterBola(BolaBillar.BOLA5));

        assertEquals(bolaEnCajetinEsperada ,mesa1.BolasCajetin);
        mesa1.meterBola(BolaBillar.BLANCO);
        assertEquals(bolaEnCajetinEsperada ,mesa1.BolasCajetin);
        assertEquals(bolaEnMesaEsperada ,mesa1.BolasMesa);

        mesa1.meterBola(BolaBillar.BOLA8);
        bolaEnCajetinEsperada.add(BolaBillar.BOLA8);
        bolaEnMesaEsperada.remove(BolaBillar.BOLA8);
        bolaEnCajetinEsperada.add(BolaBillar.BLANCO);
        bolaEnMesaEsperada.remove(BolaBillar.BLANCO);
        assertEquals(bolaEnCajetinEsperada ,mesa1.BolasCajetin);
        assertEquals(bolaEnMesaEsperada ,mesa1.BolasMesa);

        assertEquals(bolaEnCajetinEsperada ,mesa1.BolasCajetin);
        mesa1.meterBola(BolaBillar.BLANCO);
        assertEquals(bolaEnCajetinEsperada ,mesa1.BolasCajetin);
        assertEquals(bolaEnMesaEsperada ,mesa1.BolasMesa);
    }

    @Test
    void obtenerGanadorTest(){
        String ganaLisa = "Ganador: Jugador Bolas Lisas\n";
        String ganaRallas = "Ganador : Jugador Bolas Rayadas\n";
        String empate = "Empate\n";
        String vaGanandoLisa = "Va ganando el jugador de las bolas Lisas\n";
        String vaGanandoRallas = "Va ganando el jugador de las bolas Rayadas\n";
        String vanEmpatados = "Estan empatados actualmente\n";

        MesaBillar mesa1 = new MesaBillar();
        mesa1.iniciarPartida();

        assertEquals(vanEmpatados , mesa1.obtenerGanador());

        mesa1.meterBola(BolaBillar.BOLA2);
        assertEquals(vaGanandoLisa , mesa1.obtenerGanador());
        mesa1.meterBola(BolaBillar.BOLA1);
        assertEquals(vaGanandoLisa , mesa1.obtenerGanador());
        mesa1.meterBola(BolaBillar.BOLA3);
        assertEquals(vaGanandoLisa , mesa1.obtenerGanador());
        mesa1.meterBola(BolaBillar.BOLA4);
        assertEquals(vaGanandoLisa , mesa1.obtenerGanador());
        mesa1.meterBola(BolaBillar.BOLA15);
        assertEquals(vaGanandoLisa , mesa1.obtenerGanador());
        mesa1.meterBola(BolaBillar.BOLA14);
        assertEquals(vaGanandoLisa , mesa1.obtenerGanador());
        mesa1.meterBola(BolaBillar.BOLA13);
        assertEquals(vaGanandoLisa , mesa1.obtenerGanador());
        mesa1.meterBola(BolaBillar.BOLA12);
        assertEquals(vanEmpatados , mesa1.obtenerGanador());
        mesa1.meterBola(BolaBillar.BOLA11);
        assertEquals(vaGanandoRallas , mesa1.obtenerGanador());
        mesa1.meterBola(BolaBillar.BOLA10);
        assertEquals(vaGanandoRallas , mesa1.obtenerGanador());
        mesa1.meterBola(BolaBillar.BOLA5);
        assertEquals(vaGanandoRallas , mesa1.obtenerGanador());
        mesa1.meterBola(BolaBillar.BOLA6);
        assertEquals(vanEmpatados , mesa1.obtenerGanador());
        mesa1.meterBola(BolaBillar.BOLA7);
        assertEquals(vaGanandoLisa , mesa1.obtenerGanador());
        mesa1.meterBola(BolaBillar.BOLA9);
        assertEquals(vanEmpatados , mesa1.obtenerGanador());
        mesa1.meterBola(BolaBillar.BOLA8);
        assertEquals(empate , mesa1.obtenerGanador());

        mesa1.iniciarPartida();

        mesa1.meterBola(BolaBillar.BOLA1);
        assertThrows(IllegalArgumentException.class , ()->mesa1.meterBola(BolaBillar.BOLA1));
        mesa1.meterBola(BolaBillar.BOLA2);
        mesa1.meterBola(BolaBillar.BOLA3);
        mesa1.meterBola(BolaBillar.BOLA4);
        mesa1.meterBola(BolaBillar.BOLA5);
        mesa1.meterBola(BolaBillar.BOLA6);
        mesa1.meterBola(BolaBillar.BOLA7);
        mesa1.meterBola(BolaBillar.BOLA8);
        assertEquals(ganaLisa , mesa1.obtenerGanador());

        mesa1.iniciarPartida();

        mesa1.meterBola(BolaBillar.BOLA11);
        mesa1.meterBola(BolaBillar.BOLA12);
        mesa1.meterBola(BolaBillar.BOLA13);
        mesa1.meterBola(BolaBillar.BOLA14);
        mesa1.meterBola(BolaBillar.BOLA15);
        mesa1.meterBola(BolaBillar.BOLA10);
        mesa1.meterBola(BolaBillar.BOLA9);
        mesa1.meterBola(BolaBillar.BOLA8);
        assertEquals(ganaRallas , mesa1.obtenerGanador());

    }
}