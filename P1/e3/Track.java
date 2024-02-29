package e3;

import java.util.Objects;

//CREAMOS EL REGISTRO TRACK

public record Track(String posicion, String recording, String artista, String cancionN, int duracion){

    //METODO toString
    public String toString() {
        if(posicion == null || posicion.isEmpty() || recording == null || recording.isEmpty() || artista == null || artista.isEmpty() || cancionN == null || cancionN.isEmpty() || duracion <= 0){
            throw new IllegalArgumentException("Alguno de los valores no es válido");
        }
        return ("Posicion: " + posicion + "\nID Grabación: " + recording + "\nArtista: " + artista + "\nTítulo: " + cancionN + "\nDuracion: " + duracion + "\n");
    }

    //GETTERS
    public String whatPosition(){
        if(posicion == null || posicion.isEmpty())
            throw new IllegalArgumentException("La posicion no es valida");
        else
            return posicion;
    }

    public String whatId() {
        if(recording == null || recording.isEmpty())
            throw new IllegalArgumentException("La grabacion no es valida");
        else
            return recording;
    }

    public String whatArtista() {

        if(artista == null || artista.isEmpty())
            throw new IllegalArgumentException("El artista no es valido");
        else
            return artista;
    }

    public String whatSong() {
        if(cancionN == null || cancionN.isEmpty())
            throw new IllegalArgumentException("La cancion no es valida");
        else
            return cancionN;
    }

    public int whatDuration() {
        if(duracion <= 0)
            throw new IllegalArgumentException("La duracion no es valida");
        else
            return duracion;
    }

    //MODIFICAMOS EL EQUALS
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Track track = (Track) o;
        return Objects.equals(recording, track.recording);
    }

    //MODIFICAMOS EL HASHCODE

    @Override
    public int hashCode() {
        return Objects.hash(recording);
    }
}
