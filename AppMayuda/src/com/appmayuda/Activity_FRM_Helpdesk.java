package com.appmayuda;

import java.util.concurrent.ExecutionException;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.appmayuda.objetos.Usuario;
import com.appmayuda.puente.Puente;
import com.appmayuda.util.adaptador.AdaptadorTicket;
import com.appmayuda.util.parser.Parser;

public class Activity_FRM_Helpdesk extends Activity {

	
	private ListView lv_tickets;
	private AdaptadorTicket adapter_ticket;
	private Usuario usuario;
	
	private Puente puente;
	
	private void cargarControles(){
		lv_tickets = (ListView) findViewById(R.id.frm_helpdesk_lv_tickets);;
		puente = new Puente(this);
	}
	
	private void cargarLista(){
		ClaseGlobalURL global = (ClaseGlobalURL) getApplication();
		String url = global.getUrl_mostrarTickets_HelpDesk();
		try {
			adapter_ticket = new AdaptadorTicket(puente.listaTicketsHelpDesk(url));
			lv_tickets.setAdapter(adapter_ticket);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.frm_helpdesk);
		
		//usuario = Parser.parseUsuario(savedInstanceState);
		
		cargarControles();
		cargarLista();		
	}

	
	
	
}
