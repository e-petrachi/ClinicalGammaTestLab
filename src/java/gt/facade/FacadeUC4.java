package gt.facade;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.apache.log4j.Logger;

import gt.model.*;

@Stateless(name="facadeUC4")
public class FacadeUC4 {
	
	final static Logger logger = Logger.getLogger(FacadeUC4.class);
	
	@PersistenceContext(unitName = "GTlaboratory")
	private EntityManager em ;
	
	TipologiaEsame tipoEsame;
	
	public FacadeUC4() {}
	
	public List<TipologiaEsame> consultaOfferta(){
		CriteriaQuery<TipologiaEsame> cq = em.getCriteriaBuilder().createQuery(TipologiaEsame.class);
		logger.debug(em);
		cq.select(cq.from(TipologiaEsame.class));
		List<TipologiaEsame> t = em.createQuery(cq).getResultList();
		return  t;
	}
	
	public TipologiaEsame inziaTipoEsame(String nome,String info ,float costo){		
		tipoEsame=new TipologiaEsame(nome, info, costo);
		em.persist(tipoEsame);
		return tipoEsame;
	}
	
	public void updateTipologia(List<Long> indicatori, List<Long> requisiti){
		for(Long ind : indicatori){
			Indicatore i = em.find(Indicatore.class, ind);
			tipoEsame.addIndicatore(i);
			em.merge(tipoEsame);
		}
		for(Long req : requisiti){
			Prerequisito r = em.find(Prerequisito.class, req);
			tipoEsame.addPrerequisito(r);
			em.merge(tipoEsame);
		}
	}
	
	public TipologiaEsame trovaTipoEsame(long codTipoEsame){
		TipologiaEsame tipoEsame = em.find(TipologiaEsame.class, codTipoEsame);
		return tipoEsame;
	}

	public List<Indicatore> getIndicatori() {
		CriteriaQuery<Indicatore> cq = em.getCriteriaBuilder().createQuery(Indicatore.class);
		logger.debug(em);
		cq.select(cq.from(Indicatore.class));
		List<Indicatore> t = em.createQuery(cq).getResultList();
		return  t;
	}

	public List<Prerequisito> getPrerequisiti() {
		CriteriaQuery<Prerequisito> cq = em.getCriteriaBuilder().createQuery(Prerequisito.class);
		logger.debug(em);
		cq.select(cq.from(Prerequisito.class));
		List<Prerequisito> t = em.createQuery(cq).getResultList();
		return  t;
	}
	public EntityManager getEm() {return em;}
	public void setEm(EntityManager em) {this.em = em;}
	public TipologiaEsame getTipoEsame() {return tipoEsame;}
	public void setTipoEsame(TipologiaEsame tipoEsame) {this.tipoEsame = tipoEsame;}
}
