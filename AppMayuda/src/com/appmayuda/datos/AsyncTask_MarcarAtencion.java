package com.appmayuda.datos;

import java.io.IOException;

import android.os.AsyncTask;

import com.appmayuda.objetos.Ticket;

public class AsyncTask_MarcarAtencion extends
		AsyncTask<Ticket,Integer,Boolean> {

	
	private ConexionHTTP conexion;
	
	public AsyncTask_MarcarAtencion(String url){
		this.conexion = new ConexionHTTP(url);
	}
	
	@Override
	protected Boolean doInBackground(Ticket... params) {
		Ticket ticket = params[0];
		conexion.agregarDatos("FechaInicio",ticket.getAten_fecha_inicio()+"");
		conexion.agregarDatos("usario", ticket.getCod_usuario_atencion()+"");
		conexion.agregarDatos("Nticket", ticket.getNumero()+"");
		try {
			conexion.ejecutarConexion();
			String respuesta = conexion.getRespuesa();
			System.out.println("respuesta de AsyncTask_MarcarAtencion>"+respuesta);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
