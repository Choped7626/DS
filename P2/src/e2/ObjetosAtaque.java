package e2;

public interface ObjetosAtaque extends ObjetosGeneral{
    int getDano();
    int getMinMana();
    int getUsosRestantes();
    void decrementarUso();

}
