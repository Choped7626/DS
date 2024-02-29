package e2;

public class NodoFin extends Nodo{
    //CONSTRUCTOR
    public NodoFin(String nombre){super(nombre);}

    //MÉTODO
    @Override
    public void operation(Flota flota){
        flota.setUltimoNodoVisitado(this.getNombre());
    }
}
