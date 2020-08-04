package proyecto;

public class Pruebas {

	public static void main(String[] args) {
		Arbol arbol = new Arbol();
		
		System.out.println("hola");
		arbol.insertar(4,2);
		arbol.insertar(7,2);
		arbol.insertar(2,2);
		arbol.insertar(1,2);
		arbol.insertar(0,2);
		arbol.insertar(15,2);
		System.out.println("hola");
		arbol.recorrer(arbol.raiz);

	}

}
