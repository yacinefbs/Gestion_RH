package ma.bps.metier;

import java.util.List;

import ma.bps.dao.AutoFormationDocumentsDaoImpl;
import ma.bps.dao.IAutoFormationDocuments;
import ma.bps.entities.AutoFormationDocuments;

public class AutoFormationDocumentsMetierImpl implements IAutoFormationDocumentsMetier {
	
	IAutoFormationDocuments dao = new AutoFormationDocumentsDaoImpl();

	public AutoFormationDocuments ajouterAutoFormationDocuments(AutoFormationDocuments m) {
		// TODO Auto-generated method stub
		return dao.ajouterAutoFormationDocuments(m);
	}

	public AutoFormationDocuments getAutoAutoFormationDocumentsById(Long idAutoFormationDocuments) {
		// TODO Auto-generated method stub
		return dao.getAutoAutoFormationDocumentsById(idAutoFormationDocuments);
	}

	public List<AutoFormationDocuments> getAllAutoFormationDocuments() {
		// TODO Auto-generated method stub
		return dao.getAllAutoFormationDocuments();
	}

	public AutoFormationDocuments modifierAutoFormationDocuments(AutoFormationDocuments m) {
		// TODO Auto-generated method stub
		return dao.modifierAutoFormationDocuments(m);
	}

	public void supprimerAutoFormationDocuments(Long idAutoFormationDocuments) {
		// TODO Auto-generated method stub
		dao.supprimerAutoFormationDocuments(idAutoFormationDocuments);
	}

	public List<AutoFormationDocuments> chargerListDocumentAutoFormationNonAffecterAuneAutoFormation() {
		// TODO Auto-generated method stub
		return dao.chargerListDocumentAutoFormationNonAffecterAuneAutoFormation();
	}

}
