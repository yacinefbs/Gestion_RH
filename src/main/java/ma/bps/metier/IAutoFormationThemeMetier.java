package ma.bps.metier;

import java.util.List;

import ma.bps.entities.AutoFormationTheme;

public interface IAutoFormationThemeMetier {
	
	public AutoFormationTheme ajouterAutoFormationTheme(AutoFormationTheme m);
	public AutoFormationTheme getAutoFormationThemeById(Long idAutoFormationTheme);
	public List<AutoFormationTheme> getAllAutoFormationTheme();
	public AutoFormationTheme modifierAutoFormationTheme(AutoFormationTheme m);
	public void supprimerAutoFormationTheme(Long idAutoFormationTheme);
	
	public List<AutoFormationTheme> chargerListeAutoFormationThemeAyantDesAutoFormation();

}
