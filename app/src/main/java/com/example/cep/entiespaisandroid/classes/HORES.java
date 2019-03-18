package com.example.cep.entiespaisandroid.classes;

import java.time.LocalTime;

/**
 * CLASSE HORES
 */
public class HORES
{
	//ATRIBUTS
	private int id;
	private LocalTime inici;
	private LocalTime fi;

	//CONSTRUCTORS
	public HORES()
	{
	}

	public HORES(int id, LocalTime inici, LocalTime fi)
	{
		this.id = id;
		this.inici = inici;
		this.fi = fi;
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

	public LocalTime getInici()
	{
		return inici;
	}

	public void setInici(LocalTime inici)
	{
		this.inici = inici;
	}

	public LocalTime getFi()
	{
		return fi;
	}

	public void setFi(LocalTime fi)
	{
		this.fi = fi;
	}
}
