package e2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class SimularIncursion {

    private void mostrarResultado(boolean exito,Flota flota) {
        String resultado = exito ? "ÉXITO" : "FRACASO";
        System.out.println("Resultado de la salida: \n\t" + resultado);
        System.out.println("\tÚltimo Nodo Visitado: " + flota.getUltimoNodoVisitado());
        System.out.println("\tHP Final: "+ flota.getHp());
    }

    public void simularIncursion(Flota flota, Nodo nodo) {
        boolean exito = true;
        nodo.operation(flota);

        if (!flota.isFlotaActiva())
            exito = false;

        mostrarResultado(exito, flota);
    }


    public static int RutaMinima(Nodo nodoInicial) {
        Queue<Nodo> cola = new LinkedList<>();
        cola.add(nodoInicial);
        int nivel = 0;

        while (!cola.isEmpty()) {
            int sizeNivel = cola.size();
            nivel++;

            for (int i = 0; i < sizeNivel; i++) {
                Nodo nodoActual = cola.poll();
                if (nodoActual instanceof NodoFin)
                    return nivel;

                if (nodoActual != null)
                    cola.addAll(nodoActual.hijos);
            }
        }
        return -1;
    }

    public static String Newick(Nodo nodo) {
        if (nodo == null) return"";

        StringBuilder newick = new StringBuilder();
        newick.append("(");
        newick.append(nodo.getNombre());
        newick.append(" ");
        newick.append(nodo.getClass().getSimpleName());

        if (!nodo.hijos.isEmpty()) {
            newick.append(", ");
            for (int i = 0; i < nodo.hijos.size(); i++) {
                newick.append(Newick(nodo.hijos.get(i)));
                if (i < nodo.hijos.size() - 1)
                    newick.append(", ");
            }
        }
        newick.append(")");
        return newick.toString();
    }
}
