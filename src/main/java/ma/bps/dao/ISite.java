package ma.bps.dao;

import java.util.List;
import ma.bps.entities.Sites;

public interface ISite {
	public Sites ajouterSite(Sites s);
	public Sites getSiteById(Long idSite);
	public List<Sites> getAllSites();
	public Sites modifierSite(Sites s);
	public void supprimerSite(Long idSite);
}
