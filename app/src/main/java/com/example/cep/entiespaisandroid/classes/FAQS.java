package com.example.cep.entiespaisandroid.classes;

/**
 * CLASSE FAQS
 */
public class FAQS
{
	//ATRIBUTS
	private int id;
	private String pregunta;
	private String descripcion;

	//CONSTRUCTORS
	public FAQS()
	{
	}

	public FAQS(int id, String pregunta, String descripcion)
	{
		this.id = id;
		this.pregunta = pregunta;
		this.descripcion = descripcion;
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

	public String getPregunta()
	{
		return pregunta;
	}

	public void setPregunta(String pregunta)
	{
		this.pregunta = pregunta;
	}

	public String getDescripcion()
	{
		return descripcion;
	}

	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}
}
