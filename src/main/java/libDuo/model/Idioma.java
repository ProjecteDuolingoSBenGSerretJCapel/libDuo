package libDuo.model;

import java.util.List;

import javax.persistence.*;



@Entity
@Table(name = "idioma")
public class Idioma {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idIdioma")
	private long idIdioma;
	
	@Column(name = "idioma")
	private String idioma;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "idCurs")
	private List<Curs> cursos;
	
	public Idioma() {
		super();
	}
	
	public Idioma(String idioma) {
		this.idioma = idioma;
	}
	
	//get id idioma
	public long getIdIdioma() {
		return idIdioma;
	}
	
	//set id idioma
	public void setIdIdioma(long idIdioma) {
		this.idIdioma = idIdioma;
	}
	
	//get Idioma
	public String getIdioma() {
		return idioma;
	}
	
	//set idioma
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	
	//Get Cursos
	public List<Curs> getCursos(){
		return cursos;
	}
	
	//Set Cursos
	public void setCursos(List<Curs> cursos) {
		this.cursos = cursos;
	}

}
