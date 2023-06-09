package Servicio;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import Entidad.Paciente;

public interface IntPaciente {

	public List<Paciente> IngresarPaciente(List<Paciente> listaPaciente,String ruta);
	public List<Paciente> darDeAltaPaciente(List<Paciente> listaPaciente, File archivo);
	public void ListarPaciente(List<Paciente> listaPaciente, File archivo);

}
