package e2;

public record Armor(String codename, int proteccion, int minimaFuerza) implements ObjetosDefensa {

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

    @Override
    public boolean getEsAtaque() {
        return false;
    }

    public String toString(){
        return "Armor: " + codename + "\t";
    }


}