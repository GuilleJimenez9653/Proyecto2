package arboles;

public class Nodo {
	private int dato;
	private int valor;
	private Nodo hijoIzquierdo, hjoDerecho;
	
	public Nodo () {}
	
	/**
	 * Constructor con parametros de la clase nodo
	 * @param dato es la clave del nodo
	 * @param valor es la cantidad que posee el nodo
	 */
	public Nodo(int dato,int valor) {
		this.dato = dato;
		this.valor = valor;
		this.hjoDerecho = null;
		this.hijoIzquierdo = null;
	}

	public int getDato() {
		return dato;
	}

	public void setDato(int dato) {
		this.dato = dato;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Nodo getHijoIzquierdo() {
		return hijoIzquierdo;
	}

	public void setHijoIzquierdo(Nodo hijoIzquierdo) {
		this.hijoIzquierdo = hijoIzquierdo;
	}

	public Nodo getHjoDerecho() {
		return hjoDerecho;
	}

	public void setHjoDerecho(Nodo hjoDerecho) {
		this.hjoDerecho = hjoDerecho;
	}

	
}
