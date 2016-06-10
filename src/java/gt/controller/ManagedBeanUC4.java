package gt.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import gt.facade.FacadeUC4;
import gt.model.Indicatore;
import gt.model.Prerequisito;
import gt.model.TipologiaEsame;

@ManagedBean(name = "managedBeanUC4", eager = true)
@RequestScoped
public class ManagedBeanUC4 implements Serializable {

	private static final long serialVersionUID = 4L;

	@ManagedProperty("#{costo}")
	private Float costo;
	@ManagedProperty("#{nome}")
	private String nome;
	@ManagedProperty("#{descrizione}")
	private String descrizione;
	private String error1;
	private String error2;
	private String error3;
	private long idTipologia;
	@ManagedProperty("#{tipologia}")
	private TipologiaEsame tipologia;
	private List<TipologiaEsame> tipologie;
	private List<Indicatore> indicatori;
	private Set<Indicatore> indicatoriS;
	private List<Prerequisito> prerequisiti;
	private Set<Prerequisito> prerequisitiS;
	@ManagedProperty("#{idIndicatore1}")
	private long idIndicatore1;
	@ManagedProperty("#{idIndicatore2}")
	private long idIndicatore2;
	@ManagedProperty("#{idIndicatore3}")
	private long idIndicatore3;
	@ManagedProperty("#{idPrerequisito1}")
	private long idPrerequisito1;
	@ManagedProperty("#{idPrerequisito2}")
	private long idPrerequisito2;
	@ManagedProperty("#{idPrerequisito3}")
	private long idPrerequisito3;


	@EJB(beanName="facadeUC4")
	private FacadeUC4 facade;

	public ManagedBeanUC4(){}

	public String stampaTipiEsame(){
		this.setTipologie(facade.consultaOfferta());
		return "inserisciTipologia.xhtml";
	}
	public String creaTipologiaEsame(){
		if(this.nome.isEmpty()) {
			this.error1 = "error";
			this.setTipologie(facade.consultaOfferta());
			return "inserisciTipologia.xhtml";
		} 
		if(this.costo==0L){
			this.error2 = "error";
			this.setTipologie(facade.consultaOfferta());
			return "inserisciTipologia.xhtml";
		}
		this.tipologia = facade.inziaTipoEsame(nome, descrizione, costo);
		this.idTipologia = this.tipologia.getId();
		this.indicatori = facade.getIndicatori();
		this.prerequisiti = facade.getPrerequisiti();
		return "associaIndicatoriRequisiti.xhtml";
	}
	public String aggiungiIndicatoriRequisiti(){
		List<Long> idInd = new ArrayList<Long>();
		if(idIndicatore1!=0L)
			idInd.add(idIndicatore1); 
		if(idIndicatore2!=0L)
			idInd.add(idIndicatore2); 
		if(idIndicatore3!=0L)
			idInd.add(idIndicatore3);

		List<Long> idReq = new ArrayList<Long>();
		if(idPrerequisito1!=0L)
			idReq.add(idPrerequisito1);
		if(idPrerequisito2!=0L); 
			idReq.add(idPrerequisito2); 
		if(idPrerequisito3!=0L)
			idReq.add(idPrerequisito3);
		
		facade.updateTipologia(idInd, idReq);
		this.tipologia = facade.trovaTipoEsame(idTipologia);
		this.setIndicatoriS(new TreeSet<Indicatore>(tipologia.getIndicatori()));
		this.setPrerequisitiS(new TreeSet<Prerequisito>(tipologia.getPrerequisiti()));
		return "confermaTipologia.xhtml";
	}

	public Float getCosto() {
		return costo;
	}

	public void setCosto(Float costo) {
		this.costo = costo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

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

	public String getError3() {
		return error3;
	}

	public void setError3(String error3) {
		this.error3 = error3;
	}

	public long getIdTipologia() {
		return idTipologia;
	}

	public void setIdTipologia(long idTipologia) {
		this.idTipologia = idTipologia;
	}

	public TipologiaEsame getTipologia() {
		return tipologia;
	}

	public void setTipologia(TipologiaEsame tipologia) {
		this.tipologia = tipologia;
	}

	public List<TipologiaEsame> getTipologie() {
		return tipologie;
	}

	public void setTipologie(List<TipologiaEsame> tipologie) {
		this.tipologie = tipologie;
	}

	public List<Indicatore> getIndicatori() {
		return indicatori;
	}

	public void setIndicatori(List<Indicatore> indicatori) {
		this.indicatori = indicatori;
	}

	public Set<Indicatore> getIndicatoriS() {
		return indicatoriS;
	}

	public void setIndicatoriS(Set<Indicatore> indicatoriS) {
		this.indicatoriS = indicatoriS;
	}

	public List<Prerequisito> getPrerequisiti() {
		return prerequisiti;
	}

	public void setPrerequisiti(List<Prerequisito> prerequisiti) {
		this.prerequisiti = prerequisiti;
	}


	public Set<Prerequisito> getPrerequisitiS() {
		return prerequisitiS;
	}

	public void setPrerequisitiS(Set<Prerequisito> prerequisitiS) {
		this.prerequisitiS = prerequisitiS;
	}

	public long getIdIndicatore1() {
		return idIndicatore1;
	}

	public void setIdIndicatore1(long idIndicatore1) {
		this.idIndicatore1 = idIndicatore1;
	}

	public long getIdIndicatore2() {
		return idIndicatore2;
	}

	public void setIdIndicatore2(long idIndicatore2) {
		this.idIndicatore2 = idIndicatore2;
	}

	public long getIdIndicatore3() {
		return idIndicatore3;
	}

	public void setIdIndicatore3(long idIndicatore3) {
		this.idIndicatore3 = idIndicatore3;
	}

	public long getIdPrerequisito1() {
		return idPrerequisito1;
	}

	public void setIdPrerequisito1(long idPrerequisito1) {
		this.idPrerequisito1 = idPrerequisito1;
	}

	public long getIdPrerequisito2() {
		return idPrerequisito2;
	}

	public void setIdPrerequisito2(long idPrerequisito2) {
		this.idPrerequisito2 = idPrerequisito2;
	}

	public long getIdPrerequisito3() {
		return idPrerequisito3;
	}

	public void setIdPrerequisito3(long idPrerequisito3) {
		this.idPrerequisito3 = idPrerequisito3;
	}

	public FacadeUC4 getFacade() {
		return facade;
	}

	public void setFacade(FacadeUC4 facade) {
		this.facade = facade;
	}


}
