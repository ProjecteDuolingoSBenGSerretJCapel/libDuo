package libDuo.model;

import javax.persistence.*;

@Entity
@Table(name = "cursosFets")
public class CursosFets {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idCursFet")
	private long idCursFet;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCurs")
	private Curs curs;
	
	
	
	public Curs getCurs() {
		return curs;
	}

	public void setCurs(Curs curs) {
		this.curs = curs;
	}

	public Usuari getUsuari() {
		return usuari;
	}

	public void setUsuari(Usuari usuari) {
		this.usuari = usuari;
	}

	@ManyToOne()
	private Usuari usuari;
	

	
	public CursosFets() {
		
	}

	//get id curs fet
	public long getIdCursFet() {
		return idCursFet;
	}

	//set id curs fet
	public void setIdCursFet(long idCursFet) {
		this.idCursFet = idCursFet;
	}
	
	
	

}
