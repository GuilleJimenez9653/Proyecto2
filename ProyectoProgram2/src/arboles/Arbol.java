package arboles;

public class Arbol {
	Nodo raiz;
	
	public Arbol() {
		raiz = null;
	}
	
	public void agregarNodo(int dato,int valor) {
		Nodo nuevo = new Nodo(dato,valor);
		if (raiz == null) {
			raiz = nuevo;
		}else {
			Nodo aux = raiz;
			Nodo padre;
			while(true) {
				padre = aux;
				if(dato < aux.getDato()) {
					aux = aux.getHijoIzquierdo();
					if(aux == null) {
						padre.setHijoIzquierdo(nuevo);
						return;
					}
				}else {
					aux = aux.getHjoDerecho();
					if(aux == null) {
						padre.setHjoDerecho(nuevo);
						return;
					}
				}
			}
		}
	}
}
