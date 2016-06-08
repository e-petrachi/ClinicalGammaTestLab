package gt.controller;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;

import gt.facade.FacadeUC5;
import gt.model.Esame;


@ManagedBean
public class ManagedBeanUC5 {
		
	private String cognome;
	private List<Esame> esami;
	private String nome;
	
	@EJB(beanName="facadeUC5")
	private FacadeUC5 facade;
	
	public String trovaEsami(){
		this.esami=facade.esamiEffettuatiMedico(nome, cognome);
		return "faces/storicoEsamiDottore";
		
	}
	public String getCognome() {return cognome;}
	public void setCognome(String cognome) {this.cognome = cognome;}
	public List<Esame> getEsami() {return esami;}
	public void setEsami(List<Esame> esami) {this.esami = esami;}
	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}
	public FacadeUC5 getFacade() {return facade;}
	public void setFacade(FacadeUC5 facade) {this.facade = facade;}
}
