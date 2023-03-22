package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;


@Entity
public class Adresse {
	
	@Id
	@Column (name = "client_id")
	private Integer id;
	
	private String rue;
	private String ville;
	
	@OneToOne
	@MapsId
	@JoinColumn(name = "client_id")
	private Client client;
	
	
	
	public Integer getIdAdresse() {
		return id;
	}
	public void setIdAdresse(Integer idAdresse) {
		this.id = idAdresse;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	
}
