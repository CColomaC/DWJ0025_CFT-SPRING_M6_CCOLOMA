package cl.christian.java.cft.modelo;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Carrera {

	@Min(0)
	private int id;
	@Size(min=8, max=100)
	private String nombre;
	@Size(min=8, max=100)
	private String descripcion;
	
	public Carrera() {
		super();
	}

	public Carrera(int id, String nombre, String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}