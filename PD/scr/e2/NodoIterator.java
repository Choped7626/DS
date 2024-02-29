package e2;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class NodoIterator implements Iterator<Nodo> {

    //ATRIBUTOS
    private int pos = 0;
    private final List<Nodo> nodos;

    //CONSTRUCTOR
    public NodoIterator(List<Nodo> nodos){this.nodos = nodos;}

    //MÉTODOS
    @Override
    public boolean hasNext(){return pos < nodos.size();}

    @Override
    public Nodo next(){
        if (!hasNext()) throw new NoSuchElementException();
        return nodos.get(pos++);
    }
}
