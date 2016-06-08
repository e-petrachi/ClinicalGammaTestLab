package gt.model;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tipologiaesame")
@NamedQuery(name = "findAllTipologia", query = "SELECT t FROM TipologiaEsame t")
public class TipologiaEsame {
	
	@Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private float costo;
	private String descrizione;
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Prerequisito> prerequisiti;
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Indicatore> indicatori;
	
	public TipologiaEsame(String nome, String descrizione, float costo) {	
		this.nome = nome;
		this.descrizione = descrizione;
		this.costo = costo;
		this.prerequisiti=new ArrayList<Prerequisito>();
		this.indicatori=new  ArrayList<Indicatore>();
	}
	public TipologiaEsame() {
		this.prerequisiti=new ArrayList<Prerequisito>();
		this.indicatori=new  ArrayList<Indicatore>();
	}
	
	public long getId() {return id;}
	public void setId(long id) {this.id = id;}
	public List<Prerequisito> getPrerequisiti() {return prerequisiti;}
	public void setPrerequisiti(List<Prerequisito> prerequisiti) {this.prerequisiti = prerequisiti;}
	public List<Indicatore> getIndicatori() {return indicatori;}
	public void setIndicatori(List<Indicatore> indicatori) {this.indicatori = indicatori;}
	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}
	public long getCodice() {return id;}
	public void setCodice(long codice) {this.id = codice;}
	public String getDescrizione() {return descrizione;}
	public void setDescrizione(String descrizione) {this.descrizione = descrizione;}
	public float getCosto() {return costo;}
	public void setCosto(float costo) {this.costo = costo;}
	public void addPrerequisito(Prerequisito p) {this.prerequisiti.add(p);}
	public void addIndicatore(Indicatore indicatore) {this.indicatori.add(indicatore);}
	
	@Override
	public int hashCode() {
		return (int)this.id;
	}
	@Override
	public boolean equals(Object obj) {
		TipologiaEsame other = (TipologiaEsame) obj;
		return this.id == other.getId();
	}

}
