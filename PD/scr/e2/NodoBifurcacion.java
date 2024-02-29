package e2;

public abstract class NodoBifurcacion extends Nodo{
    //CONSTRUCTOR
    public NodoBifurcacion(String nombre, Nodo rutaIzquierda, Nodo rutaDerecha) {
        super(nombre);
        anadirHijo(rutaIzquierda);
        anadirHijo(rutaDerecha);
    }
    //MÉTODO
    @Override
    public abstract void operation(Flota flota);
}
