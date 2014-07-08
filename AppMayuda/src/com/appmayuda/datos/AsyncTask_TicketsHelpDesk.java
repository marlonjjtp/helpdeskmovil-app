package com.appmayuda.datos;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.json.JSONException;

import android.os.AsyncTask;

import com.appmayuda.objetos.Ticket;
import com.appmayuda.util.parser.Parser;

public class AsyncTask_TicketsHelpDesk extends
		AsyncTask<Void, Integer, List<Ticket>> {

	private ConexionHTTP conexion;

	
	private List<Ticket> tickets;
	
	
	public AsyncTask_TicketsHelpDesk(String URL){
		this.conexion = new ConexionHTTP(URL);
	}
	@Override
	protected List<Ticket> doInBackground(Void... params) {
		
		try {
			conexion.ejecutarConexion();
			String respuesta = conexion.getRespuesa();
			tickets = Parser.parseTickets(respuesta);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		System.out.println("tickets.size() "+tickets.size());
		return tickets;
	}

}
