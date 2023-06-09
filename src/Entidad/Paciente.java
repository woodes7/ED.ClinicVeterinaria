package Entidad;

public class Paciente {
	//Atributos
	private String nombre;
	private String telefono;	
	private String fechaIngreso;
	private String fechaAlta;
	//Constructor
	public Paciente( String nombre, String telefono, String fechaIngreso, String fechaAlta) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;		
		this.fechaIngreso = fechaIngreso;
		this.fechaAlta = fechaAlta;
	}
	public Paciente() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//Getters && Setters
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public String getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	
	@Override
	public String toString() {
		return "Paciente [nombre=" + nombre + ", telefono=" + telefono + ", fechaIngreso=" + fechaIngreso
				+ ", fechaAlta=" + fechaAlta + "]";
	}

	
	
}
