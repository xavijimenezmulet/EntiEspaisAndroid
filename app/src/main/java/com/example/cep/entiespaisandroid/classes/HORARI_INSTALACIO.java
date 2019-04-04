package com.example.cep.entiespaisandroid.classes;

/**
 * CLASSE HORARI INSTALACIO
 */
public class HORARI_INSTALACIO
{
	//ATRIBUTS
	private int id_dia;
	private int id_hores;
	private int id_instalacio;

	//Tomar horas
	private HORES hora;

	//CONSTRUCTORS
	public HORARI_INSTALACIO()
	{
	}

	public HORARI_INSTALACIO(int id_dia, int id_hores, int id_instalacio)
	{
		this.id_dia = id_dia;
		this.id_hores = id_hores;
		this.id_instalacio = id_instalacio;
	}


	public HORARI_INSTALACIO(int id_dia, int id_hores, int id_instalacio, HORES hora)
	{
		this.id_dia = id_dia;
		this.id_hores = id_hores;
		this.id_instalacio = id_instalacio;
		this.hora = hora;
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

	public int getId_instalacio()
	{
		return id_instalacio;
	}

	public void setId_instalacio(int id_instalacio)
	{
		this.id_instalacio = id_instalacio;
	}

	/*
	public HORES getHora()
	{
		return hora;
	}
	*/
}
