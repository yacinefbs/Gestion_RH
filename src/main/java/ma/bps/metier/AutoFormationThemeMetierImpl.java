package ma.bps.metier;

import java.util.List;

import ma.bps.dao.AutoFormationThemeDaoImpl;
import ma.bps.dao.IAutoFormationTheme;
import ma.bps.entities.AutoFormation;
import ma.bps.entities.AutoFormationTheme;

public class AutoFormationThemeMetierImpl implements IAutoFormationThemeMetier {
	
	IAutoFormationTheme dao = new AutoFormationThemeDaoImpl();

	public AutoFormationTheme ajouterAutoFormationTheme(AutoFormationTheme m) {
		// TODO Auto-generated method stub
		return dao.ajouterAutoFormationTheme(m);
	}

	public AutoFormationTheme getAutoFormationThemeById(Long idAutoFormationTheme) {
		// TODO Auto-generated method stub
		return dao.getAutoFormationThemeById(idAutoFormationTheme);
	}

	public List<AutoFormationTheme> getAllAutoFormationTheme() {
		// TODO Auto-generated method stub
		return dao.getAllAutoFormationTheme();
	}

	public AutoFormationTheme modifierAutoFormationTheme(AutoFormationTheme m) {
		// TODO Auto-generated method stub
		return dao.modifierAutoFormationTheme(m);
	}

	public void supprimerAutoFormationTheme(Long idAutoFormationTheme) {
		// TODO Auto-generated method stub
		dao.supprimerAutoFormationTheme(idAutoFormationTheme);
		
	}

	public List<AutoFormationTheme> chargerListeAutoFormationThemeAyantDesAutoFormation() {
		// TODO Auto-generated method stub
		return dao.chargerListeAutoFormationThemeAyantDesAutoFormation();
	}

	

}
