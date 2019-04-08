package com.example.cep.entiespaisandroid.classes;

import java.sql.Time;
import java.time.LocalTime;

/**
 * CLASSE HORES
 */
public class HORES
{
	//ATRIBUTS
	private int id;
	private String inici;
	private String fi;

	//CONSTRUCTORS
	public HORES()
	{
	}

	public HORES(int id, String inici, String fi)
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

	public String getInici()
	{
		return inici;
	}

	public void setInici(String inici)
	{
		this.inici = inici;
	}

	public String getFi()
	{
		return fi;
	}

	public void setFi(String fi)
	{
		this.fi = fi;
	}
}
