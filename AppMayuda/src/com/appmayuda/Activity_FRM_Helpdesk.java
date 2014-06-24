package com.appmayuda;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.appmayuda.objetos.Usuario;
import com.appmayuda.util.adaptador.AdaptadorTicket;
import com.appmayuda.util.parser.Parser;

public class Activity_FRM_Helpdesk extends Activity {

	
	private ListView lv_tickets;
	private AdaptadorTicket adapter_ticket;
	private Usuario usuario;
	
	private void cargarControles(){
		lv_tickets = (ListView) findViewById(R.id.frm_helpdesk_lv_tickets);;
	}
	
	private void cargarDatos(){
		
	}
	
	private void mostrarDatos(){
		
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.frm_helpdesk);
		
		usuario = Parser.parseUsuario(savedInstanceState);
		
		cargarControles();
		cargarDatos();
		
		
	}

	
	
	
}
