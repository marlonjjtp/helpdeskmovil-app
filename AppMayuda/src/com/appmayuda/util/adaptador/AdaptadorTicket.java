package com.appmayuda.util.adaptador;

import java.util.List;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.appmayuda.objetos.Ticket;

public class AdaptadorTicket extends BaseAdapter {

	private List<Ticket> tickets;
	
	
	@Override
	public int getCount() {
		return tickets.size();
	}

	@Override
	public Object getItem(int pos) {
		return tickets.get(pos);
	}

	@Override
	public long getItemId(int pos) {
		return pos;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		return null;
	}

}
