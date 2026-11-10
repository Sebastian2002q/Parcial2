package co.edu.uniquindio.parcial2.punto2;

public class Main2 {
    public static void main(String[] args) {
        Pila<String> historial = new Pila<>();
        historial.push("A1");
        historial.push("A2");
        historial.push("A3");
        historial.push("A4");
        historial.push("A5");
        historial.push("A6");
        System.out.println("Original: " + historial);
        Pila<String> resultado = obtenerSegmento(historial, 2, 4);
        System.out.println("Resultado: " + resultado);
        System.out.println("Original final: " + historial);
    }

    public static <T> Pila<T> obtenerSegmento(Pila<T> original, int inicio, int fin) {
        Pila<T> resultado = new Pila<>();
        if (inicio < 1 || inicio > fin) {
            return resultado;
        }
        Pila<T> auxiliar = new Pila<>();
        Pila<T> segmentoInvertido = new Pila<>();
        int posicion = 1;
        while (!original.isEmpty() && posicion <= fin) {
            T accion = original.pop();
            auxiliar.push(accion);
            if (posicion >= inicio) {
                segmentoInvertido.push(accion);
            }
            posicion++;
        }
        while (!auxiliar.isEmpty()) {
            original.push(auxiliar.pop());
        }
        if (posicion <= fin) {
            return resultado;
        }
        while (!segmentoInvertido.isEmpty()) {
            resultado.push(segmentoInvertido.pop());
        }
        return resultado;
    }

}
