package validateurs;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


@FacesValidator("ValidateurHeureDebutEtHeureFinTranchePlanTravail")
public class ValidateurHeureDebutEtHeureFinTranchePlanTravail implements Validator {

	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		// TODO Auto-generated method stub
		
		
		
		 UIInput startDateComponent = (UIInput) component.getAttributes().get("heureDebut");
		 
		 String heureDebut = (String) startDateComponent.getValue();
		 
		 
		 String heureFin = (String) value;
		 
		 
		 UIInput quelJour = (UIInput) component.getAttributes().get("jour");
		 String jour = (String) quelJour.getValue();
		 
		 
		 System.out.println("///////////////////////////////////////////// Heure Debut : " + heureDebut);
		 
		 System.out.println("///////////////////////////////////////////// Heure Fin : " + heureFin);
		 
		 System.out.println("///////////////////////////////////////////// jour : " + jour);
		 
		 
		 if (jour.equals("lundi")) 
		 {
		
	            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Vérification Tranche","c lundi !!");
	            throw new ValidatorException(msg);
			 
		 }
		
		

	}

}
