package validateurs;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import ma.bps.metier.ISalarieMetier;
import ma.bps.metier.SalarieMetierImpl;

@FacesValidator("validateurMatriculeNotExist")
public class ValidateurMatriculeNotExist implements Validator {

	
	
	public ValidateurMatriculeNotExist() {
	
	}

	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
		
		Long matricule = (Long) arg2;
		
		ISalarieMetier salarieMetier = new SalarieMetierImpl();
		System.out.println("validateur matricule1 : " + salarieMetier.verifierExisteMatricule(matricule));
		
		if(salarieMetier.verifierExisteMatricule(matricule) == false){
			FacesMessage msg = new FacesMessage();
			msg.setDetail("Ce matricule n'existe pas !!!");
			msg.setSummary("Ce matricule n'existe pas !!!");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
	}

}
