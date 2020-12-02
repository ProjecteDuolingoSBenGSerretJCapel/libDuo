package libDuo.Dao;

public interface IAvatarDAO {
	
	//posar imatge del avatar mitjancant la ruta de la foto
	public boolean afegirAvatar(String imgAvatar);
	
	//cambiar imatge del avatar mitjanacant la ruta de la foto
	public boolean cambiarAvatar(String imgAvatar);
	
	//eliminar el avatar
	public boolean eliminarAvatar();

}
