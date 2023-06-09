package Servicio;

import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Objects;

import Entidad.Paciente;

public interface IntFichero {
	
	public void EscribirFichero(String ruta, String mensaje);
	public void escribirEnArchivoPaciente(List<Paciente> listaPaciente, String rutaArchivo);
}
