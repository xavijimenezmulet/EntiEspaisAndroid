package com.example.cep.entiespaisandroid.utilities;

import android.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * CLASSE UTILITATS (PER REUTILITZAR CODI)
 */
public class Utilitats
{
	//ATRIBUTS PER ENCRIPTAR I DESENCRIPTAR CONTRASSENYA
	private static final String key = "04B915BA43FEB5B6"; 			//la mateixa clau que al visual studio
	private static final String initVector = "encryptionIntVec";

	/**
	 * ENS ENCRIPTA UNA CONTRASSENYA A PARTIR D'UN STRING
	 * @param value
	 * @return
	 */
	public static String encrypt(String value) {
		try {
			IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
			SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

			Cipher cipher = Cipher.getInstance("CBC");
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

			byte[] encrypted = cipher.doFinal(value.getBytes());
			return Base64.encodeToString(encrypted,Base64.DEFAULT);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/**
	 * ENS DESENCRIPTA UNA CONTRASSENYA EN MODE CBC
	 * @param encrypted
	 * @return
	 */
	public static String decrypt(String encrypted)
	{
		try
		{
			IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
			SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

			Cipher cipher = Cipher.getInstance("CBC");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
			byte[] original = cipher.doFinal(Base64.decode(encrypted, Base64.DEFAULT));

			return new String(original);
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}

		return null;
	}
}
