package com.appmayuda.util.parser;

import android.os.Bundle;

import com.appmayuda.objetos.Usuario;

public class Parser {

	public static Usuario parseUsuario(Bundle bundle){
		Usuario usuario = new Usuario();
		usuario.setCodigo(bundle.getString("id_usuario"));
		usuario.setNombre(bundle.getString("nombre"));
		usuario.setApellido(bundle.getString("apellidos"));
		usuario.setTipo_usuario(bundle.getString("tipo"));
		usuario.setUsuario(bundle.getString("usuario"));
		usuario.setPass("pass");
		return usuario;
	}
	
	public static Bundle parseBundle(Usuario usuario){
		Bundle bundle = new Bundle();
		bundle.putString("id_usuario",usuario.getCodigo());
		bundle.putString("nombre", usuario.getNombre());
		bundle.putString("apellidos",usuario.getApellido());
		bundle.putString("usuario", usuario.getUsuario());
		bundle.putString("password", usuario.getPass());
		bundle.putString("tipo", usuario.getTipo_usuario());
		return bundle;
	}
}
