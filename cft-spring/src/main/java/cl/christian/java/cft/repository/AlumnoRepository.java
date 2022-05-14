package cl.christian.java.cft.repository;

import java.util.List;

import cl.christian.java.cft.modelo.Alumno;

public interface AlumnoRepository {

	public List<Alumno> findAll();
	
	public Alumno findById();
	
	public void create(Alumno alumno);
	
	public void delete(int id);

	Alumno findById(int id);

	void edit(Alumno alumno);
}
