package gt.facade;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.log4j.Logger;
import gt.model.*;

@Stateless(name="facadeUC5")
public class FacadeUC5 {

	final static Logger logger = Logger.getLogger(FacadeUC5.class);

	@PersistenceContext(unitName = "GTlaboratory")
	private EntityManager em ;

	public FacadeUC5() {}	

	@SuppressWarnings("unchecked")
	public List<Esame> esamiEffettuatiMedico(String nome,String cognome){
		String jpql = "SELECT e FROM Esame e,Medico m WHERE e.medico.id=m.id and m.nome='"+nome+"' and m.cognome='"+cognome+"'";   
		Query query = em.createQuery(jpql);
		logger.debug(em);
		return (List<Esame>) query.getResultList();		
	}

	public EntityManager getEm() {return em;}
	public void setEm(EntityManager em) {this.em = em;}
}
