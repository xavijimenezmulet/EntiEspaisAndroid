package com.example.cep.entiespaisandroid.classes;

/**
 * CLASSE ENTITATS
 */
public class ENTITATS
{
	//ATRIBUTS
	private int id;
	private String temporada;
	private String nom;
	private String contrasenya;
	private String adresa;
	private String nif;
	private String email;
	private String ruta_imagen;
	private String ruta_video;
	private double altitud;
	private double latitud;

	//CONSTRUCTORS
	public ENTITATS()
	{
	}

	public ENTITATS(int id, String temporada, String nom, String contrasenya, String adresa, String nif, String email, String ruta_imagen, String ruta_video, double altitud, double latitud)
	{
		this.id = id;
		this.temporada = temporada;
		this.nom = nom;
		this.contrasenya = contrasenya;
		this.adresa = adresa;
		this.nif = nif;
		this.email = email;
		this.ruta_imagen = ruta_imagen;
		this.ruta_video = ruta_video;
		this.altitud = altitud;
		this.latitud = latitud;
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

	public String getTemporada()
	{
		return temporada;
	}

	public void setTemporada(String temporada)
	{
		this.temporada = temporada;
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

	public void setContrassenya(String contrasenya)
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

	public String getNif()
	{
		return nif;
	}

	public void setNif(String nif)
	{
		this.nif = nif;
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

	public String getRuta_video()
	{
		return ruta_video;
	}

	public void setRuta_video(String ruta_video)
	{
		this.ruta_video = ruta_video;
	}

	public double getAltitud()
	{
		return altitud;
	}

	public void setAltitud(double altitud)
	{
		this.altitud = altitud;
	}

	public double getLatitud()
	{
		return latitud;
	}

	public void setLatitud(double latitud)
	{
		this.latitud = latitud;
	}

	@Override
	public String toString()
	{
		return "ENTITATS{" +
				"id=" + id +
				", temporada='" + temporada + '\'' +
				", nom='" + nom + '\'' +
				", contrasenya='" + contrasenya + '\'' +
				", adresa='" + adresa + '\'' +
				", nif='" + nif + '\'' +
				", email='" + email + '\'' +
				", ruta_imagen='" + ruta_imagen + '\'' +
				", ruta_video='" + ruta_video + '\'' +
				", altitud=" + altitud +
				", latitud=" + latitud +
				'}';
	}
}
