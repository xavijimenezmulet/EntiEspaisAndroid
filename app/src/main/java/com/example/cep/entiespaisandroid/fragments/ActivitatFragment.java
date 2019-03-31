package com.example.cep.entiespaisandroid.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.cep.entiespaisandroid.R;

public class ActivitatFragment extends Fragment
{
	private ImageView ImgPrincipal;

	@Override
	public View onCreateView(LayoutInflater inflater,
							 ViewGroup container,
							 Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.fragment_activitat, container, false);
	}

	@Override
	public void onActivityCreated(Bundle state)
	{
		super.onActivityCreated(state);

		ImgPrincipal = (ImageView) getView().findViewById(R.id.ImgPrincipalActivitat);
		ImgPrincipal.setImageResource(R.drawable.logoprincipal);
	}
}
