package ma.bps.metier;

import java.util.List;

import ma.bps.entities.AdressesPro;

public interface IAdresseProMetier {
	public AdressesPro ajouterAdressePro(AdressesPro a);
	public AdressesPro getAdresseProById(Long idAdressePro);
	public AdressesPro getAdresseProBySalarie(Long idSalarie);
	public List<AdressesPro> getAllAdressesPro();
	public AdressesPro modifierAdressePro(AdressesPro a);
	public void supprimerAdressePro(Long idAdressePro);
}
