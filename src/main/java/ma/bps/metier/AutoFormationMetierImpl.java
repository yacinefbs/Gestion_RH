package ma.bps.metier;

import java.util.List;

import ma.bps.dao.AutoFormationDaoImpl;
import ma.bps.dao.IAutoFormation;
import ma.bps.entities.AutoFormation;
import ma.bps.entities.AutoFormationDocuments;

public class AutoFormationMetierImpl implements IAutoFormationMetier {

	IAutoFormation dao = new AutoFormationDaoImpl();
	
	public AutoFormation ajouterAutoFormation(AutoFormation m) {
		// TODO Auto-generated method stub
		return dao.ajouterAutoFormation(m);
	}

	public AutoFormation getAutoFormationById(Long idAutoFormation) {
		// TODO Auto-generated method stub
		return dao.getAutoFormationById(idAutoFormation);
	}

	public List<AutoFormation> getAllAutoFormation() {
		// TODO Auto-generated method stub
		return dao.getAllAutoFormation();
	}

	public AutoFormation modifierAutoFormation(AutoFormation m) {
		// TODO Auto-generated method stub
		return dao.modifierAutoFormation(m);
	}

	public void supprimerAutoFormation(Long idAutoFormation) {
		// TODO Auto-generated method stub
		dao.supprimerAutoFormation(idAutoFormation);
	}

	public List<Object[]> chargerNombreDocumentFormation(Long idFormation) {
		// TODO Auto-generated method stub
		return dao.chargerNombreDocumentFormation(idFormation);
	}

	public List<AutoFormationDocuments> chargerLesDocumentUneFormation(Long idFormation) {
		// TODO Auto-generated method stub
		return dao.chargerLesDocumentUneFormation(idFormation);
	}

	public List<AutoFormation> chargerListeAutoFormationUnTheme(long idTheme) {
		// TODO Auto-generated method stub
		return dao.chargerListeAutoFormationUnTheme(idTheme);
	}

	public List<AutoFormation> chargerListeAutoFormationRechercheParSujet(String sujetChercher) {
		// TODO Auto-generated method stub
		return dao.chargerListeAutoFormationRechercheParSujet(sujetChercher);
	}

}
