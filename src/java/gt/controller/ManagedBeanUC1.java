package gt.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import gt.facade.FacadeUC1;
import gt.model.Indicatore;
import gt.model.Prerequisito;
import gt.model.TipologiaEsame;

@ManagedBean(name = "managedBeanUC1", eager = true)
public class ManagedBeanUC1 implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty("#{id}")
	private long id;	
	private TipologiaEsame tipologia;
	private Set<Prerequisito> prerequisiti;
	private Set<Indicatore> indicatori;
	private List<TipologiaEsame> tipologie;

	@EJB(beanName="facadeUC1")
	private FacadeUC1 facade;

	public ManagedBeanUC1(){}
	
	public String avviamento(){
		facade.avvia();
		return "freeUser.xhtml";
	}
	public String stampaTipiEsame(){
		this.tipologie=facade.consultaOfferta();
		return "consultaOffertaTipo.xhtml";
	}
	public String scegliTipologia(){
		this.tipologia=facade.stampaTipoEsame(id);
		this.indicatori= new TreeSet<Indicatore>(tipologia.getIndicatori());
		this.prerequisiti= new TreeSet<Prerequisito>(tipologia.getPrerequisiti());
		return "offerta.xhtml";
	}

	public List<TipologiaEsame> getTipiEsame() {return tipologie;}
	public void setTipiEsame(List<TipologiaEsame> tipiEsame) {this.tipologie = tipiEsame;}
	public TipologiaEsame getTipoEsame() {return tipologia;}
	public void setTipoEsame(TipologiaEsame tipoEsame) {this.tipologia = tipoEsame;}
	public long getId() {return id;}
	public void setId(long id) {this.id = id;}
	public TipologiaEsame getTipologia() {return tipologia;}
	public void setTipologia(TipologiaEsame tipologia) {this.tipologia = tipologia;}
	public List<TipologiaEsame> getTipologie() {return tipologie;}
	public void setTipologie(List<TipologiaEsame> tipologie) {this.tipologie = tipologie;}
	public Set<Prerequisito> getPrerequisiti() {return prerequisiti;}
	public void setPrerequisiti(Set<Prerequisito> prerequisiti) {this.prerequisiti = prerequisiti;}
	public Set<Indicatore> getIndicatori() {return indicatori;}
	public void setIndicatori(Set<Indicatore> indicatori) {this.indicatori = indicatori;}
	public FacadeUC1 getFacade() {return facade;}
	public void setFacade(FacadeUC1 facade) {this.facade = facade;}
	
}
