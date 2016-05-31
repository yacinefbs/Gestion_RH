package ma.bps.dao;

import java.util.List;

import ma.bps.entities.ModePaiements;

public interface IModePaiement {
	public ModePaiements ajouterModePaiment(ModePaiements mode);
	public List<ModePaiements> getAllModePaiement();
	public ModePaiements getModePaiementById(Long idMode);
}
