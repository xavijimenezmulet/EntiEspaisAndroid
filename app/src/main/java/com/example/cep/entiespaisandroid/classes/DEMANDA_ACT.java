package com.example.cep.entiespaisandroid.classes;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * CLASSE DEMANDA ACTIVITAT
 */
public class DEMANDA_ACT implements Serializable
{
	//ATRIBUTS
	private int id;
	private String nom;
	private byte num_espais;
	private byte num_dies;
	private Boolean es_asignada;
	private int id_equip;
	private int id_interval_hores;
	private int id_espai;
	private ArrayList<DIA_SEMANA> DIA_SEMANA;
	//CONSTRUCTORS
	public DEMANDA_ACT()
	{
	}

	public DEMANDA_ACT(int id, String nom, byte num_espais, byte num_dies, Boolean es_asignada, int id_equip, int id_interval_hores, int id_espai, ArrayList<DIA_SEMANA> DIA_SEMANA)
	{
		this.id = id;
		this.nom = nom;
		this.num_espais = num_espais;
		this.num_dies = num_dies;
		this.es_asignada = es_asignada;
		this.id_equip = id_equip;
		this.id_interval_hores = id_interval_hores;
		this.id_espai = id_espai;
		this.DIA_SEMANA=DIA_SEMANA;
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
/**
	public LocalTime getDuracio()
	{
		return duracio;
	}

	public void setDuracio(LocalTime duracio)
	{
		this.duracio = duracio;
	}
**/
	public byte getNum_espais()
	{
		return num_espais;
	}

	public void setNum_espais(byte num_espais)
	{
		this.num_espais = num_espais;
	}

	public byte getNum_dies()
	{
		return num_dies;
	}

	public void setNum_dies(byte num_dies)
	{
		this.num_dies = num_dies;
	}

	public Boolean getEs_asignada()
	{
		return es_asignada;
	}

	public void setEs_asignada(Boolean es_asignada)
	{
		this.es_asignada = es_asignada;
	}

	public int getId_equip()
	{
		return id_equip;
	}

	public void setId_equip(int id_equip)
	{
		this.id_equip = id_equip;
	}

	public int getId_interval_hores()
	{
		return id_interval_hores;
	}

	public void setId_interval_hores(int id_interval_hores)
	{
		this.id_interval_hores = id_interval_hores;
	}

	public int getId_espai()
	{
		return id_espai;
	}

	public void setId_espai(int id_espai)
	{
		this.id_espai = id_espai;
	}

	public ArrayList<DIA_SEMANA> getDia_semanas() {
		return DIA_SEMANA;
	}

	public void setDia_semanas(ArrayList<DIA_SEMANA> DIA_SEMANA) {
		this.DIA_SEMANA = DIA_SEMANA;
	}

}
