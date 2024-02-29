package e2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Nodo {
    //ATRIBUTOS
    private final String nombre;
    public List<Nodo> hijos;

    //CONSTRUCTOR
    public Nodo(String nombre) {
        this.nombre = nombre;
        this.hijos = new ArrayList<>();
    }

    //METODOS

    public void anadirHijo(Nodo hijo){hijos.add(hijo);}
    public String getNombre(){return nombre;}
    public Iterator<Nodo> getIterator(){return new NodoIterator(hijos);}
    public void tomarRuta(Flota flota, boolean condicion) {
        Iterator<Nodo> iterator = getIterator();
        Nodo siguienteNodo;

        if (condicion) {
            siguienteNodo = iterator.next();
        }
        else {
            iterator.next();
            siguienteNodo = iterator.hasNext() ? iterator.next() : null;
        }

        if (siguienteNodo != null) {
            siguienteNodo.operation(flota);
        }
        else System.out.println("Final del camino con flota activa y sin acabar encontrando un nodoFin");
    }

    public abstract void operation(Flota flota);
}
