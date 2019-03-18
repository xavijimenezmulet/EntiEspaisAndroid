package com.example.cep.entiespaisandroid.classes;

/**
 * CLASSE COMPETICIONS
 */
public class COMPETICIONS
{
	//ATRIBUTS
	private int id;
	private String nom;

	//CONSTRUCTORS
	public COMPETICIONS()
	{
	}

	public COMPETICIONS(int id, String nom)
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
