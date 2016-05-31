package validateurs;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import ma.bps.dao.SalarieDaoImpl;
import ma.bps.metier.ISalarieMetier;
import ma.bps.metier.SalaireMetierImpl;
import ma.bps.metier.SalarieMetierImpl;

@FacesValidator("validateurEmail")
public class ValidateurEmail implements Validator {

	Pattern p = Pattern.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@(yahoo|gmail|hotmail)(\\.(com|fr|ma))$");
	
	
	
	public ValidateurEmail() {
	}



	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
		// TODO Auto-generated method stub
		String email = (String)arg2;
		Matcher m = p.matcher(email);
		
		if(!m.matches()){
			FacesMessage msg = new FacesMessage();
			msg.setDetail("Adresse email est invalide !!!");
			msg.setSummary("Adresse email est invalide !!!");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
		
		
	}

}
