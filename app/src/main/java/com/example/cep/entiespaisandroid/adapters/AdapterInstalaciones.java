package com.example.cep.entiespaisandroid.adapters;

import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cep.entiespaisandroid.R;
import com.example.cep.entiespaisandroid.classes.INSTALACIONS;

import java.util.ArrayList;

public class AdapterInstalaciones extends RecyclerView.Adapter<AdapterInstalaciones.InstalacionsViewHolder>
{
	private View.OnClickListener listener;

	private ArrayList<INSTALACIONS> instalacions;

	public AdapterInstalaciones(ArrayList<INSTALACIONS> instalacions)
	{
		this.instalacions = instalacions;
	}

	static class InstalacionsViewHolder extends RecyclerView.ViewHolder
	{
		private ImageView imatgeInstalacio;
		private TextView nomInstalacio;

		public InstalacionsViewHolder(View itemView)
		{
			super(itemView);

			imatgeInstalacio = itemView.findViewById(R.id.imatgeInstalacio);
			nomInstalacio = itemView.findViewById(R.id.nomInstalacio);
		}

		public void bindLine(INSTALACIONS i) {
			//imatgeInstalacio.setImageBitmap(BitmapFactory.decodeFile(i.getRuta_imagen()));
			nomInstalacio.setText(i.getNom());

		}
	}

	@Override
	public InstalacionsViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)
	{
		View itemView = LayoutInflater.from(viewGroup.getContext())
				.inflate(R.layout.cardview_instalacions, viewGroup, false);

		itemView.setOnClickListener(listener);

		InstalacionsViewHolder instalacionsViewHolder = new InstalacionsViewHolder(itemView);

		return instalacionsViewHolder;
	}

	@Override
	public void onBindViewHolder(InstalacionsViewHolder viewHolder, int pos)
	{
		INSTALACIONS item = instalacions.get(pos);

		viewHolder.bindLine(item);
	}

	@Override
	public int getItemCount() {
		return instalacions.size();
	}

	public void setOnClickListener(View.OnClickListener listener)
	{
		this.listener = listener;
	}

	public void onClick(View view)
	{
		if (listener != null)
			listener.onClick(view);
	}

}
