package e3;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListaArtistas {

    private final List<Artist> artistas;
    public ListaArtistas(List<Artist> artistas) {
        this.artistas = artistas;
    }
    public List<Artist> getArtistas() {
        return artistas;
    }

    public void addArt(Artist art){
        if(artistas.contains(art)){
            throw new IllegalArgumentException("Artista duplicado , modificar diferenciador");
        }else
            artistas.add(art);
    }

    public void ordenNatural(){//ordena de forma natural solo teniendo en cuenta id siempre y cuando no haya duplicados , si no se ordenan
        Collections.sort(artistas , Comparator.comparing(Artist::getId).thenComparing(Artist::getDiferenciadorNombresDuplicados));
    }
    public void ordenarComparator(Comparator<Artist> comparador){//esto es para usar luego
        Collections.sort(artistas , comparador);
    }
}
