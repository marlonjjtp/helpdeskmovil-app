package com.appmayuda;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.appmayuda.objetos.Usuario;
import com.appmayuda.util.parser.Parser;

public class Activity_RegistroTicket extends Activity {

	
	private EditText et_usuario,et_descripcion;
	
	private Usuario usuario;
	
	private void cargarControles(){
		et_usuario = (EditText) findViewById(R.id.frm_registrar_ticket_et_usuario);
		et_descripcion = (EditText) findViewById(R.id.frm_registrar_ticket_et_descripcion);
 	}
	
	public void registrar(View view){
		
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.frm_registrar_ticket);
		usuario = Parser.parseUsuario(savedInstanceState);
		cargarControles();
	}
		
}
