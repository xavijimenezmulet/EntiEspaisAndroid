package com.example.cep.entiespaisandroid.utilities;


/**
 * CLASSE UTILITATS (PER REUTILITZAR CODI)
 */

// Java crypt example SJ

import org.mindrot.jbcrypt.*;


public class Utilitats
{
	//ATRIBUTS PER ENCRIPTAR I DESENCRIPTAR CONTRASSENYA
	public static final String key = "04B915BA43FEB5B6"; 			//la mateixa clau que al visual studio
	public static final int SALT_LONG = 12;
	public static final String CONTRA_DEFECTE = "$2a$12$Msaz.t3.9BJX8WrDaVK.mehiX/9GrKVU2.RzXLKS1xP.6t5wvpPFi";

	public static String encriptar(String password)
	{
		String encrypted = "";
		try
		{

			String clearText = password;

			encrypted = BCrypt.hashpw(clearText, BCrypt.gensalt(SALT_LONG));

		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
		return encrypted;
	}

	public static Boolean verificar(String password)
	{
		Boolean verdadero = false;
		try
		{
			String clearText = password;

			String encrypted = Conexions.entitat_conectada.getContrasenya();

			// Check that an unencrypted password matches one that has
			// previously been hashed
			if (BCrypt.checkpw(clearText, encrypted))
			{
				verdadero = true;
			}
			else
			{
				verdadero = false;
			}
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}

		return verdadero;
	}

	public static boolean isNumeric(String cadena){
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}

	public static String tempActual(){
		String temporada = "";

		temporada = Conexions.entitat_conectada.getTemporada();


		return temporada;
	}


} // class
