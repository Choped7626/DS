package e2;

public interface PersonajeInterfaz {
    String getName();
    int getSalud();
    void quitarSalud(int dano);
    int getFuerza();
    int getMana();
    int ProteccionTotal();
    void anadirObjetosAtaque(ObjetosAtaque ataque);
    void anadirObjetosDefensa(ObjetosDefensa defensa);
}
