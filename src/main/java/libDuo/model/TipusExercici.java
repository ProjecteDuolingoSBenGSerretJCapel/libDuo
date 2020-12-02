package libDuo.model;

import javax.persistence.*;

@Entity
@Table(name = "tipusExercici")
public class TipusExercici {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idTipusExercici")
	private long idTipusExercici;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idExercicis")
	private Exercicis exercicis;
	
	public Exercicis getExercicis() {
		return exercicis;
	}

	public void setExercicis(Exercicis exercicis) {
		this.exercicis = exercicis;
	}

	public TipusExercici() {
		
	}

	//get id tipus exercici
	public long getIdTipusExercici() {
		return idTipusExercici;
	}

	//set id tipus exercici
	public void setIdTipusExercici(long idTipusExercici) {
		this.idTipusExercici = idTipusExercici;
	}
	
}
