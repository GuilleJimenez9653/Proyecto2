package archivos;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class manejoDeArchivos {
	public static void main(String[] args){
		
		File archivo = new File("datosUsuario.txt");
		PrintWriter escribir;
		if (!archivo.exists()){			
			try {
				archivo.createNewFile();
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		else{
			try {
				escribir = new PrintWriter(archivo,"utf-8");
				escribir.println("El coño a tu madre");
				escribir.close();
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}	
}
