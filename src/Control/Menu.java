package Control;

import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Entidad.Paciente;
import Servicio.ImplFichero;
import Servicio.ImplMenu;
import Servicio.ImplPaciente;
import Servicio.IntFichero;
import Servicio.IntMenu;
import Servicio.IntPaciente;
import Servicio.Utils.Mensajes;

public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcion;
		IntFichero implFichero=new ImplFichero();
		Mensajes mensajes = new Mensajes();
		IntMenu implMenu= new ImplMenu();
		
		IntPaciente paciente = new ImplPaciente();
		
		List<Paciente> listaPaciente = new ArrayList<>();
	
		File archivo = new File("C:\\Users\\pablo\\OneDrive\\Escritorio\\Logs.txt");
		File archivoPAciente = new File("C:\\Users\\pablo\\OneDrive\\Escritorio\\BasedeDatosPacientes.txt");
		Scanner entradaOpcion = new Scanner(System.in);
		 
		try {
			do {			
				// Mostramos el menú
				implMenu.MostrarMenu();
				
				opcion = entradaOpcion.nextInt();
				System.out.println("[INFO] - Has seleccionado la opcion " + opcion);

				switch (opcion) {
				
				case 1:
					 listaPaciente = paciente.IngresarPaciente(listaPaciente, archivoPAciente.getPath().toString());
					break;
				case 2:
					listaPaciente = paciente.darDeAltaPaciente(listaPaciente, archivoPAciente);
					
					break;
				case 3:
					paciente.ListarPaciente(listaPaciente,archivoPAciente);

					break;				
				default:
				}
			}while(opcion !=0);
		} catch (InputMismatchException e) {

			implFichero.EscribirFichero(archivo.getPath(), mensajes.getFormatoERR());
		} catch (Exception e) {
			System.out.println("Se produjo un error" + e.getMessage());
		}
	}
}

