package libDuo.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "categoria")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idCategoria")
	private long idCategoria;
	
	@Column(name = "tipusCategoria")
	private String tipusCategoria;
	
	@ManyToOne()
	private Curs curs;
	
	@Column(name = "ultimExercici")
	private int ultimExercici;
	
	@Column(name = "cantitatExercicis")
	private int cantitatExercicis;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "idNivell")
	private List<Nivells> nivells;
	
	public List<Nivells> getNivells() {
		return nivells;
	}

	public void setNivells(List<Nivells> nivells) {
		this.nivells = nivells;
	}

	public Curs getCurs() {
		return curs;
	}

	public void setCurs(Curs curs) {
		this.curs = curs;
	}

	public Categoria() {
		
	}
	
	public Categoria(String tipusCategoria) {
		this.tipusCategoria = tipusCategoria;
	}
	
	//get id categoria
	public long getIdCategoria() {
		return idCategoria;
	}
	
	//set id categoria
	public void setIdCategoria(long idCategoria) {
		this.idCategoria = idCategoria;
	}
	
	//get tipus de categoria
	public String getTipusCategoria() {
		return tipusCategoria;
	}
	
	//set tipus de categoria
	public void setTipusCategoria(String tipusCategoria) {
		this.tipusCategoria = tipusCategoria;
	}
	
	
	public int getUltimExercici() {
		return ultimExercici;
	}

	public void setUltimExercici(int ultimExercici) {
		this.ultimExercici = ultimExercici;
	}

	public int getCantitatExercicis() {
		return cantitatExercicis;
	}
	
	public void setCantitatExercicis(int cantitatExercicis) {
		this.cantitatExercicis = cantitatExercicis;
	}	

}
