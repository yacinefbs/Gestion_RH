package validateurs;

import java.util.regex.Matcher;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import ma.bps.metier.ISalarieMetier;
import ma.bps.metier.SalarieMetierImpl;

@FacesValidator("validateurExistEmail")
public class ValidateurExistEmail implements Validator {

	
	
	
	public ValidateurExistEmail() {
		
	}

	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
		// TODO Auto-generated method stub
		String email = (String)arg2;
		ISalarieMetier salarieMetier = new SalarieMetierImpl();
		if(salarieMetier.verifierExisteEmail(email)){
			FacesMessage msg = new FacesMessage();
			msg.setDetail("Adresse email déjâ existe !!!");
			msg.setSummary("Adresse email déjâ existe !!!");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
	}

}
