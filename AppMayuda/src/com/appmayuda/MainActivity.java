package com.appmayuda;

import com.appmayuda.objetos.Usuario;
import com.appmayuda.puente.Puente;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	private EditText txt_usuario, txt_password;
	Usuario us = new Usuario();
	Puente obj =  new Puente(this);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_main);
		
		txt_usuario = (EditText) findViewById(R.id.txt_usuario);
		txt_password = (EditText) findViewById(R.id.txt_pasword);

	}
	
	public void loguearse(View v){
		String usuario = txt_usuario.getText().toString().toUpperCase();
		String pass = txt_password.getText().toString();
		us.setPass(pass);
		us.setUsuario(usuario);
		Usuario nus = obj.loguarse(us,this);
		if (nus!=null){
			Toast.makeText(this,"acceso permitido", Toast.LENGTH_SHORT).show();
			loginPermitido(nus);
		}else {
			Toast.makeText(this,"usuario/contraseña incorrecto", Toast.LENGTH_SHORT).show();
		}
		
	}
	
	/**
	 * Compara el tipo de usario e inicia el activity que le corresponde
	 * @param usuario
	 */
	private void loginPermitido(Usuario usuario) {
		Intent intent = null;
		if (usuario.getTipo_usuario().equals("HELPDESK")){
			
		}else if (usuario.getTipo_usuario().equals("USUARIO")){
			
		}else if (usuario.getTipo_usuario().equals("AVANZADO")){
			
		}else if (usuario.getTipo_usuario().equals("ADMINISTRADOR")){
			
		}
		startActivity(intent);
	}

}
