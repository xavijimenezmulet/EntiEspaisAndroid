package com.example.cep.entiespaisandroid.fragments;


import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import com.example.cep.entiespaisandroid.R;
import com.example.cep.entiespaisandroid.adapters.ListaActivitatsAdapter;
import com.example.cep.entiespaisandroid.classes.ACTIVITATS;
import com.example.cep.entiespaisandroid.classes.EQUIPS;

import java.util.ArrayList;

import static com.example.cep.entiespaisandroid.activities.MainActivity.navigationView;

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
		equips.add(new EQUIPS(3, "F.C. Sant Cugat B", true,
				1,"2018-2019", 15, 3,
				2, 1,1));
		equips.add(new EQUIPS(4, "F.C. Sant Cugat Basquet",
				false, 1,"2018-2019", 15,
				3, 2, 1,1));
		equips.add(new EQUIPS(4, "F.C. Sant Cugat Basquet",
				false, 1,"2018-2019", 15,
				3, 2, 1,1));
		equips.add(new EQUIPS(4, "F.C. Sant Cugat Basquet",
				false, 1,"2018-2019", 15,
				3, 2, 1,1));
		equips.add(new EQUIPS(4, "F.C. Sant Cugat Basquet",
				false, 1,"2018-2019", 15,
				3, 2, 1,1));
		equips.add(new EQUIPS(4, "F.C. Sant Cugat Basquet",
				false, 1,"2018-2019", 15,
				3, 2, 1,1));
		equips.add(new EQUIPS(4, "F.C. Sant Cugat Basquet",
				false, 1,"2018-2019", 15,
				3, 2, 1,1));
		equips.add(new EQUIPS(4, "F.C. Sant Cugat Basquet",
				false, 1,"2018-2019", 15,
				3, 2, 1,1));
		equips.add(new EQUIPS(4, "F.C. Sant Cugat Basquet",
				false, 1,"2018-2019", 15,
				3, 2, 1,1));
		equips.add(new EQUIPS(4, "F.C. Sant Cugat Basquet",
				false, 1,"2018-2019", 15,
				3, 2, 1,1));
		equips.add(new EQUIPS(4, "F.C. Sant Cugat Basquet",
				false, 1,"2018-2019", 15,
				3, 2, 1,1));
		equips.add(new EQUIPS(4, "F.C. Sant Cugat Basquet",
				false, 1,"2018-2019", 15,
				3, 2, 1,1));
		equips.add(new EQUIPS(4, "F.C. Sant Cugat Basquet",
				false, 1,"2018-2019", 15,
				3, 2, 1,1));
		equips.add(new EQUIPS(4, "F.C. Sant Cugat Basquet",
				false, 1,"2018-2019", 15,
				3, 2, 1,1));
		equips.add(new EQUIPS(4, "F.C. Sant Cugat Basquet",
				false, 1,"2018-2019", 15,
				3, 2, 1,1));
		equips.add(new EQUIPS(4, "F.C. Sant Cugat Basquet",
				false, 1,"2018-2019", 15,
				3, 2, 1,1));

		mRecyClerView = getView().findViewById(R.id.rv_recycler_view);
		mRecyClerView.setHasFixedSize(true);
		mLayoutManager = new LinearLayoutManager(getContext());
		mAdapter = new AdaptadorEquips(equips);
		((AdaptadorEquips) mAdapter).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				/*Fragment fragment = new EquipFragment();
				Bundle bundle = new Bundle();
				bundle.putParcelable("parcel_equip", equips.get(
						mRecyClerView.getChildAdapterPosition(v)));
				fragment.setArguments(bundle);

				FragmentTransaction ft = getActivity().getSupportFragmentManager().
						beginTransaction();
				ft.replace(R.id.fragment_content, fragment);
				ft.addToBackStack(null);
				ft.commit();

				navigationView.getMenu().getItem(0).setChecked(false);
				((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(equips.get(
						mRecyClerView.getChildAdapterPosition(v)).getNom());*/
				final int position_eq = mRecyClerView.getChildAdapterPosition(v);
				final EQUIPS equip = equips.get(position_eq);

				AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
				builder.setTitle(equip.getNom());
				builder.setIcon(R.drawable.icono_logo);
				View root = getLayoutInflater().inflate(
						(R.layout.alert_dialog_equips), null);
				EditText editText = root.findViewById(R.id.etxt_nombre);
				editText.setText(equip.getNom());

				CheckBox checkboxDiscapacidad = root.findViewById(R.id.cb_si);

				if (equip.getTe_discapacitat())
				{
					checkboxDiscapacidad.setChecked(true);
				}
				builder.setView(root);

				builder.setNegativeButton("ELIMINAR", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						equips.remove(position_eq);
						mAdapter.notifyItemRemoved(position_eq);
						mAdapter.notifyItemRangeChanged(position_eq, equips.size());
					}
				});

				builder.setPositiveButton("GUARDAR", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

					}
				});

				builder.setNeutralButton("VER ACTIVIDADES", new DialogInterface.OnClickListener()
				{
					@Override
					public void onClick(DialogInterface dialogInterface, int i)
					{
						AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
						builder.setTitle(equip.getNom());
						builder.setIcon(R.drawable.icono_logo);
						View root = getLayoutInflater().inflate(
								(R.layout.alert_dialog_activitats), null);
						ArrayList<ACTIVITATS> activitats = new ArrayList<>();
						for (int j = 0; j < 20; j++) {
						activitats.add(new ACTIVITATS(1, "Actividad9293", 2, 3, 4));
						}
						ListView listview = root.findViewById(R.id.lv_activitats);
						ListaActivitatsAdapter adapter = new ListaActivitatsAdapter(getContext(), activitats);
						listview.setAdapter(adapter);
						builder.setView(root);
						AlertDialog dlg = builder.show();
						dlg.getWindow().setBackgroundDrawable(getResources().getDrawable(R.drawable.dialog_bg));
					}
				});


				AlertDialog dlg = builder.show();
				dlg.getWindow().setBackgroundDrawable(getResources().getDrawable(R.drawable.dialog_bg));


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
			View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_item,
					viewGroup, false);

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
