package co.edu.uniquindio.parcial2.punto1;

public record Operacion(String codigo, Estado estado) {
    @Override
    public String toString() {
        return codigo + " (" + estado + ")";
    }
}
