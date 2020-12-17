package libDuo.model;



import javax.persistence.*;

@Entity
@Table(name = "exercicis") 
public class Exercicis {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idExercicis")
	private long idExercicis;
	
	@Column(name = "ulimExercici")
	private int utlimExercici;
	
	@Column(name = "cantitatExercici")
	private int cantitatExercici;
	
	@ManyToOne()
	private Nivells nivell;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "exercicis")
	private ExercicisResolts exercicisresolts;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "exercicis")
	private TipusExercici tipusExercici;
	
	@Column( name = "dadesEx")
	private String fitxerDades;
	
	public String getFitxerDades() {
		return fitxerDades;
	}

	public void setFitxerDades(String fitxerExercici) {
		this.fitxerDades = fitxerExercici;
	}

	public Exercicis(int ultimExercici, int cantitatExercicis,  String fitxerDades) {
		this.utlimExercici = ultimExercici;
		this.cantitatExercici = cantitatExercicis;
		this.fitxerDades = fitxerDades;
	}
	public Exercicis() {
		
	}
	
	public ExercicisResolts getExercicisresolts() {
		return exercicisresolts;
	}

	public void setExercicisresolts(ExercicisResolts exercicisresolts) {
		this.exercicisresolts = exercicisresolts;
	}

	public TipusExercici getTipusExercici() {
		return tipusExercici;
	}

	public void setTipusExercici(TipusExercici tipusExercici) {
		this.tipusExercici = tipusExercici;
	}

	public Nivells getNivell() {
		return nivell;
	}

	public void setNivell(Nivells nivell) {
		this.nivell = nivell;
	}
	
	public int getUtlimExercici() {
		return utlimExercici;
	}

	public void setUtlimExercici(int utlimExercici) {
		this.utlimExercici = utlimExercici;
	}

	public int getCantitatExercici() {
		return cantitatExercici;
	}

	public void setCantitatExercici(int cantitatExercici) {
		this.cantitatExercici = cantitatExercici;
	}



	
}
