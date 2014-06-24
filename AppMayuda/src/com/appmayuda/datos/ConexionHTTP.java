package com.appmayuda.datos;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class ConexionHTTP {

	private String URL;
	private HttpClient httpclient;
	private HttpPost httppost;
	private List<NameValuePair> datos;
	private HttpEntity httpentity;
	private HttpEntity httpentityres;
	private HttpResponse httpresponse;
	private String respuesta;
	
	
	public ConexionHTTP(String URL){
		this.URL = URL;
	}
	
	/**
	 * agrega los datos a ser enviados en el POST
	 */
	public void agregarDatos(String key, String value){
		BasicNameValuePair dato = new BasicNameValuePair(key,value);
		datos.add(dato);
	}
	
	
	/**
	 * ejecuta las sentencias para la conexion segun los parametros agregados, almacena la respuesta en una variable que puede ser obtenida con el metodo getRespuesta()
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public void ejecutarConexion() throws ClientProtocolException, IOException{
		httpclient = new DefaultHttpClient();
		httppost = new HttpPost(URL);
		httpentity = new UrlEncodedFormEntity(datos);
		httppost.setEntity(httpentity);
		httpresponse = httpclient.execute(httppost);
		httpentityres = httpresponse.getEntity();
		respuesta = EntityUtils.toString(httpentityres);
	}
	
	/**
	 * 
	 * @return String con la respuesta del servidor
	 */
	public String getRespuesa(){
		return this.respuesta;
	}
	
}
