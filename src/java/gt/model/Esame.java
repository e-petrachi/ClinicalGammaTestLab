package gt.model;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "esame")
@NamedQuery(name = "findAllEsame", query = "SELECT e FROM Esame e")
public class Esame {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Temporal(TemporalType.DATE)
	private Date dataprenotazione;	
	@Temporal(TemporalType.DATE)
	private Date dataeffettuata;	
    @OneToOne
	private TipologiaEsame tipologiaEsame;
    @ManyToOne
    private Paziente paziente;
    @ManyToOne
    private Medico medico;
	@OneToMany
	@JoinColumn(name = "esame_id")
	private List<Risultato> risultati;
	
	public Esame(Paziente paziente, TipologiaEsame tipoEsame) {
		this.paziente=paziente;
		this.tipologiaEsame=tipoEsame;
		this.dataprenotazione= new Date(System.currentTimeMillis());
		this.risultati = new ArrayList<Risultato>();
	}
	public Esame() {
		this.risultati = new ArrayList<Risultato>();
	}
	public TipologiaEsame getTipo() {return tipologiaEsame;}
	public void setTipo(TipologiaEsame tipo) {this.tipologiaEsame = tipo;}
	public Paziente getPaziente() {return paziente;}
	public void setPaziente(Paziente paziente) {this.paziente = paziente;}
	public Medico getMedico() {return medico;}
	public void setMedico(Medico medico) {this.medico = medico;}
	public Date getData() {return dataprenotazione;}
	public void setData(Date data) {this.dataprenotazione = data;}
	public void setRisultati() {this.risultati = new ArrayList<Risultato>();}
	public void addRisultato(Risultato r){this.risultati.add(r);}
	public List<Risultato> getRisultati() {return risultati;}
	public long getId() {return id;}
	public void setId(long id) {this.id = id;}
	public Date getDataprenotazione() {return dataprenotazione;}
	public void setDataprenotazione(Date dataprenotazione) {this.dataprenotazione = dataprenotazione;}
	public Date getDataeffettuata() {return dataeffettuata;}
	public void setDataeffettuata(Date dataeffettuata) {this.dataeffettuata = dataeffettuata;}
	public TipologiaEsame getTipologiaEsame() {return tipologiaEsame;}
	public void setTipologiaEsame(TipologiaEsame tipologiaEsame) {this.tipologiaEsame = tipologiaEsame;}
	public void setRisultati(List<Risultato> risultati) {this.risultati = risultati;}
	@Override
	public int hashCode() {
		return (int)this.id;
	}
	@Override
	public boolean equals(Object obj) {
		Esame other = (Esame) obj;
		return this.id == other.getId();
	}
	
	
}
