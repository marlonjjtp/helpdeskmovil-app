package com.appmayuda.util.adaptador;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.appmayuda.R;
import com.appmayuda.R.id;
import com.appmayuda.objetos.Ticket;

public class AdaptadorTicket extends BaseAdapter {

	private List<Ticket> tickets;
	
	
	
	
	public AdaptadorTicket(List<Ticket> tickets) {
		super();
		this.tickets = tickets;
	}

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
	public View getView(int position, View contentView, ViewGroup group) {
		if (contentView==null){
			LayoutInflater inflater = (LayoutInflater) group.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			//contentView = inflater.inflate(R.layout.item_view_ticket, group);
			contentView = inflater.inflate(R.layout.item_view_ticket, null);
			
			TextView tv_numero_ticket,tv_usuario_solicitante,tv_fecha,tv_estado;
			
			tv_numero_ticket = (TextView) contentView.findViewById(R.id.item_view_ticket_tv_numero_ticket);
			tv_usuario_solicitante = (TextView) contentView.findViewById(R.id.item_view_ticket_tv_usuario_solicitante);
			tv_fecha = (TextView) contentView.findViewById(R.id.item_view_ticket_tv_fecha);
			tv_estado = (TextView) contentView.findViewById(R.id.item_view_ticket_tv_estado);
			
			tv_numero_ticket.setText(tickets.get(position).getNumero()+"");
			tv_usuario_solicitante.setText(tickets.get(position).getNombre_usuario_solicitante());
			tv_fecha.setText(tickets.get(position).getFecha_registro().toString());
			tv_estado.setText(tickets.get(position).getEstado());
		}
		return contentView;
	}

}
