package com.example.demo.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.IVehiculoService;
import com.example.demo.service.to.VehiculoTo;

@RestController
@RequestMapping("/vehiculos")
@CrossOrigin
public class VehiculoControllerResFul {
	
	@Autowired
	private IVehiculoService vehiculoService;
	
	@GetMapping(path = "/{placa}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VehiculoTo> buscarPorPlaca(@PathVariable String placa) {
		
		VehiculoTo vehi = this.vehiculoService.BuscarPorPlaca(placa);
		
		Link myLink = linkTo(methodOn(VehiculoControllerResFul.class).buscarPorPlaca(vehi.getPlaca())).withSelfRel();
		vehi.add(myLink);
		
		return new ResponseEntity<>(vehi, null, 200);
	}
	
	
	@GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<VehiculoTo>> buscarTodo() {
		List<VehiculoTo> lista = this.vehiculoService.BuscarTodo();
		
		for (VehiculoTo vehi : lista) {
			Link myLink = linkTo(methodOn(VehiculoControllerResFul.class).buscarPorPlaca(vehi.getPlaca())).withRel("informacion");
			vehi.add(myLink);
		}

		
		return new ResponseEntity<>(lista, null, 200);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*insertar -> @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	buscar -> @GetMapping(path = "/{cedula}", produces = MediaType.APPLICATION_JSON_VALUE)
	actualizar -> @PutMapping(path = "/{identificador}")
	actualizar parcial -> @PatchMapping(path = "/{identificador}")
	eliminar -> @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)


	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<PacienteTo> guardar(@RequestBody Paciente paciente) {

			HttpHeaders cabeceras = new HttpHeaders();
			cabeceras.add("detalleMensaje", "Paciente insertado exitosamente");

			this.pacienteService.guardar(paciente);

			PacienteTo paci = this.pacienteService.buscarPorCedula(paciente.getCedula());
			
			Link myLink = linkTo(methodOn(PacienteControllerResFul.class).buscarPorCedula(paciente.getCedula())).withSelfRel();
			paci.add(myLink);

			return new ResponseEntity<>(paci, cabeceras, 200);

		}



	siempre devolver ResponEntity

		public ResponseEntity<List<Estudiante>> consultarTodos(@RequestParam String provincia) {
			//buscarTodos?provincia=pichincha
			
			HttpHeaders cabeceras = new HttpHeaders();
			cabeceras.add("detalleMensaje", "Ciudadanos consultados exitosamente");
			cabeceras.add("valorAPI", "Incalculable");
			
			return new ResponseEntity<>(this.estudianteService.buscarTodos(provincia),cabeceras,228);
		}*/

}
