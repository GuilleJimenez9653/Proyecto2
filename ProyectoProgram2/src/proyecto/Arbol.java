package proyecto;

public class Arbol {
	
	Nodo raiz;
	
	public Arbol() {
		raiz = null;
	}
	
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
	
	public void recorrer(Nodo nodo) {
		if(nodo != null) {
			recorrer(nodo.getIzquierda());
			System.out.println("Indice " + nodo.getLlave() + "Valor " + nodo.getValor());
			recorrer(nodo.getDerecha());
		}
	}
	
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
	
	public void suma(Nodo primer_nodo, Nodo segundo_nodo) {
		if (primer_nodo.getValor() == segundo_nodo.getValor()) {
			segundo_nodo.setValor(segundo_nodo.getValor()*2);
			eliminar(raiz,primer_nodo);
		}
	}
}
