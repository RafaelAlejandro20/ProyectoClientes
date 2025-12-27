package com.mx.ApiRestClientes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.ApiRestClientes.dao.ClientesDao;
import com.mx.ApiRestClientes.model.Clientes;

@Service
public class ClientesServImp implements ClientesServ{
	
	@Autowired
	ClientesDao clientesDao;

	@Override
	public Clientes buscar(Integer id) {
		return clientesDao.findById(id).orElse(null);
	}

	@Transactional
	@Override
	public boolean eliminar(Integer idCliente) {
		if(buscar(idCliente) == null)
			return false;
		else {
			clientesDao.deleteById(idCliente);
			return true;
		}
	}
	
	public String guardar(Clientes cli) {
		if(buscar(cli.getIdCliente()) == null) {
			clientesDao.guardar(cli.getIdCliente(),cli.getNombreCompleto(),cli.getPuesto(),cli.getSalario(),cli.getFechaEntrada());
			return "GUARDADO";
		}else {
			return "NO GUARDADO";
		}
	}
	
	public String editar(Clientes cli) {
		if(buscar(cli.getIdCliente()) == null)
			return "NO EDITADO";
		else {
			clientesDao.editar(cli.getNombreCompleto(),cli.getPuesto(),cli.getSalario(),cli.getFechaEntrada(),cli.getIdCliente());
			return "EDITADO";
		}
	}
	
	@Transactional(readOnly = true)
	public List<Clientes> buscarXnombre(String nombre) {
		return clientesDao.buscarXnombre(nombre);
	}
}
