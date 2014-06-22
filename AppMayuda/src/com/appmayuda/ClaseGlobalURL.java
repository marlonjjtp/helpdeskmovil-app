package com.appmayuda;

import android.app.Application;

public class ClaseGlobalURL extends Application {

	private String url_logeo = "http://192.168.1.39/proyectoMoviles/android/Alogeuo.php";
	private String url_;
	
	public String getURL_logue(){
		return this.url_logeo;
	}
	
}
