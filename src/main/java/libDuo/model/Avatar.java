package libDuo.model;

import javax.persistence.*;

@Entity
@Table(name = "avatar")
public class Avatar {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idAvatar")
	private long idAvatar;

	@Column(name = "imgAvatar")
	private String imgAvatar;

	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuari", updatable = false, nullable = false)
	private Usuari usuari;
	
	
	public Usuari getUsuari() {
		return usuari;
	}

	public void setUsuari(Usuari usuari) {
		this.usuari = usuari;
	}

	public Avatar() {

	}
	
	public Avatar(String imgAvatar) {
		this.imgAvatar = imgAvatar;
	}

	//get id avatar
	public long getIdAvatar() {
		return idAvatar;
	}

	//set id avatar
	public void setIdAvatar(long idAvatar) {
		this.idAvatar = idAvatar;
	}

	//get ruta en local img avatar
	public String getImgAvatar() {
		return imgAvatar;
	}

	//set ruta en local img avatar
	public void setImgAvatar(String imgAvatar) {
		this.imgAvatar = imgAvatar;
	}
	
}
