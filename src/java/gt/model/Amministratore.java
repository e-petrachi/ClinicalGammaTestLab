package gt.model;

import javax.persistence.*;

@Entity
@Table(name = "amministratore")
@NamedQuery(name = "findAllAmministratore", query = "SELECT a FROM Amministratore a")
public class Amministratore {
	
	@Id 
	private String username;
	@Column(nullable = false)
	private String password;
	
	public Amministratore(){}
	public Amministratore(String user, String psw) {
		this.username = user;
		/*this.password = Criptatore.getInstance().codifica(psw);*/
		this.password = psw;
		}
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
		Amministratore other = (Amministratore) obj;
		return username.equals(other.username);
	}
	
}
