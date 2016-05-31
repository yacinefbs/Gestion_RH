package ma.bps.metier;

import java.util.List;
import ma.bps.dao.IService;
import ma.bps.dao.ServiceDaoImpl;
import ma.bps.entities.Services;

public class ServiceMetierImpl implements IServiceMetier {

	private IService dao = new ServiceDaoImpl();

	public Services ajouterService(Services s) {
		// TODO Auto-generated method stub
		return dao.ajouterService(s);
	}

	public Services getServiceById(Long idService) {
		// TODO Auto-generated method stub
		return dao.getServiceById(idService);
	}

	public List<Services> getAllServices() {
		// TODO Auto-generated method stub
		return dao.getAllServices();
	}

	public Services modifierService(Services s) {
		// TODO Auto-generated method stub
		return dao.modifierService(s);
	}

	public void supprimerService(Long idService) {
		// TODO Auto-generated method stub
		dao.supprimerService(idService);
	}
}
