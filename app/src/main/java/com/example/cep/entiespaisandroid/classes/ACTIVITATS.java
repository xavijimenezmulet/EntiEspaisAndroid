package com.example.cep.entiespaisandroid.classes;

/**
 * CLASSE ACTIVITATS
 */
public class ACTIVITATS
{
	//ATRIBUTS
	private int id;
	private String nom;
	private int id_demanda_act;
	private int id_admin;
	private int id_espai;

	//CONSTRUCTORS
	public ACTIVITATS()
	{
	}

	public ACTIVITATS(int id, String nom, int id_demanda_act, int id_admin, int id_espai)
	{
		this.id = id;
		this.nom = nom;
		this.id_demanda_act = id_demanda_act;
		this.id_admin = id_admin;
		this.id_espai = id_espai;
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

	public String getNom()
	{
		return nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public int getId_demanda_act()
	{
		return id_demanda_act;
	}

	public void setId_demanda_act(int id_demanda_act)
	{
		this.id_demanda_act = id_demanda_act;
	}

	public int getId_admin()
	{
		return id_admin;
	}

	public void setId_admin(int id_admin)
	{
		this.id_admin = id_admin;
	}

	public int getId_espai()
	{
		return id_espai;
	}

	public void setId_espai(int id_espai)
	{
		this.id_espai = id_espai;
	}
}
