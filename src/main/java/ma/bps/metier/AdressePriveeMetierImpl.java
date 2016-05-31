package ma.bps.metier;

import java.util.List;

import ma.bps.dao.AdressePriveeDaoImpl;
import ma.bps.dao.IAdressePrivee;
import ma.bps.entities.AdressesPrivee;

public class AdressePriveeMetierImpl implements IAdressePriveeMetier {

	private IAdressePrivee dao = new AdressePriveeDaoImpl();
	
	
	public AdressesPrivee ajouterAdressePrivee(AdressesPrivee a) {
		// TODO Auto-generated method stub
		return dao.ajouterAdressePrivee(a);
	}

	public AdressesPrivee getAdressePriveeById(Long idAdressePrivee) {
		// TODO Auto-generated method stub
		return dao.getAdressePriveeById(idAdressePrivee);
	}

	public AdressesPrivee getAdressesPriveeBySalarie(Long idSalarie) {
		// TODO Auto-generated method stub
		return dao.getAdressesPriveeBySalarie(idSalarie);
	}

	public List<AdressesPrivee> getAllAdressesPrivee() {
		// TODO Auto-generated method stub
		return dao.getAllAdressesPrivee();
	}

	public AdressesPrivee modifierAdressePrivee(AdressesPrivee a) {
		// TODO Auto-generated method stub
		return dao.modifierAdressePrivee(a);
	}

	public void supprimerAdressePrivee(Long idAdressePrivee) {
		// TODO Auto-generated method stub
		dao.supprimerAdressePrivee(idAdressePrivee);
	}

}
