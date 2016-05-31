package ma.bps.metier;

import java.util.List;

import ma.bps.entities.Qualifications;

public interface IQualificationMetier {
	public Qualifications ajouterQualification(Qualifications q);
	public Qualifications getQualificationById(Long idQualification);
	public List<Qualifications> getAllQualifications();
	public Qualifications modifierQualification(Qualifications q);
	public void supprimerQualification(Long idQualification);
}
