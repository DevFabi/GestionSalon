package bean;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TypePrestation {
	
	private StringProperty libellePrestation;
	private IntegerProperty prixPrestation;
	
	public TypePrestation() {
		this.libellePrestation = new SimpleStringProperty();
		this.prixPrestation = new SimpleIntegerProperty();
	}
	
	public void setLibellePrestation(StringProperty libellePrestation) {
		this.libellePrestation = libellePrestation;
	}
	public void setPrixPrestation(IntegerProperty prixPrestation) {
		this.prixPrestation = prixPrestation;
	}
	public StringProperty getLibellePrestationProperty() {
		return libellePrestation;
	}
	public IntegerProperty getPrixPrestationProperty() {
		return prixPrestation;
	}
	
	public String getLibellePrestation() {
		return libellePrestation.get();
	}
	public void setLibellePrestation(String libellePrestation) {
		this.libellePrestation.set(libellePrestation);
	}
	public int getPrixPrestation() {
		return prixPrestation.get();
	}
	public void setPrixPrestation(int prixPrestation) {
		this.prixPrestation.set(prixPrestation);
	}

	
	@Override
	public String toString() {
		return "TypePrestation [libellePrestation=" + libellePrestation + ", prixPrestation=" + prixPrestation + "]";
	}

	
	


}
