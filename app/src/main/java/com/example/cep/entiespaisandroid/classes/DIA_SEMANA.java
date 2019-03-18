package com.example.cep.entiespaisandroid.classes;

/**
 * CLASSE DIA SEMANA
 */
public class DIA_SEMANA
{
	//ATRIBUTS
	private int id;
	private String nom;

	//CONSTRUCTORS
	public DIA_SEMANA()
	{
	}

	public DIA_SEMANA(int id, String nom)
	{
		this.id = id;
		this.nom = nom;
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
}
