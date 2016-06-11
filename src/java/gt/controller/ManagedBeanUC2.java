package gt.controller;

import javax.faces.bean.ManagedBean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import gt.facade.FacadeUC2;
import gt.model.*;

@ManagedBean(name = "managedBeanUC2")
@RequestScoped
public class ManagedBeanUC2 implements Serializable {

	private static final long serialVersionUID = 2L;

	@ManagedProperty("#{tipo}")
	private long tipo;
	@ManagedProperty("#{paziente}")
	private String paziente;
	private Paziente p;
	private TipologiaEsame t;
	private Esame esame;
	private List<TipologiaEsame> tipologie;
	private List<Paziente> pazienti;
	private String error;

	private String stringaErrore;

	@EJB(beanName="facadeUC2")
	private FacadeUC2 facade;

	public ManagedBeanUC2(){}

	public String stampaTipiEsame(){
		this.setTipologie(facade.consultaOfferta());
		return "inserisciEsame.xhtml";
	} 
	public String creaEsame(){	
		this.setPazienti(facade.getPazienti());
		if(facade.trovaTipoEsame(tipo)==null) {
			this.error = "error";
			this.setStringaErrore("Inserisci un ID valido!");
			this.setTipologie(facade.consultaOfferta());
			return "inserisciEsame.xhtml";
		}
		this.setT(facade.trovaTipoEsame(tipo));
		return "associaPaziente.xhtml";
	}
	public String associaEsame(){	
		this.setT(facade.trovaTipoEsame(tipo));
		if(facade.trovaPaziente(paziente)==null) {
			this.error = "error";
			this.setStringaErrore("Inserisci un USER valido!");
			this.setPazienti(facade.getPazienti());
			return "associaPaziente.xhtml";
		}
		this.setP(facade.trovaPaziente(paziente));	
		Esame e = facade.creaEsame(p,t);
		this.esame = e;
		return "confermaEsame.xhtml";
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
	public Paziente getP() {return p;}
	public void setP(Paziente p) {this.p = p;}
	public TipologiaEsame getT() {return t;}
	public void setT(TipologiaEsame t) {this.t = t;}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getStringaErrore() {
		return stringaErrore;
	}

	public void setStringaErrore(String stringaErrore) {
		this.stringaErrore = stringaErrore;
	}


}
