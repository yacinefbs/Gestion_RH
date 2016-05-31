package ma.bps.metier;

import java.util.List;

import ma.bps.dao.AdresseProDaoImpl;
import ma.bps.dao.IAdressePro;
import ma.bps.entities.AdressesPro;

public class AdresseProMetierImpl implements IAdresseProMetier {

	private IAdressePro dao = new AdresseProDaoImpl();
	
	public AdressesPro ajouterAdressePro(AdressesPro a) {
		// TODO Auto-generated method stub
		return dao.ajouterAdressePro(a);
	}

	public AdressesPro getAdresseProById(Long idAdressePro) {
		// TODO Auto-generated method stub
		return dao.getAdresseProById(idAdressePro);
	}

	public AdressesPro getAdresseProBySalarie(Long idSalarie) {
		// TODO Auto-generated method stub
		return dao.getAdresseProBySalarie(idSalarie);
	}

	public List<AdressesPro> getAllAdressesPro() {
		// TODO Auto-generated method stub
		return dao.getAllAdressesPro();
	}

	public AdressesPro modifierAdressePro(AdressesPro a) {
		// TODO Auto-generated method stub
		return dao.modifierAdressePro(a);
	}

	public void supprimerAdressePro(Long idAdressePro) {
		// TODO Auto-generated method stub
		dao.supprimerAdressePro(idAdressePro);
	}
}
