import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
 
 
public class main {
 
   	public static void main(String[] args) throws IOException {
         	// TODO Auto-generated method stub
         	File Ffichero=new File("C:\\Users\\7 Tecnica\\Desktop\\vita.txt");
         	//File bkp = new File("C:\\Users\\Users\\7 Tecnica\\Desktop\\archivo.txt.bkp");
         	//Ffichero.createNewFile()
         	
         	//Files.copy(in, target, options)
         	
   	Marcar(Ffichero);
 	
  Path copy_from_4 = Paths.get("C:\\Users\\7 Tecnica\\Desktop", "vita.txt");
  Path copy_to_4 = Paths.get("C:\\Users\\7 Tecnica\\Desktop", "archivo.txt");
  try (OutputStream os = new FileOutputStream(copy_to_4.toFile())) {

   Files.copy(copy_from_4, os);
   }
   catch (IOException e) {
       System.err.println(e);
      }
   	}
 
   	public static void Marcar(File archivoA)   {
         	try {
                	FileReader fr = new FileReader(archivoA) ;
                	BufferedReader br = new BufferedReader(fr);
                	
                	String cambiado ="";
                	char prev = '.';
                	
                	
                	while(br.ready())
                	{
                       	char c = (char)br.read();
                       	if(prev=='.') {
                              	c = Character.toUpperCase(c);
                       	}
                       	prev=c;
                       	cambiado+=c;
                	}
                	
                	System.out.println("cambiado::::"+cambiado);
                	fr.close();
                	FileWriter sw = new FileWriter(archivoA);
                	BufferedWriter dw = new BufferedWriter(sw);
                	dw.write(cambiado);
                	dw.flush();
                	sw.close();
                	
         	}
         	catch (Exception ex) {
         	   	/*Captura un posible error y le imprime en pantalla*/
         	    	System.out.println(ex.getMessage());
         	}
   	}
}
