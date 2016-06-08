package gt.facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.apache.log4j.Logger;

import gt.model.*;

@Stateless(name="facadeUC2")
public class FacadeUC2 {

	final static Logger logger = Logger.getLogger(FacadeUC2.class);

	@PersistenceContext(unitName = "GTlaboratory")
	private EntityManager em ;

	public FacadeUC2() {}

	public List<TipologiaEsame> consultaOfferta(){
		CriteriaQuery<TipologiaEsame> cq = em.getCriteriaBuilder().createQuery(TipologiaEsame.class);
		logger.debug(em);
		cq.select(cq.from(TipologiaEsame.class));
		List<TipologiaEsame> t = em.createQuery(cq).getResultList();
		return  t;
	}

	public List<Paziente> getPazienti() {
		CriteriaQuery<Paziente> cq = em.getCriteriaBuilder().createQuery(Paziente.class);
		logger.debug(em);
		cq.select(cq.from(Paziente.class));
		List<Paziente> t = em.createQuery(cq).getResultList();
		return  t;
	}

	public Esame creaEsame(long codTipoEsame,String user){

		TipologiaEsame tipoEsame;
		Paziente paziente;

		paziente= em.find(Paziente.class, user);
		if(paziente==null) return null;
		tipoEsame= em.find(TipologiaEsame.class, codTipoEsame);
		if(tipoEsame==null) return null;
		Esame esame=new Esame(paziente,tipoEsame);
		paziente.addEsame(esame);

		em.persist(esame);
		logger.debug(em);

		return esame;
	}

	public EntityManager getEm() {return em;}
	public void setEm(EntityManager em) {this.em = em;}

}
