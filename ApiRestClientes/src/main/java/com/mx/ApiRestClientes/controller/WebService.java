package com.mx.ApiRestClientes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.ApiRestClientes.model.Clientes;
import com.mx.ApiRestClientes.service.ClientesServImp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping(path = "gs/clientes")
@CrossOrigin
public class WebService {
	@Autowired
	ClientesServImp imp;
	
	@GetMapping("prueba")
	public void prueba() {
		System.out.println("gatos");
	}
	
	@PostMapping("crear")
	public ResponseEntity<?> guardar(@RequestBody Clientes cli) {
		String response = imp.guardar(cli);
		return new ResponseEntity<String>("REGISTRO " + response,HttpStatus.OK);
	}
	
	@GetMapping(path = "{id}")
	public ResponseEntity<?> buscar(@PathVariable("id") Integer idCliente) {
		if(imp.buscar(idCliente)==null)
			return new ResponseEntity<String>("NO EXISTE ESE CLIENTE",HttpStatus.OK);
		else
			return new ResponseEntity<Clientes>(imp.buscar(idCliente),HttpStatus.OK);
	}
	
	@PutMapping(path = "modificar")
	public ResponseEntity<?> modificar(@RequestBody Clientes cli) {
		String response = imp.editar(cli);
		return new ResponseEntity<String>("REGISTRO " + response,HttpStatus.OK);
	}
	
	@DeleteMapping(path = "borrar")
	public ResponseEntity<?> eliminar(@RequestBody Clientes cli) {
		boolean response = imp.eliminar(cli.getIdCliente());
		if(response)
			return new ResponseEntity<String>("REGISTRO ELIMINADO",HttpStatus.OK);
		else
			return new ResponseEntity<String>("REGISTRO NO ELIMINADO",HttpStatus.OK);
	}
	
	@GetMapping(path = "buscar/{nombre}")
	public ResponseEntity<?> buscarXnombre(@PathVariable("nombre") String nombre) {
		return new ResponseEntity<List<Clientes>>(imp.buscarXnombre(nombre),HttpStatus.OK);
	}
}
