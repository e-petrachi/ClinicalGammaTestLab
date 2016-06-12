package gt.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.log4j.Logger;
import gt.model.Amministratore;
import gt.model.Paziente;

@Stateless(name="facadeLogin")
public class FacadeLogin {
	
	final static Logger logger = Logger.getLogger(FacadeLogin.class);
	
	@PersistenceContext(unitName = "GTlaboratory")
	private EntityManager em ;
	
	private Paziente pazienteCorrente;
	private Amministratore amministratoreCorrente;
	
	public FacadeLogin(){}
	
	public boolean loginPaziente(String username ,String password) {
		boolean var=false;
		Paziente paziente_nonAutenticato=em.find(Paziente.class, username);

		if( paziente_nonAutenticato.checkPassword(password)){ 
			this.pazienteCorrente=paziente_nonAutenticato; 
			var=  true; 
		}
		return var;
	}
	public boolean loginAmministratore(String username ,String password) {
		boolean var=false;
		if(em.find(Amministratore.class, username)==null) return false; 
		Amministratore amministratore_nonAutenticato=em.find(Amministratore.class, username);
		if( amministratore_nonAutenticato.checkPassword(password)){ 
			this.amministratoreCorrente=amministratore_nonAutenticato; 
			var=  true; 
		}
		return var;
	}

	
	public EntityManager getEm() {return em;}
	public void setEm(EntityManager em) {this.em = em;}
	public Paziente getPazienteCorrente() {return pazienteCorrente;}
	public void setPazienteCorrente(Paziente pazienteCorrente) {this.pazienteCorrente = pazienteCorrente;}
	public Amministratore getAmministratoreCorrente() {return amministratoreCorrente;}
	public void setAmministratoreCorrente(Amministratore amministratoreCorrente) {this.amministratoreCorrente = amministratoreCorrente;}
	
}
