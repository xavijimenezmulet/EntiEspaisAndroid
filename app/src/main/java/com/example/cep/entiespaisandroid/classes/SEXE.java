package com.example.cep.entiespaisandroid.classes;

/**
 * CLASSE SEXE
 */
public class SEXE
{
	//ATRIBUTS
	private int id;
	private String tipus;

	//CONSTRUCTORS

	public SEXE()
	{
	}

	public SEXE(int id, String tipus)
	{
		this.id = id;
		this.tipus = tipus;
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

	public String getTipus()
	{
		return tipus;
	}

	public void setTipus(String tipus)
	{
		this.tipus = tipus;
	}

	@Override
	public String toString()
	{
		return "SEXE{" +
				"id=" + id +
				", tipus='" + tipus + '\'' +
				'}';
	}
}
