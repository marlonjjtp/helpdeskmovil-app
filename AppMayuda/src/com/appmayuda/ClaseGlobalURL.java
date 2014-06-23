package com.appmayuda;

import android.app.Application;

public class ClaseGlobalURL extends Application {

	private String url = "http://192.168.1.3";
	private String url_logeo = "/nuevo_moviles/android/logueo.php";
	
	

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
	
	
}
