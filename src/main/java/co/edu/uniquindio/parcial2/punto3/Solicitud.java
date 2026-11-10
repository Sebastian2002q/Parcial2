package co.edu.uniquindio.parcial2.punto3;

public record Solicitud(String codigo, Prioridad prioridad, int duracion) {

    public Solicitud {
        if (duracion <= 0) {
            throw new IllegalArgumentException("La duracion debe ser positiva");
        }
    }

    @Override
    public String toString() {
        return codigo;
    }
}