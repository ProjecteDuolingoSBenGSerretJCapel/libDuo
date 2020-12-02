package libDuo.implement;

import libDuo.Dao.IMonedesDAO;
import libDuo.model.Monedes;

public class MonedesImpl implements IMonedesDAO{

	@Override
	public boolean augmentarMonedes(int monedesActuals) {
	
		return false;
	}

	@Override
	public boolean disminuirMonedes(int monedesActuals) {
		Monedes monedes = new Monedes();
		return false;
	}

}
