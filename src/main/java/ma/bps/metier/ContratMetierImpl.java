package ma.bps.metier;

import java.util.Date;
import java.util.List;

import defaults.typeContrat;
import ma.bps.dao.ContratDaoImpl;
import ma.bps.dao.IContrat;
import ma.bps.entities.Contrats;

public class ContratMetierImpl implements IContratMetier {

	private IContrat dao = new ContratDaoImpl();
	
	public Contrats ajouterContrat(Contrats contrat) {
		// TODO Auto-generated method stub
		return dao.ajouterContrat(contrat);
	}

	public Contrats getContratById(Long idContrat) {
		// TODO Auto-generated method stub
		return dao.getContratById(idContrat);
	}

	public List<Contrats> getAllContrats() {
		// TODO Auto-generated method stub
		return dao.getAllContrats();
	}

	public List<Contrats> getContratByIdSalarie(Long idSalarie) {
		// TODO Auto-generated method stub
		return dao.getContratByIdSalarie(idSalarie);
	}

	public Contrats modifierContrat(Contrats Contrat) {
		// TODO Auto-generated method stub
		return dao.modifierContrat(Contrat);
	}

	public void supprimerContrat(Long idContrat) {
		// TODO Auto-generated method stub
		dao.supprimerContrat(idContrat);
	}

	public Date dateDebutContrat(Long idSalarie) {
		// TODO Auto-generated method stub
		return dao.dateDebutContrat(idSalarie);
	}

}
