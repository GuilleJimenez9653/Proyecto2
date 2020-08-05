package archivos;
import java.io.*;


public class manejoDeArchivos{
	
	int n = 0;	//ESTE CONTADOR HACE QUE ENTRE DOS VECES EN EL ARCHIVO
	boolean log= true; 
	boolean append = true;
	File archivo = new File("datosUsuario.txt");
	FileWriter escribir; // Escribir en archivo;
	PrintWriter linea; // Escribir en archivo
	
	/*Explico que sucede aqui:
	 * Cuando se entra por primera vez, se tiene que repetir el while dos veces, una para que cree el archivo, y otra para que escriba dentro del archivo que se creo
	 * y cuando entra por segunda vez, como el archivo esta creado, log = false lo que hace que n=1 y el while se repita solo una vez y no dos como lo hizo cuando se creo. */
	
	public String leerTXT(String dir){
		int cont = 0;
		
		String texto = null;
		try{
			BufferedReader bf = new BufferedReader(new FileReader(dir));
			String temp = "";
			String bfRead;
																				//ARREGLAR LECTURA DE ARCHIVO
			while ((bfRead = bf.readLine()) != null){
					temp = temp + bfRead;
			}
			texto = temp;	
		}
		catch(Exception e){System.err.println("No se encontro archivo.");
		}
		
		return texto;
	}
	
	public manejoDeArchivos(String texto){
		
		if (log = false){		
			n=1;
		}
		while (n < 1){	
			if (!archivo.exists()){			
				try {
					archivo.createNewFile();
					log = false;
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			else{
				try {
					escribir = new FileWriter(archivo, true);
					linea = new PrintWriter(escribir);
					linea.println(texto);
					linea.close();
				} 
				catch (Exception e) {
					e.printStackTrace();
			}
				n++;
				System.out.println(n);
		}
	}
	}
}
