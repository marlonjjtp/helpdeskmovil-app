package com.appmayuda.objetos;

import java.sql.Date;

import com.appmayuda.util.Hora;

public class Ticket {

	private int numero;
	private Date fecha_registro;
	private Hora hora_registro;
	private String prioridad;
	private String estado;
	private String descripcion;
	private Date aten_fecha_inicio;
	private Hora aten_hora_inicio;
	private Date aten_fecha_fin;
	private Hora aten_hora_fin;
	private String aten_detalle;
	private String cod_usuario_registro;
	private String nombre_usuario_solicitante;
	private String cod_usuario_atencion;
	private String nombre_usuario_atencion;

	public Ticket() {

	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Date getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public Hora getHora_registro() {
		return hora_registro;
	}

	public void setHora_registro(Hora hora_registro) {
		this.hora_registro = hora_registro;
	}

	public String getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getAten_fecha_inicio() {
		return aten_fecha_inicio;
	}

	public void setAten_fecha_inicio(Date aten_fecha_inicio) {
		this.aten_fecha_inicio = aten_fecha_inicio;
	}

	public Hora getAten_hora_inicio() {
		return aten_hora_inicio;
	}

	public void setAten_hora_inicio(Hora aten_hora_inicio) {
		this.aten_hora_inicio = aten_hora_inicio;
	}

	public Date getAten_fecha_fin() {
		return aten_fecha_fin;
	}

	public void setAten_fecha_fin(Date aten_fecha_fin) {
		this.aten_fecha_fin = aten_fecha_fin;
	}

	public Hora getAten_hora_fin() {
		return aten_hora_fin;
	}

	public void setAten_hora_fin(Hora aten_hora_fin) {
		this.aten_hora_fin = aten_hora_fin;
	}

	public String getAten_detalle() {
		return aten_detalle;
	}

	public void setAten_detalle(String aten_detalle) {
		this.aten_detalle = aten_detalle;
	}

	public String getCod_usuario_registro() {
		return cod_usuario_registro;
	}

	public void setCod_usuario_registro(String cod_usuario_registro) {
		this.cod_usuario_registro = cod_usuario_registro;
	}

	public String getNombre_usuario_solicitante() {
		return nombre_usuario_solicitante;
	}

	public void setNombre_usuario_solicitante(String nombre_usuario_solicitante) {
		this.nombre_usuario_solicitante = nombre_usuario_solicitante;
	}

	public String getCod_usuario_atencion() {
		return cod_usuario_atencion;
	}

	public void setCod_usuario_atencion(String cod_usuario_atencion) {
		this.cod_usuario_atencion = cod_usuario_atencion;
	}

	public String getNombre_usuario_atencion() {
		return nombre_usuario_atencion;
	}

	public void setNombre_usuario_atencion(String nombre_usuario_atencion) {
		this.nombre_usuario_atencion = nombre_usuario_atencion;
	}

}
