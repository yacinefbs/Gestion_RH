package ma.bps.metier;

import java.util.List;

import ma.bps.dao.IMessage;
import ma.bps.dao.MessageDaoImpl;
import ma.bps.entities.Message;
import ma.bps.entities.MessageFichierJoint;

public class MessageMetierImpl implements IMessageMetier {

	IMessage dao = new MessageDaoImpl();

	public void ajouterMessage(Message m) {
		// TODO Auto-generated method stub
		dao.ajouterMessage(m);

	}

	public Message getMessageById(Long idMessage) {
		// TODO Auto-generated method stub
		return dao.getMessageById(idMessage);
	}

	public List<Message> getAllMessages() {
		// TODO Auto-generated method stub
		return dao.getAllMessages();
	}

	public Message modifierMessage(Message m) {
		// TODO Auto-generated method stub
		return dao.modifierMessage(m);
	}

	public void supprimerMessagee(Long idMessage) {
		// TODO Auto-generated method stub
		dao.supprimerMessagee(idMessage);
	}

	public List<Object[]> chargerNombreMessageRecuNonLuSalarie(long idSalarie) {
		// TODO Auto-generated method stub
		return dao.chargerNombreMessageRecuNonLuSalarie(idSalarie);
	}

	public List<Object[]> chargerNombreMessageRecuSalarie(long idSalarie) {
		// TODO Auto-generated method stub
		return dao.chargerNombreMessageRecuSalarie(idSalarie);
	}

	public List<Object[]> chargerNombreMessageEnvoyerSalarie(long idSalarie) {
		// TODO Auto-generated method stub
		return dao.chargerNombreMessageEnvoyerSalarie(idSalarie);
	}

	public List<Object[]> chargerNombreMessageRecuSupprimerSalarie(long idSalarie) {
		// TODO Auto-generated method stub
		return dao.chargerNombreMessageRecuSupprimerSalarie(idSalarie);
	}

	public List<Object[]> chargerNombreMessageEnvoyerSupprimerSalarie(long idSalarie) {
		// TODO Auto-generated method stub
		return dao.chargerNombreMessageEnvoyerSupprimerSalarie(idSalarie);
	}

	public List<Message> chargerMessageRecuNonLuSalarie(long idSalarie) {
		// TODO Auto-generated method stub
		return dao.chargerMessageRecuNonLuSalarie(idSalarie);
	}

	public List<Message> chargerMessageRecuLuSalarie(long idSalarie) {
		// TODO Auto-generated method stub
		return dao.chargerMessageRecuLuSalarie(idSalarie);
	}

	public List<Message> chargerMessageEnvoyerSalarie(long idSalarie) {
		// TODO Auto-generated method stub
		return dao.chargerMessageEnvoyerSalarie(idSalarie);
	}


	public List<Message> chargerMessageEnvoyerSupprimerSalarie(long idSalarie) {
		// TODO Auto-generated method stub
		return dao.chargerMessageEnvoyerSupprimerSalarie(idSalarie);
	}

	public List<MessageFichierJoint> chargerListeDesFichiersJointUnMessage(Long idMessage) {
		// TODO Auto-generated method stub
		return dao.chargerListeDesFichiersJointUnMessage(idMessage);
	}

	public List<Message> chargerMessageRecuLuSupprimerSalarie(long idSalarie) {
		// TODO Auto-generated method stub
		return dao.chargerMessageRecuLuSupprimerSalarie(idSalarie);
	}

	public List<Message> chargerMessageRecuNonLuSupprimerSalarie(long idSalarie) {
		// TODO Auto-generated method stub
		return dao.chargerMessageRecuNonLuSupprimerSalarie(idSalarie);
	}

}
