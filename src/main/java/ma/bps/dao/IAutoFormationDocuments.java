package ma.bps.dao;

import java.util.List;

import ma.bps.entities.AutoFormation;
import ma.bps.entities.AutoFormationDocuments;
import ma.bps.entities.MessageFichierJoint;

public interface IAutoFormationDocuments {
	
	public AutoFormationDocuments ajouterAutoFormationDocuments(AutoFormationDocuments m);
	public AutoFormationDocuments getAutoAutoFormationDocumentsById(Long idAutoFormationDocuments);
	public List<AutoFormationDocuments> getAllAutoFormationDocuments();
	public AutoFormationDocuments modifierAutoFormationDocuments(AutoFormationDocuments m);
	public void supprimerAutoFormationDocuments(Long idAutoFormationDocuments);
	
	public List<AutoFormationDocuments> chargerListDocumentAutoFormationNonAffecterAuneAutoFormation();

}
