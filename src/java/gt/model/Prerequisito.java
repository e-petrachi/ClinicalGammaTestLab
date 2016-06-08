package gt.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "prequisito")
@NamedQuery(name = "findAllPrerequisito", query = "SELECT p FROM Prerequisito p")
public class Prerequisito implements Comparable<Prerequisito>{
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private long id;
	private String codice;
	private String valore;
	@ManyToMany(mappedBy = "prerequisiti")
	private List<TipologiaEsame> tipiEsame;
	
	public Prerequisito(String codice, String valore) {	
		this.codice=codice;
		this.valore=valore;
		this.tipiEsame=new ArrayList<TipologiaEsame>();
	}
	public Prerequisito(){
		this.tipiEsame=new ArrayList<TipologiaEsame>();
	}
	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}
	public String getCodice() {return codice;}
	public void setCodice(String nome) {this.codice = nome;}
	public String getValore() {return valore;}
	public void setValore(String valore) {this.valore = valore;}
	public List<TipologiaEsame> getTipoEsami() {return tipiEsame;}
	public void addTipoEsame(TipologiaEsame tipoEsame) {this.tipiEsame.add(tipoEsame);}
	
	@Override
	public int hashCode() {
		return (int)this.id;
	}
	@Override
	public boolean equals(Object obj) {
		Prerequisito other = (Prerequisito) obj;
		return this.id == other.getId();
	}
	@Override
	public int compareTo(Prerequisito o) {
		return (int) (this.id - o.getId());
	}
	
	
	
	
	
}
