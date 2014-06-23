package com.appmayuda;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity_ConfigURL extends Activity {

	
	private Button btn_cambiar;
	private EditText et_url;
	
	
	public void CambiarURL(View v){
		int ip = Integer.parseInt(et_url.getText().toString());
		cambiarURL(ip);
	}
	
	private void cambiarURL(int nuevaip){
		String nuevaurl = "http://"+nuevaip;
		ClaseGlobalURL global = (ClaseGlobalURL) getApplication();
		global.setUrl(nuevaurl);
	}

	private void cargarDatos(){
		ClaseGlobalURL global = (ClaseGlobalURL) getApplication();
		String url = global.getUrl();
		int index = url.lastIndexOf("//");
		int ip = Integer.parseInt(url.substring(index));
		et_url.setText(ip+"");
		System.out.println("ip >"+ip);
	}
	
	private void cargarControles(){
		btn_cambiar = (Button) findViewById(R.id.form_configurl_btn_cambiar);
		et_url = (EditText) findViewById(R.id.form_configurl_et_url);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.form_configurl);
		cargarControles();
	}
	
	
	
	
}
