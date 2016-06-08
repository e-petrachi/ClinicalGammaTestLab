package gt.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ManagedBean;

import gt.facade.*;

@ManagedBean(name = "managedBeanLogin")
public class ManagedBeanLogin implements Serializable {

	private static final long serialVersionUID = 2L;
	
	@ManagedProperty("#{user}")
	private String username;	
	private String password;

	@EJB(beanName="facadeLogin")
	private FacadeLogin facade;
	
	@EJB(beanName="facadeUC1")
	private FacadeUC1 facade1;

	public ManagedBeanLogin(){}
	
	public String loginA() {
		String rit="amministratore.xhtml";
		try {
			if(facade.loginAmministratore(username, password))
				rit="funAmministratore.xhtml";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rit;
	}


	public String loginP(){
		String rit="paziente.xhtml";
		try {
			if(facade.loginPaziente(username, password))
				rit="index.xhtml";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rit;
	}
	public String avviamento(){
		facade1.avvia();
		return "amministratore.xhtml";
	}


	public String getUsername() {return username;}
	public void setUsername(String username) {this.username = username;}
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	public FacadeLogin getFacade() {return facade;}
	public void setFacade(FacadeLogin facade) {this.facade = facade;}

}