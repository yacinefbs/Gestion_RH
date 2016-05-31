package ma.bps.dao;

import java.util.List;

import ma.bps.entities.Banques;
import ma.bps.entities.Organismes;

public interface IOrganisme {
	public Organismes ajouterOrganisme(Organismes o);
	public Organismes getOrganismeById(Long idOrganisme);
	public List<Organismes> getAllOrganismes();
	public Organismes modifierOrganismes(Organismes o);
	public void supprimerOrganisme(Long idOrganisme);
}
