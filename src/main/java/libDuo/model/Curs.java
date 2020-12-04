package libDuo.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "curs")
public class Curs {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idCurs")
	private long idCurs;
	
	@ManyToOne()
	private Idioma idiomaOrigen;
	
	@ManyToOne()
	private Idioma idiomaDesti;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "idCategoria")
	private List<Categoria> categoria;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "curs")
	private CursosFets cursosFets;
	
	//GETTERS I SETTERS
	
	
	public List<Categoria> getCategoria() {
		return categoria;
	}

	public void setCategoria(List<Categoria> categoria) {
		this.categoria = categoria;
	}


	public Idioma getIdiomaOrigen() {
		return idiomaOrigen;
	}

	public void setIdiomaOrigen(Idioma idiomaOrigen) {
		this.idiomaOrigen = idiomaOrigen;
	}

	public Idioma getIdiomaDesti() {
		return idiomaDesti;
	}

	public void setIdiomaDesti(Idioma idiomaDesti) {
		this.idiomaDesti = idiomaDesti;
	}

	public CursosFets getCursosFets() {
		return cursosFets;
	}

	public void setCursosFets(CursosFets cursosFets) {
		this.cursosFets = cursosFets;
	}

	public Curs() {
		
	}

	//get id curs
	public long getIdCurs() {
		return idCurs;
	}

	//Set id curs
	public void setIdCurs(long idCurs) {
		this.idCurs = idCurs;
	}
	
	
	
}
