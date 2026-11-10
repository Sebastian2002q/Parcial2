package co.edu.uniquindio.parcial2.punto4;

public class Tree {
    private Nodo raiz;

    public static class Nodo {
        int codigo;
        Nodo izquierdo;
        Nodo derecho;

        public Nodo(int codigo) {
            this.codigo = codigo;
        }
    }

    public void insertar(int codigo) {
        raiz = insertar(raiz, codigo);
    }

    private Nodo insertar(Nodo nodo, int codigo) {
        if (nodo == null) {
            return new Nodo(codigo);
        }
        if (codigo < nodo.codigo) {
            nodo.izquierdo = insertar(nodo.izquierdo, codigo);
        } else if (codigo > nodo.codigo) {
            nodo.derecho = insertar(nodo.derecho, codigo);
        }
        return nodo;
    }

    public void eliminar(int codigo) {
        raiz = eliminar(raiz, codigo);
    }

    private Nodo eliminar(Nodo nodo, int codigo) {
        if (nodo == null) {
            return null;
        }
        if (codigo < nodo.codigo) {
            nodo.izquierdo = eliminar(nodo.izquierdo, codigo);
        } else if (codigo > nodo.codigo) {
            nodo.derecho = eliminar(nodo.derecho, codigo);
        } else {
            if (nodo.izquierdo == null) {
                return nodo.derecho;
            }
            if (nodo.derecho == null) {
                return nodo.izquierdo;
            }
            Nodo mayor = nodo.izquierdo;
            while (mayor.derecho != null) {
                mayor = mayor.derecho;
            }
            nodo.codigo = mayor.codigo;
            nodo.izquierdo = eliminar(nodo.izquierdo, mayor.codigo);
        }
        return nodo;
    }

    public int contarEquiposEnRango(int inferior, int superior) {
        return contarEquiposEnRango(raiz, inferior, superior);
    }

    private int contarEquiposEnRango(Nodo nodo, int inferior, int superior) {
        if (nodo == null || inferior > superior) {
            return 0;
        }
        if (nodo.codigo < inferior) {
            return contarEquiposEnRango(nodo.derecho, inferior, superior);
        }
        if (nodo.codigo > superior) {
            return contarEquiposEnRango(nodo.izquierdo, inferior, superior);
        }
        return 1 + contarEquiposEnRango(nodo.izquierdo, inferior, superior) + contarEquiposEnRango(nodo.derecho, inferior, superior);
    }

    public void inorden() {
        inorden(raiz);
        System.out.println();
    }

    private void inorden(Nodo nodo) {
        if (nodo == null) {
            return;
        }
        inorden(nodo.izquierdo);
        System.out.print(nodo.codigo + " ");
        inorden(nodo.derecho);
    }
}