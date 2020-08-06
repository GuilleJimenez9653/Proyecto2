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
	
	public boolean esVacio() {
		return raiz == null;
	}
	
	public void inOrden(Nodo r) {
		if(r != null) {
			inOrden(r.getHijoIzquierdo());
			System.out.println(r.getDato());
			inOrden(r.getHjoDerecho());
		}
	}
	
	public void preOrden(Nodo r) {
		if(r != null) {
			System.out.println(r.getDato());
			preOrden(r.getHijoIzquierdo());
			preOrden(r.getHjoDerecho());
		}
	}
	
	public void postOrden(Nodo r) {
		if(r != null) {
			postOrden(r.getHijoIzquierdo());
			postOrden(r.getHjoDerecho());
			System.out.println(r.getDato());
		}
	}
	
	public boolean eliminar(int d) {
		Nodo aux = raiz;
		Nodo padre = raiz;
		boolean esHijoIzq = true;
		while(aux.getDato() != d) {
			padre = aux;
			if(d < aux.getDato()) {
				esHijoIzq = true;
				aux = aux.getHijoIzquierdo();
			}else {
				esHijoIzq = false;
				aux = aux.getHjoDerecho();
			}
			if(aux == null) {
				return false;
			}
		}
		if (aux.getHijoIzquierdo() == null && aux.getHjoDerecho() == null) {
			if(aux == raiz) {
				raiz = null;
			}else if(esHijoIzq) {
				padre.setHijoIzquierdo(null);
			}else {
				padre.setHjoDerecho(null);
			}
		}else if(aux.getHjoDerecho()==null) {
			if(aux == raiz) {
				raiz = aux.getHijoIzquierdo();
			}else if(esHijoIzq) {
				padre.setHijoIzquierdo(aux.getHijoIzquierdo());
			}else {
				padre.setHjoDerecho(aux.getHijoIzquierdo());
			}
		}else if(aux.getHijoIzquierdo()==null) {
			if(aux == raiz) {
				raiz = aux.getHjoDerecho();
			}else if(esHijoIzq) {
				padre.setHijoIzquierdo(aux.getHjoDerecho());
			}else {
				padre.setHjoDerecho(aux.getHijoIzquierdo());
			}
		}else {
			Nodo reemplazo = obtenerNodoReemplazo(aux);
			if(aux == raiz) {
				raiz = reemplazo;
			}else if(esHijoIzq) {
				padre.setHijoIzquierdo(reemplazo);
			}else {
				padre.setHjoDerecho(reemplazo);
			}
			reemplazo.setHijoIzquierdo(aux.getHijoIzquierdo());
		}
		return true;
	}
	
	public Nodo obtenerNodoReemplazo(Nodo nodoReem) {
		Nodo reemplazarPadre = nodoReem;
		Nodo reemplazo = nodoReem;
		Nodo aux = nodoReem.getHjoDerecho();
		while(aux != null) {
			reemplazarPadre = reemplazo;
			reemplazo = aux;
			aux = aux.getHijoIzquierdo();
		}
		if(reemplazo != nodoReem.getHjoDerecho()) {
			reemplazarPadre.setHijoIzquierdo(reemplazo.getHijoIzquierdo());
			reemplazo.setHjoDerecho(nodoReem.getHjoDerecho());
		}
		System.out.println("El Nodo Reemplazo es " + reemplazo);
		return reemplazo;
	}
	
}
