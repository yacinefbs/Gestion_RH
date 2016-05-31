package ma.bps.metier;

import java.util.List;

import ma.bps.dao.BanqueDaoImpl;
import ma.bps.dao.IBanque;
import ma.bps.entities.Banques;

public class BanqueMetierImpl implements IBanqueMetier {

	
	private IBanque dao = new BanqueDaoImpl();
	public Banques ajouterBanque(Banques b) {
		// TODO Auto-generated method stub
		return dao.ajouterBanque(b);
	}
	
	public Banques getBanqueById(Long idBanque){
		return dao.getBanqueById(idBanque);
	}
	public List<Banques> getAllBanques() {
		// TODO Auto-generated method stub
		return dao.getAllBanques();
	}
	
	public Banques modifierBanque(Banques b){
		return dao.modifierBanque(b);
	}
	
	public void supprimerBanque(Long idBanque){
		dao.supprimerBanque(idBanque);
	}

	public Banques getBanqueByAgence(Long idAgence) {
		// TODO Auto-generated method stub
		return dao.getBanqueByAgence(idAgence);
	}
}
