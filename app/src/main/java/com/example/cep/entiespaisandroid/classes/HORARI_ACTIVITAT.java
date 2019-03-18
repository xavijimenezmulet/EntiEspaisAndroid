package com.example.cep.entiespaisandroid.classes;

/**
 * CLASSE HORARI ACTIVITAT
 */
public class HORARI_ACTIVITAT
{
	//ATRIBUTS
	private int id_dia;
	private int id_hores;
	private int id_activitat;

	//CONSTRUCTORS
	public HORARI_ACTIVITAT()
	{
	}

	public HORARI_ACTIVITAT(int id_dia, int id_hores, int id_activitat)
	{
		this.id_dia = id_dia;
		this.id_hores = id_hores;
		this.id_activitat = id_activitat;
	}

	//GETTERS && SETTERS
	public int getId_dia()
	{
		return id_dia;
	}

	public void setId_dia(int id_dia)
	{
		this.id_dia = id_dia;
	}

	public int getId_hores()
	{
		return id_hores;
	}

	public void setId_hores(int id_hores)
	{
		this.id_hores = id_hores;
	}

	public int getId_activitat()
	{
		return id_activitat;
	}

	public void setId_activitat(int id_activitat)
	{
		this.id_activitat = id_activitat;
	}
}
