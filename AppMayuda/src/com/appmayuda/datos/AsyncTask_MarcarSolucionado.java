package com.appmayuda.datos;

import java.io.IOException;


import android.os.AsyncTask;

import com.appmayuda.objetos.Ticket;

public class AsyncTask_MarcarSolucionado extends
		AsyncTask<Ticket,Integer,Boolean> {

	
	
	private ConexionHTTP conexion;
	
	public AsyncTask_MarcarSolucionado(String url){
		this.conexion = new ConexionHTTP(url);
	}
	
	@Override
	protected Boolean doInBackground(Ticket... params) {
		Ticket ticket = params[0];
		conexion.agregarDatos("Ticket",ticket.getNumero()+"") ;
		conexion.agregarDatos("fechafin", ticket.getAten_fecha_fin()+"");
		conexion.agregarDatos("descripcion", ticket.getAten_detalle()+"");
		conexion.agregarDatos("usuario",ticket.getCod_usuario_atencion()+"");
		try {
			conexion.ejecutarConexion();
			String respuesta = conexion.getRespuesa();
			System.out.print("respuesta de AsyncTask_MarcarSolucionado>"+respuesta);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
