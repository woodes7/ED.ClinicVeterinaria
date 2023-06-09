package Servicio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import Entidad.Paciente;
import Servicio.Utils.Mensajes;

public class ImplPaciente implements IntPaciente {
	IntFichero implFichero = new ImplFichero();

	private Mensajes mensajes;

	public void listaPaciente(Mensajes mensajes) {
		this.mensajes = mensajes;
	}

	public List<Paciente> IngresarPaciente(List<Paciente> listaPaciente, String ruta) {

		try {
			// TODO Auto-generated method stub
			Scanner entradaValor = new Scanner(System.in);

			System.out.println("Ingresa nuevo Paciente");
			System.out.println("Dime el nombre del Paciente: ");
			String nombre = entradaValor.next();
			System.out.println("Dime el telefono del Paciente: ");
			String telefono = entradaValor.next();

			String fechaIngreso = DateTimeFormatter.ofPattern("dd MMM yyyy, hh:mm:ss a").format(LocalDateTime.now());
			String fechaAlta = "-------";
			Paciente paciente = new Paciente(nombre, telefono, fechaIngreso, fechaAlta);

			listaPaciente.add(paciente);

			return listaPaciente;
		} catch (InputMismatchException e) {
			LocalDateTime fechaHoraActual = LocalDateTime.now();
			implFichero.EscribirFichero(ruta, mensajes.getFormatoERR());
			return listaPaciente;
		} catch (Exception e) {
			System.out.println("Se produjo un error" + e.getMessage());
			return listaPaciente;
		}
	}

	@Override
	public void ListarPaciente(List<Paciente> listaPaciente, File archivo) {
		// TODO Auto-generated method stub

		try {
			if (!listaPaciente.isEmpty()) {

				for (int i = 0; i < listaPaciente.size(); i++) {
					System.out.println(listaPaciente.get(i).toString());

				}
				implFichero.escribirEnArchivoPaciente(listaPaciente, archivo.getPath());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();

		}
	}

	public List<Paciente> leerPacientesDeArchivo(String rutaArchivo) {
		List<Paciente> pacientes = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] datos = linea.split(";");
				if (datos.length == 4) {
					String telefono = datos[0];
					String nombre = datos[1];
					String fechaIngreso = datos[2];
					String fechaAlta = datos[3];

					Paciente paciente = new Paciente(telefono, nombre, fechaIngreso, fechaAlta);
					pacientes.add(paciente);
				}
			}
			System.out.println("Pacientes leídos del archivo correctamente.");
		} catch (IOException e) {
			System.out.println("Error al leer los pacientes del archivo: " + e.getMessage());
		}

		return pacientes;
	}

	@Override
	public List<Paciente> darDeAltaPaciente(List<Paciente> listaPaciente, File archivo){
			Scanner entradavalores = new Scanner(System.in);
		try {			
			Paciente paciente = new Paciente();			
			System.out.println("Dime el numero de telefono para buscar el paciente: ");
	
			String telefono = entradavalores.next();
			
			for (int i = 0; i < listaPaciente.size(); i++) {
				if(telefono.equals(listaPaciente.get(i).getTelefono())){
					String fechaAlta = DateTimeFormatter.ofPattern("dd MMM yyyy, hh:mm:ss a").format(LocalDateTime.now());
					
					System.out.println("Esta es la fecha de alta quiere Modificarla (para S=sí , N=no");
					System.out.println(fechaAlta);		
					String opcion= entradavalores.next();	
								
					
					if(opcion.equalsIgnoreCase(opcion="S"))				
						fechaAlta= entradavalores.next();
					
					listaPaciente.get(i).setFechaAlta(fechaAlta);
					implFichero.escribirEnArchivoPaciente( listaPaciente,archivo.getPath());
				}
			implFichero.escribirEnArchivoPaciente( listaPaciente,archivo.getPath());	
			}							
		} catch (Exception  e) {
			System.out.println("Se produjo un error" + e.getMessage());
			implFichero.EscribirFichero(null, mensajes.getFormatoERR());
			return listaPaciente;
		}
		return listaPaciente;
}
}