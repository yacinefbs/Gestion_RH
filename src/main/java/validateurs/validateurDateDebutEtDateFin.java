package validateurs;


import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


@FacesValidator("validateurDateDebutEtDateFin")
public class validateurDateDebutEtDateFin implements Validator {

	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		// TODO Auto-generated method stub

		Date dateFin = (Date) value;
		UIInput component1 = (UIInput) component.getAttributes().get("dateDebut");
		
		Date dateDebut = (Date) component1.getValue();
		
		if(dateDebut.after(dateFin)){
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erreur !!!","Date de fin doît être supérieure à la date de début");
			throw new ValidatorException(msg);
		}
		
		
	}

}
