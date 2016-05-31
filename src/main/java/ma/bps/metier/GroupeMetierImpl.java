package ma.bps.metier;

import java.util.List;

import ma.bps.dao.GroupeDaoImpl;
import ma.bps.dao.IGroupe;
import ma.bps.entities.Groupes;
import ma.bps.entities.Salaires;
import ma.bps.entities.Salaries;

public class GroupeMetierImpl implements IGroupeMetier {

	private IGroupe dao = new GroupeDaoImpl();
	
	public void ajouterGrouppe(Groupes g) {
		// TODO Auto-generated method stub
		dao.ajouterGrouppe(g);
	}

	public Groupes getGroupeById(Long idGroupe) {
		// TODO Auto-generated method stub
		return dao.getGroupeById(idGroupe);
	}

	public List<Groupes> getAllGroupes() {
		// TODO Auto-generated method stub
		return dao.getAllGroupes();
	}

	public Groupes modifierGroupe(Groupes g) {
		// TODO Auto-generated method stub
		return dao.modifierGroupe(g);
	}

	public void supprimerGroupe(Long idGroupe) {
		// TODO Auto-generated method stub
		dao.supprimerGroupe(idGroupe);
	}
	
	public List<Salaires> getAllGroupeSalarie(Long idGroup){
		return dao.getAllGroupeSalarie(idGroup);
	}

	public void annulerPlanGroupe(long idPlan) {
		// TODO Auto-generated method stub
		dao.annulerPlanGroupe(idPlan);
	}

	public List<Groupes> chargerListeGroupeQuiNePossedePasDePlan() {
		// TODO Auto-generated method stub
		return dao.chargerListeGroupeQuiNePossedePasDePlan();
	}

	public List<Salaries> chargerListeSalarieUnGroupe(Long idGroup) {
		// TODO Auto-generated method stub
		return dao.chargerListeSalarieUnGroupe(idGroup);
	}

}
