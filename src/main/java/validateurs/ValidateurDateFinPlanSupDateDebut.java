package validateurs;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("ValidateurDateFinPlanSupDateDebut")
public class ValidateurDateFinPlanSupDateDebut implements Validator {

	//@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		// TODO Auto-generated method stub

        if (value == null) {
            return; // Let required="true" handle.
        }

        UIInput startDateComponent = (UIInput) component.getAttributes().get("dateDebutPlan");

        if (!startDateComponent.isValid()) {
            return; // Already invalidated. Don't care about it then.
        }

        Date startDate = (Date) startDateComponent.getValue();
        
        System.out.println("************************************* Date *****************" + startDateComponent.getValue());

        if (startDate == null) {
            return; // Let required="true" handle.
        }

        Date endDate = (Date) value;

        if (startDate.after(endDate)) {
            startDateComponent.setValid(false);
//            FacesContext facesContext = FacesContext.getCurrentInstance();
//            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Vérification Date", "La date fin doit étre supérieur à la date début !!"));
            
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Vérification Date","La date fin doit étre supérieur à la date début !!");
            throw new ValidatorException(msg);
        }
    }
		
	}

