package com.example.cep.entiespaisandroid.classes;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * CLASSE EQUIPS
 */
public class EQUIPS implements Parcelable
{
	//ATRIBUTS
	private int id;
	private String nom;
	private Boolean te_discapacitat;
	private int id_entitat;
	private String temporada;
	private int id_competicio;
	private int id_categoria_edat;
	private int id_categoria_equip;
	private int id_sexe;
	private int id_esport;

	//CONSTRUCTORS
	public EQUIPS()
	{
	}

	public EQUIPS(int id, String nom, Boolean te_discapacitat, int id_entitat, String temporada,
				  int id_competicio, int id_categoria_edat, int id_categoria_equip, int id_sexe,
				  int id_esport)
	{
		this.id = id;
		this.nom = nom;
		this.te_discapacitat = te_discapacitat;
		this.id_entitat = id_entitat;
		this.temporada = temporada;
		this.id_competicio = id_competicio;
		this.id_categoria_edat = id_categoria_edat;
		this.id_categoria_equip = id_categoria_equip;
		this.id_sexe = id_sexe;
		this.id_esport = id_esport;
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

	public Boolean getTe_discapacitat()
	{
		return te_discapacitat;
	}

	public void setTe_discapacitat(Boolean te_discapacitat)
	{
		this.te_discapacitat = te_discapacitat;
	}

	public int getId_entitat()
	{
		return id_entitat;
	}

	public void setId_entitat(int id_entitat)
	{
		this.id_entitat = id_entitat;
	}

	public String getTemporada()
	{
		return temporada;
	}

	public void setTemporada(String temporada)
	{
		this.temporada = temporada;
	}

	public int getId_competicio()
	{
		return id_competicio;
	}

	public void setId_competicio(int id_competicio)
	{
		this.id_competicio = id_competicio;
	}

	public int getId_categoria_edat()
	{
		return id_categoria_edat;
	}

	public void setId_categoria_edat(int id_categoria_edat)
	{
		this.id_categoria_edat = id_categoria_edat;
	}

	public int getId_categoria_equip()
	{
		return id_categoria_equip;
	}

	public void setId_categoria_equip(int id_categoria_equip)
	{
		this.id_categoria_equip = id_categoria_equip;
	}

	public int getId_sexe()
	{
		return id_sexe;
	}

	public void setId_sexe(int id_sexe)
	{
		this.id_sexe = id_sexe;
	}

	public int getId_esport()
	{
		return id_esport;
	}

	public void setId_esport(int id_esport)
	{
		this.id_esport = id_esport;
	}

	//
	protected EQUIPS(Parcel in) {
		id = in.readInt();
		nom = in.readString();
		te_discapacitat = in.readByte() != 0;
		id_entitat = in.readInt();
		temporada = in.readString();
		id_competicio = in.readInt();
		id_categoria_edat = in.readInt();
		id_categoria_equip = in.readInt();
		id_sexe = in.readInt();
		id_esport = in.readInt();
	}

	public static final Creator<EQUIPS> CREATOR = new Creator<EQUIPS>() {
		@Override
		public EQUIPS createFromParcel(Parcel in) {
			return new EQUIPS(in);
		}

		@Override
		public EQUIPS[] newArray(int size) {
			return new EQUIPS[size];
		}
	};

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(id);
		dest.writeString(nom);
		dest.writeByte((byte) (te_discapacitat ? 1 : 0));
		dest.writeInt(id_entitat);
		dest.writeString(temporada);
		dest.writeInt(id_competicio);
		dest.writeInt(id_categoria_edat);
		dest.writeInt(id_categoria_equip);
		dest.writeInt(id_sexe);
		dest.writeInt(id_esport);
	}

	@Override
	public String toString()
	{
		return "EQUIPS{" +
				"id=" + id +
				", nom='" + nom + '\'' +
				", te_discapacitat=" + te_discapacitat +
				", id_entitat=" + id_entitat +
				", temporada='" + temporada + '\'' +
				", id_competicio=" + id_competicio +
				", id_categoria_edat=" + id_categoria_edat +
				", id_categoria_equip=" + id_categoria_equip +
				", id_sexe=" + id_sexe +
				", id_esport=" + id_esport +
				'}';
	}
}
