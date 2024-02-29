package e3;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

//https://youtrack.jetbrains.com/issue/IDEA-279616?_gl=1*10xetiq*_ga*Mjg2NjUyMzgzLjE2OTY0MzM1OTA.*_ga_9J976DJZ68*MTY5OTkxNzE2MC45LjAuMTY5OTkxNzE2MC42MC4wLjA.&_ga=2.17639866.228430260.1699917161-286652383.1696433590
public class testArtist {

    @Test
    void calculateMedia(){
        List<Integer> puntos = new ArrayList<>();
        Set<String> generos = new HashSet<>();
        Set<String> aliases = new HashSet<>();

        puntos.add(1);
        puntos.add(5);
        puntos.add(3);
        Artist a1 = new Artist("" , "" , puntos , generos , aliases , "" , "");
        assertEquals(3, a1.getPuntuacionMedia());

        puntos.add(3);
        Artist a2 = new Artist("" , "" , puntos , generos , aliases , "" , "");
        assertEquals(3, a2.getPuntuacionMedia());

        puntos.add(2);
        Artist a3 = new Artist("" , "" , puntos , generos , aliases , "" , "");
        assertEquals(2.8, a3.getPuntuacionMedia());

        puntos.add(-2);
        Artist a4 = new Artist("" , "" , puntos , generos , aliases , "" , "");
        assertEquals(2 , a4.getPuntuacionMedia());
    }

    @Test
    void ArtistC(){
        List<Integer> puntos1 = new ArrayList<>();
        Set<String> generos1 = new HashSet<>();
        Set<String> aliases1 = new HashSet<>();

        puntos1.add(1);
        assertEquals(1 , puntos1.get(0));
        puntos1.add(5);
        assertEquals(5 , puntos1.get(1));
        puntos1.add(3);
        assertEquals(3 , puntos1.get(2));

        generos1.add("hip hop");
        assertTrue(generos1.contains("hip hop"));
        generos1.add("pop rap");
        assertTrue(generos1.contains("pop rap"));
        generos1.add("electropop");
        assertTrue(generos1.contains("electropop"));
        generos1.add("pop");
        assertTrue(generos1.contains("pop"));
        generos1.add("gospel");
        assertTrue(generos1.contains("gospel"));
        generos1.add("christian hip hop");
        assertTrue(generos1.contains("christian hip hop"));

        aliases1.add("Ye");
        assertTrue(aliases1.contains("Ye"));
        aliases1.add("K. West");
        assertTrue(aliases1.contains("K. West"));
        aliases1.add("Yeezy");
        assertTrue(aliases1.contains("Yeezy"));

        Artist a1 = new Artist("ye" , "kanye west" , puntos1 , generos1 , aliases1 , "United States" , "");

        List<Integer> puntos2 = new ArrayList<>();
        Set<String> generos2 = new HashSet<>();
        Set<String> aliases2 = new HashSet<>();

        puntos2.add(5);
        assertEquals(5 , puntos2.get(0));
        puntos2.add(5);
        assertEquals(5 , puntos2.get(1));
        puntos2.add(3);
        assertEquals(3 , puntos2.get(2));

        generos2.add("hip hop");
        assertTrue(generos2.contains("hip hop"));
        generos2.add("trap");
        assertTrue(generos2.contains("trap"));

        aliases2.add("Yung Gravy, bbno$ & Rich Brian");
        assertTrue(aliases2.contains("Yung Gravy, bbno$ & Rich Brian"));
        aliases2.add("YUNG BAE with Wiz Khalifa, bbno$ & MAX");
        assertTrue(aliases2.contains("YUNG BAE with Wiz Khalifa, bbno$ & MAX"));
        aliases2.add("Connor Price & bbno$");
        assertTrue(aliases2.contains("Connor Price & bbno$"));

        Artist a2 = new Artist("bbno$" , "bbno$" , puntos2 , generos2 , aliases2 , "Canada" , "");

        List<Integer> puntos3 = new ArrayList<>();
        Set<String> generos3 = new HashSet<>();
        Set<String> aliases3 = new HashSet<>();

        puntos3.add(5);
        assertEquals(5 , puntos3.get(0));
        puntos3.add(5);
        assertEquals(5 , puntos3.get(1));
        puntos3.add(5);
        assertEquals(5 , puntos3.get(2));

        generos3.add("trap");
        assertTrue(generos3.contains("trap"));

        aliases3.add("Bizarrap & Ysy A");
        assertTrue(aliases3.contains("Bizarrap & Ysy A"));
        aliases3.add("Ysy A");
        assertTrue(aliases3.contains("Ysy A"));
        aliases3.add("Duki & Ysy A");
        assertTrue(aliases3.contains("Duki & Ysy A"));

        Artist a3 = new Artist("YSY A" , "YSY A" , puntos3 , generos3 , aliases3 , "Argentina" , "");

        List<Integer> puntos4 = new ArrayList<>();
        Set<String>  generos4 = new HashSet<>();
        Set<String>  aliases4 = new HashSet<>();

        puntos4.add(5);
        assertEquals(5 , puntos4.get(0));
        puntos4.add(5);
        assertEquals(5 , puntos4.get(1));
        puntos4.add(5);
        assertEquals(5 , puntos4.get(2));
        puntos4.add(5);
        assertEquals(5 , puntos4.get(3));
        puntos4.add(2);
        assertEquals(2 , puntos4.get(4));

        generos4.add("pop punk");
        assertTrue(generos4.contains("pop punk"));
        generos4.add("punk rock");
        assertTrue(generos4.contains("punk rock"));
        generos4.add("punk");
        assertTrue(generos4.contains("punk"));
        generos4.add("alternative rock");
        assertTrue(generos4.contains("alternative rock"));
        generos4.add("pop rock");
        assertTrue(generos4.contains("pop rock"));
        generos4.add("rock");
        assertTrue(generos4.contains("rock"));
        generos4.add("skate punk");
        assertTrue(generos4.contains("skate punk"));

        aliases4.add("blink ‐ 182");
        assertTrue(aliases4.contains("blink ‐ 182"));
        aliases4.add("blink182");
        assertTrue(aliases4.contains("blink182"));
        aliases4.add("Blink 182");
        assertTrue(aliases4.contains("Blink 182"));

        Artist a4 = new Artist("blink 182" , "blink-182" , puntos4 , generos4 , aliases4 , "United States" , "");

        List<Integer> puntos5 = new ArrayList<>();
        Set<String>  generos5 = new HashSet<>();
        Set<String>  aliases5 = new HashSet<>();

        puntos5.add(5);
        assertEquals(5 , puntos5.get(0));

        generos5.add("pop punk");
        assertTrue(generos5.contains("pop punk"));
        generos5.add("post-hardcore");
        assertTrue(generos5.contains("post-hardcore"));
        generos5.add("melodic metalcore");
        assertTrue(generos5.contains("melodic metalcore"));

        aliases5.add("From Behind These Walls");
        assertTrue(aliases5.contains("From Behind These Walls"));

        Artist a5 = new Artist("Falling in reverse" , "Falling in reverse" , puntos5 , generos5 , aliases5 , "United States" , "");

        //assertTrue(a1.compareTo(a1) == 0);
        assertTrue(a1.compareTo(a2) > 0);
        assertTrue(a1.compareTo(a3) > 0);
        assertTrue(a1.compareTo(a4) > 0);
        assertTrue(a1.compareTo(a5) > 0);

        assertTrue(a2.compareTo(a1) < 0);
        //assertTrue(a2.compareTo(a2) == 0);
        assertTrue(a2.compareTo(a3) > 0);
        assertTrue(a2.compareTo(a4) < 0);
        assertTrue(a2.compareTo(a5) > 0);

        assertTrue(a3.compareTo(a1) < 0);
        assertTrue(a3.compareTo(a2) < 0);
        //assertTrue(a3.compareTo(a3) == 0);
        assertTrue(a3.compareTo(a4) < 0);
        assertTrue(a3.compareTo(a5) > 0);

        assertTrue(a4.compareTo(a1) < 0);
        assertTrue(a4.compareTo(a2) > 0);
        assertTrue(a4.compareTo(a3) > 0);
        //assertTrue(a4.compareTo(a4) == 0);
        assertTrue(a4.compareTo(a5) > 0);

        assertTrue(a5.compareTo(a1) < 0);
        assertTrue(a5.compareTo(a2) < 0);
        assertTrue(a5.compareTo(a3) < 0);
        assertTrue(a5.compareTo(a4) < 0);
        //assertTrue(a5.compareTo(a5) == 0);
    }

