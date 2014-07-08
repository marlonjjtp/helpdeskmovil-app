package com.appmayuda.datos;

import java.io.IOException;






import android.os.AsyncTask;

import com.appmayuda.objetos.Ticket;
import com.appmayuda.util.parser.Parser;

public class AsyncTask_RegistroTicekt extends
		AsyncTask<Ticket,Integer,Boolean> {

	private ConexionHTTP conexion;

	
	public AsyncTask_RegistroTicekt(String url){
		this.conexion = new ConexionHTTP(url);
	}
	
	@Override
	protected Boolean doInBackground(Ticket... params){
		System.out.print("iniciando AsyncTask_RegistroTicket");
		Ticket ticket = params[0];
		System.out.println("fecha>"+Parser.fechaFormateada(ticket.getFecha_registro())+"");
		System.out.println("descripcion>"+ticket.getDescripcion());
		System.out.println("usuario>"+ticket.getCod_usuario_registro());
		conexion.agregarDatos("fechaRegistro",Parser.fechaFormateada(ticket.getFecha_registro())+"");
		conexion.agregarDatos("descripcion", ticket.getDescripcion());
		conexion.agregarDatos("usuario",ticket.getCod_usuario_registro());
		try {
			conexion.ejecutarConexion();
			String respuesta = conexion.getRespuesa();
			System.out.print("respuesta de AsyncTask_RegistroTicket"+respuesta);
		} catch (IOException e) {
			System.out.print("error al registrar ticket");
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
