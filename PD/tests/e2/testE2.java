package e2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testE2 {

    @Test
    void flotaTest() {
        Flota flotaA = new Flota(11,42,47,0,0);
        Flota flotaB = new Flota(1,25,0,46,28);

        assertEquals(11, flotaA.getHp());
        assertEquals(42, flotaA.getBlindaje());
        assertEquals(47, flotaA.getPoderDeFuego());
        assertEquals(0, flotaA.getAntiaereos());
        assertEquals(0, flotaA.getLineaDeVision());

        assertEquals(1, flotaB.getHp());
        assertEquals(25, flotaB.getBlindaje());
        assertEquals(0, flotaB.getPoderDeFuego());
        assertEquals(46, flotaB.getAntiaereos());
        assertEquals(28, flotaB.getLineaDeVision());

        flotaA.perderHp(5);
        flotaB.perderHp(2);
        assertEquals(6, flotaA.getHp());
        assertEquals(-1, flotaB.getHp());
        assertTrue(flotaA.isFlotaActiva());
        assertFalse(flotaB.isFlotaActiva());

    }

    @Test
    void nodosTest() {
        Nodo nodoD = new NodoFin("D");
        Nodo nodoI = new NodoFin("I");
        Nodo nodoK = new NodoFin("K");
        Nodo nodoH = new NodoFin("H");
        Nodo nodoG = new NodoTormentaMarina("G",nodoI, 67);
        Nodo nodoE = new NodoAtaqueAereo("E",nodoK, 151);
        Nodo nodoB = new NodoBatalla("B",nodoD, nodoE, 20, 30, 25);
        Nodo nodoF = new NodoBatalla("F",nodoH, nodoG, 30, 17, 41);
        Nodo nodoC = new NodoTormentaMarina("C",nodoF, 20);
        Nodo nodoA = new NodoAvistamiento("A",nodoB, nodoC, 28);


        assertEquals("A", nodoA.getNombre());

    }

    @Test
    void simulacionIncursion() {

        //Creación de flotas
        Flota flotaA = new Flota(11,42,47,0,0);
        Flota flotaB = new Flota(1,25,0,46,28);

        //Creacion de nodo
        Nodo nodoD = new NodoFin("D");
        Nodo nodoI = new NodoFin("I");
        Nodo nodoK = new NodoFin("K");
        Nodo nodoH = new NodoFin("H");
        Nodo nodoG = new NodoTormentaMarina("G",nodoI, 67);
        Nodo nodoE = new NodoAtaqueAereo("E",nodoK, 151);
        Nodo nodoB = new NodoBatalla("B",nodoD, nodoE, 20, 30, 25);
        Nodo nodoF = new NodoBatalla("F",nodoH, nodoG, 30, 17, 41);
        Nodo nodoC = new NodoTormentaMarina("C",nodoF, 20);
        Nodo nodoA = new NodoAvistamiento("A",nodoB, nodoC, 28);


        SimularIncursion simulacion = new SimularIncursion();

        //Tamaño ruta minima
        assertEquals(3, SimularIncursion.RutaMinima(nodoA));
        assertEquals(-1, SimularIncursion.RutaMinima(null));
        assertEquals(2, SimularIncursion.RutaMinima(nodoB));

        //Newick para nodo A
        String newickA = SimularIncursion.Newick(nodoA);
        String resultadoEsperadoNodoA = "(A NodoAvistamiento, (B NodoBatalla, (D NodoFin), (E NodoAtaqueAereo, (K NodoFin))), (C NodoTormentaMarina, (F NodoBatalla, (H NodoFin), (G NodoTormentaMarina, (I NodoFin)))))";
        assertEquals(resultadoEsperadoNodoA, newickA);

        //Newick para nodo B
        String newickB = SimularIncursion.Newick(nodoB);
        String resultadoEsperadoNodoB = "(B NodoBatalla, (D NodoFin), (E NodoAtaqueAereo, (K NodoFin)))";
        assertEquals(resultadoEsperadoNodoB, newickB);

        //Newick para nodo E
        String newickE = SimularIncursion.Newick(nodoE);
        String resultadoEsperadoNodoE = "(E NodoAtaqueAereo, (K NodoFin))";
        assertEquals(resultadoEsperadoNodoE, newickE);


        //Simular partiendo de la flota A
        simulacion.simularIncursion(flotaA,nodoA);
        assertEquals("H", flotaA.getUltimoNodoVisitado());
        assertEquals(1, flotaA.getHp());
        assertTrue(flotaA.isFlotaActiva());

        //Simular partiendo de la flota B
        simulacion.simularIncursion(flotaB, nodoA);
        assertEquals("E", flotaB.getUltimoNodoVisitado());
        assertEquals(-33, flotaB.getHp());
        assertFalse(flotaB.isFlotaActiva());


        //Comprobación de si tenemos un único nodo y que no sea fin
        Nodo nodoExcepcion = new NodoAtaqueAereo("Excepcion",null, 4);
        Flota excepcion = new Flota(50,50,40,55,33);
        simulacion.simularIncursion(excepcion, nodoExcepcion);
        assertEquals("Excepcion", excepcion.getUltimoNodoVisitado());


    }

    @Test
    void diagramaSecuencia() {
        //Creación de flota
        Flota flotaA = new Flota(9,42,30,0,70);

        //Creacion de nodo
        Nodo nodoI = new NodoFin("I");
        Nodo nodoH = new NodoFin("H");
        Nodo nodoG = new NodoTormentaMarina("G",nodoI, 67);
        Nodo nodoF = new NodoBatalla("F",nodoH, nodoG, 35, 17, 41);

        SimularIncursion simulacion = new SimularIncursion();

        simulacion.simularIncursion(flotaA, nodoF);

        assertEquals(9, flotaA.getHp());
        assertEquals("(F NodoBatalla, (H NodoFin), (G NodoTormentaMarina, (I NodoFin)))", SimularIncursion.Newick(nodoF));


    }

}
