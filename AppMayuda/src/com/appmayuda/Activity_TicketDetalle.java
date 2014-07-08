package com.appmayuda;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

import com.appmayuda.objetos.Ticket;
import com.appmayuda.util.parser.Parser;

public class Activity_TicketDetalle extends Activity {

	private Ticket ticket;
	
	private EditText et_numer_ticket, et_prioridad, et_estado, et_fecha, et_tecnico, et_descripcion;
	
	private void cargarControles(){
		et_numer_ticket = (EditText) findViewById(R.id.frm_ticket_detalle_et_numero_ticket);
		et_prioridad = (EditText) findViewById(R.id.frm_ticket_detalle_et_priodad);
		et_estado = (EditText) findViewById(R.id.frm_ticket_detalle_et_estado);
		et_fecha = (EditText) findViewById(R.id.frm_ticket_detalle_et_fecha);
		et_tecnico = (EditText) findViewById(R.id.frm_ticket_detalle_et_tecnico);
		et_descripcion = (EditText) findViewById(R.id.frm_ticket_detalle_et_descripcion);
	}
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.frm_ticket_detalle);
		cargarControles();
		Bundle bundle = getIntent().getBundleExtra("ticket");
		ticket = Parser.parseTicket(bundle);
		//ticket = Parser.parseTicket(savedInstanceState);
		
	}

	
	
	
}
