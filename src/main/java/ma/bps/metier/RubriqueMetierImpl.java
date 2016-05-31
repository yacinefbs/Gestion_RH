package ma.bps.metier;

import java.util.List;

import ma.bps.dao.IRubriques;
import ma.bps.dao.RubriqueDaoImpl;
import ma.bps.entities.Rubriques;

public class RubriqueMetierImpl implements IRubriquMetier {

	private IRubriques dao = new RubriqueDaoImpl();
	
	public Rubriques ajouterRubrique(Rubriques r) {
		// TODO Auto-generated method stub
		return dao.ajouterRubrique(r);
	}

	public Rubriques getRubriquesById(Long idRubrique) {
		// TODO Auto-generated method stub
		return dao.getRubriquesById(idRubrique);
	}

	public List<Rubriques> getAllRubriques() {
		// TODO Auto-generated method stub
		return dao.getAllRubriques();
	}

	public Rubriques modifierRubrique(Rubriques r) {
		// TODO Auto-generated method stub
		return dao.modifierRubrique(r);
	}

	public void supprimerRubrique(Long idRubrique) {
		// TODO Auto-generated method stub
		dao.supprimerRubrique(idRubrique);
	}
}
