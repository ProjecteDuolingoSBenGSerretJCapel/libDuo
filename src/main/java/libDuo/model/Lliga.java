package libDuo.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "lliga")
public class Lliga {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idLliga")
	private long idLliga;

	private String divisioLliga;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="idUsuari")
	private List<Usuari> usuaris;

	


	public List<Usuari> getUsuaris() {
		return usuaris;
	}

	public void setUsuaris(List<Usuari> usuaris) {
		this.usuaris = usuaris;
	}

	public Lliga() {

	}

	public Lliga(String divisioLliga) {
		this.divisioLliga = divisioLliga;
	}

	//get id lliga
	public long getIdLliga() {
		return idLliga;
	}

	//set id lliga
	public void setIdLliga(long idLliga) {
		this.idLliga = idLliga;
	}
	
	//get divisio lliga
	public String getDivisioLliga() {
		return divisioLliga;
	}

	//set divisio lliga
	public void setDivisioLliga(String divisioLliga) {
		this.divisioLliga = divisioLliga;
	}
	
	
	

}
