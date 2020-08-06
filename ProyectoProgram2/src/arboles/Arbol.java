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
	
	/**
	 * Elimina un nodo del arbol, devuelve true si elimino correctamente y false si hubo un error
	 * @param d resive como parametro el numero del nodo
	 * @return true si elimino correctamente y false si hubo error
	 */
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
	
	private boolean comprobarRelacion(Nodo nodoUno,Nodo nodoDos) {
		boolean log = false;
		Nodo padre = encontrarPadre(raiz,nodoUno);
		if (nodoUno == nodoDos.getHjoDerecho()||nodoUno == nodoDos.getHijoIzquierdo()) {
			log = true;
		}else if(nodoDos == nodoUno.getHjoDerecho() || nodoDos == nodoUno.getHijoIzquierdo()) {
			log = true;
		}else if(padre.getHijoIzquierdo() == nodoDos || padre.getHjoDerecho() == nodoDos) {
			log = true;
		}
		
		return log;
	}
	
	private Nodo encontrarPadre(Nodo nodo,Nodo nodoHijo) {
		Nodo padre = nodo;
		if(nodo != null) {
			if(padre.getHijoIzquierdo() == nodoHijo || padre.getHjoDerecho() == nodoHijo) {
				return padre;
			}
			encontrarPadre(nodo.getHijoIzquierdo(),nodoHijo);
			encontrarPadre(nodo.getHjoDerecho(),nodoHijo);
		}
		return padre;
	}
	
	public void suma(Nodo nodoUno,Nodo nodoDos) {
		if (comprobarRelacion(nodoUno,nodoDos)) {
			if(nodoUno.getValor() == nodoDos.getValor()) {
				//nodoDos es el padre
				if(nodoUno == nodoDos.getHjoDerecho()||nodoUno == nodoDos.getHijoIzquierdo()) {
					nodoDos.setValor(nodoDos.getValor() + nodoUno.getValor());
					eliminar(nodoUno.getDato());
				}else if(nodoDos == nodoUno.getHjoDerecho() || nodoDos == nodoUno.getHijoIzquierdo()) {
					//nodoUno es el padre
					nodoUno.setValor(nodoUno.getValor() + nodoDos.getValor());
					eliminar(nodoDos.getDato());
				}else {
					//son hermanos
					nodoDos.setValor(nodoDos.getValor() + nodoUno.getValor());
					eliminar(nodoUno.getDato());
				}
			}
		}
	}
}
