package com.example.cep.entiespaisandroid.utilities;

import com.example.cep.entiespaisandroid.classes.ACTIVITATS;
import com.example.cep.entiespaisandroid.classes.ADMINISTRADORS;
import com.example.cep.entiespaisandroid.classes.CATEGORIA_EDAT;
import com.example.cep.entiespaisandroid.classes.CATEGORIA_EQUIP;
import com.example.cep.entiespaisandroid.classes.COMPETICIONS;
import com.example.cep.entiespaisandroid.classes.DEMANDA_ACT;
import com.example.cep.entiespaisandroid.classes.DIAS_DEMANDA;
import com.example.cep.entiespaisandroid.classes.DIA_SEMANA;
import com.example.cep.entiespaisandroid.classes.ENTITATS;
import com.example.cep.entiespaisandroid.classes.EQUIPS;
import com.example.cep.entiespaisandroid.classes.ESPAIS;
import com.example.cep.entiespaisandroid.classes.ESPORTS;
import com.example.cep.entiespaisandroid.classes.FAQS;
import com.example.cep.entiespaisandroid.classes.HORARI_ACTIVITAT;
import com.example.cep.entiespaisandroid.classes.HORARI_INSTALACIO;
import com.example.cep.entiespaisandroid.classes.HORES;
import com.example.cep.entiespaisandroid.classes.INSTALACIONS;
import com.example.cep.entiespaisandroid.classes.SEXE;
import com.example.cep.entiespaisandroid.classes.TELEFONS_ENTITATS;
import com.example.cep.entiespaisandroid.classes.TELEFONS_INSTALACIONS;

import java.util.ArrayList;

/**
 * CLASSE UTILITARIA PER CONTROLAR LES CONEXIONS
 */
public class Conexions
{
	//STATICS PER NO CREAR INSTANCIA D'OBJECTE
	public static ArrayList<ACTIVITATS> activitats;
	public static ArrayList<ADMINISTRADORS> administradors;
	public static ArrayList<CATEGORIA_EDAT> categoria_edats;
	public static ArrayList<CATEGORIA_EQUIP> categoria_equips;
	public static ArrayList<COMPETICIONS> competicions;
	public static ArrayList<DEMANDA_ACT> demanda_acts;
	public static ArrayList<DIA_SEMANA> dies_setmana;
	public static ArrayList<DIAS_DEMANDA> dias_demanda;
	public static ArrayList<ENTITATS> entitats;
	public static ArrayList<EQUIPS> equips;
	public static ArrayList<ESPAIS> espais;
	public static ArrayList<ESPORTS> esports;
	public static ArrayList<FAQS> faqs;
	public static ArrayList<HORARI_ACTIVITAT> horari_activitats;
	public static ArrayList<HORARI_INSTALACIO> horari_instalacios;
	public static ArrayList<HORES> hores;
	public static ArrayList<INSTALACIONS> instalacions;
	public static ArrayList<SEXE> sexes;
	public static ArrayList<TELEFONS_ENTITATS> telefons_entitats;
	public static ArrayList<TELEFONS_INSTALACIONS> telefons_instalacions;
	public static ENTITATS entitat_conectada;
	//public static ArrayList<EQUIPS> equipsGeneral;

	//GETTERS && SETTERS
	public static ArrayList<ACTIVITATS> getActivitats()
	{
		return activitats;
	}

	public static void setActivitats(ArrayList<ACTIVITATS> activitats)
	{
		Conexions.activitats = activitats;
	}

	public static ArrayList<ADMINISTRADORS> getAdministradors()
	{
		return administradors;
	}

	public static void setAdministradors(ArrayList<ADMINISTRADORS> administradors)
	{
		Conexions.administradors = administradors;
	}

	public static ArrayList<CATEGORIA_EDAT> getCategoria_edats()
	{
		return categoria_edats;
	}

	public static void setCategoria_edats(ArrayList<CATEGORIA_EDAT> categoria_edats)
	{
		Conexions.categoria_edats = categoria_edats;
	}

	public static ArrayList<CATEGORIA_EQUIP> getCategoria_equips()
	{
		return categoria_equips;
	}

	public static void setCategoria_equips(ArrayList<CATEGORIA_EQUIP> categoria_equips)
	{
		Conexions.categoria_equips = categoria_equips;
	}

	public static ArrayList<COMPETICIONS> getCompeticions()
	{
		return competicions;
	}

	public static void setCompeticions(ArrayList<COMPETICIONS> competicions)
	{
		Conexions.competicions = competicions;
	}

	public static ArrayList<DEMANDA_ACT> getDemanda_acts()
	{
		return demanda_acts;
	}

	public static void setDemanda_acts(ArrayList<DEMANDA_ACT> demanda_acts)
	{
		Conexions.demanda_acts = demanda_acts;
	}

