package gt.controller;

import java.util.Date;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedProperty;

import gt.facade.FacadeUC6;
import gt.model.*;

@ManagedBean
public class ManagedBeanUC6 {

	@ManagedProperty(value="#{param.idEsame}")
	private Long codEsame;
	private Esame esame;
	private Risultato risultato;

	private String valore;

	private String indicatore;
	private String nomeMedico;
	private String cognomeMedico;

	private Date data;

	@EJB(beanName="facadeUC6")
	private FacadeUC6 facade;

	public String trovaEsame(){
		this.esame=facade.getEsame(codEsame);
		return "faces/inserisciMedicoData.jsp";
	}

	public String inserisciMedico_ora(){
		facade.setMedicoAndEsame(nomeMedico, cognomeMedico, codEsame,data);
		return "faces/compilaRisultati.jsp";
	}

	public String inserisciRisultati(){
		facade.inserisciRisutatiEsame(indicatore, valore);
		return "faces/compilaRisultati.jsp";
	}

	public Long getCodEsame() {return codEsame;}
	public void setCodEsame(Long codEsame) {this.codEsame = codEsame;}
	public Esame getEsame() {return esame;}
	public void setEsame(Esame esame) {this.esame = esame;}
	public Risultato getRisultato() {return risultato;}
	public void setRisultato(Risultato risultato) {this.risultato = risultato;}
	public String getValore() {return valore;}
	public void setValore(String valore) {this.valore = valore;}
	public String getIndicatore() {return indicatore;}
	public void setIndicatore(String indicatore) {this.indicatore = indicatore;}
	public String getNomeMedico() {return nomeMedico;}
	public void setNomeMedico(String nomeMedico) {this.nomeMedico = nomeMedico;}
	public String getCognomeMedico() {return cognomeMedico;}
	public void setCognomeMedico(String cognomeMedico) {this.cognomeMedico = cognomeMedico;}
	public Date getData() {return data;}
	public void setData(Date data) {this.data = data;}
	public FacadeUC6 getFacade() {return facade;}
	public void setFacade(FacadeUC6 facade) {this.facade = facade;}
}
