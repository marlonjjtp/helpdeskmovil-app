package com.appmayuda;

import java.util.concurrent.ExecutionException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.appmayuda.objetos.Ticket;
import com.appmayuda.objetos.Usuario;
import com.appmayuda.puente.Puente;
import com.appmayuda.sesion.DatosSesion;
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
			
			lv_tickets.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					cargarActivityDetalle(position);				
				}
			});
			
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	private void cargarActivityDetalle(int numero_ticket){
//		Intent intent = new Intent(this,Activity_TicketDetalle.class);
//		Bundle bundle = Parser.parseBundle();
//		startActivityForResult(intent, 1);
//	}
	
	private void cargarActivityDetalle(int posicion){
		System.out.println("iniciando cargarActivityDetalle() "+posicion);
		Intent intent = new Intent(Activity_FRM_Helpdesk.this,Activity_TicketDetalle.class);
		Ticket ticket = (Ticket) lv_tickets.getItemAtPosition(posicion);
//		Bundle bundle = Parser.parseBundle((Ticket) lv_tickets.getItemAtPosition(posicion));
//		intent.putExtra("ticket",bundle);
		DatosSesion.ticket = ticket;
		startActivityForResult(intent, 1);
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
