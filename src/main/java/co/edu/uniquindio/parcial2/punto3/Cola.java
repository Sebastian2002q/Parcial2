package co.edu.uniquindio.parcial2.punto3;

public class Cola<T> {
    private Nodo<T> frente;
    private Nodo<T> fin;

    private static class Nodo<T> {
        T valor;
        Nodo<T> siguiente;

        Nodo(T valor) {
            this.valor = valor;
        }
    }

    public void enqueue(T valor) {
        Nodo<T> nuevo = new Nodo<>(valor);
        if (isEmpty()) {
            frente = nuevo;
        } else {
            fin.siguiente = nuevo;
        }
        fin = nuevo;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("La cola esta vacia");
        }
        T valor = frente.valor;
        frente = frente.siguiente;
        if (frente == null) {
            fin = null;
        }
        return valor;
    }

    public boolean isEmpty() {
        return frente == null;
    }

    @Override
    public String toString() {
        StringBuilder texto = new StringBuilder();
        Nodo<T> actual = frente;
        while (actual != null) {
            if (texto.length() > 0) {
                texto.append(" -> ");
            }
            texto.append(actual.valor);
            actual = actual.siguiente;
        }
        return texto.toString();
    }
}
