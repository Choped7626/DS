package e3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Set;


public class testListaArtistas {

    @Test
    void ListasDeArtistas(){
        List<Integer> puntos1 = new ArrayList<>();
        Set<String> generos1 = new HashSet<>();
        Set<String> aliases1 = new HashSet<>();

        puntos1.add(1);
        puntos1.add(5);
        puntos1.add(3);

        generos1.add("hip hop");
        generos1.add("pop rap");
        generos1.add("electropop");
        generos1.add("pop");
        generos1.add("gospel");
        generos1.add("christian hip hop");

        aliases1.add("Ye");
        aliases1.add("K. West");
        aliases1.add("Yeezy");

        Artist a1 = new Artist("ye" , "kanye west" , puntos1 , generos1 , aliases1 , "United States" , "A");

        List<Integer> puntos2 = new ArrayList<>();
        Set<String> generos2 = new HashSet<>();
        Set<String> aliases2 = new HashSet<>();

        puntos2.add(5);
        puntos2.add(5);
        puntos2.add(3);

        generos2.add("hip hop");
        generos2.add("trap");

        aliases2.add("Yung Gravy, bbno$ & Rich Brian");
        aliases2.add("YUNG BAE with Wiz Khalifa, bbno$ & MAX");
        aliases2.add("Connor Price & bbno$");

        Artist a2 = new Artist("bbno$" , "bbno$" , puntos2 , generos2 , aliases2 , "Canada" , "");

        List<Integer> puntos3 = new ArrayList<>();
        Set<String> generos3 = new HashSet<>();
        Set<String> aliases3 = new HashSet<>();

        puntos3.add(5);
        puntos3.add(5);
        puntos3.add(5);

        generos3.add("trap");

        aliases3.add("Bizarrap & Ysy A");
        aliases3.add("Ysy A");
        aliases3.add("Duki & Ysy A");

        Artist a3 = new Artist("YSY A" , "YSY A" , puntos3 , generos3 , aliases3 , "Argentina" , "");

        List<Integer> puntos4 = new ArrayList<>();
        Set<String> generos4 = new HashSet<>();
        Set<String> aliases4 = new HashSet<>();

        puntos4.add(5);
        puntos4.add(5);
        puntos4.add(5);
        puntos4.add(5);
        puntos4.add(2);

        generos4.add("pop punk");
        generos4.add("punk rock");
        generos4.add("punk");
        generos4.add("alternative rock");
        generos4.add("pop rock");
        generos4.add("rock");
        generos4.add("skate punk");

        aliases4.add("blink ‐ 182");
        aliases4.add("blink182");
        aliases4.add("Blink 182");

        Artist a4 = new Artist("blink 182" , "blink-182" , puntos4 , generos4 , aliases4 , "United States" , "B");

        List<Integer> puntos5 = new ArrayList<>();
        Set<String> generos5 = new HashSet<>();
        Set<String> aliases5 = new HashSet<>();

        puntos5.add(5);

        generos5.add("pop punk");
        generos5.add("post-hardcore");
        generos5.add("melodic metalcore");

        aliases5.add("From Behind These Walls");

        Artist a5 = new Artist("Falling in reverse" , "Falling in reverse" , puntos5 , generos5 , aliases5 , "United States" , "C");

        Artist a6 = new Artist("Falling in reverse" , "" , new ArrayList<>() , new HashSet<>() , new HashSet<>() , "" , "A");

        ListaArtistas artistaslist = new ListaArtistas(new ArrayList<>());

        artistaslist.addArt(a1);
        assertEquals(a1 , artistaslist.getArtistas().get(0));
        artistaslist.addArt(a2);
        assertEquals(a2 , artistaslist.getArtistas().get(1));
        artistaslist.addArt(a3);
        assertEquals(a3 , artistaslist.getArtistas().get(2));
        artistaslist.addArt(a4);
        assertEquals(a4 , artistaslist.getArtistas().get(3));
        artistaslist.addArt(a5);
        assertEquals(a5 , artistaslist.getArtistas().get(4));
        artistaslist.addArt(a6);
        assertEquals(a6 , artistaslist.getArtistas().get(5));

        artistaslist.ordenNatural();
        assertTrue(0 >= artistaslist.getArtistas().get(0).getId().compareTo(artistaslist.getArtistas().get(1).getId()));
        assertTrue(0 >= artistaslist.getArtistas().get(1).getId().compareTo(artistaslist.getArtistas().get(2).getId()));
        assertTrue(0 >= artistaslist.getArtistas().get(2).getId().compareTo(artistaslist.getArtistas().get(3).getId()));
        assertTrue(0 >= artistaslist.getArtistas().get(3).getId().compareTo(artistaslist.getArtistas().get(4).getId()));
        assertTrue(0 <= artistaslist.getArtistas().get(4).getId().compareTo(artistaslist.getArtistas().get(0).getId()));

        artistaslist.getArtistas().remove(a6);
        assertEquals(5 , artistaslist.getArtistas().size());

        artistaslist.ordenarComparator(comparadoresArtistas.ordenacionElectricismo());
        assertTrue(artistaslist.getArtistas().get(0).getElectricismo().size() >= artistaslist.getArtistas().get(1).getElectricismo().size());
        assertTrue(artistaslist.getArtistas().get(1).getElectricismo().size() >= artistaslist.getArtistas().get(2).getElectricismo().size());
        assertTrue(artistaslist.getArtistas().get(2).getElectricismo().size() >= artistaslist.getArtistas().get(3).getElectricismo().size());
        assertTrue(artistaslist.getArtistas().get(3).getElectricismo().size() >= artistaslist.getArtistas().get(4).getElectricismo().size());
        assertTrue(artistaslist.getArtistas().get(4).getElectricismo().size() <= artistaslist.getArtistas().get(0).getElectricismo().size());

        artistaslist.ordenarComparator(comparadoresArtistas.ordenacionPuntuaciones());
        assertTrue(artistaslist.getArtistas().get(0).getPuntuacionMedia() <= artistaslist.getArtistas().get(1).getPuntuacionMedia());
        assertTrue(artistaslist.getArtistas().get(1).getPuntuacionMedia() <= artistaslist.getArtistas().get(2).getPuntuacionMedia());
        assertTrue(artistaslist.getArtistas().get(2).getPuntuacionMedia() <= artistaslist.getArtistas().get(3).getPuntuacionMedia());
        assertTrue(artistaslist.getArtistas().get(3).getPuntuacionMedia() <= artistaslist.getArtistas().get(4).getPuntuacionMedia());
        assertTrue(artistaslist.getArtistas().get(4).getPuntuacionMedia() >= artistaslist.getArtistas().get(0).getPuntuacionMedia());

        artistaslist.ordenarComparator(comparadoresArtistas.ordenacionAreas());
        assertTrue(0 >=  artistaslist.getArtistas().get(0).getAreas().compareTo(artistaslist.getArtistas().get(1).getAreas()));
        assertTrue(0 >= artistaslist.getArtistas().get(1).getAreas().compareTo(artistaslist.getArtistas().get(2).getAreas()));
        assertTrue(0 >= artistaslist.getArtistas().get(2).getAreas().compareTo(artistaslist.getArtistas().get(3).getAreas()));
        assertTrue(0 >= artistaslist.getArtistas().get(3).getAreas().compareTo(artistaslist.getArtistas().get(4).getAreas()));
        assertTrue(0 <= artistaslist.getArtistas().get(4).getAreas().compareTo(artistaslist.getArtistas().get(0).getAreas()));

        artistaslist.ordenarComparator(comparadoresArtistas.ordenacionAlias());
        assertTrue(artistaslist.getArtistas().get(0).getAlias().size() >= artistaslist.getArtistas().get(1).getAlias().size());
        assertTrue(artistaslist.getArtistas().get(1).getAlias().size() >= artistaslist.getArtistas().get(2).getAlias().size());
        assertTrue(artistaslist.getArtistas().get(2).getAlias().size() >= artistaslist.getArtistas().get(3).getAlias().size());
        assertTrue(artistaslist.getArtistas().get(3).getAlias().size() >= artistaslist.getArtistas().get(4).getAlias().size());
        assertTrue(artistaslist.getArtistas().get(4).getAlias().size() <= artistaslist.getArtistas().get(0).getAlias().size());

    }

}