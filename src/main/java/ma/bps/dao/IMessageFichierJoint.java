package ma.bps.dao;

import java.util.List;

import ma.bps.entities.Message;
import ma.bps.entities.MessageFichierJoint;

public interface IMessageFichierJoint {
	
	public void ajouterMessageFichierJoint(MessageFichierJoint f);
	public MessageFichierJoint getMessageFichierJointById(Long idMessageFichierJoint);
	public List<MessageFichierJoint> getAllMessageFichierJoint();
	public MessageFichierJoint modifierMessageFichierJoint(MessageFichierJoint f);
	public void supprimerMessageFichierJoint(Long idMessageFichierJoint);

	public List<MessageFichierJoint> chargerListFichierNonAffecterAunMessage();
	public void affecterDesFichierAunMessage(Message message);
	
}
