package validateurs;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


@FacesValidator("validateurSelectOneMenu")
public class validateurSelectOneMenu implements Validator {

	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		// TODO Auto-generated method stub
		Long valeur = (Long) value;
		
		if (valeur == 0L) 
		{
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"","Choisir une valeur de la liste !!");
            throw new ValidatorException(msg);
		}
	}

}
