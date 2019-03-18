package com.example.cep.entiespaisandroid.classes;

/**
 * CLASSE ADMINISTRADORS
 */
public class ADMINISTRADORS
{
	//ATRIBUTS
	private int id;
	private String contrasenya;
	private String nom;
	private String cognoms;
	private String dni;
	private String email;

	//CONSTRUCTORS
	public ADMINISTRADORS()
	{
	}

	public ADMINISTRADORS(int id, String contrasenya, String nom, String cognoms, String dni, String email)
	{
		this.id = id;
		this.contrasenya = contrasenya;
		this.nom = nom;
		this.cognoms = cognoms;
		this.dni = dni;
		this.email = email;
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

	public String getContrasenya()
	{
		return contrasenya;
	}

	public void setContrasenya(String contrasenya)
	{
		this.contrasenya = contrasenya;
	}

	public String getNom()
	{
		return nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public String getCognoms()
	{
		return cognoms;
	}

	public void setCognoms(String cognoms)
	{
		this.cognoms = cognoms;
	}

	public String getDni()
	{
		return dni;
	}

	public void setDni(String dni)
	{
		this.dni = dni;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}
}
