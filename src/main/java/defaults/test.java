package defaults;


import ma.bps.dao.IModePaiement;
import ma.bps.entities.Agences;
import ma.bps.entities.B_Conges;
import ma.bps.entities.Banques;
import ma.bps.entities.ModePaiements;
import ma.bps.entities.Qualifications;
import ma.bps.entities.Services;
import ma.bps.entities.Sites;
import ma.bps.entities.Societes;
import ma.bps.metier.AgenceMetierImpl;
import ma.bps.metier.B_CongeMetierImpl;
import ma.bps.metier.BanqueMetierImpl;
import ma.bps.metier.IAgenceMetier;
import ma.bps.metier.IB_CongeMetier;
import ma.bps.metier.IBanqueMetier;
import ma.bps.metier.IModePaiementMetier;
import ma.bps.metier.IQualificationMetier;
import ma.bps.metier.IServiceMetier;
import ma.bps.metier.ISiteMetier;
import ma.bps.metier.ISocieteMetier;
import ma.bps.metier.ModePaiementMetierImpl;
import ma.bps.metier.QualificationMetierImpl;
import ma.bps.metier.ServiceMetierImpl;
import ma.bps.metier.SiteMetierImpl;
import ma.bps.metier.SocieteMetierImpl;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			IBanqueMetier banque = new BanqueMetierImpl();
			IQualificationMetier qualification = new QualificationMetierImpl();
			IServiceMetier service = new ServiceMetierImpl();
			ISiteMetier site = new SiteMetierImpl();
			IAgenceMetier agence = new AgenceMetierImpl();
			IModePaiementMetier modePaiement = new ModePaiementMetierImpl();
			IB_CongeMetier bcongeMetier = new B_CongeMetierImpl();
			ISocieteMetier societeMetier = new SocieteMetierImpl();
			
			Agences ag = new Agences();
			Banques b = new Banques();
			Societes s = new Societes();
			s.setAdresseSociete("414, bd Ibn Tachfine, 2° étg. Hakam 1 - 20320 Casablanca.");
			s.setNomSociete("BPS Maroc");
			
			societeMetier.ajouterSociete(s);
			
				B_Conges b_conge = new B_Conges();
			
			b_conge = new B_Conges(0, 0.5, 0, 0);
			b_conge.setSociete(societeMetier.getSocieteById(1L));
			bcongeMetier.ajouterB_Conge(b_conge);
			
			b_conge = new B_Conges(0.5, 5, 1.5, 3);
			b_conge.setSociete(societeMetier.getSocieteById(1L));
			bcongeMetier.ajouterB_Conge(b_conge);
			
			b_conge = new B_Conges(5, 10, 1.5, 4.5);
			b_conge.setSociete(societeMetier.getSocieteById(1L));
			bcongeMetier.ajouterB_Conge(b_conge);
			
			b_conge = new B_Conges(10, 15, 1.5, 6);
			b_conge.setSociete(societeMetier.getSocieteById(1L));
			bcongeMetier.ajouterB_Conge(b_conge);
			
			b_conge = new B_Conges(15, 20, 1.5, 7.5);
			b_conge.setSociete(societeMetier.getSocieteById(1L));
			bcongeMetier.ajouterB_Conge(b_conge);
			
			b_conge = new B_Conges(20, 9999, 1.5, 9);
			b_conge.setSociete(societeMetier.getSocieteById(1L));
			bcongeMetier.ajouterB_Conge(b_conge);
			
			banque.ajouterBanque(new Banques("Banque populaire"));
			banque.ajouterBanque(new Banques("BMCE"));
			banque.ajouterBanque(new Banques("BMCI"));
			banque.ajouterBanque(new Banques("Crédit du Maroc"));
			banque.ajouterBanque(new Banques("Attijari Wafa Bank 1"));
			
			
			qualification.ajouterQualification(new Qualifications("Ingénieur"));
			qualification.ajouterQualification(new Qualifications("Directeur"));
			qualification.ajouterQualification(new Qualifications("Comptable"));
			
			service.ajouterService(new Services("Comptabilité"));
			service.ajouterService(new Services("Informatique"));
		
			site.ajouterSite(new Sites("BPS -- Casablanca"));
			site.ajouterSite(new Sites("BPS -- Rabat"));
			site.ajouterSite(new Sites("BPS -- Tanger"));
			
			ag = new Agences("Banque populaire -- Casablanca", "Casablanca");
			ag.setBanque(banque.getBanqueById(1L));
			agence.ajouterAgence(ag);
			
			ag = new Agences("Banque populaire -- Rabat", "Rabat");
			ag.setBanque(banque.getBanqueById(1L));
			agence.ajouterAgence(ag);
			
			ag = new Agences("Banque populaire -- Tanger", "Tanger");
			ag.setBanque(banque.getBanqueById(1L));
			agence.ajouterAgence(ag);
				
			ag = new Agences("Banque populaire -- Yaakoub el Mansour", "Casablanca");
			ag.setBanque(banque.getBanqueById(1L));
			agence.ajouterAgence(ag);
							
			ag = new Agences("Banque populaire -- Gandi", "Casablanca");
			ag.setBanque(banque.getBanqueById(1L));
			agence.ajouterAgence(ag);
			
			
			ag = new Agences("BMCE -- Casablanca", "Casablanca");
			ag.setBanque(banque.getBanqueById(2L));
			agence.ajouterAgence(ag);
			
			ag = new Agences("BMCE -- Rabat", "Rabat");
			ag.setBanque(banque.getBanqueById(2L));
			agence.ajouterAgence(ag);
			
			ag = new Agences("BMCE -- Tanger", "Tanger");
			ag.setBanque(banque.getBanqueById(2L));
			agence.ajouterAgence(ag);
				
			ag = new Agences("BMCE -- Yaakoub el Mansour", "Casablanca");
			ag.setBanque(banque.getBanqueById(2L));
			agence.ajouterAgence(ag);
							
			ag = new Agences("BMCE -- Gandi", "Casablanca");
			ag.setBanque(banque.getBanqueById(2L));
			agence.ajouterAgence(ag);
			
			
			ag = new Agences("BMCI -- Casablanca", "Casablanca");
			ag.setBanque(banque.getBanqueById(3L));
			agence.ajouterAgence(ag);
			
			ag = new Agences("BMCI -- Rabat", "Rabat");
			ag.setBanque(banque.getBanqueById(3L));
			agence.ajouterAgence(ag);
			
			ag = new Agences("BMCI -- Tanger", "Tanger");
			ag.setBanque(banque.getBanqueById(3L));
			agence.ajouterAgence(ag);
				
			ag = new Agences("BMCI -- Yaakoub el Mansour", "Casablanca");
			ag.setBanque(banque.getBanqueById(3L));
			agence.ajouterAgence(ag);
							
			ag = new Agences("BMCI -- Gandi", "Casablanca");
			ag.setBanque(banque.getBanqueById(3L));
			agence.ajouterAgence(ag);
			
			
			
			ag = new Agences("Crédit du Maroc -- Casablanca", "Casablanca");
			ag.setBanque(banque.getBanqueById(4L));
			agence.ajouterAgence(ag);
			
			ag = new Agences("Crédit du Maroc -- Rabat", "Rabat");
			ag.setBanque(banque.getBanqueById(4L));
			agence.ajouterAgence(ag);
			
			ag = new Agences("Crédit du Maroc -- Tanger", "Tanger");
			ag.setBanque(banque.getBanqueById(4L));
			agence.ajouterAgence(ag);
				
			ag = new Agences("Crédit du Maroc -- Yaakoub el Mansour", "Casablanca");
			ag.setBanque(banque.getBanqueById(4L));
			agence.ajouterAgence(ag);
							
			ag = new Agences("Crédit du Maroc -- Gandi", "Casablanca");
			ag.setBanque(banque.getBanqueById(4L));
			agence.ajouterAgence(ag);
			
			modePaiement.ajouterModePaiment(new ModePaiements("Espèce"));
			modePaiement.ajouterModePaiment(new ModePaiements("Chèque"));
			modePaiement.ajouterModePaiment(new ModePaiements("Virement"));
			
			
	}

}
