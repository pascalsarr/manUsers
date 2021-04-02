package entities;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
@Entity
@Table(name = "Utilisateur")
public class Utilisateur  {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private   int id;
	
	@Column(name = "nom")
	private String	nom;
	@Column(name = "prenom")
	private String	prenom;
	@Column(name = "login")
	private String	login;
	@Column(name = "password")
	private String	password;

	public Utilisateur()
	{
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Utilisateur(  String nom, String prenom, String login, String password)
	{
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
	}
    
	
	

	public String getNom()
	{
		return nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public String getPrenom()
	{
		return prenom;
	}

	public void setPrenom(String prenom)
	{
		this.prenom = prenom;
	}

	public String getLogin()
	{
		return login;
	}

	public void setLogin(String login)
	{
		this.login = login;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

}
