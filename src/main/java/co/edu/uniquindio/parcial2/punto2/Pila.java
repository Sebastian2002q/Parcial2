package co.edu.uniquindio.parcial2.punto2;

public class Pila<T> {
    private Nodo<T> tope;

    private static class Nodo<T> {
        T valor;
        Nodo<T> siguiente;

        Nodo(T valor, Nodo<T> siguiente) {
            this.valor = valor;
            this.siguiente = siguiente;
        }
    }

    public void push(T valor) {
        tope = new Nodo<>(valor, tope);
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila esta vacia");
        }

        T valor = tope.valor;
        tope = tope.siguiente;
        return valor;
    }

    public boolean isEmpty() {
        return tope == null;
    }

    @Override
    public String toString() {
        StringBuilder texto = new StringBuilder();
        Nodo<T> actual = tope;

        while (actual != null) {
            if (!texto.isEmpty()) {
                texto.append(" -> ");
            }
            texto.append(actual.valor);
            actual = actual.siguiente;
        }
        return texto.toString();
    }
}
