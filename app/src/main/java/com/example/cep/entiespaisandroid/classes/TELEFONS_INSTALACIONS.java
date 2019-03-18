package com.example.cep.entiespaisandroid.classes;

/**
 * CLASSE TELEFONS INSTALACIONS
 */
public class TELEFONS_INSTALACIONS
{
	private int id;
	private String telefon;
	private int id_instalacio;

	//CONSTRUCTORS
	public TELEFONS_INSTALACIONS()
	{
	}

	public TELEFONS_INSTALACIONS(int id, String telefon, int id_instalacio)
	{
		this.id = id;
		this.telefon = telefon;
		this.id_instalacio = id_instalacio;
	}

	//GETTERS && SETTERS
	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getTelefon()
	{
		return telefon;
	}

	public void setTelefon(String telefon)
	{
		this.telefon = telefon;
	}

	public int getId_instalacio()
	{
		return id_instalacio;
	}

	public void setId_instalacio(int id_instalacio)
	{
		this.id_instalacio = id_instalacio;
	}
}
