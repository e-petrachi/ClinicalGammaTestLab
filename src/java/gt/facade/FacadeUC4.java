package gt.facade;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
	
	public Prerequisito addRequisitoTipoEsame(String key,String value){
		Prerequisito p = new Prerequisito(key,value);
		p.addTipoEsame(tipoEsame);
		em.persist(p);
		tipoEsame.addPrerequisito(p);
		em.merge(tipoEsame);
		return p;
	}
	public Prerequisito addRequisitoTipoEsameEsistente(long id){
		Prerequisito p = em.find(Prerequisito.class, id);
		p.addTipoEsame(tipoEsame);
		tipoEsame.addPrerequisito(p);
		em.merge(p);
		em.merge(tipoEsame);
		return p;
	}
	
	public Indicatore addIndicatoreTipoEsame(String indicatore){
		Indicatore i = new Indicatore(indicatore);
		i.addTipoEsame(tipoEsame);
		em.persist(i);
		tipoEsame.addIndicatore(i);
		em.merge(tipoEsame);
		return i;
	}
	public Indicatore addIndicatoreTipoEsameEsistente(long id){
		Indicatore i = em.find(Indicatore.class, id);
		i.addTipoEsame(tipoEsame);
		tipoEsame.addIndicatore(i);
		em.merge(i);
		em.merge(tipoEsame);
		return i;
	}
	
	public EntityManager getEm() {return em;}
	public void setEm(EntityManager em) {this.em = em;}
	public TipologiaEsame getTipoEsame() {return tipoEsame;}
	public void setTipoEsame(TipologiaEsame tipoEsame) {this.tipoEsame = tipoEsame;}

	public List<Indicatore> getIndicatori() {
		CriteriaQuery<Indicatore> cq = em.getCriteriaBuilder().createQuery(Indicatore.class);
		logger.debug(em);
		cq.select(cq.from(Indicatore.class));
		List<Indicatore> t = em.createQuery(cq).getResultList();
		return  t;
	}
	@SuppressWarnings("unchecked")
	public List<Indicatore> getIndicatoriTipologia(long idTipologia) {
		String jpql = "SELECT i FROM Indicatore i,Tipologia t WHERE i.tipologia.id=t.id AND t.id='"+idTipologia+"'";   
		Query query = em.createQuery(jpql);
		logger.debug(em);
		return (List<Indicatore>) query.getResultList();	
	}

	public List<Prerequisito> getPrerequisiti() {
		CriteriaQuery<Prerequisito> cq = em.getCriteriaBuilder().createQuery(Prerequisito.class);
		logger.debug(em);
		cq.select(cq.from(Prerequisito.class));
		List<Prerequisito> t = em.createQuery(cq).getResultList();
		return  t;
	}
	@SuppressWarnings("unchecked")
	public List<Prerequisito> getPrerequisitiTipologia(long idTipologia) {
		String jpql = "SELECT i FROM Prerequisito i,Tipologia t WHERE i.tipologia.id=t.id AND t.id='"+idTipologia+"'";   
		Query query = em.createQuery(jpql);
		logger.debug(em);
		return (List<Prerequisito>) query.getResultList();
	}
	public TipologiaEsame trovaTipoEsame(long codTipoEsame){
		TipologiaEsame tipoEsame = em.find(TipologiaEsame.class, codTipoEsame);
		return tipoEsame;
	}
	
}
