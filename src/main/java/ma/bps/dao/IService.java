package ma.bps.dao;

import java.util.List;
import ma.bps.entities.Banques;
import ma.bps.entities.Services;

public interface IService {
	public Services ajouterService(Services s);
	public Services getServiceById(Long idService);
	public List<Services> getAllServices();
	public Services modifierService(Services s);
	public void supprimerService(Long idService);
}
