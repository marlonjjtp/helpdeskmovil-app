package com.appmayuda.datos;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.appmayuda.objetos.Usuario;



public class AsyncTask_Logueo extends AsyncTask<Usuario,Void,String> {

	private Context context;
	private String url;
	
	
	@Override
	protected String doInBackground(Usuario... usuario) {
		String respuesta = "";
		try{
			System.out.println("url >"+url);
			System.out.println("usuario >"+usuario[0].getUsuario());
			System.out.println("pass >"+usuario[0].getPass());
			
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httpost = new HttpPost(url);
			List<NameValuePair> datos = new ArrayList<>();
			datos.add(new BasicNameValuePair("usuario",usuario[0].getUsuario()));
			//datos.add(new BasicNameValuePair("password",usuario[0].getPass()));
			datos.add(new BasicNameValuePair("pass",usuario[0].getPass()));
			HttpEntity entity = new UrlEncodedFormEntity(datos);
			httpost.setEntity(entity);
	
			HttpResponse response = httpclient.execute(httpost);
			HttpEntity entidad_resp = response.getEntity();
			respuesta = EntityUtils.toString(entidad_resp);
			System.out.println("respuesta de logueo: "+respuesta);
		} catch (Exception e) {
			e.printStackTrace();
			respuesta = "hubo un error " + e;
		}
		return respuesta;
	}


	@Override
	protected void onPostExecute(String result) {
		//Toast.makeText(context,result, Toast.LENGTH_SHORT).show();
		super.onPostExecute(result);
	}


	public void setDatos(Context context, String url){
		this.context = context;
		this.url = url;
	}
	
}
