package validateurs;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("ValidateuSelectionnerTypePlanTravailDeLaListe")
public class ValidateuSelectionnerTypePlanTravailDeLaListe implements Validator {

	public void validate(FacesContext arg0, UIComponent arg1, Object value) throws ValidatorException {
		// TODO Auto-generated method stub
		
		String valeur = (String) value;
		
		if (valeur.equals("ss")) 
		{
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Vérification type plan","Choisir le type plan de la liste !!");
            throw new ValidatorException(msg);
		}

	}

}
