package validateurs;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


@FacesValidator("validateurPrenom")
public class ValidateurPrenom implements Validator {

//	Pattern p = Pattern.compile("/^[a-zA-Zàâäéèêëçùûüôö]+[-']?[a-zA-Zàâäéèêëçùûüôö]+$/");

	
	
	
	public ValidateurPrenom() {
	}




	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
		String chaine = (String)arg2;
//		Matcher m = p.matcher(chaine);
		
//		if(!m.matches()){
		if(chaine.length()<3 || chaine.length()>=10){
			FacesMessage msg = new FacesMessage();
			msg.setDetail("Le prénom doit contenir seulement des caracères !!!");
			msg.setSummary("Le prénom doit contenir seulement des caracères !!!");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
	}
	
	
}
