package com.mx.ApiRestClientes.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CLIENTES_SOLTE")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Clientes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", columnDefinition = "INT", nullable = false)
	private Integer idCliente;
	
	@Column(name = "NOMBRE_COMPLETO", columnDefinition = "VARFCHAR2(100)", nullable = false)
	private String nombreCompleto;
	
	@Column(name = "PUESTO", columnDefinition = "VARCHAR2(100)", nullable = false)
	private String puesto;
	
	@Column(name = "SALARIO", columnDefinition = "NUMBER(8,2)", nullable = false)
	private Float salario;
	
	@Column(name = "FECHA_ENTRADA", columnDefinition = "DATE", nullable = false)
	private Date fechaEntrada;
}
