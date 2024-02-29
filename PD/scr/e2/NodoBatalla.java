package e2;

public class NodoBatalla extends NodoBifurcacion{
    //ATRIBUTOS
    private int hpEnemigo;
    private final int blindajeEnemigo;
    private final int poderFuegoEnemigo;

    //CONSTRUCTOR
    public NodoBatalla(String nombre, Nodo rutaIzquierda, Nodo rutaDerecha, int hpEnemigo, int blindajeEnemigo, int poderFuegoEnemigo) {
        super(nombre, rutaIzquierda, rutaDerecha);
        this.hpEnemigo = hpEnemigo;
        this.blindajeEnemigo = blindajeEnemigo;
        this.poderFuegoEnemigo = poderFuegoEnemigo;
    }

    //MÉTODO
    @Override
    public void operation(Flota flota) {
        int danoAEnemigo = Math.max(0, flota.getPoderDeFuego() - blindajeEnemigo);
        hpEnemigo -= danoAEnemigo;

        int danoAFlota = Math.max(0, poderFuegoEnemigo - flota.getBlindaje());
        flota.perderHp(danoAFlota);

        flota.setUltimoNodoVisitado(this.getNombre());
        tomarRuta(flota, hpEnemigo <= 0);
    }

}
