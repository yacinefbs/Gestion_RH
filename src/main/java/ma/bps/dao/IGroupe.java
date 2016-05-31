package ma.bps.dao;

import java.util.List;

import ma.bps.entities.Groupes;
import ma.bps.entities.Salaires;
import ma.bps.entities.Salaries;

public interface IGroupe {
	public void ajouterGrouppe(Groupes g);
	public Groupes getGroupeById(Long idGroupe);
	public List<Groupes> getAllGroupes();
	public Groupes modifierGroupe(Groupes g);
	public void supprimerGroupe(Long idGroupe);
	public List<Salaires> getAllGroupeSalarie(Long idGroup);
	public void annulerPlanGroupe(long idPlan); // cette methode est utiliser pour rendre idPlan d'un groupe null ( pour que le Plan puise etre supprimer )
	
	public List<Groupes> chargerListeGroupeQuiNePossedePasDePlan(); // cette methode est utiliser pour charger les groupes qui n'on pas de plan de travail
	
	public List<Salaries> chargerListeSalarieUnGroupe(Long idGroup); // charge la liste des salarie d'un groupe
}
