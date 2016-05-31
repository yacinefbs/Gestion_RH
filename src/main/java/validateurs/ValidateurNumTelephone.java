package validateurs;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("validateurNumTelephone")
public class ValidateurNumTelephone implements Validator {
	Pattern p = Pattern.compile("^(0){1}[5-6]{1}[0-9]{8}$");
	//khalid : ^0[5-6]{1}(([0-9]{2}){4})|((\s[0-9]{2}){4})|((-[0-9]{2}){4})$
	
	
	public ValidateurNumTelephone() {
	}


	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
		String chaine = (String)arg2;
		Matcher m = p.matcher(chaine);
		
		if(!m.matches()){
			FacesMessage msg = new FacesMessage();
			msg.setDetail("Le numéro de téléphone n'est pas valide !!!");
			msg.setSummary("Le numéro de téléphone n'est pas valide !!!");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
	}

}
