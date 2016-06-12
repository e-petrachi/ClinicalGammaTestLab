package gt.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ManagedBean;

import gt.facade.*;

@ManagedBean(name = "managedBeanLogin")
public class ManagedBeanLogin implements Serializable {

	private static final long serialVersionUID = 3L;

	@ManagedProperty("#{user}")
	private String username;	
	private String password;
	private String error;
	private String stringaErrore;

	@EJB(beanName="facadeLogin")
	private FacadeLogin facade;

	@EJB(beanName="facadeUC1")
	private FacadeUC1 facade1;

	public ManagedBeanLogin(){}

	public String loginA() {
		if(facade.loginAmministratore(username, password))
			return "funAmministratore.xhtml";
		this.setError("error");
		this.stringaErrore = "Inserisci dei dati validi per Autenticarti!";
		return "amministratore.xhtml";
	}
	
	public String loginP() {
		if(facade.loginPaziente(username, password))
			return "";
		this.setError("error");
		this.stringaErrore = "Inserisci dei dati validi per Autenticarti!";
		return "amministratore.xhtml";
	}
	public String avviamento() {
		facade1.avvia();
		return "amministratore.xhtml";
	}

	public String getUsername() {return username;}
	public void setUsername(String username) {this.username = username;}
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	public String getError() {return error;}
	public void setError(String error) {this.error = error;}
	public String getStringaErrore() {return stringaErrore;}
	public void setStringaErrore(String stringaErrore) {this.stringaErrore = stringaErrore;}
	public FacadeLogin getFacade() {return facade;}
	public void setFacade(FacadeLogin facade) {this.facade = facade;}

}