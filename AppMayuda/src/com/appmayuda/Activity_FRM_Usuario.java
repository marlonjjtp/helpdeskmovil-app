package com.appmayuda;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.appmayuda.objetos.Usuario;
import com.appmayuda.sesion.DatosSesion;

public class Activity_FRM_Usuario extends Activity{

	private Usuario usuario;
	private TextView tv_nombre;
	private Button btn_registrar_ticket;
	
	public void registrarTicket(View view){
		Intent intent = new Intent(this,Activity_RegistroTicket.class);
		startActivityForResult(intent,1);
	}
	
	private void cargarControles(){
		tv_nombre = (TextView) findViewById(R.id.frm_usuario_tv_nombre);
		btn_registrar_ticket = (Button) findViewById(R.id.frm_usuario_btn_registrar_ticket);
	}
	
	private void cargarDatos(){
		tv_nombre.setText(usuario.getApellido()+" "+usuario.getNombre());
		//tv_nombre.setText(usuario.getUsuario());
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.frm_usuario);
		
		usuario = DatosSesion.usuario;
		cargarControles();
		cargarDatos();
		
	}

	
	
	
	
}
