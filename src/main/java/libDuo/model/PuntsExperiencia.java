package libDuo.model;

import javax.persistence.*;

@Entity
@Table(name = "puntsExperiencia")
public class PuntsExperiencia {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idPuntsExperiencia")
	private long idPuntsExperiencia;
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuari", updatable = false, nullable = false)
	private Usuari usuari;
	
	


	public Usuari getUsuari() {
		return usuari;
	}

	public void setUsuari(Usuari usuari) {
		this.usuari = usuari;
	}

	public PuntsExperiencia() {

	}

	//get id punts experiencia
	public long getIdPuntsExperiencia() {
		return idPuntsExperiencia;
	}

	//set id punts experiencia
	public void setIdPuntsExperiencia(long idPuntsExperiencia) {
		this.idPuntsExperiencia = idPuntsExperiencia;
	}
	
	
	
}
