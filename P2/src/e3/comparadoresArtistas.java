package e3;

import java.util.Comparator;

public class comparadoresArtistas {


    public static Comparator<Artist> ordenacionPuntuaciones(){//de menos a mas
        return Comparator.comparingDouble(Artist::getPuntuacionMedia);
    }

    public static Comparator<Artist> ordenacionAreas(){//lexicograficamente y con diferenciador
        return Comparator.comparing(Artist::getAreas).thenComparing(Artist::getDiferenciadorNombresDuplicados);
    }

    public static Comparator<Artist> ordenacionAlias(){//de menor numero de alias a mayor
        Comparator<Artist> aux = Comparator.comparing(artist -> artist.getAlias().size());
        return aux.reversed();
    }

    public static Comparator<Artist> ordenacionElectricismo(){//de mayor a menor numero de generos
        Comparator<Artist> aux = Comparator.comparingInt(artist -> artist.getElectricismo().size());
        return aux.reversed();
    }

}
