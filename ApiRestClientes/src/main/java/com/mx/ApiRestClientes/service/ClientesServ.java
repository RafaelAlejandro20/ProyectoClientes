package com.mx.ApiRestClientes.service;

import com.mx.ApiRestClientes.model.Clientes;

public interface ClientesServ {	
	public Clientes buscar(Integer id);
	
	public boolean eliminar(Integer idCliente);
}
