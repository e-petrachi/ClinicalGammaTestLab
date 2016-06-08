package gt.facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import gt.model.*;

@Stateless(name="facadeUC3")
public class FacadeUC3 {
	
	final static Logger logger = Logger.getLogger(FacadeUC3.class);
	
	@PersistenceContext(unitName = "GTlaboratory")
	private EntityManager em ;
	
	private Long codpaziente;

	public FacadeUC3() {}

	public List<Esame> consultaEsami(Long codPaz){
		
		this.setCodpaziente(codPaz);
		String jpql = "SELECT e FROM Esame e WHERE paziente_id="+codPaz;   
		Query query = em.createQuery(jpql);
		logger.debug(em);
		@SuppressWarnings("unchecked")
		List<Esame> e =query.getResultList();
		return e;
	}

	public Esame getEsame(String codEsame){
		String jpql = "SELECT e FROM Esame e WHERE e.paziente.id="+this.codpaziente+" AND e.id="+codEsame;   
		Query query = em.createQuery(jpql);
		logger.debug(em);
		return (Esame) query.getSingleResult();
	}

	public EntityManager getEm() {return em;}
	public void setEm(EntityManager em) {this.em = em;}
	public Long getCodpaziente() {return codpaziente;}
	public void setCodpaziente(Long codpaziente) {this.codpaziente = codpaziente;}
}
