package e2;

public class NodoAvistamiento extends NodoBifurcacion{
    //ATRIBUTO
    private final int distancia;
    //CONSTRUCTOR
    public NodoAvistamiento(String nombre, Nodo rutaIzquierda, Nodo rutaDerecha, int distancia) {
        super(nombre, rutaIzquierda, rutaDerecha);
        this.distancia = distancia;
    }

    //MÉTODO
    @Override
    public void operation(Flota flota) {
        boolean avistamientoExitoso = flota.getLineaDeVision() >= distancia;
        flota.setUltimoNodoVisitado(this.getNombre());
        tomarRuta(flota, avistamientoExitoso);
    }
}
