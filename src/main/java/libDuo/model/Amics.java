package libDuo.model;

import javax.persistence.*;



@Entity
@Table(name = "amics")
public class Amics{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idAmic")
	private long idAmic;


	
	

	@ManyToOne()

	private Usuari usuari;
	
	
	public Amics() {
		
	}
	
	public Amics(Usuari usuari) {
		this.usuari = usuari;
	}

	//get id amic
	public long getIdAmic() {
		return idAmic;
	}

	//set id amic
	public void setIdAmic(long idAmic) {
		this.idAmic = idAmic;
	}

	//get usuari amic
	public Usuari getUsuari() {
		return usuari;
	}

	//set usuari amics
	public void setUsuari(Usuari usuari) {
		this.usuari = usuari;
	}

	
}
