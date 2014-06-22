package com.appmayuda.util;

import java.text.DecimalFormat;

public class Hora {

	private int horas;
	private int minutos;
	private int segundos;
	
	public Hora() {

	}
	
	public Hora(int horas, int minutos, int segundos) {

		this.horas = horas;
		this.minutos = minutos;
		this.segundos = segundos;
	}
	
	public int getHoras() {
		return horas;
	}
	public int getMinutos() {
		return minutos;
	}
	public int getSegundos() {
		return segundos;
	}
	public void setHoras(int horas) {
		this.horas = horas;
	}
	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}
	public void setSegundos(int segundos) {
		this.segundos = segundos;
	}
	
	
	/**
	 * Genera una cadena con la informacion actual de la hora
	 * Se usa el formato "HH-MM-SS"
	 * @return la cadena con el valor de la hora
	 */
	public String enTexto(){
		DecimalFormat df = new DecimalFormat("00");
		return df.format(horas)+"-"+df.format(minutos)+"-"+df.format(segundos);
	}
	
	
}
