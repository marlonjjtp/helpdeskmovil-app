package com.appmayuda;

import android.app.Application;

public class ClaseGlobalURL extends Application {

	private String url = "http://192.168.1.39";
	private String url_logeo = "/proyectoMoviles/android/Alogeuo.php";
	
	
	public String getURL_logue(){
		return url+url_logeo;
	}
	
	
}
