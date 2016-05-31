package ma.bps.metier;

import java.util.List;

import ma.bps.entities.Services;

public interface IServiceMetier {
	public Services ajouterService(Services s);
	public Services getServiceById(Long idService);
	public List<Services> getAllServices();
	public Services modifierService(Services s);
	public void supprimerService(Long idService);
}
