package ma.bps.presentation;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.UploadedFile;

import ch.qos.logback.core.util.FileSize;
import ma.bps.dao.IMessageFichierJoint;
import ma.bps.entities.Message;
import ma.bps.entities.MessageFichierJoint;
import ma.bps.metier.IMessageFichierJointMetier;
import ma.bps.metier.IMessageMetier;
import ma.bps.metier.ISalarieMetier;
import ma.bps.metier.MessageFichierJointMetierImpl;
import ma.bps.metier.MessageMetierImpl;
import ma.bps.metier.SalarieMetierImpl;

@ManagedBean
public class BeanMessage {

	
	
	
	// les metier
	ISalarieMetier metierSalarie = new SalarieMetierImpl();
	IMessageFichierJointMetier metierFichierJoint = new MessageFichierJointMetierImpl();
	IMessageMetier metiermessage = new MessageMetierImpl();
	

	// les varriable
	private long idDestinataire;
	Message messageAenvoyer = new Message();
	Message messageAlu = new Message();
	private long idMessageArepondre;
	
	
	// les check box pour supprimer
	private long[] messageRecuSelectionnerPourSupprimer;
	
	private List<Message> messageRecuSelectionnerPourSupprimerUnSalarie;
	private List<Message> messageRecuNonLuSelectionnerPourSupprimerUnSalarie;


	
	// getters setters
	
	

	public List<Message> getMessageRecuSelectionnerPourSupprimerUnSalarie() {
		return messageRecuSelectionnerPourSupprimerUnSalarie;
	}

	public long getIdMessageArepondre() {
		return idMessageArepondre;
	}

	public void setIdMessageArepondre(long idMessageArepondre) {
		this.idMessageArepondre = idMessageArepondre;
	}

	public List<Message> getMessageRecuNonLuSelectionnerPourSupprimerUnSalarie() {
		return messageRecuNonLuSelectionnerPourSupprimerUnSalarie;
	}

	public void setMessageRecuNonLuSelectionnerPourSupprimerUnSalarie(
			List<Message> messageRecuNonLuSelectionnerPourSupprimerUnSalarie) {
		this.messageRecuNonLuSelectionnerPourSupprimerUnSalarie = messageRecuNonLuSelectionnerPourSupprimerUnSalarie;
	}

	public Message getMessageAlu() {
		return messageAlu;
	}

	public void setMessageAlu(Message messageAlu) {
		this.messageAlu = messageAlu;
	}

	public void setMessageRecuSelectionnerPourSupprimerUnSalarie(
			List<Message> messageRecuSelectionnerPourSupprimerUnSalarie) {
		this.messageRecuSelectionnerPourSupprimerUnSalarie = messageRecuSelectionnerPourSupprimerUnSalarie;
	}

	public long[] getMessageRecuSelectionnerPourSupprimer() {
		return messageRecuSelectionnerPourSupprimer;
	}

	public void setMessageRecuSelectionnerPourSupprimer(long[] messageRecuSelectionnerPourSupprimer) {
		this.messageRecuSelectionnerPourSupprimer = messageRecuSelectionnerPourSupprimer;
	}

	public IMessageFichierJointMetier getMetierFichierJoint() {
		return metierFichierJoint;
	}

	public void setMetierFichierJoint(IMessageFichierJointMetier metierFichierJoint) {
		this.metierFichierJoint = metierFichierJoint;
	}

	public IMessageMetier getMetiermessage() {
		return metiermessage;
	}

	public void setMetiermessage(IMessageMetier metiermessage) {
		this.metiermessage = metiermessage;
	}

	

	public Message getMessageAenvoyer() {
		return messageAenvoyer;
	}

	public void setMessageAenvoyer(Message messageAenvoyer) {
		this.messageAenvoyer = messageAenvoyer;
	}

	public long getIdDestinataire() {
		return idDestinataire;
	}

	public void setIdDestinataire(long idDestinataire) {
		this.idDestinataire = idDestinataire;
	}

	public ISalarieMetier getMetierSalarie() {
		return metierSalarie;
	}

	public void setMetierSalarie(ISalarieMetier metierSalarie) {
		this.metierSalarie = metierSalarie;
	}

