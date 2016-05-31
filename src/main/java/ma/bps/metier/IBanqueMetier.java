package ma.bps.metier;

import java.util.List;

import ma.bps.entities.Banques;

public interface IBanqueMetier {
	public Banques ajouterBanque(Banques b);
	public Banques getBanqueById(Long idBanque);
	public List<Banques> getAllBanques();
	public Banques modifierBanque(Banques b);
	public void supprimerBanque(Long idBanque);
	public Banques getBanqueByAgence(Long idAgence);
}
