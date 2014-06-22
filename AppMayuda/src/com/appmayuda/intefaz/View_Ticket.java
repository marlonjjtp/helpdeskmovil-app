package com.appmayuda.intefaz;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.appmayuda.objetos.Ticket;

public class View_Ticket extends LinearLayout {

	private Ticket ticket;
	
	private TextView tv_numero;
	private TextView tv_descripcion;
	private TextView tv_usuario_registro;
	private int color;
	
	public View_Ticket(Context context) {
		super(context);
		generarView();
	}

	private void mostrarNumero(){
		LinearLayout child = new LinearLayout(getContext());
		child.setOrientation(LinearLayout.HORIZONTAL);
		tv_numero = new TextView(getContext());
		tv_numero.setText(ticket.getNumero());
		tv_numero.setTextSize(20);
		addView(child);
	}
	
	private void generarView(){
		setOrientation(LinearLayout.VERTICAL);
		mostrarNumero();
	}
	
}
