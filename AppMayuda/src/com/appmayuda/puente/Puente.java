package com.appmayuda.puente;

import java.util.List;

import android.app.Activity;
import android.content.Context;

import com.appmayuda.ClaseGlobalURL;
import com.appmayuda.datos.AsyncTask_Logueo;
import com.appmayuda.objetos.Ticket;
import com.appmayuda.objetos.Usuario;

public class Puente {

	private Context context;

	public Puente(Context context) {
		this.context = context;
	}
	
	public String loguearse(Usuario usuario,Activity ac){
		try {
			AsyncTask_Logueo task = new AsyncTask_Logueo();
			ClaseGlobalURL global = (ClaseGlobalURL) ac.getApplication();
			task.setDatos(context, global.getURL_logue());
			task.execute(usuario);
			return task.get();
		}catch (Exception e){
			e.printStackTrace();
			return "error "+ e;
		}
	
	}
	
	public String marcarComoSolucionado(int numeroTicket){
		
		return "";
	}
	
	public Ticket ticket(int numeroTicket){
		
		return null;
	}
	
	public List<Ticket> listaTickets(){
		
		return null;
	}
	
	
}
