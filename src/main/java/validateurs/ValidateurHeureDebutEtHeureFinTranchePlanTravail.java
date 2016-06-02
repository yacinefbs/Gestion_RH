package validateurs;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import ma.bps.entities.TranchePlanTravail;
import ma.bps.metier.ITranchePlanTravailMetier;
import ma.bps.metier.TranchePlanTravailMetierImpl;

import java.util.Date;
import java.util.List;

@FacesValidator("ValidateurHeureDebutEtHeureFinTranchePlanTravail")
public class ValidateurHeureDebutEtHeureFinTranchePlanTravail implements Validator {

	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		// TODO Auto-generated method stub
		
		
		ITranchePlanTravailMetier metierTranche = new TranchePlanTravailMetierImpl();
		
		
		 UIInput startDateComponent = (UIInput) component.getAttributes().get("heureDebut");
		 
		 Date heureDebut = (Date) startDateComponent.getValue();
		 
		 
		 Date heureFin = (Date) value;
		 
		 
		 String jour = (String) component.getAttributes().get("jour");
		 
		 UIInput idPlanComponent = (UIInput) component.getAttributes().get("idPlan");
		 
		 Long idPlan = (Long) idPlanComponent.getValue();
		 
		 
		 Boolean deuxJour = false;
		 
		 
		 if (jour.equals("lundi"))
		 {
			 UIInput deuxJoursComponent = (UIInput) component.getAttributes().get("deuxJourLundi");
			 
			 deuxJour = (Boolean) deuxJoursComponent.getValue();
		 }
		 
		 if (jour.equals("mardi"))
		 {
			 UIInput deuxJoursComponent = (UIInput) component.getAttributes().get("deuxJourMardi");
			 
			 deuxJour = (Boolean) deuxJoursComponent.getValue();
		 }
		 
		 if (jour.equals("mercredi"))
		 {
			 UIInput deuxJoursComponent = (UIInput) component.getAttributes().get("deuxJourMercredi");
			 
			 deuxJour = (Boolean) deuxJoursComponent.getValue();
		 }
		 
		 if (jour.equals("jeudi"))
		 {
			 UIInput deuxJoursComponent = (UIInput) component.getAttributes().get("deuxJourJeudi");
			 
			 deuxJour = (Boolean) deuxJoursComponent.getValue();
		 }
		 
		 if (jour.equals("vendredi"))
		 {
			 UIInput deuxJoursComponent = (UIInput) component.getAttributes().get("deuxJourVendredi");
			 
			 deuxJour = (Boolean) deuxJoursComponent.getValue();
		 }
		 
		 if (jour.equals("samedi"))
		 {
			 UIInput deuxJoursComponent = (UIInput) component.getAttributes().get("deuxJourSamedi");
			 
			 deuxJour = (Boolean) deuxJoursComponent.getValue();
		 }
		 
		 if (jour.equals("dimanche"))
		 {
			 UIInput deuxJoursComponent = (UIInput) component.getAttributes().get("deuxJourDimanche");
			 
			 deuxJour = (Boolean) deuxJoursComponent.getValue();
		 }
		 

		
		 
		 
		 System.out.println("///////////////////////////////////////////// Heure Debut : " + heureDebut);
		 
		 System.out.println("///////////////////////////////////////////// Heure Fin : " + heureFin);
		 
		 System.out.println("///////////////////////////////////////////// jour : " + jour);
		 
		 System.out.println("///////////////////////////////////////////// id Plan : " + idPlan);
		 
		 System.out.println("///////////////////////////////////////////// Deux Jours : " + deuxJour);
		 
		 
		 // ila kanat la tranche sur 2 jours
		 if (deuxJour) 
		 {
			 
			 heureFin.setDate(heureFin.getDate()+1); // kanzido nhar f la date
			 
			 if (heureDebut.after(heureFin)) 
			 {
				 
				 // ila kanat heur debut kbar man heure fin 7abass lmar9a
		            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Vérification Tranche","Attention !! Heure début est supérieur à heure fin");
		            throw new ValidatorException(msg);
			 }
			 else
			 {
				 
				 // ila kanat heure debut sghar man heure fin ya3ni mazyana
				 // nchoufo yakma had la tranche matdakhla m3a chi tranche khra
				 
				 
				 for (TranchePlanTravail tranchePlanTravail : metierTranche.getTranchePlanTravailByJour(jour,idPlan)) 
				 {
					
					 Date heureDebutTrancheTest = tranchePlanTravail.getHeureDebut();
					 Date heureFinTrancheTest = tranchePlanTravail.getHeureFin();
					 
					 if (tranchePlanTravail.isDeuxJour()) 
					 {
						 heureFinTrancheTest.setDate(heureFinTrancheTest.getDate()+1); // kanzido nhar f la date
					 }
					 
					 
					 if ((heureDebut.after(heureDebutTrancheTest) && heureFinTrancheTest.after(heureDebut)) || ((heureFin.after(heureDebutTrancheTest) && heureFinTrancheTest.after(heureFin)))) 
					 {
						
				            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Vérification Tranche","( Attention !! cette tranche est en coflit avec une autre tranche )");
				            throw new ValidatorException(msg);
						 
					 }
					 
				 }
				 
				 
			 }
			 
			
		 }
		// ila ma kanatch la tranche sur 2 jours
		 else
		 {
			 


			 
			 if (heureDebut.after(heureFin)) 
			 {
				 
				 // ila kanat heur debut kbar man heure fin 7abass lmar9a
		            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Vérification Tranche","Attention !! Heure début est supérieur à heure fin");
		            throw new ValidatorException(msg);
			 }
			 else
			 {
				 
				 // ila kanat heure debut sghar man heure fin ya3ni mazyana
				 // nchoufo yakma had la tranche matdakhla m3a chi tranche khra
				 
				 
				 for (TranchePlanTravail tranchePlanTravail : metierTranche.getTranchePlanTravailByJour(jour,idPlan)) 
				 {
					
					 Date heureDebutTrancheTest = tranchePlanTravail.getHeureDebut();
					 Date heureFinTrancheTest = tranchePlanTravail.getHeureFin();
					 
					 if (tranchePlanTravail.isDeuxJour()) 
					 {
						 heureFinTrancheTest.setDate(heureFinTrancheTest.getDate()+1); // kanzido nhar f la date
					 }
					 
					 
					 if ((heureDebut.after(heureDebutTrancheTest) && heureFinTrancheTest.after(heureDebut)) || ((heureFin.after(heureDebutTrancheTest) && heureFinTrancheTest.after(heureFin)))) 
					 {
						
				            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Vérification Tranche","( Attention !! cette tranche est en coflit avec une autre tranche )");
				            throw new ValidatorException(msg);
						 
					 }
					 
				 }
				 
				 
			 }
			 
			 
			 
			 
			 
		 }
		 
		 
		 
		 

		 
		 
		 
//		 if (jour.equals("lundi")) 
//		 {
//		
//	            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Vérification Tranche","c lundi !!");
//	            throw new ValidatorException(msg);
//			 
//		 }
		
		

	}

}
