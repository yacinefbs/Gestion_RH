package ma.bps.metier;

import java.util.List;

import ma.bps.entities.Sites;

public interface ISiteMetier {
	public Sites ajouterSite(Sites s);
	public Sites getSiteById(Long idSite);
	public List<Sites> getAllSites();
	public Sites modifierSite(Sites s);
	public void supprimerSite(Long idSite);
}
