package ma.bps.dao;

import java.util.List;

import ma.bps.entities.AutoFormation;
import ma.bps.entities.AutoFormationTheme;

public interface IAutoFormationTheme {
	
	public AutoFormationTheme ajouterAutoFormationTheme(AutoFormationTheme m);
	public AutoFormationTheme getAutoFormationThemeById(Long idAutoFormationTheme);
	public List<AutoFormationTheme> getAllAutoFormationTheme();
	public AutoFormationTheme modifierAutoFormationTheme(AutoFormationTheme m);
	public void supprimerAutoFormationTheme(Long idAutoFormationTheme);
	
	public List<AutoFormationTheme> chargerListeAutoFormationThemeAyantDesAutoFormation();

}
