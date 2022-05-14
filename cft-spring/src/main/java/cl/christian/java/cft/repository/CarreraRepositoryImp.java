package cl.christian.java.cft.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cl.christian.java.cft.modelo.Carrera;

@Repository
public class CarreraRepositoryImp implements CarreraRepository{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private Carrera makeObject(ResultSet rs, int filaNum) throws SQLException {
		int id = rs.getInt("id");
		String nombre = rs.getString("nombre");
		String descripcion = rs.getString("descripcion");
		return new Carrera(id, nombre, descripcion);
		}

	@Override
	public List<Carrera> findAll() {
		String sql = "SELECT * FROM carreras3";
		return jdbcTemplate.query(sql, this::makeObject);
	}

	@Override
	public Carrera findById(int id) {
		String sql = "SELECT * from carreras3 WHERE id=?";
		return jdbcTemplate.queryForObject(sql, this::makeObject, id);
	}

	@Override
	public void create(Carrera carrera) {
		String sql = "INSERT INTO carreras3(nombre, descripcion) VALUES(?, ?)";
		jdbcTemplate.update(sql, carrera.getNombre(), carrera.getDescripcion() );
	}
	
	@Override
	public void edit(Carrera carrera) {
		String sql = "UPDATE carreras3 SET nombre = ?, descripcion = ? WHERE id = ?";
		jdbcTemplate.update(
		sql,
		carrera.getNombre(),
		carrera.getDescripcion(),
		carrera.getId()
		);
	}

	@Override
	public void delete(int id) {
	String sql = "DELETE FROM carreras3 WHERE id = ?";
	jdbcTemplate.update(sql, id );
	}

	@Override
	public Carrera findById() {
		return null;
	}

}
