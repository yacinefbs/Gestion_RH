package ma.bps.presentation;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.commons.io.FilenameUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import ma.bps.entities.AutoFormation;
import ma.bps.entities.AutoFormationDocuments;
import ma.bps.entities.AutoFormationTheme;
import ma.bps.entities.Message;
import ma.bps.entities.MessageFichierJoint;
import ma.bps.metier.AutoFormationDocumentsMetierImpl;
import ma.bps.metier.AutoFormationMetierImpl;
import ma.bps.metier.AutoFormationThemeMetierImpl;
import ma.bps.metier.IAutoFormationDocumentsMetier;
import ma.bps.metier.IAutoFormationMetier;
import ma.bps.metier.IAutoFormationThemeMetier;

@ManagedBean
@SessionScoped
public class BeanAutoFormation {
	
	IAutoFormationMetier metierAutoFormation = new AutoFormationMetierImpl();
	IAutoFormationDocumentsMetier metierAutoFormationDocuments = new AutoFormationDocumentsMetierImpl();
	IAutoFormationThemeMetier metierAutoFormationTheme = new AutoFormationThemeMetierImpl();
	
	AutoFormation autoFormationAajouter = new AutoFormation();
	AutoFormation autoFormationAmodifier = new AutoFormation();
	
	private long idAutoFormationAModifier;
	
	

	AutoFormationTheme autoFormationThemeAajouter = new AutoFormationTheme();
	
	
	// id de theme de formation
	private long idAutoFormationTheme ;
	
	// varriable pour presiser si modification ou ajout
	private String ajoutOuModif = "ajout";
	
		
	
	
	// Getters and Setters
	
	public long getIdAutoFormationAModifier() {
		return idAutoFormationAModifier;
	}
	public void setIdAutoFormationAModifier(long idAutoFormationAModifier) {
		this.idAutoFormationAModifier = idAutoFormationAModifier;
	}
	
	public String getAjoutOuModif() {
		return ajoutOuModif;
	}
	public void setAjoutOuModif(String ajoutOuModif) {
		ajoutOuModif = ajoutOuModif;
	}
	public IAutoFormationThemeMetier getMetierAutoFormationTheme() {
		return metierAutoFormationTheme;
	}
	public void setMetierAutoFormationTheme(IAutoFormationThemeMetier metierAutoFormationTheme) {
		this.metierAutoFormationTheme = metierAutoFormationTheme;
	}
	public AutoFormationTheme getAutoFormationThemeAajouter() {
		return autoFormationThemeAajouter;
	}
	public void setAutoFormationThemeAajouter(AutoFormationTheme autoFormationThemeAajouter) {
		this.autoFormationThemeAajouter = autoFormationThemeAajouter;
	}
	public long getIdAutoFormationTheme() {
		return idAutoFormationTheme;
	}
	public void setIdAutoFormationTheme(long idAutoFormationTheme) {
		this.idAutoFormationTheme = idAutoFormationTheme;
	}
	public IAutoFormationMetier getMetierAutoFormation() {
		return metierAutoFormation;
	}
	public void setMetierAutoFormation(IAutoFormationMetier metierAutoFormation) {
		this.metierAutoFormation = metierAutoFormation;
	}
	public IAutoFormationDocumentsMetier getMetierAutoFormationDocuments() {
		return metierAutoFormationDocuments;
	}
	public void setMetierAutoFormationDocuments(IAutoFormationDocumentsMetier metierAutoFormationDocuments) {
		this.metierAutoFormationDocuments = metierAutoFormationDocuments;
	}
	public AutoFormation getAutoFormationAajouter() {
		return autoFormationAajouter;
	}
	public void setAutoFormationAajouter(AutoFormation autoFormationAajouter) {
		this.autoFormationAajouter = autoFormationAajouter;
	}
	public AutoFormation getAutoFormationAmodifier() {
		return autoFormationAmodifier;
	}
	public void setAutoFormationAmodifier(AutoFormation autoFormationAmodifier) {
		this.autoFormationAmodifier = autoFormationAmodifier;
	}
	
	
	
	
	// les methodes 
	
	
	
	
	
//	 cette methode est appeler au chargement de lapage associer a ce bean
//	@PostConstruct
//	public void init() {
//
//		System.out.println("dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd");
//		
//		for (AutoFormationDocuments fichierMessage : metierAutoFormationDocuments.chargerListDocumentAutoFormationNonAffecterAuneAutoFormation()) 
//		{
//			metierAutoFormationDocuments.supprimerAutoFormationDocuments(fichierMessage.getIdFichier());
//			File file = new File(fichierMessage.getChemin());
//			if (file.exists()) 
//			{
//				file.delete();
//	        }
//			
//			
//		}
//		
//		
//		
//	}
	
	
	
	
	
	
	
