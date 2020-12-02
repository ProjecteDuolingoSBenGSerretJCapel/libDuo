package libDuo.model;

import javax.persistence.*;



@Entity
@Table(name = "botiga")
public class Botiga {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idBotiga")
	private long idBotiga;
	
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuari", updatable = false, nullable = false)
	private Usuari usuari;
	
	

	public Usuari getUsuari() {
		return usuari;
	}

	public void setUsuari(Usuari usuari) {
		this.usuari = usuari;
	}

	public Botiga() {
		
	}

	//Get id botiga
	public long getIdBotiga() {
		return idBotiga;
	}

	//set id botiga
	public void setIdBotiga(long idBotiga) {
		this.idBotiga = idBotiga;
	}
	
	
}
