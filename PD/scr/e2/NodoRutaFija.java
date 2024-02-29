package e2;

public abstract class NodoRutaFija extends Nodo{

    //CONSTRUCTOR
    public NodoRutaFija(String nombre, Nodo hijo) {
        super(nombre);
        anadirHijo(hijo);
    }

    //MÉTODO
    @Override
    public abstract void operation(Flota flota);
}
