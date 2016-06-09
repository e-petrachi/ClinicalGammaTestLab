package gt.model;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "paziente")
@NamedQuery(name = "findAllPaziente", query = "SELECT p FROM Paziente p")
public class Paziente {
	@Id
	private String username;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String cognome;
	@Column(nullable = false)
	private String password;
	@OneToMany(mappedBy="paziente", fetch = FetchType.EAGER)
	private List<Esame> esami;

	public Paziente(String user,String psw,String nome, String cognome) {
		this.username = user; 
		/*this.password = Criptatore.getInstance().codifica(psw);*/
		this.password = psw;
		this.nome = nome; 
		this.cognome = cognome;
		this.esami = new ArrayList<Esame>();
	}
	public Paziente(){
		this.esami = new ArrayList<Esame>();
	}
	public List<Esame> getEsami() {return esami;}
	public void addEsame(Esame e){this.esami.add(e);}
	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}
	public String getCognome() {return cognome;}
	public void setCognome(String cognome) {this.cognome = cognome;}
	public String getUsername() {return username;}
	public void setUsername(String username) {this.username = username;}
	
	public void setPassword(String psw) {
		/*this.password = Criptatore.getInstance().codifica(psw);*/
		this.password = psw;
		}
	public boolean checkPassword(String password) {
		return this.password.equals(password);//Criptatore.getInstance().decodifica(this.password).equals(password);
	}
	@Override
	public int hashCode() {
		return username.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		Paziente other = (Paziente) obj;
		return username.equals(other.username);
	}

}
