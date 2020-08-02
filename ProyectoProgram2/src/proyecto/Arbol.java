package proyecto;

public class Arbol {
	
	Nodo raiz;
	
	public Arbol() {
		raiz = null;
	}
	
	/**
	 * Funcion para insertar un nodo en el arbol
	 * @param indice se usa indice para saber el valor del indice del nodo que se desea ingresar, este es unico y no se debe repetir
	 * @param valor valor contiene el numero que va a poseer el nodo
	 */
	public void insertar(int indice, int valor) {
		Nodo nodo = new Nodo(indice);
		nodo.setValor(valor);
		if(raiz == null) {
			raiz = nodo;
		}else {
			Nodo aux = raiz;
			while(aux != null) {
				nodo.setPadre(aux);
				if(nodo.getLlave()>=aux.getLlave()) {
					aux.setDerecha(aux.getDerecha());
				}else {
					aux.setIzquierda(aux.getIzquierda());
				}
			}
			if (nodo.getLlave() < nodo.getPadre().getLlave()) {
				nodo.getPadre().setIzquierda(nodo);
			}else {
				nodo.getPadre().setDerecha(nodo);
			}
		}
	}
	
	/**
	 * Imprime el arbol con los nodos de forma ordenada 
	 * @param nodo se le pasa el nodo raiz para recorrer el arbol
	 */
	public void recorrer(Nodo nodo) {
		if(nodo != null) {
			recorrer(nodo.getIzquierda());
			System.out.println("Indice " + nodo.getLlave() + "Valor " + nodo.getValor());
			recorrer(nodo.getDerecha());
		}
	}
	
	/**
	 * Elimina un nodo y reorganiza los nodos
	 * @param raiz se le pasa el nodo raiz para poder recorrer el arbol
	 * @param nodo es el nodo que se desea eliminar
	 */
	public void eliminar(Nodo raiz ,Nodo nodo) {
        if(raiz==null) return;

         if (raiz.getDerecha()==nodo) {

            raiz.setDerecha(null);
         }
         if (raiz.getIzquierda()==nodo) {
             raiz.setIzquierda(null);
         }

            eliminar(raiz.getIzquierda(),nodo);
            eliminar(raiz.getDerecha(),nodo);
        }
	
	/**
	 * Busca si dos nodos tienen relacion padre hijo o hermanos
	 * @param primer_nodo es el primer nodo que se selecciona en la interfaz grafica
	 * @param segundo_nodo el segundo nodo que se selecciona e la interfaz grafica
	 * @return retorna true si tiene alguna relacion, retorna false si no tienen ninguna relacion
	 */
	private boolean padreHijo(Nodo primer_nodo, Nodo segundo_nodo) {
		boolean log = false;
		if (primer_nodo.getDerecha()==segundo_nodo) {
			log = true;
		}else if(primer_nodo.getIzquierda()==segundo_nodo) {
			log = true;
		}else if(segundo_nodo.getDerecha()==primer_nodo) {
			log = true;
		}else if(segundo_nodo.getIzquierda()==primer_nodo) {
			log = true;
		}else if (primer_nodo.getPadre()==segundo_nodo.getPadre()) {
			log = true;
		}
		return log;
	}
	
	/**
	 * devuelve el nodo padre de los dos nodos seleccionados
	 * @param primer_nodo primer nodo seleccionado
	 * @param segundo_nodo segundo nodo seleccionado
	 * @return devuelve el nodo padre
	 */
	private Nodo identificarPadre(Nodo primer_nodo, Nodo segundo_nodo) {
		Nodo nodo_padre = null;
		if (primer_nodo.getPadre() == segundo_nodo) {
			nodo_padre = segundo_nodo;
		}else if(segundo_nodo.getPadre() == primer_nodo) {
			nodo_padre = primer_nodo;
		}else if(primer_nodo.getPadre() == segundo_nodo.getPadre()) {
			nodo_padre = primer_nodo.getPadre();
		}
		return nodo_padre;
	}
	
	/**
	 * suma los valores de dos nodos y borra el primero que se le pasa
	 * esta funcion debe revisarse 
	 * @param primer_nodo es el primer nodo que se selecciona en la interfaz grafica
	 * @param segundo_nodo segundo_nodo el segundo nodo que se selecciona e la interfaz grafica
	 */
	public void suma(Nodo primer_nodo, Nodo segundo_nodo) {
		Nodo nodo_padre = null;
		if ((primer_nodo.getValor() == segundo_nodo.getValor())&&(padreHijo(primer_nodo,segundo_nodo))) {
			nodo_padre = identificarPadre(primer_nodo,segundo_nodo);
			if (nodo_padre == primer_nodo) {
				primer_nodo.setValor(primer_nodo.getValor()*2);
				eliminar(raiz,segundo_nodo);
			}else if (nodo_padre == segundo_nodo) {
				segundo_nodo.setValor(segundo_nodo.getValor()*2);
				eliminar(raiz,primer_nodo);
			}else if (nodo_padre == primer_nodo.getPadre()) {
				segundo_nodo.setValor(segundo_nodo.getValor()*2);
				eliminar(raiz,primer_nodo);
			}
		}
	}
}
