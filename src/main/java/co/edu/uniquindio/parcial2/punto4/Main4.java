package co.edu.uniquindio.parcial2.punto4;

public class Main4 {

    public static void main(String[] args) {
        Tree arbol = new Tree();
        int[] codigos = {50, 30, 70, 20, 40, 60, 80, 55, 65};
        for (int codigo : codigos) {
            arbol.insertar(codigo);
        }
        System.out.println("Arbol original:");
        arbol.inorden();
        //System.out.println("Equipos entre 30 y 65: " + arbol.contarEquiposEnRango(30, 65));
        arbol.eliminar(50);
        System.out.println("Arbol despues de eliminar 50:");
        arbol.inorden();
    }
}

