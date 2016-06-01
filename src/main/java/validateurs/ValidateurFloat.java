package validateurs;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("validateurFloat")
public class ValidateurFloat implements Validator {
	
	//Pattern p = Pattern.compile("^[0-9]{1,30}/.[0-9]{0,2}$");

	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		// TODO Auto-generated method stub
		String d = (String)value;
		
		try 
		{
			
			double a = Double.parseDouble(d);
			
			if (a == 15) 
			{
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Champs invalide !!!","== 15");
			}
			
			
		} catch (Exception e) 
		{
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Champs invalide !!!","Ce champs doit être numérique !!");
		}
		
//		Matcher m = p.matcher(d);
//		
//		if(!m.matches()){
//			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Champs invalide !!!","Ce champs doit être numérique !!");
//		}
	}

}
