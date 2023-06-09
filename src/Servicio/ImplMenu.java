package Servicio;

public class ImplMenu implements IntMenu {

	@Override
	public void MostrarMenu() {
		
		System.out.println("---------Menu--------------");
		System.out.println("1. Ingresar nuevo paciente");
		System.out.println("2. Dar Alta Paciente");
		System.out.println("3. Listar Paciente");

	}

	
}
