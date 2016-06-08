package gt.facade;

import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.log4j.Logger;
import gt.model.*;


@Stateless(name="facadeUC6")
public class FacadeUC6 {
	
	final static Logger logger = Logger.getLogger(FacadeUC6.class);

	@PersistenceContext(unitName = "GTlaboratory")
	private EntityManager em ;

	private Esame esame;
	private Indicatore indicatore;

	public FacadeUC6() {}

	public void setMedicoAndEsame(String nome,String cognome,Long codEsame,Date date){
		em.find(Esame.class,codEsame);
		String jpql = "SELECT m FROM Medico m WHERE  m.nome='"+nome+"' and m.cognome='"+cognome+"'";   
		Query query = em.createQuery(jpql);
		Medico medico= (Medico) query.getResultList();	
		esame.setMedico(medico);
		esame.setDataeffettuata(date);
		medico.addEsame(esame);
		em.merge(esame);
		em.merge(medico);
		logger.debug(em);
	}
	public void inserisciRisutatiEsame(String codice,String valore){
		Risultato risultato;
		this.indicatore=em.find(Indicatore.class, codice);
		risultato= new Risultato(indicatore,valore);
		
		em.persist(risultato);
		logger.debug(em);
	}
	
	public Esame getEsame(Long codEsame){
		String jpql = "SELECT e FROM Esame e WHERE  e.id="+codEsame;   
		Query query = em.createQuery(jpql);
		logger.debug(em);
		return (Esame) query.getSingleResult();
	}

	public EntityManager getEm() {return em;}
	public void setEm(EntityManager em) {this.em = em;}
	public Esame getEsame() {return esame;}
	public void setEsame(Esame esame) {this.esame = esame;}
	public Indicatore getIndicatore() {return indicatore;}
	public void setIndicatore(Indicatore indicatore) {this.indicatore = indicatore;}

}
