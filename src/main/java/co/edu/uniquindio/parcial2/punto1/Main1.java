package co.edu.uniquindio.parcial2.punto1;

public class Main1 {
    public static void main(String[] args) {
        Pila<Operacion> historial = new Pila<>();
        historial.push(new Operacion("O1", Estado.ANULADA));
        historial.push(new Operacion("O2", Estado.CONFIRMADA));
        historial.push(new Operacion("O3", Estado.CONFIRMADA));
        historial.push(new Operacion("O4", Estado.ANULADA));
        historial.push(new Operacion("O5", Estado.CONFIRMADA));
        System.out.println("Original: " + historial);
        Pila<Operacion> resultado = obtenerUltimasConfirmadas(historial, 2);
        System.out.println("Resultado: " + resultado);
        System.out.println("Original final: " + historial);
    }

    public static Pila<Operacion> obtenerUltimasConfirmadas(Pila<Operacion> historial, int n) {
        Pila<Operacion> resultado = new Pila<>();
        if (n <= 0) {
            return resultado;
        }
        Pila<Operacion> auxiliar = new Pila<>();
        Pila<Operacion> confirmadasInvertidas = new Pila<>();
        int contador = 0;
        while (!historial.isEmpty() && contador < n) {
            Operacion operacion = historial.pop();
            auxiliar.push(operacion);
            if (operacion.estado() == Estado.CONFIRMADA) {
                confirmadasInvertidas.push(operacion);
                contador++;
            }
        }
        while (!auxiliar.isEmpty()) {
            historial.push(auxiliar.pop());
        }
        while (!confirmadasInvertidas.isEmpty()) {
            resultado.push(confirmadasInvertidas.pop());
        }
        return resultado;
    }
}