    @Test
    void gettersFunciones(){
        List<Integer> puntos = new ArrayList<>();
        Set<String>  generos = new HashSet<>();
        Set<String>  aliases = new HashSet<>();

        puntos.add(1);
        puntos.add(5);
        puntos.add(3);

        generos.add("hip hop");
        generos.add("pop rap");
        generos.add("electropop");
        generos.add("pop");
        generos.add("gospel");
        generos.add("christian hip hop");

        aliases.add("Ye");
        aliases.add("K. West");
        aliases.add("Yeezy");

        Artist a1 = new Artist("ye" , "kanye west" , puntos , generos , aliases , "United States" , "");

        assertEquals("ye" , a1.getId());
        assertEquals("kanye west" , a1.getName());
        assertEquals(3 , a1.getPuntuacionMedia());
        assertEquals(puntos , a1.getColeccionPuntuaciones());
        assertEquals(3 , a1.getColeccionPuntuaciones().get(2));
        assertEquals(1 , a1.getColeccionPuntuaciones().get(0));
        assertEquals(5 , a1.getColeccionPuntuaciones().get(1));
        assertEquals(generos , a1.getElectricismo());
        assertTrue(a1.getElectricismo().contains("pop"));
        assertTrue(a1.getElectricismo().contains("electropop"));
        assertTrue(a1.getElectricismo().contains("pop rap"));
        assertTrue(a1.getElectricismo().contains("christian hip hop"));
        assertTrue(a1.getElectricismo().contains("gospel"));
        assertEquals(aliases , a1.getAlias());
        assertTrue(a1.getAlias().contains("K. West"));
        assertTrue(a1.getAlias().contains("Ye"));
        assertTrue(a1.getAlias().contains("Yeezy"));
        assertEquals("United States" , a1.getAreas());
        assertTrue(a1.getAreas().contains("United States"));
        assertEquals( "" , a1.getDiferenciadorNombresDuplicados());
        a1.setDiferenciadorNombresDuplicados("Kanye West 1");
        assertEquals( "Kanye West 1" , a1.getDiferenciadorNombresDuplicados());

    }
}