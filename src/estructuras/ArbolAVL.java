package estructuras;

// Árbol AVL de clave y valor: un árbol binario de búsqueda que después de cada inserción o eliminación
// hace rotaciones para que las alturas de los dos subárboles de cada nodo no difieran en más de 1.
// Así la altura se mantiene en O(log n) aunque las claves lleguen en orden, como pasa con los ID.
// Plantilla de la Entrega 1: atributos y métodos que se implementarán en la Entrega 2.
public class ArbolAVL<K extends Comparable<K>, V> {

    private static class Nodo<K, V> {
        final K clave;
        V valor;
        int altura;
        Nodo<K, V> izquierdo;
        Nodo<K, V> derecho;

        Nodo(K clave, V valor) {
            this.clave = clave;
            this.valor = valor;
            this.altura = 1; // un nodo sin hijos tiene altura 1
        }
    }

    private Nodo<K, V> raiz;
    private int tamano;

    // valor guardado con esa clave, o null si no está: se baja por la izquierda o la derecha según la clave
    public V buscar(K clave) { // O(log n)
        Nodo <K, V> actual = raiz;
        while(actual != null) {
        int comparacion = clave.compareTo(actual.clave);

        if (comparacion == 0) {
            return actual.valor;
        }
        actual = comparacion < 0 ? actual.izquierdo: actual.derecho;
        }
        return null;
    }

    // inserta la pareja (si la clave ya existe, cambia el valor) y rebalancea el camino hasta la raíz
    public void insertar(K clave, V valor) { // O(log n)
        if (clave == null) {
        throw new IllegalArgumentException("La clave no puede ser null");
    }

    boolean[] nuevo = {false};
    raiz = insertar(raiz, clave, valor, nuevo);

    if (nuevo[0]) {
        tamano++;
    }
    }

    private Nodo<K, V> insertar(
        Nodo<K, V> nodo,
        K clave,
        V valor,
        boolean[] nuevo) {

    if (nodo == null) {
        nuevo[0] = true;
        return new Nodo<>(clave, valor);
    }

    int comparacion = clave.compareTo(nodo.clave);

    if (comparacion < 0) {
        nodo.izquierdo = insertar(nodo.izquierdo, clave, valor, nuevo);
    } else if (comparacion > 0) {
        nodo.derecho = insertar(nodo.derecho, clave, valor, nuevo);
    } else {
        nodo.valor = valor;
        return nodo;
    }

    actualizarAltura(nodo);
    return balancear(nodo);
}

    // quita la clave y retorna su valor (null si no estaba); con dos hijos se usa el sucesor inorden
    public V eliminar(K clave) { // O(log n)
        throw pendiente();
    }

    // valores ordenados por clave (recorrido inorden)
    public DLL<V> valoresEnOrden() { // O(n)
        throw pendiente();
    }

    public int size() { // O(1)
        return tamano;
    }

    public boolean isEmpty() { // O(1)
        return raiz == null;
    }

    private int altura(Nodo<K, V> nodo) {
    return nodo == null ? 0 : nodo.altura;
    }

    private void actualizarAltura(Nodo<K, V> nodo) {
    nodo.altura = 1 + Math.max(
            altura(nodo.izquierdo),
            altura(nodo.derecho)
        );
    }

    private int balance(Nodo<K, V> nodo) {
    return nodo == null ? 0 : altura(nodo.izquierdo) - altura(nodo.derecho);
    }

    // las cuatro situaciones de desbalance se corrigen con estas dos rotaciones (simples o combinadas)
    private Nodo<K, V> rotarDerecha(Nodo<K, V> nodo) { // O(1)
        throw pendiente();
    }

    private Nodo<K, V> rotarIzquierda(Nodo<K, V> nodo) { // O(1)
        throw pendiente();
    }

    private static UnsupportedOperationException pendiente() {
        return new UnsupportedOperationException("Pendiente para la Entrega 2");
    }
}
