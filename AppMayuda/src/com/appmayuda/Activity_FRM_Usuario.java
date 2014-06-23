package com.appmayuda;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.appmayuda.objetos.Usuario;
import com.appmayuda.util.parser.Parser;

public class Activity_FRM_Usuario extends Activity{

	private Usuario usuario;
	private TextView tv_nombre;
	private Button btn_registrar_ticket;
	
	private void cargarControles(){
		tv_nombre = (TextView) findViewById(R.id.frm_usuario_tv_nombre);
		btn_registrar_ticket = (Button) findViewById(R.id.frm_usuario_btn_registrar_ticket);
	}
	
	private void cargarDatos(){
		tv_nombre.setText(usuario.getApellido()+" "+usuario.getNombre());
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.frm_usuario);
		
		usuario = Parser.parseUsuario(savedInstanceState);
		
		cargarControles();
		cargarDatos();
		
	}

	
	
	
	
}