	public static ArrayList<DIA_SEMANA> getDies_setmana()
	{
		return dies_setmana;
	}

	public static void setDies_setmana(ArrayList<DIA_SEMANA> dies_setmana)
	{
		Conexions.dies_setmana = dies_setmana;
	}

	public static ArrayList<DIAS_DEMANDA> getDias_demanda()
	{
		return dias_demanda;
	}

	public static void setDias_demanda(ArrayList<DIAS_DEMANDA> dias_demanda)
	{
		Conexions.dias_demanda = dias_demanda;
	}

	public static ArrayList<ENTITATS> getEntitats()
	{
		return entitats;
	}

	public static void setEntitats(ArrayList<ENTITATS> entitats)
	{
		Conexions.entitats = entitats;
	}

	public static ArrayList<EQUIPS> getEquips()
	{
		return equips;
	}

	public static void setEquips(ArrayList<EQUIPS> equips)
	{
		Conexions.equips = equips;
	}

	public static ArrayList<ESPAIS> getEspais()
	{
		return espais;
	}

	public static void setEspais(ArrayList<ESPAIS> espais)
	{
		Conexions.espais = espais;
	}

	public static ArrayList<ESPORTS> getEsports()
	{
		return esports;
	}

	public static void setEsports(ArrayList<ESPORTS> esports)
	{
		Conexions.esports = esports;
	}

	public static ArrayList<FAQS> getFaqs()
	{
		return faqs;
	}

	public static void setFaqs(ArrayList<FAQS> faqs)
	{
		Conexions.faqs = faqs;
	}

	public static ArrayList<HORARI_ACTIVITAT> getHorari_activitats()
	{
		return horari_activitats;
	}

	public static void setHorari_activitats(ArrayList<HORARI_ACTIVITAT> horari_activitats)
	{
		Conexions.horari_activitats = horari_activitats;
	}

	public static ArrayList<HORARI_INSTALACIO> getHorari_instalacios()
	{
		return horari_instalacios;
	}

	public static void setHorari_instalacios(ArrayList<HORARI_INSTALACIO> horari_instalacios)
	{
		Conexions.horari_instalacios = horari_instalacios;
	}

	public static ArrayList<HORES> getHores()
	{
		return hores;
	}

	public static void setHores(ArrayList<HORES> hores)
	{
		Conexions.hores = hores;
	}

	public static ArrayList<INSTALACIONS> getInstalacions()
	{
		return instalacions;
	}

	public static void setInstalacions(ArrayList<INSTALACIONS> instalacions)
	{
		Conexions.instalacions = instalacions;
	}

	public static ArrayList<SEXE> getSexes()
	{
		return sexes;
	}

	public static void setSexes(ArrayList<SEXE> sexes)
	{
		Conexions.sexes = sexes;
	}

	public static ArrayList<TELEFONS_ENTITATS> getTelefons_entitats()
	{
		return telefons_entitats;
	}

	public static void setTelefons_entitats(ArrayList<TELEFONS_ENTITATS> telefons_entitats)
	{
		Conexions.telefons_entitats = telefons_entitats;
	}

	public static ArrayList<TELEFONS_INSTALACIONS> getTelefons_instalacions()
	{
		return telefons_instalacions;
	}

	public static void setTelefons_instalacions(ArrayList<TELEFONS_INSTALACIONS> telefons_instalacions)
	{
		Conexions.telefons_instalacions = telefons_instalacions;
	}

	public static ENTITATS getEntitat_conectada()
	{
		return entitat_conectada;
	}

	public static void setEntitat_conectada(ENTITATS entitat_conectada)
	{
		Conexions.entitat_conectada = entitat_conectada;
	}

	public static void getDadesProvaEntitatConectada(){
		entitat_conectada = new ENTITATS();
		entitat_conectada.setNom("S.E. SANT CUGAT");
		entitat_conectada.setAdresa("Germandat 49, Sant Cugat del Vallès");
		entitat_conectada.setNif("B1234567");
		entitat_conectada.setEmail("sesantcugat@gmail.com)");
		entitat_conectada.setRuta_imagen("http://cdn.ertheo.com/blog/wp-content/uploads/2018/06/Fc_barcelona.png");
		entitat_conectada.setRuta_video("http://techslides.com/demos/sample-videos/small.mp4");
	}

	public static void getTelefonsEntitatProva(){
		telefons_entitats = new ArrayList<TELEFONS_ENTITATS>();
		TELEFONS_ENTITATS te = new TELEFONS_ENTITATS();
		te.setNumero("692882429");
		telefons_entitats.add(te);
		te.setNumero("938174107");
		telefons_entitats.add(te);

	}
}
