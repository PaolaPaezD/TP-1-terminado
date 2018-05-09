
/*import java.util.ArrayList;
import java.util.List;


import javax.swing.JOptionPane;

public class Agenda {
	
	
	public  void ListarContacto() {
		List <String> ListaAgenda= new ArrayList <String>();
		Contacto myClase=new Contacto();
		String hola=myClase.AgregarContacto();
		ListaAgenda.add(hola);
		for(int i=0; i< ListaAgenda.size()-1;i++) {
		System.out.println(ListaAgenda.get(i));
	}
	}
	



}*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Agenda {
	private final ArrayList<Contacto> datos;

	public Agenda() {
		datos = new ArrayList();
	}

	public void AgregarContacto() {
		String name, paterno, telefono, mail;

		// for (int i = 0; i < datos.size(); i++) {
		Scanner input = new Scanner(System.in);
		System.out.println("Por favor introduce un Nombre: ");
		name = input.nextLine();
		System.out.println("Introduce el apellido Paterno: ");
		paterno = input.nextLine();
		System.out.println("Introduce el telefono: ");
		telefono = input.nextLine();
		System.out.println("Introduce el mail: ");
		mail = input.nextLine();

		Contacto c = new Contacto(name, paterno, telefono, mail);

		if (contactoExiste(c)) {
			System.out.println("Repetido");
		} else {
			datos.add(c);
		}

	}

	public boolean contactoExiste(Contacto c) {
		for (Contacto contacto : datos) {
			if (contacto.getNombre().equals(c.getNombre())) {

				return true;
			}
		}

		return false;

	}

	public void ListarContacto() {

		for (Contacto contacto : datos) {
			System.out.println(contacto);

		}
	}

	public Contacto buscarContacto(String name) {

		for (Contacto a : datos) {
			if (name.equals(a.getNombre())) {
				System.out.println("existe");
				return a;
			}
		}
		System.out.println("Persona no encontrada\n");
		return null;
	}

	public Contacto BuscarContactoporTelefono(String telefono) {

		for (Contacto a : datos) {

			if (telefono.equals(a.gettelefono())) {
				System.out.println("existe");
				return a;
		}
			
	}
		System.out.println("Telefono no encontrado\n");
		return null;
	}

	public void allPeople() {
		for (Contacto a : datos) {
			System.out.println(a.toString());
		}
	}

	public void eliminarContacto(String name) {
		for (Contacto a : datos) {
			if (name.equals(a.getNombre()))
				a.toString();
			int idx = datos.indexOf(a);
			datos.remove(idx);
		}
		System.out.println("No se encontro el contacto");
	}

	public void guardarContacto() {
		try {
			String lugar = JOptionPane.showInputDialog("\n Ingrese la direccion del archivo ");
			BufferedWriter out = new BufferedWriter(new FileWriter(new File(lugar)));
			for (int i = 0; i < datos.size(); i++) {
				out.write(datos.get(i).getNombre() + "\n ");
				out.write(datos.get(i).getApellidoPaterno() + "\n ");
				out.write(datos.get(i).gettelefono() + "\n ");
				out.write(datos.get(i).getmail() + "\n ");
			}
			out.close();

		} catch (Exception e) {
			e.printStackTrace();
			return;

		}
	}

	public void CargarContacto(String lugar) {

		try {
			BufferedReader in = new BufferedReader(new FileReader(new File(lugar)));
			while (in.ready()) {

				String name = in.readLine();
				String paterno = in.readLine();
				String telefono = in.readLine();
				String mail = in.readLine();

				Contacto c = new Contacto(name, paterno, telefono, mail);

				datos.add(c);
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
			return;

		}

	}

}
