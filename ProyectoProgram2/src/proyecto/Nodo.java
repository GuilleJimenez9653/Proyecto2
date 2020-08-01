package proyecto;

public class Nodo {
	
	private Nodo padre;
	private Nodo derecha;
	private Nodo izquierda;
	private int llave;
	private int valor;
	
	public Nodo() {}
	
	public Nodo(int indice) {
		this.llave = indice;
		this.derecha = null;
		this.izquierda = null;
		this.valor = 0;
	}

	public Nodo getPadre() {
		return padre;
	}

	public void setPadre(Nodo padre) {
		this.padre = padre;
	}

	public Nodo getDerecha() {
		return derecha;
	}

	public void setDerecha(Nodo derecha) {
		this.derecha = derecha;
	}

	public Nodo getIzquierda() {
		return izquierda;
	}

	public void setIzquierda(Nodo izquierda) {
		this.izquierda = izquierda;
	}

	public int getLlave() {
		return llave;
	}

	public void setLlave(int llave) {
		this.llave = llave;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
}
