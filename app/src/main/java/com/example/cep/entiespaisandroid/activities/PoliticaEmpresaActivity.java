package com.example.cep.entiespaisandroid.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cep.entiespaisandroid.R;

public class PoliticaEmpresaActivity extends AppCompatActivity
{
	private TextView TextText;
	private ImageView ImgLogo;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_politica_empresa);

		TextText = (TextView)findViewById(R.id.TextText);
		ImgLogo = (ImageView)findViewById(R.id.ImgLogo);

		TextText.setText("Para proceder al registro, acceso y posterior uso de la Aplicación, el Usuario deberá facilitar -de forma voluntaria-, datos de\n" +
				"carácter personal (esencialmente, identificativos y de contacto), los cuales serán incorporados a soportes automatizados\n" +
				"titularidad de ENTI ESPAIS\n" +
				"La recogida, almacenamiento, modificación, estructuración y en su caso, eliminación, de los datos proporcionados por los\n" +
				"Usuarios, constituirán operaciones de tratamiento llevadas a cabo por el Responsable, con la finalidad de garantizar el\n" +
				"correcto funcionamiento de la Aplicación, mantener la relación de prestación de servicios y/o comercial con el Usuario, y\n" +
				"para la gestión, administración, información, prestación y mejora del servicio.\n" +
				"Los datos personales facilitados por el Usuario -especialmente, el correo electrónico o e-mail- podrán emplearse también\n" +
				"para remitir boletines (newsletters), así como comunicaciones comerciales de promociones y/o publicidad de la Aplicación,\n" +
				"siempre y cuando, el Usuario haya prestado previamente su consentimiento expreso para la recepción de estas\n" +
				"comunicaciones vía electrónica.\n " + "El tratamiento de los datos del Usuario, se realiza con las siguientes bases jurídicas que legitiman el mismo:\n" +
				"• La solicitud de información y/o la contratación de los servicios de la Aplicación, cuyos términos y condiciones se\n" +
				"pondrán a disposición del Usuario en todo caso, con carácter previo, para su expresa aceptación.\n" +
				"• El consentimiento libre, específico, informado e inequívoco del Usuario, poniendo a su disposición la presente política\n" +
				"de privacidad, que deberá aceptar mediante una declaración o una clara acción afirmativa, como el marcado de una\n" +
				"casilla dispuesta al efecto.\n" +
				"En caso de que el Usuario no facilite a ENTI ESPAIS sus datos, o lo haga de forma errónea o incompleta, no será posible\n" +
				"proceder al uso de la Aplicación. " + "Los datos personales proporcionados por el Usuario, se conservarán en los sistemas y bases de datos del Responsable del\n" +
				"Tratamiento, mientras aquél continúe haciendo uso de la Aplicación, y siempre que no solicite su supresión.\n" +
				"Con el objetivo de depurar las posibles responsabilidades derivadas del tratamiento, los datos se conservarán por un período\n" +
				"mínimo de cinco años. ");

		ImgLogo.setImageResource(R.drawable.logoprincipal);
	}
}
