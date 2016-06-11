package gt.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.faces.application.FacesMessage;
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

	public String loginA() throws Exception {
		if(facade.loginAmministratore(username, password))
			return "funAmministratore.xhtml";
		this.setError("error");
		this.stringaErrore = "Inserisci dei dati validi per Autenticarti!";
		return "amministratore.xhtml";
	}
	/*public String loginProject() throws Exception {
        boolean result = facade.loginAmministratore(username, password);
        if (result) {
            // Richiama la sessione Http e salva username
            HttpSession session = Util.getSession();
            session.setAttribute("username", username);

            return "funAmministratore.xhtml";
        } else {

            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Credenziali di accesso non valide!",
                    "Riprova di nuovo!"));

            // manda un messaggio di sessione non valida
            return "amministratore.xhtml";
        }
    }

    public String logout() {
      HttpSession session = Util.getSession();
      session.invalidate();
      return "amministratore.xhtml";
   }*/


	public String loginP() throws Exception {
		String rit="paziente.xhtml";
		if(facade.loginPaziente(username, password))
			rit="index.xhtml";
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
	public String getError() {return error;}
	public void setError(String error) {this.error = error;}
	public String getStringaErrore() {return stringaErrore;}
	public void setStringaErrore(String stringaErrore) {this.stringaErrore = stringaErrore;}
	public FacadeLogin getFacade() {return facade;}
	public void setFacade(FacadeLogin facade) {this.facade = facade;}

}