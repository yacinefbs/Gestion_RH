package ma.bps.metier;

import java.util.List;

import ma.bps.dao.ISite;
import ma.bps.dao.SiteDaoImpl;
import ma.bps.entities.Sites;

public class SiteMetierImpl implements ISiteMetier {

	private ISite dao = new SiteDaoImpl();
	
	public Sites ajouterSite(Sites s) {
		// TODO Auto-generated method stub
		return dao.ajouterSite(s);
	}

	public Sites getSiteById(Long idSite) {
		// TODO Auto-generated method stub
		return dao.getSiteById(idSite);
	}

	public List<Sites> getAllSites() {
		// TODO Auto-generated method stub
		return dao.getAllSites();
	}

	public Sites modifierSite(Sites s) {
		// TODO Auto-generated method stub
		return dao.modifierSite(s);
	}

	public void supprimerSite(Long idSite) {
		// TODO Auto-generated method stub
		dao.supprimerSite(idSite);
	}

}
