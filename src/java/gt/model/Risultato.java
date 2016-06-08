package gt.model;

import javax.persistence.*;

@Entity
@Table(name = "risultato")
@NamedQuery(name = "findAllRisultato", query = "SELECT r FROM Risultato r")
public class Risultato {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@OneToOne
	private Indicatore indicatore;
	private String valore;
	
	public Risultato(){}
	public Risultato(Indicatore indicatore, String valore) {
		this.indicatore=indicatore;
		this.valore=valore;
	}
	
	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}
	public Indicatore getIndicatore() {return indicatore;}
	public void setIndicatore(Indicatore indicatore) {this.indicatore = indicatore;}
	public String getValore() {return valore;}
	public void setValore(String valore) {this.valore = valore;}
	@Override
	public int hashCode() {
		return (int)this.id;
	}
	@Override
	public boolean equals(Object obj) {
		Risultato other = (Risultato) obj;
		return this.id == other.getId();
	}
}
