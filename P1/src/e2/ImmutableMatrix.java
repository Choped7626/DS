package e2;

import java.util.Arrays;

public final class ImmutableMatrix {

    private final int [][]im;
    private final int filas;
    private final int columnas;

    public ImmutableMatrix(int[][] arr) {
        filas  = arr.length;
        columnas = arr[0].length;
        int ragged = 0;
        im = new int[filas][columnas];
        for (int i = 0; i < filas; i++){
            if(columnas != arr[i].length)  //Si el número de elementos de la fila i es distinto al de la fila 0
                ragged++;  //Incrementamos nuestro contador de excepcion

            if (ragged == 0) {
                im[i] = Arrays.copyOf(arr[i], columnas);

            } else {
                throw new IllegalArgumentException("La matriz no puede ser irregular\n");
            }
        }

    }

    public ImmutableMatrix(int f , int c) {
        filas = f;
        columnas = c;
        im = new int[filas][columnas];
        int cnt = 1;
        for (int i = 0 ; i < filas ; i++){
            for (int j = 0 ; j < columnas ; j++){
                im[i][j] = cnt;
                cnt++;
            }
        }
    }
    public String toString(){
        StringBuilder obj = new StringBuilder();
        for (int[] ints : im) {
            obj.append(Arrays.toString(ints));  //Convertimos la fila actual en cadena
            obj.append("\n");
        }
        return obj.toString();
    }


    public int at(int f , int c){
        if(f >= filas  || c >= columnas || f < 0 || c < 0){
            throw new IllegalArgumentException();
        }else
            return im[f][c];
    }

    public int rowCount(){
        return im.length;
    }

    public int columnCount(){
        return im[0].length;
    }

    public int[][] toArray2D(){
        int[][] copia = new int[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                copia[i][j] = im[i][j];
            }
        }
        return copia;
    }

    public ImmutableMatrix reverse(){
        int[][] nuevaM = new int[filas][columnas];
        for (int i = 0 ; i < filas ; i++){
            for (int j = columnas - 1 ; j >= 0 ; j--){
                nuevaM[i][j] = im[i][columnas - j - 1];
            }
        }
        return new ImmutableMatrix(nuevaM);
    }

    public ImmutableMatrix transpose() {
        int[][] traspuesta = new int[columnas][filas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                traspuesta[j][i] = im[i][j];
            }
        }
        return new ImmutableMatrix(traspuesta);
    }

    public ImmutableMatrix reshape(int newCol) {
        if (im.length * im[0].length % newCol != 0)
            throw new IllegalArgumentException("Error\n");

        int newFil = im.length * im[0].length / newCol;  //Calculamos el número de filas necesario en la nueva matriz para mantener la misma cantidad de elementos
        int[][] resh = new int[newFil][newCol];

        int cnt = 0;  //Contador para recorrer los elementos de la matriz
        for (int i = 0; i < newFil; i++) {
            for (int j = 0; j < newCol; j++) {
                int cntFila = cnt / im[0].length;  //calculamos la fila
                int cntColumna = cnt % im[0].length;  // y la columna
                resh[i][j] = im[cntFila][cntColumna];
                cnt++;  //Aumentamos el contador
            }
        }
        return new ImmutableMatrix(resh);
    }
}