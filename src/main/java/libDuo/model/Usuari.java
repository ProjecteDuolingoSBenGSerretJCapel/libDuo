package libDuo.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "usuari")
public class Usuari{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idUsuari")
	private long idUsuari;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "cognom")
	private String cognom;
	
	@Column(name = "dataNaixament")
	private Date dataNaixament;
	
	@Column(name = "correu")
	private String correu;
	
	@Column(name = "contrasena")
	private String contrasena;
	
	@Column(name = "usuari")
	private String usuari;
	
	@OneToOne(mappedBy = "usuari", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Botiga botiga;
	
	@OneToOne(mappedBy = "usuari", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private PuntsExperiencia puntsExperiencia;
	
	@OneToOne(mappedBy = "usuari", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Monedes monedes;
	
	@OneToOne(mappedBy = "usuari", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Avatar avatar;
	
	@ManyToOne()
	private Lliga lliga;
	

	public Lliga getLliga() {
		return lliga;
	}

	public void setLliga(Lliga lliga) {
		this.lliga = lliga;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="id_Amic")
	private List<Amics> id_Amic;
	
	

	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="id_ExercicisReslots")
	private List<ExercicisResolts> id_ExercicisReslots;
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="idCursFet")
	private List<CursosFets> idCursFet;


	public List<CursosFets> getIdCursFet() {
		return idCursFet;
	}

	public void setIdCursFet(List<CursosFets> idCursFet) {
		this.idCursFet = idCursFet;
	}

	public Botiga getBotiga() {
		return botiga;
	}

	public void setBotiga(Botiga botiga) {
		this.botiga = botiga;
	}

	public PuntsExperiencia getPuntsExperiencia() {
		return puntsExperiencia;
	}

	public void setPuntsExperiencia(PuntsExperiencia puntsExperiencia) {
		this.puntsExperiencia = puntsExperiencia;
	}

	public Monedes getMonedes() {
		return monedes;
	}

	public void setMonedes(Monedes monedes) {
		this.monedes = monedes;
	}

	public Avatar getAvatar() {
		return avatar;
	}

	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}
	
	public List<Amics> getId_Amic() {
		return id_Amic;
	}
	
	public void setId_Amic(List<Amics> id_Amic) {
		this.id_Amic = id_Amic;
	}
	
	public List<ExercicisResolts> getId_ExercicisReslots() {
		return id_ExercicisReslots;
	}

	public void setId_ExercicisReslots(List<ExercicisResolts> id_ExercicisReslots) {
		this.id_ExercicisReslots = id_ExercicisReslots;
	}
	
	public Usuari() {
		
	}
	
	public Usuari(String nom, String cognom, Date dataNaixament, String correu, String contrasena, String usuari){
		this.nom = nom;
		this.cognom = cognom;
		this.dataNaixament = dataNaixament;
		this.correu = correu;
		this.contrasena = contrasena;
		this.usuari = usuari;
	}

	//get id usuari
	public long getIdUsuari() {
		return idUsuari;
	}

	//set id usuari
	public void setIdUsuari(long idUsuari) {
		this.idUsuari = idUsuari;
	}

	//get nom usuari
	public String getNom() {
		return nom;
	}

	//set nom usuari
	public void setNom(String nom) {
		this.nom = nom;
	}

	//get cognom usuari
	public String getCognom() {
		return cognom;
	}

	//set cognom usuari
	public void setCognom(String cognom) {
		this.cognom = cognom;
	}

	//get data naixament usauri
	public Date getDataNaixament() {
		return dataNaixament;
	}

	//set data naixament usauri
	public void setDataNaixament(Date dataNaixament) {
		this.dataNaixament = dataNaixament;
	}

	//get correu usuari
	public String getCorreu() {
		return correu;
	}

	//set correu usuari
	public void setCorreu(String correu) {
		this.correu = correu;
	}

	//get contrasena usuari
	public String getContrasena() {
		return contrasena;
	}

	//set contrasena usuari
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	//get nickname usuari
	public String getUsuari() {
		return usuari;
	}

	//set nickname usuari
	public void setUsuari(String usuari) {
		this.usuari = usuari;
	}

}