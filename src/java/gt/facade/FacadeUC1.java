package gt.facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.apache.log4j.Logger;



import gt.model.*;

@Stateless(name="facadeUC1")
public class FacadeUC1 {

	final static Logger logger = Logger.getLogger(FacadeUC1.class);

	private boolean riempito = false; 

	@PersistenceContext(unitName = "GTlaboratory")
	private EntityManager em ;

	public FacadeUC1() {}

	public List<TipologiaEsame> consultaOfferta(){
		CriteriaQuery<TipologiaEsame> cq = em.getCriteriaBuilder().createQuery(TipologiaEsame.class);
		logger.debug(em);
		cq.select(cq.from(TipologiaEsame.class));
		List<TipologiaEsame> t = em.createQuery(cq).getResultList();
		return  t;
	}

	public TipologiaEsame stampaTipoEsame(long codiceTipEsame){
		TipologiaEsame t = em.find(TipologiaEsame.class, codiceTipEsame);
		logger.debug(em);
		return t;
	}

	public void avvia() {	
		if(riempito==false){

			Amministratore a1 = new Amministratore("DirettoreSportello","password");
			Amministratore a2 = new Amministratore("DirettorePrenozioni","password");
			Amministratore a3 = new Amministratore("AddettoSportello","password");
			em.persist(a1);
			em.persist(a2);
			em.persist(a3);

			Paziente p1 = new Paziente("Mario.Rossi", "psw1", "Mario", "Rossi");
			Paziente p2 = new Paziente("Luigi.Verdi", "psw2", "Luigi", "Verdi");
			Paziente p3 = new Paziente("Ezio.Neri", "psw3", "Ezio", "Neri");
			Paziente p4 = new Paziente("Enrico.Bianchi","psw4", "Enrico", "Bianchi");
			em.persist(p1);
			em.persist(p2);
			em.persist(p3);
			em.persist(p4);

			Medico m1 = new Medico("Pierluigi","Scuri");
			Medico m2 = new Medico("Michelangelo","Chiari");
			Medico m3 = new Medico("Francesco","Medi");
			em.persist(m1);
			em.persist(m2);
			em.persist(m3);

			Prerequisito pre1 = new Prerequisito("Digiuno7", "Richiede il digiuno per sette ore prima dell'esame");
			Prerequisito pre2 = new Prerequisito("Digiuno10", "Richiede il digiuno per dieci ore prima dell'esame");
			Prerequisito pre3 = new Prerequisito("Riposo","Richiede il riposo dopo l'esame");
			Prerequisito pre4 = new Prerequisito("SoloAcqua","Richiede che si beva solo acqua nel giorno prima dell'esame");
			em.persist(pre1);
			em.persist(pre2);
			em.persist(pre3);
			em.persist(pre4);

			Indicatore indicatoreA  = new Indicatore("Vitamina A");		
			Indicatore indicatoreB  = new Indicatore("Vitamina B");		
			Indicatore indicatoreC  = new Indicatore("Vitamina C");
			Indicatore indicatoreE  = new Indicatore("Emoglobina");
			Indicatore indicatorePm = new Indicatore("Pressione minima");
			Indicatore indicatorePM = new Indicatore("Pressione massima");
			Indicatore indicatoreBC = new Indicatore("Battito Cardiaco");
			Indicatore indicatoreGV = new Indicatore("Gradi di vista");		
			em.persist(indicatoreA);
			em.persist(indicatoreB);
			em.persist(indicatoreC);
			em.persist(indicatoreE);       
			em.persist(indicatorePm);
			em.persist(indicatorePM);
			em.persist(indicatoreBC);
			em.persist(indicatoreGV);

			TipologiaEsame tipo1 = new TipologiaEsame("CheckUp", "Si eseguono tutti gli esami generici", 150);
			tipo1.addPrerequisito(pre1);
			tipo1.addIndicatore(indicatoreC);
			tipo1.addIndicatore(indicatoreE);
			em.persist(tipo1);
			em.merge(pre1);
			em.merge(indicatoreC);
			em.merge(indicatoreE);

			TipologiaEsame tipo2 = new TipologiaEsame("Urine","Si esegue l'esame delle urine", 50);
			tipo2.addPrerequisito(pre4);
			tipo2.addIndicatore(indicatoreC);
			em.persist(tipo2);
			em.merge(pre4);
			em.merge(indicatoreC);

			TipologiaEsame tipo3 = new TipologiaEsame("Sangue","Si esegue l'esame del sangue", 80);
			tipo3.addPrerequisito(pre3);
			tipo3.addPrerequisito(pre1);
			tipo3.addPrerequisito(pre4);
			tipo3.addIndicatore(indicatoreA);
			tipo3.addIndicatore(indicatoreE);
			em.persist(tipo3);
			em.merge(pre3);
			em.merge(pre1);
			em.merge(pre4);
			em.merge(indicatoreA);
			em.merge(indicatoreE);

			TipologiaEsame tipo4 = new TipologiaEsame("Vista","Si esegue l'esame della vista", 20);
			tipo4.addIndicatore(indicatoreGV);
			em.persist(tipo4);
			em.merge(indicatoreGV);

			TipologiaEsame tipo5 = new TipologiaEsame("RX","Si esegue la risonanza magnetica a raggi x", 100);
			em.persist(tipo5);
			
			TipologiaEsame tipo6 = new TipologiaEsame("Tac","Si esegue la radiografia", 70);
			em.persist(tipo6);
			
			Esame esame1 = new Esame(p1,tipo1);
			esame1.setMedico(m1);
			p1.addEsame(esame1);
			m1.addEsame(esame1);
			em.persist(esame1);
			em.merge(p1);
			em.merge(m1);

			Esame esame2 = new Esame(p2,tipo2);    	
			p2.addEsame(esame2);
			em.persist(esame2);
			em.merge(p2);

			Esame esame3 = new Esame(p3,tipo3);
			esame3.setMedico(m3);
			p3.addEsame(esame3);
			m3.addEsame(esame3);
			em.persist(esame3);
			em.merge(m3);
			em.merge(p3);

			Esame esame4 = new Esame(p4,tipo4);
			p4.addEsame(esame4);
			em.persist(esame4);
			em.merge(p4);

			Risultato risultatoA1 = new Risultato(indicatoreA, "0,30");
			Risultato risultatoA2 = new Risultato(indicatoreA, "0,50");
			Risultato risultatoB  = new Risultato(indicatoreB, "0,30");

			esame1.addRisultato(risultatoA1);
			esame1.addRisultato(risultatoB);
			esame4.addRisultato(risultatoA2);

			em.persist(risultatoA1);
			em.persist(risultatoB);
			em.persist(risultatoA2);
			em.merge(esame1);
			em.merge(esame4);

			this.riempito = true;
		}
	}

	public EntityManager getEm() {return em;}
	public void setEm(EntityManager em) {this.em = em;}

}
