package ma.bps.metier;

import java.util.List;

import ma.bps.entities.ModePaiements;

public interface IModePaiementMetier {
	public List<ModePaiements> getAllModePaiement();
	public ModePaiements getModePaiementById(Long idMode);
	public ModePaiements ajouterModePaiment(ModePaiements mode);
}
