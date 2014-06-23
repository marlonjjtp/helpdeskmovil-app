package com.appmayuda.objetos;

public class Usuario {

	private String nombre;
	private String apellido;
	
	private String codigo;
	private String usuario;
	private String pass;
	private boolean estado;
	private String tipo_usuario;

	public Usuario() {
	}
	

	public boolean isEstado() {
		return estado;
	}

	
	
	public String getNombre() {
		return nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getTipo_usuario() {
		return tipo_usuario;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setTipo_usuario(String tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
