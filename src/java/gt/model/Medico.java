package gt.model;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "medico")
@NamedQuery(name = "findAllMedico", query = "SELECT m FROM Medico m")
public class Medico {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String cognome;
	@Column
	private String specializzazione;
	@OneToMany(mappedBy="medico")
	private List<Esame> esami;

	public Medico(String nome,String cognome){
		this.nome = nome;
		this.cognome = cognome;
		this.esami = new ArrayList<Esame>();
	}
	public Medico(String nome,String cognome,String specializzazione){
		this.nome = nome;
		this.cognome = cognome;
		this.specializzazione = specializzazione;
		this.esami = new ArrayList<Esame>();
	}
	public Medico(){
		this.esami = new ArrayList<Esame>();
	}
	public long getId() {return id;}
	public void setId(long id) {this.id = id;}
	public List<Esame> getEsami() {return esami;}
	public void addEsame(Esame e){this.esami.add(e);}
	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}
	public String getCognome() {return cognome;}
	public void setCognome(String cognome) {this.cognome = cognome;}
	public String getSpecializzazione() {return specializzazione;}
	public void setSpecializzazione(String specializzazione) {this.specializzazione = specializzazione;}
	@Override
	public int hashCode() {
		return (int)this.id;
	}
	@Override
	public boolean equals(Object obj) {
		Medico other = (Medico) obj;
		return this.id == other.getId();
	}
}
