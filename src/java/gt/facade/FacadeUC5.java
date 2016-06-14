package gt.facade;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

import org.apache.log4j.Logger;
import gt.model.*;

@Stateless(name="facadeUC5")
public class FacadeUC5 {

	final static Logger logger = Logger.getLogger(FacadeUC5.class);

	@PersistenceContext(unitName = "GTlaboratory")
	private EntityManager em ;

	public FacadeUC5() {}	

	public List<Esame> esamiEffettuatiMedico(String nome,String cognome){
		String jpql = "SELECT e FROM Esame e,Medico m WHERE e.medico.id=m.id and m.nome='"+nome+"' and m.cognome='"+cognome+"'";   
		TypedQuery<Esame> q = em.createQuery(jpql, Esame.class);
		logger.debug(em);
		List<Esame> esami = q.getResultList();	
		return esami;
	}

	public List<Medico> anagraficaMedici() {
		CriteriaQuery<Medico> cq = em.getCriteriaBuilder().createQuery(Medico.class);
		logger.debug(em);
		cq.select(cq.from(Medico.class));
		List<Medico> t = em.createQuery(cq).getResultList();
		return  t;
	}

	public EntityManager getEm() {return em;}
	public void setEm(EntityManager em) {this.em = em;}
}
