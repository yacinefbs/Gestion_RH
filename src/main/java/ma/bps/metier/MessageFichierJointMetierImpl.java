package ma.bps.metier;

import java.util.List;

import ma.bps.dao.IMessageFichierJoint;
import ma.bps.dao.MessageFichierJointDaoImpl;
import ma.bps.entities.Message;
import ma.bps.entities.MessageFichierJoint;

public class MessageFichierJointMetierImpl implements IMessageFichierJointMetier {
	
	IMessageFichierJoint dao = new MessageFichierJointDaoImpl();

	public void ajouterMessageFichierJoint(MessageFichierJoint f) {
		// TODO Auto-generated method stub
		dao.ajouterMessageFichierJoint(f);

	}

	public MessageFichierJoint getMessageFichierJointById(Long idMessageFichierJoint) {
		// TODO Auto-generated method stub
		return dao.getMessageFichierJointById(idMessageFichierJoint);
	}

	public List<MessageFichierJoint> getAllMessageFichierJoint() {
		// TODO Auto-generated method stub
		return dao.getAllMessageFichierJoint();
	}

	public MessageFichierJoint modifierMessageFichierJoint(MessageFichierJoint f) {
		// TODO Auto-generated method stub
		return dao.modifierMessageFichierJoint(f);
	}

	public void supprimerMessageFichierJoint(Long idMessageFichierJoint) {
		// TODO Auto-generated method stub
		dao.supprimerMessageFichierJoint(idMessageFichierJoint);
		

	}

	public List<MessageFichierJoint> chargerListFichierNonAffecterAunMessage() {
		// TODO Auto-generated method stub
		return dao.chargerListFichierNonAffecterAunMessage();
	}

	public void affecterDesFichierAunMessage(Message message) {
		// TODO Auto-generated method stub
		dao.affecterDesFichierAunMessage(message);
	}

}
