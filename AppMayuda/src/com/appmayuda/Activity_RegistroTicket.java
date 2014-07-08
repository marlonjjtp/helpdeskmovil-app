package com.appmayuda;

import java.sql.Date;
import java.util.Calendar;
import java.util.concurrent.ExecutionException;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.appmayuda.objetos.Ticket;
import com.appmayuda.puente.Puente;
import com.appmayuda.sesion.DatosSesion;
import com.appmayuda.util.parser.Parser;

public class Activity_RegistroTicket extends Activity {

	
	private EditText et_usuario,et_descripcion;
	private Puente puente;
	
	private void cargarControles(){
		et_usuario = (EditText) findViewById(R.id.frm_registrar_ticket_et_usuario);
		et_descripcion = (EditText) findViewById(R.id.frm_registrar_ticket_et_descripcion);
		puente = new Puente(this);
	}
	
	private void cargarDatos(){
		et_usuario.setText(DatosSesion.usuario.getUsuario());
	}
	
	public void registrarTicket(View view){
		Ticket ticket = new Ticket();
		Date fecha_registro =new  Date(Calendar.getInstance().getTime().getTime());
		String descripcion = et_descripcion.getText().toString();
		String usuario = et_usuario.getText().toString();
		
		ticket.setFecha_registro(fecha_registro);
		ticket.setDescripcion(descripcion);
		ticket.setNombre_usuario_solicitante(usuario);
		ticket.setCod_usuario_registro(DatosSesion.usuario.getCodigo());
		boolean exito=false;
		try {
			exito =puente.registrarTicket(ticket,this);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (exito){
			Toast.makeText(this,"Ticket registrado", Toast.LENGTH_SHORT).show();
			finish();
		}else{
			Toast.makeText(this,"Error, el ticket no ha sido registrado", Toast.LENGTH_SHORT).show();
		}
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.frm_registrar_ticket);
		cargarControles();
		cargarDatos();
	}
}
