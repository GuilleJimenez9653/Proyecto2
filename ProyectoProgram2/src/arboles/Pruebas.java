package arboles;

import javax.swing.JOptionPane;

public class Pruebas {

	public static void main(String[] args) {
		int opcion = 0,elemento,valor;
		Arbol arbol = new Arbol();
		do {
			try {
				opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
						"1. Agregar un Nodo\n"
						+ "2. Salir\n"
								+"Elige una opcion...","Arboles Binarios",
								JOptionPane.QUESTION_MESSAGE));
				switch (opcion) {
					case 1:
						elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
								"Ingresa el numero del nodo...","Agregando Nodo",
								JOptionPane.QUESTION_MESSAGE));
						valor = Integer.parseInt(JOptionPane.showInputDialog(null,
								"Ingresa el valor del nodo...","Agregando Nodo",
								JOptionPane.QUESTION_MESSAGE));
						arbol.agregarNodo(elemento,valor);
						break;
					case 2:
						JOptionPane.showMessageDialog(null,"Aplicacion finalizada","Fin",JOptionPane.INFORMATION_MESSAGE);
						break;
					default:
						JOptionPane.showMessageDialog(null,"Opcion Incorrecta","Cuidado",JOptionPane.INFORMATION_MESSAGE);
				}
			}catch(NumberFormatException n) {
				JOptionPane.showMessageDialog(null,"Error"+ n.getMessage());
			}
		}while (opcion != 2);
	}

}
