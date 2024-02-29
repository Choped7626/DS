package e2;

public class NodoAtaqueAereo extends NodoRutaFija{
    //ATRIBUTO
    private final int poderAereoEnemigo;

    //CONSTRUCTOR
    public NodoAtaqueAereo(String nombre, Nodo hijo, int poderAereoEnemigo) {
        super(nombre, hijo);
        this.poderAereoEnemigo = poderAereoEnemigo;
    }

    //MÉTODO
    @Override
    public void operation(Flota flota) {
        int dano = Math.max(0, poderAereoEnemigo - (2 * flota.getAntiaereos() + flota.getBlindaje()));
        flota.perderHp(dano);
        flota.setUltimoNodoVisitado(this.getNombre());
        if (!flota.isFlotaActiva()) return;

        tomarRuta(flota,true);
    }

}
