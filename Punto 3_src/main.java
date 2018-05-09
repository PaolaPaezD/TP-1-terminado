import java.util.Scanner;

import javax.swing.JOptionPane;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcion = seleccionarOpcion();
		Agenda Agenda1=new Agenda();
		while (opcion != 0) {
			EjecutarOpcion(opcion, Agenda1);
			opcion = seleccionarOpcion();
			
		}
		
	}

	private static void EjecutarOpcion(int opcion, Agenda agenda1) {
		// TODO Auto-generated method stub
		
		
		switch (opcion) {
		case 1:
			agenda1.AgregarContacto();

			break;
		case 2:
			agenda1.ListarContacto();
			break;
		case 3:
			String contacto=JOptionPane.showInputDialog("\n Ingrese el nombre a comparar: ");
			agenda1.buscarContacto(contacto);
			break;
		case 4:
			String contactodos=JOptionPane.showInputDialog("\n Ingrese el telefono a comparar: ");
			agenda1.BuscarContactoporTelefono(contactodos);
			break;
		case 5:
			String name;
			Scanner input = new Scanner(System.in);
			System.out.println("Por favor introduce el Nombre: ");
			name = input.nextLine();
			agenda1.eliminarContacto(name);
			
			break;
		case 6:
			agenda1.guardarContacto();
			break;
		case 7:
			String lugar=(JOptionPane.showInputDialog("\n Ingrese el lugar desde donde desea cargar el archivo"));
			agenda1.CargarContacto(lugar);
			
			break;
		default:
			break;
		}

	}
	

	private static int seleccionarOpcion() {
		// TODO Auto-generated method stub
		
		int opcio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la opcion que desee: "+"\n 1-Agregar contacto  "+ "\n 2-Listar la agenda  "+" \n 3-Buscar contacto por nombre "+"\n 4-Buscar por numero "+"\n 5 -Eliminar "+"\n 6-Guardar en archivo "+"\n 7-Cargar "+"\n 0-Salir"));
		return opcio;
	}

}