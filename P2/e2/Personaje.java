package e2;

import java.util.ArrayList;
import java.util.List;

public abstract class Personaje implements PersonajeInterfaz{

    //Atributos
    private final String name;
    private int salud;
    private final int fuerza;
    private final int mana;
    private final List<ObjetosAtaque> objetosAtaques;
    private final List<ObjetosDefensa> objetosDefensas;


    //Constructor
    protected Personaje(String name, int salud, int fuerza, int mana) {
        if (salud < 0 || salud > 20)
            throw new IllegalArgumentException("El valor de salud está fuera del rango preestablecido");
        if (fuerza < 1 || fuerza > 10)
            throw new IllegalArgumentException("El valor de fuerza está fuera del rango preestablecido");
        if (mana < 0 || mana > 10)
            throw new IllegalArgumentException("El valor de maná está fuera del rango preestablecido");

        this.name = name;
        this.salud = salud;
        this.fuerza = fuerza;
        this.mana = mana;
        this.objetosAtaques = new ArrayList<>();
        this.objetosDefensas = new ArrayList<>();
    }


    //SETTERS Y GETTERS

    @Override
    public void quitarSalud(int quitar) {
        if (salud - quitar > 20)
            throw new IllegalArgumentException("Error");
        salud -= quitar;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSalud() {
        return salud;
    }

    @Override
    public int getFuerza() {
        return fuerza;
    }

    @Override
    public int getMana() {
        return mana;
    }

    public List<ObjetosAtaque> getObjetosAtaques() {
        return objetosAtaques;
    }
    public List<ObjetosDefensa> getObjetosDefensas() {
        return objetosDefensas;
    }

    @Override
    public int ProteccionTotal() {
        int proteccionTotal = 0;
        for (ObjetosDefensa objeto : objetosDefensas) {
            if (this.getFuerza() >= objeto.getFuerzaMinima())
               proteccionTotal += objeto.getProteccion();
            else System.out.println("El defensor no tiene suficiente fuerza para poder usar los objetos de defensa (entonces se resta directamente a la vida)");
        }
        return proteccionTotal;
    }

    @Override
    public void anadirObjetosAtaque(ObjetosAtaque ataque) {
        if (objetosAtaques.isEmpty()){
            if (ataque.getEsAtaque())
                objetosAtaques.add(ataque);
            else
                throw new IllegalArgumentException(ataque.getCodename()+" se esta usando como objeto de DEFENSA. NO SE PUEDE AÑADIR A LA LISTA DE OBJETOS DE ATAQUE");
        }
        else {
            if (objetosAtaques.size() > 4)
                throw new IllegalArgumentException("Ya se ha llenado la lista de objetos de ataque");
            else {
                if (ataque.getEsAtaque())
                    objetosAtaques.add(ataque);
                else
                    throw new IllegalArgumentException(ataque.getCodename()+" se esta usando como objeto de DEFENSA. NO SE PUEDE AÑADIR A LA LISTA DE OBJETOS DE ATAQUE");
            }
        }
    }

    @Override
    public void anadirObjetosDefensa(ObjetosDefensa defensa) {
        if (objetosDefensas.isEmpty()){
            if (!defensa.getEsAtaque())
                objetosDefensas.add(defensa);
            else
                throw new IllegalArgumentException(defensa.getCodename()+" se esta usando como objeto de ATAQUE. NO SE PUEDE AÑADIR A LA LISTA DE OBJETOS DE DEFENSA");

        }
        else {
            if (objetosDefensas.size() > 4)
                throw new IllegalArgumentException("Ya se ha llenado la lista de objetos de defensa");
            else {
                if (!defensa.getEsAtaque())
                    objetosDefensas.add(defensa);
                else
                    throw new IllegalArgumentException(defensa.getCodename()+" se esta usando como objeto de ATAQUE. NO SE PUEDE AÑADIR A LA LISTA DE OBJETOS DE DEFENSA");
            }
        }
    }


}