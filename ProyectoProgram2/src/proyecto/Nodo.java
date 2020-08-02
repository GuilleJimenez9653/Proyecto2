package proyecto;

public class Nodo {
	
	private Nodo padre;
	private Nodo derecha;
	private Nodo izquierda;
	private int llave;
	private int valor;
	
	/**
	 * constructor vacio de la clase nodo
	 */
	public Nodo() {}
	
	/**
	 * constructor de la clase nodo que usa un valor entero, al campo valor se le coloca 2 ya que es el numero base de las estructuras "burbujas"
	 * @param indice indice del nodo
	 */
	public Nodo(int indice) {
		this.llave = indice;
		this.derecha = null;
		this.izquierda = null;
		this.valor = 2;
	}
	
	/**
	 * get de la clase nodo para el padre
	 * @return retorna el campo padre
	 */
	public Nodo getPadre() {
		return padre;
	}
	
	/**
	 * set de la clase nodo para el campo 
	 * @param padre es el nodo padre de este nodo
	 */
	public void setPadre(Nodo padre) {
		this.padre = padre;
	}
	
	/**
	 * get del nodo hijo derecho de un nodo
	 * @return devuelve el nodo hijo derecho del nodo
	 */
	public Nodo getDerecha() {
		return derecha;
	}
	/**
	 * set para colocar el nodo hijo derecha de un nodo
	 * @param derecha nodo que sera el hijo derecho
	 */
	public void setDerecha(Nodo derecha) {
		this.derecha = derecha;
	}
	/**
	 * get del nodo hijo izquierdo de un nodo
	 * @return devuelve el nodo hijo izquierdo del nodo
	 */
	public Nodo getIzquierda() {
		return izquierda;
	}
	/**
	 * set para colocar el nodo hijo izquierdo de un nodo
	 * @param izquierda nodo que sera el hijo izquierdo
	 */
	public void setIzquierda(Nodo izquierda) {
		this.izquierda = izquierda;
	}
	/**
	 * get para el campo llave 
	 * @return devuelve la llave del nodo
	 */
	public int getLlave() {
		return llave;
	}
	/**
	 * set para el campo llave 
	 * @param llave valor que tendra el campo llave 
	 */
	public void setLlave(int llave) {
		this.llave = llave;
	}
	/**
	 * get para el campo valor del nodo
	 * @return devuelve el valor que almacena el nodo 
	 */
	public int getValor() {
		return valor;
	}
	/**
	 * set para el campo valor
	 * @param valor se usa para darle la cantidad que va a tener el nodo
	 */
	public void setValor(int valor) {
		this.valor = valor;
	}
	
}