	// cette methode est appeler au chargement de lapage associer a ce bean
//	@PostConstruct
//	public void init() {
//
//		System.out.println("dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd");
//		
//		if (this.siJeCliqueSurnouveauMessage==1) 
//		{
//			this.annulerEnvoiMessage();
//			
//		}
//		
//		this.siJeCliqueSurnouveauMessage=0;
//		
//		
//	}
	
	
	
	
	

	// Les methodes
	public List<Object[]> chargerNomPrenomSalarie(){
		return metierSalarie.ChargerNomPrenomSalarie();
	}
	
	
	
	// upload files
	
	public void uploadFichier(FileUploadEvent e) throws IOException{
		 
		System.out.println("je sui la **************************");
		
        	UploadedFile uploadedfichier=e.getFile();

        
		    SimpleDateFormat formatterNomFichier = new SimpleDateFormat("ddMMyyyyHHmmssSSS");
		    String filePath="D:/ahmed/AHMED projet PFE/eclipseMars/mesProjets/Gestion_RH/src/main/webapp/fichierProjetPfeGrh/fichierDesEmail/";
           
		   
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

	 	        MessageFichierJoint messageFichier = new MessageFichierJoint();
	 	        messageFichier.setNomReel(filename);
	 	        messageFichier.setNomSurServeur(nomEnregistrement);
	 	        messageFichier.setChemin(filePath + nomEnregistrement);
	 	        messageFichier.setTaille(taille);
	 	        
	 	        metierFichierJoint.ajouterMessageFichierJoint(messageFichier);
                
            }
//            
            // refraichement de la page
//            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
//            ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());

	}
	
	
	// charger la liste des fichier uploaded d'un message
	public List<MessageFichierJoint> chargerLesFichierUnMessage(){
		return metierFichierJoint.chargerListFichierNonAffecterAunMessage();
	}
	
	// supprimer un fichier attacher a un message au moment de l'envoi
	public void supprimerUnFichierAttacherAnouveauMessage(MessageFichierJoint fichier) throws IOException{

		
		metierFichierJoint.supprimerMessageFichierJoint(fichier.getIdFichier());
		File file = new File(fichier.getChemin());
		if (file.exists()) 
		{
			file.delete();
        }
		

	}
	
	// envoyer message
	public void envoyerMessage() throws ParseException, IOException{

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		messageAenvoyer.setDestinataire(metierSalarie.getSalarieById(this.idDestinataire));
		messageAenvoyer.setDestinateur(BeanUtilisateur.salarieConnecte);
		messageAenvoyer.setLu("non");
		messageAenvoyer.setSupprimerFacultatifParDestinataire("non");
		messageAenvoyer.setSupprimerFacultatifParDestinateur("non");
		messageAenvoyer.setSupprimerDefinitifParDestinataire("non");
		messageAenvoyer.setSupprimerDefinitifParDestinateur("non");
		messageAenvoyer.setDateMessage( formatter.parse(formatter.format(new Date())));
		metiermessage.ajouterMessage(messageAenvoyer);
		
		for (MessageFichierJoint fichierMessage : metierFichierJoint.chargerListFichierNonAffecterAunMessage()) {
			
			fichierMessage.setMessage(messageAenvoyer);
			metierFichierJoint.modifierMessageFichierJoint(fichierMessage);
		}

		
		messageAenvoyer = new Message();
		this.idDestinataire = 0;
		
		
	}
	
	
	// annuler envoi message -- khasni n7ayad ls fichier likano joidre lih
	public void annulerEnvoiMessage()
	{
		
		System.out.println("Je suis a annuler envoie message //*/*//**********************************************/////////////////");
		
		for (MessageFichierJoint fichierMessage : metierFichierJoint.chargerListFichierNonAffecterAunMessage()) 
		{
			metierFichierJoint.supprimerMessageFichierJoint(fichierMessage.getIdFichier());
			File file = new File(fichierMessage.getChemin());
			if (file.exists()) 
			{
				file.delete();
	        }
			
			messageAenvoyer = new Message();
			this.idDestinataire = 0;
			
		}
		
	}
	
	
	// charger le nombre des message non lu
	public List<Object[]> chargerNombreMessageRecuNonLuUnSalarie()
	{
		return metiermessage.chargerNombreMessageRecuNonLuSalarie(BeanUtilisateur.salarieConnecte.getIdSalarie());
	}
	
	// charger le nombre des message non lu
	public List<Object[]> chargerNombreMessageRecuUnSalarie()
	{
		return metiermessage.chargerNombreMessageRecuSalarie(BeanUtilisateur.salarieConnecte.getIdSalarie());
	}
	
	public List<Object[]> chargerNombreMessageEnvoyerUnSalarie() {
		
		return metiermessage.chargerNombreMessageEnvoyerSalarie(BeanUtilisateur.salarieConnecte.getIdSalarie());
	}

	public List<Object[]> chargerNombreMessageRecuSupprimerUnSalarie() {
		
		return metiermessage.chargerNombreMessageRecuSupprimerSalarie(BeanUtilisateur.salarieConnecte.getIdSalarie());
	}

	public List<Object[]> chargerNombreMessageEnvoyerSupprimerUnSalarie() {
		
		return metiermessage.chargerNombreMessageEnvoyerSupprimerSalarie(BeanUtilisateur.salarieConnecte.getIdSalarie());
	}
	
	
	public List<Message> chargerMessageRecuNonLuUnSalarie() {
		// TODO Auto-generated method stub
		return metiermessage.chargerMessageRecuNonLuSalarie(BeanUtilisateur.salarieConnecte.getIdSalarie());
	}

	public List<Message> chargerMessageRecuLuUnSalarie() {
		// TODO Auto-generated method stub
		return metiermessage.chargerMessageRecuLuSalarie(BeanUtilisateur.salarieConnecte.getIdSalarie());
	}

	public List<Message> chargerMessageEnvoyerUnSalarie() {
		// TODO Auto-generated method stub
		return metiermessage.chargerMessageEnvoyerSalarie(BeanUtilisateur.salarieConnecte.getIdSalarie());
	}

	public List<Message> chargerMessageRecuLuSupprimerUnSalarie() {
		// TODO Auto-generated method stub
		return metiermessage.chargerMessageRecuLuSupprimerSalarie(BeanUtilisateur.salarieConnecte.getIdSalarie());
	}
	
	public List<Message> chargerMessageRecuNonLuSupprimerUnSalarie() {
		// TODO Auto-generated method stub
		return metiermessage.chargerMessageRecuNonLuSupprimerSalarie(BeanUtilisateur.salarieConnecte.getIdSalarie());
	}

	public List<Message> chargerMessageEnvoyerSupprimerUnSalarie() {
		// TODO Auto-generated method stub
		return metiermessage.chargerMessageEnvoyerSupprimerSalarie(BeanUtilisateur.salarieConnecte.getIdSalarie());
	}

	
	// suppression message recu sélectionner temporaire
	public void supprimerListeDesMessageRecu(){
		
		for (Message m : messageRecuSelectionnerPourSupprimerUnSalarie) 
		{
			System.out.println("************************************/////////////////////////////////" + m.getIdMessage());
			
			Message messagetemp= metiermessage.getMessageById(m.getIdMessage());
			messagetemp.setSupprimerFacultatifParDestinataire("oui");
			metiermessage.modifierMessage(messagetemp);
			
		}
		
		for (Message m : messageRecuNonLuSelectionnerPourSupprimerUnSalarie) 
		{
			System.out.println("************************************/////////////////////////////////" + m.getIdMessage());
			
			Message messagetemp= metiermessage.getMessageById(m.getIdMessage());
			messagetemp.setSupprimerFacultatifParDestinataire("oui");
			metiermessage.modifierMessage(messagetemp);
			
		}
		
	}
	
	// suppression message envoyer sélectionner temporaire
	public void supprimerListeDesMessageEnvoyer(){
		
		for (Message m : messageRecuSelectionnerPourSupprimerUnSalarie) 
		{
			System.out.println("************************************/////////////////////////////////" + m.getIdMessage());
			
			Message messagetemp= metiermessage.getMessageById(m.getIdMessage());
			messagetemp.setSupprimerFacultatifParDestinateur("oui");
			metiermessage.modifierMessage(messagetemp);
			
		}
		
	}
	
	// suppression definitif des message et leurs fichiers joints
	public void supprimerDefinitifLesMessageRecu()
	{
		// suppresion des messge recu et  lu
		for (Message m : messageRecuSelectionnerPourSupprimerUnSalarie) 
		{
			
			Message messagetemp= metiermessage.getMessageById(m.getIdMessage());
			
			// on va faire le test
			// hna le destinataire li bgha i supprimer
			// ila kan 7ta le destinateur ta howa déja supprime n7aydo le message man table
			// si non ndiro ghi bila le destinataire rah supprima had le message nbadlo supprimerDefinitifParSDestinataire
			
			
			if (messagetemp.getSupprimerDefinitifParDestinateur().equals("non")) 
			{
				// hna ghadui ghi nbadlo supprimerDefinitifParSDestinataire
				messagetemp.setSupprimerDefinitifParDestinataire("oui");
				metiermessage.modifierMessage(messagetemp);
			} 
			else 
			{
				// hna ghadi n7aydo le message man table bmara
				
				// suppression des fichiers joints du message
				List<MessageFichierJoint> listeDesFichierJoint = metiermessage.chargerListeDesFichiersJointUnMessage(m.getIdMessage());
				for (MessageFichierJoint fichierMessage : listeDesFichierJoint) 
				{

					File file = new File(fichierMessage.getChemin());
					if (file.exists()) 
					{
						file.delete();
			        }
				}
				
				// suppression du message
				metiermessage.supprimerMessagee(messagetemp.getIdMessage());
				
			}
			
			
		}
		
		
		// suppresion des messge recu et non lu
 
					for (Message m : messageRecuNonLuSelectionnerPourSupprimerUnSalarie) 
					{
						
						Message messagetemp= metiermessage.getMessageById(m.getIdMessage());
						
						// on va faire le test
						// hna le destinataire li bgha i supprimer
						// ila kan 7ta le destinateur ta howa déja supprime n7aydo le message man table
						// si non ndiro ghi bila le destinataire rah supprima had le message nbadlo supprimerDefinitifParSDestinataire
						
						
						if (messagetemp.getSupprimerDefinitifParDestinateur().equals("non")) 
						{
							// hna ghadui ghi nbadlo supprimerDefinitifParSDestinataire
							messagetemp.setSupprimerDefinitifParDestinataire("oui");
							metiermessage.modifierMessage(messagetemp);
						} 
						else 
						{
							// hna ghadi n7aydo le message man table bmara
							
							// suppression des fichiers joints du message
							List<MessageFichierJoint> listeDesFichierJoint = metiermessage.chargerListeDesFichiersJointUnMessage(m.getIdMessage());
							for (MessageFichierJoint fichierMessage : listeDesFichierJoint) 
							{

								File file = new File(fichierMessage.getChemin());
								if (file.exists()) 
								{
									file.delete();
						        }
							}
							
							// suppression du message
							metiermessage.supprimerMessagee(messagetemp.getIdMessage());
							
						}
						
						
					}
		
		
	}
	
	
	
	// suppression definitif des message et leurs fichiers joints
	public void supprimerDefinitifLesMessageEnvoye()
	{
		
		
		System.out.println("supprimerDefinitifLesMessageEnvoye ************************************************");

		
		
		// suppresion des messge recu et  lu
		for (Message m : messageRecuSelectionnerPourSupprimerUnSalarie) 
		{
			
			Message messagetemp= metiermessage.getMessageById(m.getIdMessage());
			
			
			// on va faire le test
			// hna le destinataire li bgha i supprimer
			// ila kan 7ta le destinateur ta howa déja supprime n7aydo le message man table
			// si non ndiro ghi bila le destinataire rah supprima had le message nbadlo supprimerDefinitifParSDestinataire
			
			
			if (messagetemp.getSupprimerDefinitifParDestinataire().equals("non")) 
			{
				// hna ghadui ghi nbadlo supprimerDefinitifParSDestinateur
				messagetemp.setSupprimerDefinitifParDestinateur("oui");
				metiermessage.modifierMessage(messagetemp);
			}
			else
			{
				
				// suppression des fichiers joints du message
				List<MessageFichierJoint> listeDesFichierJoint = metiermessage.chargerListeDesFichiersJointUnMessage(m.getIdMessage());
				for (MessageFichierJoint fichierMessage : listeDesFichierJoint) 
				{

					File file = new File(fichierMessage.getChemin());
					if (file.exists()) 
					{
						file.delete();
			        }
				}
				
				// suppression du message
				metiermessage.supprimerMessagee(messagetemp.getIdMessage());
				
				
			}			
			
			
		}
		
	}
	
	
	
	
	// hade la methode bach ila kan le nombre de message recu non lu < 10 blama ydir pagination
	public boolean siNombreMessageRecuNonLuInferieurA10(){
		return metiermessage.chargerMessageRecuNonLuSalarie(BeanUtilisateur.salarieConnecte.getIdSalarie()).size() > 10;
	}
	
	
	// hade la methode bach ila kan le nombre de message recu lu < 10 blama ydir pagination
	public boolean siNombreMessageRecuLuInferieurA10(){
		return metiermessage.chargerMessageRecuLuSalarie(BeanUtilisateur.salarieConnecte.getIdSalarie()).size() > 10;
	}
	
	
	// hade la methode bach ila kan le nombre de message recu lu < 10 blama ydir pagination
	public boolean siNombreMessageEnvoyerInferieurA15(){
		return metiermessage.chargerMessageEnvoyerSalarie(BeanUtilisateur.salarieConnecte.getIdSalarie()).size() > 15;
	}
	

	// hade la methode bach ila kan le nombre de message recu lu < 10 blama ydir pagination
	public boolean siNombreMessageEnvoyerSupprimerInferieurA15(){
		return metiermessage.chargerMessageEnvoyerSupprimerSalarie(BeanUtilisateur.salarieConnecte.getIdSalarie()).size() > 15;
	}
	
	
	// hade la methode bach ila kan le nombre de message recu lu < 10 blama ydir pagination
	public boolean siNombreMessageRecuLuSupprimerInferieurA15(){
		return metiermessage.chargerMessageRecuLuSupprimerSalarie(BeanUtilisateur.salarieConnecte.getIdSalarie()).size() > 10;
	}
	
	// hade la methode bach ila kan le nombre de message recu lu < 10 blama ydir pagination
	public boolean siNombreMessageRecuNonLuSupprimerInferieurA15(){
		return metiermessage.chargerMessageRecuNonLuSupprimerSalarie(BeanUtilisateur.salarieConnecte.getIdSalarie()).size() > 10;
	}
	
	// aller vers nouveau message
	public String allerVersNouveaumessage(){
		
		this.annulerEnvoiMessage();
		return "AcceuilSalarieMailNouveauMessage";
	}
	
	// aller vers lecture message recu
	public String allerVersLuMessageRecu(Message m){
		this.messageAlu = m;
		this.idMessageArepondre = m.getIdMessage();
		m.setLu("oui");
		metiermessage.modifierMessage(m);
		return "AcceuilSalarieMailLuMessageRecu";
	}
	
	
	// aller vers lecture message recu
		public String allerVersLuMessageEnvoyer(Message m){
			this.messageAlu = m;
			return "AcceuilSalarieMailLuMessageEnvoyer";
		}
		
	
	// charger les fichiers joint d'unmessage
	public List<MessageFichierJoint> chargerLaListeDesFichierJointUnMessage(){
		return metiermessage.chargerListeDesFichiersJointUnMessage(this.messageAlu.getIdMessage());
	}
	
	
	// répondre a un message
	public String repondreAunMessage()
	{
	Message m = metiermessage.getMessageById(this.idMessageArepondre);
	this.idDestinataire = m.getDestinateur().getIdSalarie();
	return "AcceuilSalarieMailNouveauMessage";
		
	}
	
	// supprimer un message recu malikankouno na9raw fih
	

    

	
	
	
}
