package e3;

import java.util.*;

public class Release {  //CLASE LANZAMIENTOS

    //AÑADIMOS LOS ATRIBUTOS
    private final String identificador;

    private  String titulo;

    private String artista;

    private final List<Track> trackList;

    //CONSTRUCTOR
    public Release(String id) {
        if (id == null || id.isEmpty())
            throw new IllegalArgumentException("Identificador no válido\n");
        this.identificador = id;
        this.trackList = new ArrayList<>();
    }

    //MÉTODOS

    //SETTERS
    public void setArtist(String artist) {

        if (artist == null || artist.isEmpty())  //Comprobamos si el valor es válido o no
            throw new IllegalArgumentException("Valor no válido\n");
        else
            this.artista = artist;
    }

    public void setTitle(String title) {

        if (title == null || title.isEmpty())  //Comprobamos si el valor es válido o no
            throw new IllegalArgumentException("Valor no válido\n");
        else
            this.titulo = title;
        
    }

    public void addTrack(Track track){
        if (track == null) //Comprobamos si el valor es válido o no
            throw new IllegalArgumentException("Valor no permitido\n");
        else
            trackList.add(track);
    }

    //GETTERS
    public String whatArtist() {
        return artista;
    }
    public String whatTitle() {
        return titulo;
    }
    public List<Track> whatTrack(){
        return trackList;
    }

    //METODO toString
    public String toString(){
        StringBuilder info = new StringBuilder();
        info.append("ID Lanzamiento: ").append(identificador).append("\n");
        info.append("Título: ").append(titulo).append("\n");
        info.append("Artista principal: ").append(artista).append("\n");
        info.append("Tracklist:\n");
        for (Track track: trackList)
            info.append(track.toString()).append("\n");

        return info.toString();
    }


    //MODIFICAMOS EL EQUALS PARA QUE CUMPLA LOS REQUISITOS DEL ENUNCIADO

    public Set<String> pistasIguales() {  //Empleamos Set en vez de ArrayList porque podemos almacenar datos sin que se dupliquen y, porque además, el orden no importa
        Set<String> idGrab = new HashSet<>();  //Creamos un conjunto para guardar los idGrabaciones
        for(Track track : trackList) {  //Recorremos las pistas del lanzamiento determinado
            idGrab.add(track.whatId());  //Cogemos su recording
        }
        return idGrab;  //Devolvemos el conjunto con los idGrabaciones unicos de un lanzamiento
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Release aux = (Release) o;
        return Objects.equals(pistasIguales(), aux.pistasIguales());
    }

    //MODIFICAMOS EL HASHCODE

    @Override
    public int hashCode() {
        return Objects.hash(pistasIguales());
    }
}
