package gt.controller;

import java.io.Serializable;
import java.util.List;


import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import gt.facade.FacadeUC5;
import gt.model.Esame;
import gt.model.Medico;


@ManagedBean(name = "managedBeanUC5")
public class ManagedBeanUC5 implements Serializable {
	
	private static final long serialVersionUID = 5L;
		
	@ManagedProperty("#{nome}")
	private String nome;
	@ManagedProperty("#{cognome}")
	private String cognome;
	private List<Esame> esami;
	private List<Medico> medici;
	private String error1;
	private String error2;
	
	@EJB(beanName="facadeUC5")
	private FacadeUC5 facade;
	
	public String consultaAnagraficaMedici(){
		this.medici=facade.anagraficaMedici();
		return "ricercaEsami.xhtml";
	}
	public String trovaEsami(){
		if(nome.isEmpty()){
			this.error1 = "error";
			this.medici=facade.anagraficaMedici();
			return "ricercaEsami.xhtml";
		} else if(cognome.isEmpty()){
			this.error2 = "error";
			this.medici=facade.anagraficaMedici();
			return "ricercaEsami.xhtml";
		}
		this.esami=facade.esamiEffettuatiMedico(nome, cognome);
		return "storicoEsamiMedico.xhtml";
		
	}
	public String getCognome() {return cognome;}
	public void setCognome(String cognome) {this.cognome = cognome;}
	public List<Esame> getEsami() {return esami;}
	public void setEsami(List<Esame> esami) {this.esami = esami;}
	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}
	public List<Medico> getMedici() {return medici;}
	public void setMedici(List<Medico> medici) {this.medici = medici;}
	public String getError1() {
		return error1;
	}
	public void setError1(String error1) {
		this.error1 = error1;
	}
	public String getError2() {
		return error2;
	}
	public void setError2(String error2) {
		this.error2 = error2;
	}
	public FacadeUC5 getFacade() {return facade;}
	public void setFacade(FacadeUC5 facade) {this.facade = facade;}
}
