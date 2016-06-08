package gt.model;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "indicatore")
@NamedQuery(name = "findAllIndicatore", query = "SELECT i FROM Indicatore i")
public class Indicatore implements Comparable<Indicatore>{
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Long id;
	private String indicatore;
	@ManyToMany(mappedBy="indicatori")
	private List<TipologiaEsame> tipologieEsame;
	
	public Indicatore(){
		this.tipologieEsame=new ArrayList<TipologiaEsame>();
	}
	public Indicatore(String indicatore) {
		this.indicatore=indicatore;
		this.tipologieEsame=new ArrayList<TipologiaEsame>();
	}
	
	public long getId() {return id;}
	public void setId(long id) {this.id = id;}
	public String getIndicatore() {return indicatore;}
	public void setIndicatore(String indicatore) {this.indicatore = indicatore;}
	public List<TipologiaEsame> getTipoEsami() {return tipologieEsame;}
	public void addTipoEsame(TipologiaEsame tipoEsame) {this.tipologieEsame.add(tipoEsame);}
	public List<TipologiaEsame> getTipiEsame() {return tipologieEsame;}
	public void setTipiEsame(List<TipologiaEsame> tipiEsame) {this.tipologieEsame = tipiEsame;}
	@Override
	public int hashCode() {
		return this.id.intValue();
	}
	@Override
	public boolean equals(Object obj) {
		Indicatore other = (Indicatore) obj;
		return this.id == other.getId();
	}
	@Override
	public int compareTo(Indicatore o) {
		return (int) (this.id - o.getId());
	}
}
