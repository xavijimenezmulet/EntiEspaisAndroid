package com.example.cep.entiespaisandroid.classes;

/**
 * CLASSE ESPAIS
 */
public class ESPAIS
{
	//ATRIBUTS
	private int id;
	private String nom;
	private double preu;
	private Boolean es_exterior;
	private int id_instalacio;

	//CONSTRUCTORS
	public ESPAIS()
	{
	}

	public ESPAIS(int id, String nom, double preu, Boolean es_exterior, int id_instalacio)
	{
		this.id = id;
		this.nom = nom;
		this.preu = preu;
		this.es_exterior = es_exterior;
		this.id_instalacio = id_instalacio;
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

	public double getPreu()
	{
		return preu;
	}

	public void setPreu(double preu)
	{
		this.preu = preu;
	}

	public Boolean getEs_exterior()
	{
		return es_exterior;
	}

	public void setEs_exterior(Boolean es_exterior)
	{
		this.es_exterior = es_exterior;
	}

	public int getId_instalacio()
	{
		return id_instalacio;
	}

	public void setId_instalacio(int id_instalacio)
	{
		this.id_instalacio = id_instalacio;
	}
}
