package com.example.cep.entiespaisandroid.classes;

/**
 * CLASSE CATEGORIA EQUIP
 */
public class CATEGORIA_EQUIP
{
	//ATRIBUTS
	private int id;
	private String nom;

	//CONSTRUCTORS
	public CATEGORIA_EQUIP()
	{
	}

	public CATEGORIA_EQUIP(int id, String nom)
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
