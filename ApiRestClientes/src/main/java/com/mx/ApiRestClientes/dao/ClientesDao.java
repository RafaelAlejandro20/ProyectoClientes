package com.mx.ApiRestClientes.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.mx.ApiRestClientes.model.Clientes;

public interface ClientesDao extends JpaRepository<Clientes, Integer>{
	@Transactional
	@Query(value = "SELECT * FROM CLIENTES_SOLTE WHERE NOMBRE_COMPLETO=:NOMBRE", nativeQuery = true)
	public List<Clientes> buscarXnombre(@Param("NOMBRE") String nombre);
	
	@Transactional
	@Modifying
	@Query(value = "INSERT INTO CLIENTES_SOLTE VALUES(?1,?2,?3,?4,?5)", nativeQuery = true)
	public void guardar(Integer id, String nombre, String puesto,Float salario, Date fecha);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE CLIENTES_SOLTE SET NOMBRE_COMPLETO = ?1, PUESTO = ?2, SALARIO = ?3, FECHA_ENTRADA = ?4 WHERE ID = ?5", nativeQuery = true)
	public void editar(String nombre, String puesto,Float salario, Date fecha, Integer id);
}
