package ma.bps.metier;

import java.util.List;

import ma.bps.dao.IUtilisateur;
import ma.bps.dao.UtilisateurDaoImpl;
import ma.bps.entities.Utilisateurs;

public class UtilisateurMetierImpl implements IUtilisateurMetier {
	
	IUtilisateur dao = new UtilisateurDaoImpl();

	public void ajouterUtilisateur(Utilisateurs u) {

		dao.ajouterUtilisateur(u);

	}

	public Utilisateurs getUtilisateurById(Long idUtilisateur) {
		// TODO Auto-generated method stub
		return dao.getUtilisateurById(idUtilisateur);
	}

	public List<Utilisateurs> getAllUtilisateurs() {
		// TODO Auto-generated method stub
		return dao.getAllUtilisateurs();
	}

	public Utilisateurs modifierUtilisateur(Utilisateurs u) {
		// TODO Auto-generated method stub
		return dao.modifierUtilisateur(u);
	}

	public void supprimerUtilisateur(Long idUtilisateur) {

		dao.supprimerUtilisateur(idUtilisateur);

	}

	public List<Utilisateurs> chercherUtilisateurByLoginPasse(String login, String passe) {
		// TODO Auto-generated method stub
		return dao.chercherUtilisateurByLoginPasse(login, passe);
	}

}
