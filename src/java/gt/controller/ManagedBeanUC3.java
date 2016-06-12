package gt.controller;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedProperty;

import gt.facade.FacadeUC3;
import gt.model.*;


@ManagedBean
public class ManagedBeanUC3 {
	
	private Paziente paziente;
	
	@ManagedProperty("#{codEsame}")
	private String codEsame;
	private Esame esame;
	
	@EJB(beanName="facadeUC3")
	private FacadeUC3 facade;
	
	public String dettaglioEsame(){
		this.esame=facade.getEsame(codEsame);
		return "";
	}

	public Paziente getPaziente() {return paziente;}
	public void setPaziente(Paziente paziente) {this.paziente = paziente;}
	public String getCodEsame() {return codEsame;}
	public void setCodEsame(String codEsame) {this.codEsame = codEsame;}
	public Esame getEsame() {return esame;}
	public void setEsame(Esame esame) {this.esame = esame;}
	public FacadeUC3 getFacade() {return facade;}
	public void setFacade(FacadeUC3 facade) {this.facade = facade;}
	
}
