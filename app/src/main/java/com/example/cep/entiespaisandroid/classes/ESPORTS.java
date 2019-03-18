package com.example.cep.entiespaisandroid.classes;

/**
 * CLASSE ESPORTS
 */
public class ESPORTS
{
	//ATRIBUTS
	private int id;
	private String nom;

	//CONSTRUCTORS
	public ESPORTS()
	{
	}

	public ESPORTS(int id, String nom)
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
