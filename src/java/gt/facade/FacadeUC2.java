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

	public Esame creaEsame(Paziente p,TipologiaEsame t){

		Esame esame=new Esame(p, t);
		p.addEsame(esame);

		em.persist(esame);
		em.merge(p);
		
		logger.debug(em);

		return esame;
	}
	public TipologiaEsame trovaTipoEsame(long codTipoEsame){
		TipologiaEsame tipoEsame = em.find(TipologiaEsame.class, codTipoEsame);
		return tipoEsame;
	}
	public Paziente trovaPaziente(String user){
		Paziente paziente = em.find(Paziente.class, user);
		return paziente;
	}

	public EntityManager getEm() {return em;}
	public void setEm(EntityManager em) {this.em = em;}

}
