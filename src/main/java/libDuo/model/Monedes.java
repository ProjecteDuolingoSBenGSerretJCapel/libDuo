package libDuo.model;

import javax.persistence.*;

@Entity
@Table(name = "monedes")
public class Monedes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idMonedes")
	private long idMonedes;

	@Column(name = "quantitatMonedes")
	private int quantitatMonedes;
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuari", updatable = false, nullable = false)
	private Usuari usuari;
	
	

	public Usuari getUsuari() {
		return usuari;
	}

	public void setUsuari(Usuari usuari) {
		this.usuari = usuari;
	}

	public Monedes() {

	}

	public Monedes(int quantitatMonedes) {
		this.quantitatMonedes = quantitatMonedes;
	}

	//get id monedes
	public long getIdMonedes() {
		return idMonedes;
	}

	//set id monedes
	public void setIdMonedes(long idMonedes) {
		this.idMonedes = idMonedes;
	}

	//get quantita mondes
	public int getQuantitatMonedes() {
		return quantitatMonedes;
	}

	//set quantitat monedes
	public void setQuantitatMonedes(int quantitatMonedes) {
		this.quantitatMonedes = quantitatMonedes;
	}
	

}
