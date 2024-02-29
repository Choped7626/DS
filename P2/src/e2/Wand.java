package e2;

public class Wand implements ObjetosAtaque, ObjetosDefensa {
    String codename;
    int usosRestantes, poderAtaque, minimoMana, proteccion, minimaFuerza, primerUso;
    boolean ataque;

    public Wand (String codename, int poderAtaque, int minimoMana, int usosRestantes) {
        this.codename = codename;
        this.usosRestantes = usosRestantes;
        this.poderAtaque = poderAtaque;
        this.minimoMana = minimoMana;
        this.ataque = true;
        this.primerUso = 0;
    }

    public Wand (String codename, int proteccion, int minimaFuerza) {
        this.codename = codename;
        this.proteccion = proteccion;
        this.minimaFuerza = minimaFuerza;
        this.ataque = false;
    }

    @Override
    public boolean getEsAtaque() {
        return ataque;
    }

    @Override
    public int getDano() {
        if (ataque) {
            ataque = false;
            return poderAtaque * 2;
        }
        else
            return poderAtaque;
    }

    @Override
    public int getMinMana() {
        return minimoMana;
    }

    @Override
    public int getProteccion() {
        return proteccion;
    }

    @Override
    public int getFuerzaMinima() {
        return minimaFuerza;
    }

    @Override
    public String getCodename() {
        return codename;
    }

    public int getUsosRestantes() {
        return usosRestantes;
    }

    @Override
    public void decrementarUso() {
        usosRestantes--;
    }

    @Override
    public String toString(){
        return "Wand: " + codename+ "\t";
    }
}
