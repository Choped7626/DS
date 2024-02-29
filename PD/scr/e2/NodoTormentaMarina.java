package e2;

public class NodoTormentaMarina extends NodoRutaFija{
    //ATRIBUTO
    private final int fuerzaTormenta;

    //CONSTRUCTOR
    public NodoTormentaMarina(String nombre, Nodo hijo, int fuerzaTormenta) {
        super(nombre, hijo);
        this.fuerzaTormenta = fuerzaTormenta;
    }

    //MÉTODO
    @Override
    public void operation(Flota flota) {
        if (flota.getLineaDeVision() < fuerzaTormenta) {
            flota.perderHp(10);
        }
        flota.setUltimoNodoVisitado(this.getNombre());
        if (!flota.isFlotaActiva()) return;
        tomarRuta(flota, true);
    }

}
