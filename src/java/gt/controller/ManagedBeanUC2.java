package gt.controller;

import javax.faces.bean.ManagedBean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedProperty;

import gt.facade.FacadeUC2;
import gt.model.*;

@ManagedBean(name = "managedBeanUC2")
public class ManagedBeanUC2 implements Serializable {

	private static final long serialVersionUID = 3L;
	
	@ManagedProperty("#{tipo}")
	private long tipo;
	@ManagedProperty("#{paziente}")
	private String paziente;
	private Paziente p;
	private TipologiaEsame t;
	private Esame esame;
	private List<TipologiaEsame> tipologie;
	private List<Paziente> pazienti;
	
	@EJB(beanName="facadeUC2")
	private FacadeUC2 facade;
	
	public ManagedBeanUC2(){}
	
	public String stampaTipiEsame(){
		this.setTipologie(facade.consultaOfferta());
		return "inserisciEsame.xhtml";
	} 
	public String creaEsame(){	
		this.setPazienti(facade.getPazienti());
		if(facade.trovaTipoEsame(tipo)==null) {return "index.xhtml";}
		this.t=facade.trovaTipoEsame(tipo);
		return "associaPaziente.xhtml";
	}
	public String associaEsame(){	
		this.p=facade.trovaPaziente(paziente);	
		Esame e = facade.creaEsame(p,t);
		if(e==null) return "erroreInserimentoEsame.xhtml";
		else{
			this.esame = e;
			return "confermaEsame.xhtml";
		}	
	}

	public long getTipo() {return tipo;}
	public void setTipo(long tipo) {this.tipo = tipo;}
	public String getPaziente() {return paziente;}
	public void setPaziente(String paziente) {this.paziente = paziente;}
	public Esame getEsame() {return esame;}
	public void setEsame(Esame esame) {this.esame = esame;}
	public List<TipologiaEsame> getTipologie() {return tipologie;}
	public void setTipologie(List<TipologiaEsame> tipologie) {this.tipologie = tipologie;}
	public List<Paziente> getPazienti() {return pazienti;}
	public void setPazienti(List<Paziente> pazienti) {this.pazienti = pazienti;}
	public FacadeUC2 getFacade() {return facade;}
	public void setFacade(FacadeUC2 facade) {this.facade = facade;}
	
}
