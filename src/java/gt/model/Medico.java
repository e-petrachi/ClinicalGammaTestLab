package gt.model;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "medico")
@NamedQuery(name = "findAllMedico", query = "SELECT m FROM Medico m")
public class Medico {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
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
	public Medico(){
		this.esami = new ArrayList<Esame>();
	}
	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}
	public List<Esame> getEsami() {return esami;}
	public void addEsame(Esame e){this.esami.add(e);}
	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}
	public String getCognome() {return cognome;}
	public void setCognome(String cognome) {this.cognome = cognome;}
	public String getSpecializzazione() {return specializzazione;}
	public void setSpecializzazione(String specializzazione) {this.specializzazione = specializzazione;}
}
