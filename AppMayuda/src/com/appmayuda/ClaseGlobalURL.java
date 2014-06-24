package com.appmayuda;

import android.app.Application;

public class ClaseGlobalURL extends Application {

	//private String url = "http://192.168.1.3";
	private String url = "http://tecnest.net";
	private String url_logeo = "/ucvmovil/appmesa/android/logueo.php"; 
	//private String url_logeo = "/nuevo_moviles/android/logueo.php";
	private String url_mostrarTickets_HelpDesk = "/ucvmovil/appmesa/android/mostrarTickets_Help.php";
	private String url_mostrarTickes_Usuario = "/ucvmovil/appmesa/android/mostrarTickets.php";
	
	

	public String getUrl() {
		return url;
	}


	public String getUrl_logeo() {
		return url+url_logeo;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public void setUrl_logeo(String url_logeo) {
		this.url_logeo = url_logeo;
	}


	public String getUrl_mostrarTickets_HelpDesk() {
		return url+url_mostrarTickets_HelpDesk;
	}


	public void setUrl_mostrarTickets_HelpDesk(String url_mostrarTickets_HelpDesk) {
		this.url_mostrarTickets_HelpDesk = url_mostrarTickets_HelpDesk;
	}


	public String getUrl_mostrarTickes_Usuario() {
		return url+ url_mostrarTickes_Usuario;
	}


	public void setUrl_mostrarTickes_Usuario(String url_mostrarTickes_Usuario) {
		this.url_mostrarTickes_Usuario = url_mostrarTickes_Usuario;
	}
	
	
}
