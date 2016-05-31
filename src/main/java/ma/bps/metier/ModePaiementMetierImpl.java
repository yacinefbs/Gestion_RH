package ma.bps.metier;

import java.util.List;

import ma.bps.dao.IModePaiement;
import ma.bps.dao.ModePaiementDaoImpl;
import ma.bps.entities.ModePaiements;

public class ModePaiementMetierImpl implements IModePaiementMetier {
	
	private IModePaiement dao = new ModePaiementDaoImpl();
	
	public List<ModePaiements> getAllModePaiement() {
		// TODO Auto-generated method stub
		return dao.getAllModePaiement();
	}

	public ModePaiements getModePaiementById(Long idMode) {
		// TODO Auto-generated method stub
		return dao.getModePaiementById(idMode);
	}

	public ModePaiements ajouterModePaiment(ModePaiements mode) {
		// TODO Auto-generated method stub
		return dao.ajouterModePaiment(mode);
	}

}
