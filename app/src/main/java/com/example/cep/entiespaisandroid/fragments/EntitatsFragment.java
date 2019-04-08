package com.example.cep.entiespaisandroid.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.cep.entiespaisandroid.R;

public class EntitatsFragment extends Fragment
{
	private WebView WebOMET;
	@Override
	public View onCreateView(LayoutInflater inflater,
							 ViewGroup container,
							 Bundle savedInstanceState) {

		return inflater.inflate(R.layout.fragment_entitats, container, false);
	}

	@Override
	public void onActivityCreated(Bundle state) {
		super.onActivityCreated(state);

		WebOMET = (WebView)getView().findViewById(R.id.WebOMET);
		WebOMET.getSettings().setJavaScriptEnabled(true);
		WebOMET.getSettings().setBuiltInZoomControls(true);
		WebOMET.loadUrl("http://www.omet.santcugat.cat/");

		WebOMET.setWebViewClient(new WebViewClient(){
			public boolean shouldOverriceUrlLoading(WebView view, String url){
				return false;
			}
		});
	}
}
