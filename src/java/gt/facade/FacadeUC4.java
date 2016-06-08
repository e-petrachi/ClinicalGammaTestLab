package gt.facade;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
		String jpql = "SELECT t FROM TipologiaEsame t";   
 		Query query = em.createQuery(jpql);
 	 	logger.debug(em);
 		@SuppressWarnings("unchecked")
		List<TipologiaEsame> t =query.getResultList();
 	 		return t;
	}
	
	public void inziaTipoEsame(String nome,String  info ,Float costo){		
		tipoEsame=new TipologiaEsame();
		tipoEsame.setCosto(costo);
		tipoEsame.setNome(nome);
		tipoEsame.setDescrizione(info);
	}
	
	public void setRequistiTipoEsame(String key,String value){
		Prerequisito p = new Prerequisito(key,value);
		em.persist(p);
		logger.debug(em);
		tipoEsame.addPrerequisito(p);
	}
	
	public void setIndicatoriTipoEsame(String indicatore){
		Indicatore i = new Indicatore(indicatore);
		em.persist(i);
		logger.debug(em);
		tipoEsame.addIndicatore(i);
	}
	
	public void saveTipoEsame() {
		em.persist(tipoEsame);
		logger.debug(em);
	}
	public EntityManager getEm() {return em;}
	public void setEm(EntityManager em) {this.em = em;}
	public TipologiaEsame getTipoEsame() {return tipoEsame;}
	public void setTipoEsame(TipologiaEsame tipoEsame) {this.tipoEsame = tipoEsame;}
	
}
