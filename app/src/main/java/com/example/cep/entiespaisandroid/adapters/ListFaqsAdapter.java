package com.example.cep.entiespaisandroid.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import com.example.cep.entiespaisandroid.classes.FAQS;

import java.util.ArrayList;

public class ListFaqsAdapter extends ArrayAdapter<FAQS>
{
	public ListFaqsAdapter(@NonNull Context context, int resource)
	{
		super(context, resource);
	}
}
