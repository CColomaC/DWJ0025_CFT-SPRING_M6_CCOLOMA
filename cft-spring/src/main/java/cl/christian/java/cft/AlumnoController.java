package cl.christian.java.cft;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cl.christian.java.cft.modelo.Alumno;
import cl.christian.java.cft.modelo.Carrera;
import cl.christian.java.cft.repository.AlumnoRepository;
import cl.christian.java.cft.repository.CarreraRepository;

	@Controller
	@RequestMapping("/alumno") // prefijo de las rutas
	public class AlumnoController {
	
	@Autowired
	AlumnoRepository alumnoRepository;
	
	@Autowired
	CarreraRepository carreraRepository;
	
	@GetMapping("/nuevo")
	public String alumnoNuevo(Alumno alumno, Model modelo) {
		List<Carrera> carreras = carreraRepository.findAll();
		modelo.addAttribute("carreras", carreras);
		return "alumno/form";
	}
	
	@GetMapping("/editar/{alumnoId}") // http://localhost/alumno/editar/5
	public String alumnoEditar(@PathVariable int alumnoId, Model modelo) {
	Alumno alumno = alumnoRepository.findById(alumnoId);
	modelo.addAttribute("alumno", alumno);
	List<Carrera> carreras = carreraRepository.findAll();
	modelo.addAttribute("carreras", carreras);
	return "alumno/form";
	}
	
	@GetMapping("/eliminar/{alumnoId}")
	public String eliminar(@RequestParam(name="id", required = true) int id) {
		alumnoRepository.delete(id);
		return "redirect:/alumno/listado";
	}
	
	@GetMapping("/listado")
	public String listar(Model modelo) {
		List<Alumno> alumnos = alumnoRepository.findAll();
		modelo.addAttribute("alumnos", alumnos);
		return "alumno/listado";
	}
	
	@PostMapping("/procesar")
	public String alumnoProcesar(@Valid Alumno alumno, BindingResult informeValidacion) {
		if( informeValidacion.hasErrors() ) {
			return "alumno/form"; // si hubieron errores, vuelvo a la vista del form
		}
	
		if( alumno.getId() == 0) {
			alumnoRepository.create(alumno);
		} else {
			alumnoRepository.edit(alumno);
		}
		return "redirect:/alumno/listado";
	}

}
