package com.appmayuda.util.parser;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;

import com.appmayuda.objetos.Ticket;
import com.appmayuda.objetos.Usuario;

public class Parser {

	private static Date parseDate(String cadena) throws ParseException{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date jdate =  format.parse(cadena);
		Date date = new Date(jdate.getTime());
		return date;
	}
	
	public static List<Ticket> parseTickets(String cadena) throws JSONException, ParseException{
		
		JSONArray jsonarray = new JSONArray(cadena);
		List<Ticket> tickets = new ArrayList<Ticket>(jsonarray.length());
		for (int i=0;i<jsonarray.length();i++){
			JSONObject jsonobject = jsonarray.getJSONObject(i);
			Ticket ticket = new Ticket();
			ticket.setNumero(jsonobject.getInt("numero"));
			//long time = java.util.Date.parse(jsonobject.getString("fecha_registro"));
			//ticket.setFecha_registro(new Date(time));
			ticket.setFecha_registro(parseDate(jsonobject.getString("fecha_registro")));
			ticket.setNombre_usuario_solicitante(jsonobject.getString("apellido")+" "+jsonobject.getString("nombre"));
			ticket.setEstado(jsonobject.getString("estado"));
			ticket.setPrioridad(jsonobject.getString("prioridad"));
			tickets.add(ticket);
		}
		return tickets;
	}
	
	
	
	public static Usuario parseUsuario(Bundle bundle){
		Usuario usuario = new Usuario();
		usuario.setCodigo(bundle.getString("id_usuario"));
		usuario.setNombre(bundle.getString("nombre"));
		usuario.setApellido(bundle.getString("apellidos"));
		usuario.setTipo_usuario(bundle.getString("tipo"));
		usuario.setUsuario(bundle.getString("usuario"));
		usuario.setPass("pass");
		return usuario;
	}
	
	public static Bundle parseBundle(Usuario usuario){
		Bundle bundle = new Bundle();
		bundle.putString("id_usuario",usuario.getCodigo());
		bundle.putString("nombre", usuario.getNombre());
		bundle.putString("apellidos",usuario.getApellido());
		bundle.putString("usuario", usuario.getUsuario());
		bundle.putString("password", usuario.getPass());
		bundle.putString("tipo", usuario.getTipo_usuario());
		return bundle;
	}
}
