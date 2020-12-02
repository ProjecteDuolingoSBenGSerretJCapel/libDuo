package libDuo.model;

import javax.persistence.*;

@Entity
@Table(name = "exercicisResolts")
public class ExercicisResolts {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idExerciciResolt")
	private long idExerciciResolt;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idExercicis")
	private Exercicis exercicis;
	
	public Exercicis getExercicis() {
		return exercicis;
	}

	public void setExercicis(Exercicis exercicis) {
		this.exercicis = exercicis;
	}

	public Usuari getUsuari() {
		return usuari;
	}

	public void setUsuari(Usuari usuari) {
		this.usuari = usuari;
	}

	@ManyToOne()
	private Usuari usuari;
	
	public ExercicisResolts() {
		
	}
	
	//get id Exercici resolt
	public long getIdExerciciResolt() {
		return idExerciciResolt;
	}
	
	//set id exercici resolt
	public void setIdExerciciResolt(long idExerciciResolt) {
		this.idExerciciResolt = idExerciciResolt;
	}


}
