package com.example.cep.entiespaisandroid.classes;

/**
 * CLASSE DIA SEMANA
 */
public class DIAS_DEMANDA
{
	//ATRIBUTS
	private int id_demanda_act;
	private int id_dia_setmana;

	//CONSTRUCTORS
	public DIAS_DEMANDA()
	{

	}

	public DIAS_DEMANDA(int id_demanda_act, int id_dia_setmana)
	{
		this.id_demanda_act = id_demanda_act;
		this.id_dia_setmana = id_dia_setmana;
	}

	//GETTERS && SETTERS

	public int getId_demanda_act()
	{
		return id_demanda_act;
	}

	public void setId_demanda_act(int id_demanda_act)
	{
		this.id_demanda_act = id_demanda_act;
	}

	public int getId_dia_setmana()
	{
		return id_dia_setmana;
	}

	public void setId_dia_setmana(int id_dia_setmana)
	{
		this.id_dia_setmana = id_dia_setmana;
	}
}
