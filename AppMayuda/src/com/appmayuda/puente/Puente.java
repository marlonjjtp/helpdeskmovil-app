package com.appmayuda.puente;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;

import com.appmayuda.ClaseGlobalURL;
import com.appmayuda.datos.AsyncTask_Logueo;
import com.appmayuda.datos.AsyncTask_MarcarSolucionado;
import com.appmayuda.datos.AsyncTask_RegistroTicekt;
import com.appmayuda.datos.AsyncTask_TicketsHelpDesk;
import com.appmayuda.datos.AsyncTask_TicketsUsuario;
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
			task.setDatos(context, global.getUrl_logeo());
			task.execute(usuario);
			return task.get();
		}catch (Exception e){
			e.printStackTrace();
			return "error "+ e;
		}
	
	}
	
	/**
	 * 
	 * @param usuario objeto usuario con los datos de usuario y password
	 * @param ac un activity desde donde se hace la consulta
	 *
	 * @return null si los datos del usuario son incorrectos o
	 * Usuario con los datos completos si los datos son correctos
	 */
	public Usuario loguarse(Usuario usuario,Activity ac){
		try {
			String nousuario = "no existe el usuario";
			AsyncTask_Logueo task = new AsyncTask_Logueo();
			ClaseGlobalURL global = (ClaseGlobalURL) ac.getApplication();
			task.setDatos(context, global.getUrl_logeo());
			task.execute(usuario);
			String respuesta = task.get();
			if (respuesta.equals(nousuario)){
				return null;
			}else{
				
				JSONArray arreglojson = new JSONArray(respuesta);
				JSONObject json = (JSONObject) arreglojson.get(0);
				//JSONObject json = new JSONObject(respuesta);
				usuario.setCodigo(json.getString("id_usuario"));
				usuario.setTipo_usuario(json.getString("tipo"));
				usuario.setNombre(json.getString("nombre"));
				usuario.setApellido(json.getString("apellido"));
				usuario.setEstado(true);
				return usuario;
			}
			
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}
		
	}
	
	public List<Ticket> listaTicketsHelpDesk(String url) throws InterruptedException, ExecutionException{
		AsyncTask_TicketsHelpDesk task = new AsyncTask_TicketsHelpDesk(url);
		task.execute();
		return  task.get();
	}
	
	public List<Ticket> listaTicketUsuario(String url, String codigo_usuario) throws InterruptedException, ExecutionException{
		AsyncTask_TicketsUsuario task = new AsyncTask_TicketsUsuario(url);
		task.execute(codigo_usuario);
		return task.get();
	}
	
	public boolean marcarComoSolucionado(int numeroTicket,Activity ac) throws InterruptedException, ExecutionException{
		ClaseGlobalURL urls = (ClaseGlobalURL) ac.getApplication();
		AsyncTask_MarcarSolucionado task = new AsyncTask_MarcarSolucionado(urls.getUrl_solucionTicket());
		return task.get();
	}
	
	public Ticket ticket(int numeroTicket){
		
		return null;
	}
	
	public List<Ticket> listaTickets(){
		
		return null;
	}
	
	public boolean registrarTicket(Ticket ticket, Activity ac) throws InterruptedException, ExecutionException{
		ClaseGlobalURL urls = (ClaseGlobalURL) ac.getApplication();
		System.out.println("iniciando registrarTicket() en Parser");
		AsyncTask_RegistroTicekt task = new AsyncTask_RegistroTicekt(urls.getUrl_registroTicket());
		task.execute(ticket);
		return task.get();
	}
	
	
}
