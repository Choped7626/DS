package e1;

public class StringUtilities{

    public static boolean isValidString(String cadena, String validos, int longitud){

        validos = validos.concat("0123456789");
        char[] cadenaArray;
        char[] validosArray;
        int cnt = 0;

        if(cadena == null || cadena.isEmpty() || cadena.length() < longitud){
            return false;
        }else{
            cadenaArray = cadena.toCharArray();
            validosArray = validos.toCharArray();
            for (int i = 0 ; i < cadena.length() ; i++){
                for (int j = 0 ; j < validos.length() ; j++){
                    if(cadenaArray[i] == validosArray[j]){
                        cnt++;
                    }
                }
            }
            return cnt == cadena.length();
        }
    }

    public static String lowercaseFirst(String cadena){

        char[] cadenaArray;
        String mayus = "";
        String minus = "";
        cadenaArray  = cadena.toCharArray();

        for (int i = 0 ; i < cadena.length() ; i++){
            if('a' <= cadenaArray[i] && cadenaArray[i] <= 'z'){
                minus = minus.concat(String.valueOf(cadenaArray[i]));
            }else if('A' <= cadenaArray[i] && cadenaArray[i] <= 'Z'){
                mayus = mayus.concat(String.valueOf(cadenaArray[i]));
            }
        }
        String sol = "";
        sol = sol.concat(minus);
        sol = sol.concat(mayus);
        return sol;
    }

    public static boolean checkTextStats(String cadena , float min, float max){

        if (cadena == null || cadena.isEmpty() || min <= 0 || max <= 0){
            throw new IllegalArgumentException();
        }

        float palabras = 1;
        int longitud = 0;
        int palabraMasLarga = 0;
        float contadorTamanho = 0;
        char[] cadenaArray;
        cadenaArray = cadena.toCharArray();

        for (int i = 0 ; i < cadena.length() ; i++){
            if (cadenaArray[i] == ' '){
                palabras++;
                if(longitud > palabraMasLarga){
                    palabraMasLarga = longitud;
                    longitud = 0;
                }
            }else{
                longitud++;
                contadorTamanho++;
            }
        }

        float media = contadorTamanho/palabras;

        return media <= max && media >= min && !(palabraMasLarga > 2 * media);
    }
}