	public void ajouterAutoFormation(){
		
		autoFormationAajouter.setThemeAutoFormation(metierAutoFormationTheme.getAutoFormationThemeById(this.idAutoFormationTheme));
		autoFormationAajouter.setDateLancelent(new Date());
		metierAutoFormation.ajouterAutoFormation(this.autoFormationAajouter);
		
		for (AutoFormationDocuments fichier : metierAutoFormationDocuments.chargerListDocumentAutoFormationNonAffecterAuneAutoFormation()) {
			
			fichier.setAutoFormation(this.autoFormationAajouter);;
			metierAutoFormationDocuments.modifierAutoFormationDocuments(fichier);
		}
		


		
		this.autoFormationAajouter = new AutoFormation();
		this.idAutoFormationTheme = 0;
		
		
	}
	
	
	// upload file auto formation
	
	// upload files
	
	public void uploadFichier(FileUploadEvent e) throws IOException{
		 
		System.out.println("je sui la **************************");
		
        	UploadedFile uploadedfichier=e.getFile();

        
		    SimpleDateFormat formatterNomFichier = new SimpleDateFormat("ddMMyyyyHHmmssSSS");
		    String filePath="D:/ahmed/AHMED projet PFE/eclipseMars/mesProjets/Gestion_RH/src/main/webapp/fichierProjetPfeGrh/fichierDesAutoFormation/";
           
		   
            byte[] bytes=null;
 
            if (null!=uploadedfichier) 
            {
                bytes = uploadedfichier.getContents();
	 	        String filename = FilenameUtils.getName(uploadedfichier.getFileName());
	 	        String extension = FilenameUtils.getExtension(filename);
	 	        long taille = uploadedfichier.getSize() / 1024;
	 	        
	 	        System.out.println("taille du fichier : " + taille + " ***************ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ");
	 	        
	 	        String nomEnregistrement = formatterNomFichier.format(new Date()) + "." + extension ;
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath + nomEnregistrement)));
                stream.write(bytes);
                stream.close();

	 	        AutoFormationDocuments autoFormationFichier = new AutoFormationDocuments();
	 	        autoFormationFichier.setNomReel(filename);
	 	        autoFormationFichier.setNomSurServeur(nomEnregistrement);
	 	        autoFormationFichier.setChemin(filePath + nomEnregistrement);
	 	        autoFormationFichier.setTaille(taille);
	 	        
	 	        metierAutoFormationDocuments.ajouterAutoFormationDocuments(autoFormationFichier);
                
            }


	}
	
	
	
	
	// supprimer un fichier attacher a une auto formation au moment de l'ajout
		public void supprimerUnFichierAttacherAautoFormation(AutoFormationDocuments fichier) throws IOException{

			System.out.println(" supprimer un fichier joint ******************************************************");
			
			metierAutoFormationDocuments.supprimerAutoFormationDocuments(fichier.getIdFichier());
			File file = new File(fichier.getChemin());
			if (file.exists()) 
			{
				file.delete();
	        }
			

		}
		
	// charger les fichier joint a une auto formation au moment de l'ajout

		public List<AutoFormationDocuments> chargerLesFichierUneAutoFormationAuMomentAjout(){
			return metierAutoFormationDocuments.chargerListDocumentAutoFormationNonAffecterAuneAutoFormation();
		}
		
		
	// charger la liste des theme auto formation
		
		public List<AutoFormationTheme> chargerListeThemeAutoFormation (){
			
			return metierAutoFormationTheme.getAllAutoFormationTheme();
			
		}
		
	// ajouter autoformationthéme
		
		public void ajouterAutoFormationTheme(){
			
			metierAutoFormationTheme.ajouterAutoFormationTheme(autoFormationThemeAajouter);
			
		}
		
	// charger la liste des auto formation
		
		public List<AutoFormation> chargerListeDesAutoFormatio(){
			
			return metierAutoFormation.getAllAutoFormation();
			
		}
		
	// charger nombre document une formation
		
		public List<Object[]> chargerNombreDocumentUneFormation(AutoFormation a){
			return metierAutoFormation.chargerNombreDocumentFormation(a.getIdAutoFormation());
		}
		
		
	// charger les documents d'une formation
		
		public List<AutoFormationDocuments> chargerLesDocumentsUneFormation(){
			
			System.out.println("*******************************charger liste des fichuer auto form**************************" + this.idAutoFormationAModifier);
			return metierAutoFormation.chargerLesDocumentUneFormation(this.autoFormationAmodifier.getIdAutoFormation());

			
		}
		
	// Aller vers modification auto formation
		
		public String allerVersModifierAutoFormation(AutoFormation a){
			
			this.supprimerLesFichiersNonAtacherAuneAutoFormation();
			this.autoFormationAmodifier = a;
			this.idAutoFormationTheme = a.getThemeAutoFormation().getIdAutoFormationTheme();	
			this.idAutoFormationAModifier = a.getIdAutoFormation();
			return "gestionAutoFormationModifier";
		}
		
	// Enregistrer la modification
		
		public String modifierAutoFormation(){
			
			System.out.println("id = ***************************************  " + this.autoFormationAmodifier.getIdAutoFormation());
			
			autoFormationAmodifier.setThemeAutoFormation(metierAutoFormationTheme.getAutoFormationThemeById(this.idAutoFormationTheme));
			metierAutoFormation.modifierAutoFormation(this.autoFormationAmodifier);
			
			for (AutoFormationDocuments fichier : metierAutoFormationDocuments.chargerListDocumentAutoFormationNonAffecterAuneAutoFormation()) {
				
				fichier.setAutoFormation(this.autoFormationAmodifier);
				metierAutoFormationDocuments.modifierAutoFormationDocuments(fichier);
			}
			
			this.autoFormationAmodifier = new AutoFormation();
			this.idAutoFormationTheme = 0;
			
			return "gestionAutoFormation";
			
		}
		
	// annuler modification auto formation
		
		public String annulerModifierAutoFormation(){
			
			
			this.supprimerLesFichiersNonAtacherAuneAutoFormation();
			this.autoFormationAmodifier = new AutoFormation();
			this.idAutoFormationTheme = 0;
			this.idAutoFormationAModifier = 0;
			
			return "gestionAutoFormation";
			
		}
		
	// supprimer les documment non attacher a une autoformation
		public void supprimerLesFichiersNonAtacherAuneAutoFormation(){
			
			for (AutoFormationDocuments fichierMessage : metierAutoFormationDocuments.chargerListDocumentAutoFormationNonAffecterAuneAutoFormation()) 
			{
				metierAutoFormationDocuments.supprimerAutoFormationDocuments(fichierMessage.getIdFichier());
				File file = new File(fichierMessage.getChemin());
				if (file.exists()) 
				{
					file.delete();
		        }
				
				
			}
			
		}
		
	// supprimer une auto formation
		public void supprimerAutoFormation(AutoFormation a){
			
			// supprimer les documment attacher a la formation
			for (AutoFormationDocuments fichierMessage : metierAutoFormation.chargerLesDocumentUneFormation(a.getIdAutoFormation())) 
			{
				metierAutoFormationDocuments.supprimerAutoFormationDocuments(fichierMessage.getIdFichier());
				File file = new File(fichierMessage.getChemin());
				if (file.exists()) 
				{
					file.delete();
		        }
				
				
			}
			
			// supprimer l'auto formation
			metierAutoFormation.supprimerAutoFormation(a.getIdAutoFormation());
			
			
		}
		

	
	
	

}
