package ma.bps.metier;

import java.util.List;

import ma.bps.dao.IRetards;
import ma.bps.dao.RetardsDaoImpl;
import ma.bps.entities.Retards;

public class RetardsMetierImpl implements IRetardsMetier {
	
	IRetards dao = new RetardsDaoImpl();

	public void ajouterRetard(Retards r) {
		// TODO Auto-generated method stub
		dao.ajouterRetard(r);

	}

	public Retards getRetardById(Long idRetard) {
		// TODO Auto-generated method stub
		return dao.getRetardById(idRetard);
	}

	public List<Retards> getAllRetards() {
		// TODO Auto-generated method stub
		return dao.getAllRetards();
	}

	public Retards modifierRetard(Retards r) {
		// TODO Auto-generated method stub
		return dao.modifierRetard(r);
	}

	public void supprimerRetards(Long idRetard) {
		// TODO Auto-generated method stub
		dao.supprimerRetards(idRetard);
		
	}

}
