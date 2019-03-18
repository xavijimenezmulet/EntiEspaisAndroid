package com.example.cep.entiespaisandroid.classes;

/**
 * CLASSE TELEFONS ENTITATS
 */
public class TELEFONS_ENTITATS
{
	//ATRIBUTS
	private int id;
	private String numero;
	private int id_entitat;
	private String temporada_entitat;

	//CONSTRUCTORS
	public TELEFONS_ENTITATS()
	{
	}

	public TELEFONS_ENTITATS(int id, String numero, int id_entitat, String temporada_entitat)
	{
		this.id = id;
		this.numero = numero;
		this.id_entitat = id_entitat;
		this.temporada_entitat = temporada_entitat;
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

	public String getNumero()
	{
		return numero;
	}

	public void setNumero(String numero)
	{
		this.numero = numero;
	}

	public int getId_entitat()
	{
		return id_entitat;
	}

	public void setId_entitat(int id_entitat)
	{
		this.id_entitat = id_entitat;
	}

	public String getTemporada_entitat()
	{
		return temporada_entitat;
	}

	public void setTemporada_entitat(String temporada_entitat)
	{
		this.temporada_entitat = temporada_entitat;
	}
}
