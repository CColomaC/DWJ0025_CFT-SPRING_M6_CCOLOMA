package cl.christian.java.cft.repository;

import java.util.List;

import cl.christian.java.cft.modelo.Carrera;

public interface CarreraRepository {

	public List<Carrera> findAll();
	
	public Carrera findById();
	
	public void create(Carrera carrera);
	
	public void delete(int id);

	Carrera findById(int id);

	void edit(Carrera carrera);
}

