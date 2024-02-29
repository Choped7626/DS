package e2;

public class Flota {
    //ATRIBUTOS
    private int hp;
    private final int blindaje;
    private final int poderDeFuego;
    private final int antiaereos;
    private final int lineaDeVision;
    private String ultimoNodoVisitado;

    //CONSTRUCTOR
    public Flota(int hp, int blindaje, int poderDeFuego, int antiaereos, int lineaDeVision) {
        this.hp = hp;
        this.blindaje = blindaje;
        this.poderDeFuego = poderDeFuego;
        this.antiaereos = antiaereos;
        this.lineaDeVision = lineaDeVision;
    }

    //MÉTODOS

    public int getHp() {return hp;}
    public void perderHp(int dano){this.hp -= dano;}
    public boolean isFlotaActiva(){return hp > 0;}
    public int getBlindaje() {return blindaje;}
    public int getPoderDeFuego(){return poderDeFuego;}
    public int getAntiaereos(){return antiaereos;}
    public int getLineaDeVision(){return lineaDeVision;}
    public String getUltimoNodoVisitado(){return ultimoNodoVisitado;}
    public void setUltimoNodoVisitado(String nombreNodo) {this.ultimoNodoVisitado = nombreNodo;}


}
