package libDuo.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "nivells")
public class Nivells {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idNivell")
	private long idNivell;
	
	@Column(name = "NumNivell")
	private int nivell;

	@Column(name = "nomNivell")
	private String nomNivell;
	
	@ManyToOne()
	private Categoria categoria;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "idExercicis")
	private List<Exercicis> exercicis;
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Exercicis> getExercicis() {
		return exercicis;
	}

	public void setExercicis(List<Exercicis> exercicis) {
		this.exercicis = exercicis;
	}

	public Nivells() {
		
	}
	
	public Nivells(int nivell) {
		this.setNivell(nivell);
	}

	//get id nivell
	public long getIdNivell() {
		return idNivell;
	}

	//set id nivell
	public void setIdNivell(long idNivell) {
		this.idNivell = idNivell;
	}

	//get numero nivell
	public int getNivell() {
		return nivell;
	}

	//set num nivell
	public void setNivell(int nivell) {
		this.nivell = nivell;
	}
	
	
	public String getNomNivell() {
		return nomNivell;
	}

	public void setNomNivell(String nomNivell) {
		this.nomNivell = nomNivell;
	}

}
