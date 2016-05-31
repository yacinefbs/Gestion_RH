package ma.bps.metier;

import java.util.List;

import ma.bps.dao.IOrganisme;
import ma.bps.dao.OrganismeDaoImpl;
import ma.bps.entities.Organismes;

public class OrganismesMetierImpl implements IOrganismesMetier {

	private IOrganisme dao = new OrganismeDaoImpl();
	
	public Organismes ajouterOrganisme(Organismes o) {
		// TODO Auto-generated method stub
		return dao.ajouterOrganisme(o);
	}

	public Organismes getOrganismeById(Long idOrganisme) {
		// TODO Auto-generated method stub
		return dao.getOrganismeById(idOrganisme);
	}

	public List<Organismes> getAllOrganismes() {
		// TODO Auto-generated method stub
		return dao.getAllOrganismes();
	}

	public Organismes modifierOrganismes(Organismes o) {
		// TODO Auto-generated method stub
		return dao.modifierOrganismes(o);
	}

	public void supprimerOrganisme(Long idOrganisme) {
		// TODO Auto-generated method stub
		dao.supprimerOrganisme(idOrganisme);
	}
}
