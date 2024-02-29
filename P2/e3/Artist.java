package e3;

import java.util.List;
import java.util.Set;

public final class Artist implements Comparable<Artist> {
    private final String id;
    private final String Name;
    private final List<Integer> coleccionPuntuaciones;
    private double puntuacionMedia;
    private final Set<String> Electricismo;
    private final Set<String> Alias;
    private final String areas;
    private String diferenciadorNombresDuplicados;

    private double calculateMedia(){
        double puntuacionmedia = 0;
        for (int i = 0 ; getColeccionPuntuaciones().size() > i ; i++){
            puntuacionmedia += coleccionPuntuaciones.get(i);
        }
        if(getColeccionPuntuaciones().isEmpty())
            return 0;
        else
            return puntuacionMedia = puntuacionmedia / coleccionPuntuaciones.size();
    }

    public Artist(String id , String name , List<Integer> puntos , Set<String> generos , Set<String> aliases , String paises , String diferenciador){
        this.id = id;
        Name = name;
        coleccionPuntuaciones = puntos;
        puntuacionMedia = calculateMedia();
        Electricismo = generos;
        Alias = aliases;
        areas = paises;
        diferenciadorNombresDuplicados = diferenciador;
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return Name;
    }
    public List<Integer> getColeccionPuntuaciones() {
        return coleccionPuntuaciones;
    }
    public double getPuntuacionMedia() {
        return puntuacionMedia;
    }
    public Set<String> getElectricismo() {
        return Electricismo;
    }
    public Set<String> getAlias() {
        return Alias;
    }
    public String getAreas() {
        return areas;
    }
    public String getDiferenciadorNombresDuplicados() {
        return diferenciadorNombresDuplicados;
    }
    public void setDiferenciadorNombresDuplicados(String diferenciadorNombresDuplicados) {
        this.diferenciadorNombresDuplicados = diferenciadorNombresDuplicados;
    }
    @Override
    public int compareTo(Artist art){
        return this.id.compareTo(art.id);
    }
}


