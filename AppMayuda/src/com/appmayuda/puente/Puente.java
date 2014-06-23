package com.appmayuda.puente;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

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
