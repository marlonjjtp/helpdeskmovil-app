package com.appmayuda.util.parser;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.appmayuda.objetos.Ticket;
import com.appmayuda.objetos.Usuario;

public class Parser {

	@SuppressLint("SimpleDateFormat")
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
			System.out.println("parseando ticket json "+(i+1)+"/"+jsonarray.length());
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
		System.out.println("tickets.size() "+tickets.size());
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
	
	@SuppressLint("NewApi")
	public static Ticket parseTicket(Bundle bundle){
		System.out.println("parsenado bundle a ticket - inicado");
		
		Ticket ticket = new Ticket();
		ticket.setNumero(bundle.getInt("numero",-1));
		ticket.setFecha_registro(new Date(bundle.getLong("fecha_registro",0)));
		//ticket.setHora_registro(hora_registro);
		ticket.setPrioridad(bundle.getString("prioridad"));
		ticket.setEstado(bundle.getString("estado"));
		ticket.setDescripcion(bundle.getString("descripcion"));
		ticket.setNombre_usuario_solicitante(bundle.getString("usuario_solicitante"));
		ticket.setCod_usuario_registro(bundle.getString("codigo_usuario_solicitante"));
		
		ticket.setNombre_usuario_atencion(bundle.getString("usuario_atencion",null));
		ticket.setCod_usuario_atencion(bundle.getString("codigo_usuario_atencion",null));
		ticket.setAten_detalle(bundle.getString("atencion_detalle",null));
		ticket.setAten_fecha_inicio(new Date(bundle.getLong("fecha_inicio",0)));
		ticket.setAten_fecha_fin(new Date(bundle.getLong("fecha_fin",0)));
		System.out.println("parseando bundle a ticket - terminado");
		return ticket;
		
	}
	
	public static Bundle parseBundle(Ticket ticket){
		Bundle bundle = new Bundle();
		bundle.putInt("numero",ticket.getNumero());
		bundle.putLong("fecha_registro",ticket.getFecha_registro().getTime());
		bundle.putString("prioridad", ticket.getPrioridad());
		bundle.putString("estado",ticket.getEstado());
		bundle.putString("descripcion",ticket.getDescripcion());
		bundle.putString("usuario_solicitante",ticket.getNombre_usuario_solicitante());
		bundle.putString("codigo_usuario_solicitante",ticket.getCod_usuario_registro());
		bundle.putString("usuario_atencion",ticket.getNombre_usuario_atencion());
		bundle.putString("codigo_usuario_atencion", ticket.getCod_usuario_atencion());
		bundle.putString("atencion_detalle",ticket.getAten_detalle());
		bundle.putLong("fecha_inicio", getLong(ticket.getAten_fecha_inicio()));
		bundle.putLong("atencion_fecha_fin",getLong(ticket.getAten_fecha_fin()));
	
		return bundle;
		
	}
	
	private static long getLong(Date date){
		if (date == null){
			return -1;
		}else {
			return date.getTime();
		}
	}
}
