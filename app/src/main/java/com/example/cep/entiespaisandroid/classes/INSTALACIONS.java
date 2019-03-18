package com.example.cep.entiespaisandroid.classes;

/**
 * CLASSE INSTALACIONS
 */
public class INSTALACIONS
{
	//ATRIBUTS
	private int id;
	private String nom;
	private String contrasenya;
	private String adresa;
	private String tipus;
	private String email;
	private String ruta_imagen;
	private double altitut;
	private double latitut;

	//CONSTRUCTORS

	public INSTALACIONS()
	{
	}

	public INSTALACIONS(int id, String nom, String contrasenya, String adresa, String tipus, String email, String ruta_imagen, double altitut, double latitut)
	{
		this.id = id;
		this.nom = nom;
		this.contrasenya = contrasenya;
		this.adresa = adresa;
		this.tipus = tipus;
		this.email = email;
		this.ruta_imagen = ruta_imagen;
		this.altitut = altitut;
		this.latitut = latitut;
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

	public String getContrasenya()
	{
		return contrasenya;
	}

	public void setContrasenya(String contrasenya)
	{
		this.contrasenya = contrasenya;
	}

	public String getAdresa()
	{
		return adresa;
	}

	public void setAdresa(String adresa)
	{
		this.adresa = adresa;
	}

	public String getTipus()
	{
		return tipus;
	}

	public void setTipus(String tipus)
	{
		this.tipus = tipus;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getRuta_imagen()
	{
		return ruta_imagen;
	}

	public void setRuta_imagen(String ruta_imagen)
	{
		this.ruta_imagen = ruta_imagen;
	}

	public double getAltitut()
	{
		return altitut;
	}

	public void setAltitut(double altitut)
	{
		this.altitut = altitut;
	}

	public double getLatitut()
	{
		return latitut;
	}

	public void setLatitut(double latitut)
	{
		this.latitut = latitut;
	}
}
