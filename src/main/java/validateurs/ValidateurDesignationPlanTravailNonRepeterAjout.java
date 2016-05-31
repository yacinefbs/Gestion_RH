package validateurs;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.mysql.fabric.xmlrpc.base.Value;

import ma.bps.entities.PlanTravail;
import ma.bps.metier.IPlanTravailMetier;
import ma.bps.metier.PlanTravailMetierImpl;

@FacesValidator("ValidateurDesignationPlanTravailNonRepeterAjout")
public class ValidateurDesignationPlanTravailNonRepeterAjout implements Validator {

	public void validate(FacesContext arg0, UIComponent arg1, Object value) throws ValidatorException {
		// TODO Auto-generated method stub
		
		String designation = (String) value;
		
		System.out.println("***************************************************************" + designation);
		
		if (designation.trim().equals("")) 
		{
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Vérification Désignation","vous devez saisir une désignation !!");
            throw new ValidatorException(msg);
		}
		
		
		IPlanTravailMetier metierPlan = new PlanTravailMetierImpl();
		List <PlanTravail> ls = metierPlan.chercherPlanTravailAvecDesignation(designation);
		
		if (ls.size()>0) 
		{
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Vérification Désignation","désignation plan existe déja !!");
            throw new ValidatorException(msg);
		}
		

	}

}
