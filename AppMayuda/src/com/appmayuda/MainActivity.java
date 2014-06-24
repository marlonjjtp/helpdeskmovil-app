package com.appmayuda;

import com.appmayuda.objetos.Usuario;
import com.appmayuda.puente.Puente;
import com.appmayuda.util.parser.Parser;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
		Intent intent = new Intent();
		Bundle bundle = Parser.parseBundle(usuario);
//		bundle.putString("id_usuario",usuario.getCodigo());
//		bundle.putString("nombre", usuario.getNombre());
//		bundle.putString("apellidos",usuario.getApellido());
//		bundle.putString("usuario", usuario.getUsuario());
//		bundle.putString("password", usuario.getPass());
//		bundle.putString("tipo", usuario.getTipo_usuario());
		
		if (usuario.getTipo_usuario().equals("HELPDESK")){
			intent.setClass(this,Activity_FRM_Helpdesk.class);
		}else if (usuario.getTipo_usuario().equals("USUARIO")){
			intent.setClass(this,Activity_FRM_Usuario.class);
		}else if (usuario.getTipo_usuario().equals("AVANZADO")){
			
		}else if (usuario.getTipo_usuario().equals("ADMINISTRADOR")){
			
		}
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
		//return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.main_to_frm_usuario:
			startActivity(new Intent(this,Activity_FRM_Usuario.class));
			return true;
		case R.id.main_to_helpdesk:
			startActivity(new Intent(this,Activity_FRM_Helpdesk.class));
			return true;
		default:
			return true;
		}
		//return super.onOptionsItemSelected(item);
	}

	
	
	
}
