package e2;

public class FireBallSpell implements ObjetosAtaque{

    String codename;
    int poderAtaque,minimoMana,usosRestantes;

    public FireBallSpell(String codename, int poderAtaque, int minimoMana, int usosRestantes) {
        this.codename = codename;
        this.poderAtaque = poderAtaque;
        this.minimoMana = minimoMana;
        this.usosRestantes = usosRestantes;
    }
    @Override
    public boolean getEsAtaque() {
        return true;
    }

    @Override
    public int getDano() {
        if (usosRestantes == 1)  //Cuando le queda un uso, se resta 1 a su poder de ataque
            return poderAtaque - 1;
        else
            return poderAtaque;
    }

    @Override
    public int getMinMana() {
        return minimoMana;
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
        usosRestantes -= 1;
    }

    @Override
    public String toString(){
        return "FireBallSpell: " + codename+ "\t";
    }
}
