package ma.bps.dao;

import java.util.List;

import ma.bps.entities.Utilisateurs;

public interface IUtilisateur {
	
	public void ajouterUtilisateur(Utilisateurs u);
	public Utilisateurs getUtilisateurById(Long idUtilisateur);
	public List<Utilisateurs> getAllUtilisateurs();
	public Utilisateurs modifierUtilisateur(Utilisateurs u);
	public void supprimerUtilisateur(Long idUtilisateur);
	public List<Utilisateurs> chercherUtilisateurByLoginPasse(String login,String passe);

}
