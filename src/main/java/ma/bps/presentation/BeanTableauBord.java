package ma.bps.presentation;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ma.bps.entities.Salaries;
import ma.bps.metier.ISalarieMetier;
import ma.bps.metier.SalarieMetierImpl;

@ManagedBean
@SessionScoped
public class BeanTableauBord {
	private ISalarieMetier salarieMetier = new SalarieMetierImpl();
	private Salaries salaries;
	public Salaries getSalaries() {
		return salaries;
	}
	public void setSalaries(Salaries salaries) {
		this.salaries = salaries;
	}
	
	public int getNbrSalarie(){
		return salarieMetier.nbrSalarie();
	}
}
