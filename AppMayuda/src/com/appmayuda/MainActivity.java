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
		String respuesta = obj.loguearse(us, this);
		if(respuesta.equals("falso")){
			Toast.makeText(this, "Usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show();
		}else{
			
		}
		
	}

}
