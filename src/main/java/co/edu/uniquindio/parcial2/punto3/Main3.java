package co.edu.uniquindio.parcial2.punto3;

public class Main3 {
    public static void main(String[] args) {
        Cola<Solicitud> pendientes = new Cola<>();
        pendientes.enqueue(new Solicitud("S1", Prioridad.NORMAL, 10));
        pendientes.enqueue(new Solicitud("S2", Prioridad.ALTA, 30));
        pendientes.enqueue(new Solicitud("S3", Prioridad.ALTA, 15));
        pendientes.enqueue(new Solicitud("S4", Prioridad.NORMAL, 5));
        System.out.println("Original: " + pendientes);
        Cola<Solicitud> seleccionadas = seleccionarSolicitudes(pendientes, 25);
        System.out.println("Seleccionadas: " + seleccionadas);
        System.out.println("Pendientes: " + pendientes);
    }

    public static Cola<Solicitud> seleccionarSolicitudes(Cola<Solicitud> pendientes, int minutos) {
        Cola<Solicitud> seleccionadas = new Cola<>();
        if (minutos <= 0) {
            return seleccionadas;
        }
        Cola<Solicitud> auxiliar = new Cola<>();
        while (!pendientes.isEmpty()) {
            Solicitud solicitud = pendientes.dequeue();
            if (solicitud.prioridad() == Prioridad.ALTA && solicitud.duracion() <= minutos) {
                seleccionadas.enqueue(solicitud);
                minutos -= solicitud.duracion();
            } else {
                auxiliar.enqueue(solicitud);
            }
        }
        while (!auxiliar.isEmpty()) {
            Solicitud solicitud = auxiliar.dequeue();
            if (solicitud.prioridad() == Prioridad.NORMAL && solicitud.duracion() <= minutos) {
                seleccionadas.enqueue(solicitud);
                minutos -= solicitud.duracion();
            } else {
                pendientes.enqueue(solicitud);
            }
        }
        return seleccionadas;
    }
}
