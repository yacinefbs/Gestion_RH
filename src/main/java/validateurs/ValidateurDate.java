package validateurs;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("validateurDate")
public class ValidateurDate implements Validator {

	Pattern p = Pattern.compile("dd/MM/yyyy");
	
	
	
	public ValidateurDate() {
	}

	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String date = (String)arg2;
		Matcher m = p.matcher(date);
				
		if(!m.matches()){
			FacesMessage msg = new FacesMessage();
			msg.setDetail("La date est invalide !!!");
			msg.setSummary("La date est invalide !!!");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
	}
}
