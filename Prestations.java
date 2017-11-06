package bean;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Prestations {
	
	private StringProperty nomPrestation;
	private IntegerProperty dateHeurePrestation;
	private TypePrestation typePrestation;

	public Prestations() {
		this.nomPrestation = new SimpleStringProperty();
		this.dateHeurePrestation = new SimpleIntegerProperty();
		this.typePrestation = new TypePrestation();
	}


	public void setNomPrestation(StringProperty nomPrestation) {
		this.nomPrestation = nomPrestation;
	}

	public void setDateHeurePrestation(IntegerProperty dateHeurePrestation) {
		this.dateHeurePrestation = dateHeurePrestation;
	}

	public int getDateHeurePrestation() {
		return dateHeurePrestation.get();
	}

	public void setDateHeurePrestation(int dateHeurePrestation) {
		this.dateHeurePrestation.set(dateHeurePrestation);
	}
	public IntegerProperty getDateHeurePrestationProperty() {
		return dateHeurePrestation;
	}

	public TypePrestation getTypePrestation() {
		return typePrestation;
	}

	public void setTypePrestation(TypePrestation typePrestation) {
		this.typePrestation = typePrestation;
	}

	public String getNomPrestation() {
		return nomPrestation.get();
	}

	public void setNomPrestation(String nomPrestation) {
		this.nomPrestation.set(nomPrestation);
	}



}
