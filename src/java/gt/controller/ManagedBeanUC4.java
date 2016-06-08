package gt.controller;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedProperty;

import gt.facade.FacadeUC4;

@ManagedBean
public class ManagedBeanUC4 {

	private Float costo;
	private String nome;
	private String descrizione;
	
	@ManagedProperty(value="#{param.idIndicatore}")
	private String codiceIndicatore;
	private String key;
	private String value;
	
	@EJB(beanName="facadeUC4")
	private FacadeUC4 facade;
	
	public String creaTipo(){
		facade.inziaTipoEsame(nome, descrizione, costo);
		facade.setIndicatoriTipoEsame(codiceIndicatore);
		facade.setRequistiTipoEsame(key, value);
		facade.saveTipoEsame();
		return null;
	}

	public Float getCosto() {return costo;}
	public void setCosto(Float costo) {this.costo = costo;}
	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}
	public String getDescrizione() {return descrizione;}
	public void setDescrizione(String descrizione) {this.descrizione = descrizione;}
	public String getCodiceIndicatore() {return codiceIndicatore;}
	public void setCodiceIndicatore(String codiceIndicatore) {this.codiceIndicatore = codiceIndicatore;}
	public String getKey() {return key;}
	public void setKey(String key) {this.key = key;}
	public String getValue() {return value;}
	public void setValue(String value) {this.value = value;}
	public FacadeUC4 getFacade() {return facade;}
	public void setFacade(FacadeUC4 facade) {this.facade = facade;}
	
}
