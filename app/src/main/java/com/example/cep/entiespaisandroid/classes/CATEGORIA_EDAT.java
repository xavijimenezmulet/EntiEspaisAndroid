package com.example.cep.entiespaisandroid.classes;

/**
 * CLASSE CATEGORIA EDAT
 */
public class CATEGORIA_EDAT
{
	//ATRIBUTS
	private int id;
	private String nom;

	//CONSTRUCTORS
	public CATEGORIA_EDAT()
	{
	}

	public CATEGORIA_EDAT(int id, String nom)
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

