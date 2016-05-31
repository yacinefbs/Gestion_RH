package ma.bps.metier;

import java.util.List;

import ma.bps.dao.ITauxFraisPro;
import ma.bps.dao.TauxFraisProDaoImpl;
import ma.bps.entities.TauxFraisPro;

public class TauxFraisProMetierImpl implements ITauxFraisProMetier {

	private ITauxFraisPro dao = new TauxFraisProDaoImpl();
	
	public TauxFraisPro ajouterTauxFraisPro(TauxFraisPro t) {
		// TODO Auto-generated method stub
		return dao.ajouterTauxFraisPro(t);
	}

	public TauxFraisPro getTauxFraisProById(Long idTauxFraisPro) {
		// TODO Auto-generated method stub
		return dao.getTauxFraisProById(idTauxFraisPro);
	}

	public List<TauxFraisPro> getAllTauxFraisPros() {
		// TODO Auto-generated method stub
		return dao.getAllTauxFraisPros();
	}

	public TauxFraisPro modifierTauxFraisPro(TauxFraisPro t) {
		// TODO Auto-generated method stub
		return dao.modifierTauxFraisPro(t);
	}

	public void supprimerTauxFraisPro(Long idTauxFraisPro) {
		// TODO Auto-generated method stub
		dao.supprimerTauxFraisPro(idTauxFraisPro);
	}
	
}
