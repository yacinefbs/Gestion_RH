package ma.bps.dao;

import java.util.List;

import ma.bps.entities.Message;
import ma.bps.entities.MessageFichierJoint;

public interface IMessage {
	
	public void ajouterMessage(Message m);
	public Message getMessageById(Long idMessage);
	public List<Message> getAllMessages();
	public Message modifierMessage(Message m);
	public void supprimerMessagee(Long idMessage);
	
	// charger le nombre des message reçu non lu d'un salarie
	public List<Object[]> chargerNombreMessageRecuNonLuSalarie(long idSalarie);
	// charger le nombre des message reçu d'un salarie
	public List<Object[]> chargerNombreMessageRecuSalarie(long idSalarie);
	
	// charger le nombre des message envoyer par un salarie
	public List<Object[]> chargerNombreMessageEnvoyerSalarie(long idSalarie);
	
	// charger le nombre des message recu supprimer par un salarie
	public List<Object[]> chargerNombreMessageRecuSupprimerSalarie(long idSalarie);
	
	
	// charger le nombre des message envoyer supprimer par un salarie
	public List<Object[]> chargerNombreMessageEnvoyerSupprimerSalarie(long idSalarie);
	

	
	// charger le nombre des message reçu non lu d'un salarie
	public List<Message> chargerMessageRecuNonLuSalarie(long idSalarie);
	// charger le nombre des message reçu d'un salarie
	public List<Message> chargerMessageRecuLuSalarie(long idSalarie);
	
	// charger le nombre des message envoyer par un salarie
	public List<Message> chargerMessageEnvoyerSalarie(long idSalarie);
	
	// charger le nombre des message recu supprimer par un salarie
	public List<Message> chargerMessageRecuLuSupprimerSalarie(long idSalarie);
	
	
	// charger le nombre des message recu supprimer par un salarie
	public List<Message> chargerMessageRecuNonLuSupprimerSalarie(long idSalarie);
	
	// charger le nombre des message envoyer supprimer par un salarie
	public List<Message> chargerMessageEnvoyerSupprimerSalarie(long idSalarie);
	
	
	// charger la liste des fichiers joint un message
	public List<MessageFichierJoint> chargerListeDesFichiersJointUnMessage(Long idMessage);

	

}
