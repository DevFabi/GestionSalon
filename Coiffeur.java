package bean;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Coiffeur {

	private StringProperty nomCoiffeur;
	private StringProperty prenomCoiffeur;
	
	
	public Coiffeur() {
		super();
		this.nomCoiffeur = new SimpleStringProperty();
		this.prenomCoiffeur = new SimpleStringProperty();
	}
	
	public void setNomCoiffeur(StringProperty nomCoiffeur) {
		this.nomCoiffeur = nomCoiffeur;
	}
	public void setPrenomCoiffeur(StringProperty prenomCoiffeur) {
		this.prenomCoiffeur = prenomCoiffeur;
	}
	
	public StringProperty getNomCoiffeurProperty() {
		return nomCoiffeur;
	}
	public StringProperty getPrenomCoiffeurProperty() {
		return prenomCoiffeur;
	}
	public String getNomCoiffeur() {
		return nomCoiffeur.get();
	}

	public String getPrenomCoiffeur() {
		return prenomCoiffeur.get();
	}
	public void setPrenomCoiffeur(String PrenomCoiffeur) {
		this.prenomCoiffeur.set(PrenomCoiffeur);
	}
    public void setNomCoiffeur(String nomCoiffeur) {
        this.nomCoiffeur.set(nomCoiffeur);
    }

	
	@Override
	public String toString() {
		return "Coiffeur [nomCoiffeur=" + nomCoiffeur + ", prenomCoiffeur=" + prenomCoiffeur + "]";
	}

	

}
