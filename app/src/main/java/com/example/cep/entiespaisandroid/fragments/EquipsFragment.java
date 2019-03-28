package com.example.cep.entiespaisandroid.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cep.entiespaisandroid.R;
import com.example.cep.entiespaisandroid.classes.EQUIPS;

import java.util.ArrayList;

public class EquipsFragment extends Fragment
{
	private RecyclerView mRecyClerView;
	private RecyclerView.Adapter mAdapter;
	private RecyclerView.LayoutManager mLayoutManager;
	private ArrayList<EQUIPS> equips = new ArrayList<EQUIPS>();

	@Override
	public View onCreateView(LayoutInflater inflater,
							 ViewGroup container,
							 Bundle savedInstanceState) {

		return inflater.inflate(R.layout.fragment_equips, container, false);
	}

	@Override
	public void onActivityCreated(Bundle state) {
		super.onActivityCreated(state);
		equips.add(new EQUIPS(1, "F.C. Sant Cugat", false,
				1,"2018-2019", 15, 3,
				2, 1,1));
		equips.add(new EQUIPS(3, "F.C. Sant Cugat B", false,
				1,"2018-2019", 15, 3,
				2, 1,1));
		equips.add(new EQUIPS(4, "F.C. Sant Cugat Basquet",
				false, 1,"2018-2019", 15,
				3, 2, 1,1));


		mRecyClerView = getView().findViewById(R.id.rv_recycler_view);
		mRecyClerView.setHasFixedSize(true);
		mLayoutManager = new GridLayoutManager(getContext(),
				1, GridLayoutManager.VERTICAL, true);
		mAdapter = new AdaptadorEquips(equips);
		((AdaptadorEquips) mAdapter).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(getContext(), "CLICK", Toast.LENGTH_LONG).show();

			}
		});

		mRecyClerView.setLayoutManager(mLayoutManager);
		mRecyClerView.setAdapter(mAdapter);

	}



	class AdaptadorEquips extends RecyclerView.Adapter <AdaptadorEquips.EquipViewHolder>
			implements View.OnClickListener
	{
		private View.OnClickListener listener;
		ArrayList<EQUIPS> equipos;


		public AdaptadorEquips(ArrayList<EQUIPS> lista_equipos) {
			this.equipos = lista_equipos;
		}
		class EquipViewHolder
				extends RecyclerView.ViewHolder
		{
			private ImageView imgEquipImage;
			private TextView lblEquipName;
			private TextView lblEquipEsport;


			public EquipViewHolder(View itemView)
			{
				super(itemView);
				imgEquipImage = itemView.findViewById(R.id.iv_image);
				lblEquipName = itemView.findViewById(R.id.tv_text);
				lblEquipEsport = itemView.findViewById(R.id.tv_blah);
			}

			public void bindEquip(EQUIPS e) {
				imgEquipImage.setImageResource(R.drawable.ic_action_equips);
				lblEquipName.setText(e.getNom());
				lblEquipEsport.setText("Futbol");
			}
		}

		@NonNull
		@Override
		public EquipViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
		{
			View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_item, viewGroup, false);

			itemView.setOnClickListener(this);

			EquipViewHolder evh = new EquipViewHolder(itemView);
			return evh;
		}
		@Override
		public void onBindViewHolder(@NonNull EquipViewHolder equipViewHolder, int i)
		{
			EQUIPS item = equipos.get(i);
			equipViewHolder.bindEquip(item);
		}

		@Override
		public int getItemCount()
		{
			return equipos.size();
		}

		public void setOnClickListener(View.OnClickListener listener) {
			this.listener = listener;
		}

		@Override
		public void onClick(View view) {
			if(listener != null) {
				listener.onClick(view);

			}


		}
	}

}
