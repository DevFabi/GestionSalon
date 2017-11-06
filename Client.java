package bean;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Client {

	private StringProperty nomClient;
	private StringProperty prenomClient;
	private IntegerProperty ageClient;
	private StringProperty emailClient;
	private BooleanProperty myCheck;

	public BooleanProperty getMyCheckProperty() {
		return myCheck;
	}
	public boolean getMyCheck() {
		return myCheck.get();
	}

	public void setMyCheck(BooleanProperty myCheck) {
		this.myCheck = myCheck;
	}
	public void setMyCheck(Boolean myCheck) {
		this.myCheck.set( myCheck);;
	}
	public Client() {
		this.nomClient = new SimpleStringProperty();
		this.prenomClient = new SimpleStringProperty();
		this.ageClient = new SimpleIntegerProperty();
		this.emailClient = new SimpleStringProperty();
		this.myCheck = new SimpleBooleanProperty(false);
	}

	public StringProperty getNomClientProperty() {
		return nomClient;
	}

	public void setNomClient(StringProperty nomClient) {
		this.nomClient = nomClient;
	}

	public StringProperty getPrenomClientProperty() {
		return prenomClient;
	}

	public void setPrenomClient(StringProperty prenomClient) {
		this.prenomClient = prenomClient;
	}

	public IntegerProperty getAgeClientProperty() {
		return ageClient;
	}

	public void setAgeClient(IntegerProperty ageClient) {
		this.ageClient = ageClient;
	}

	public StringProperty getEmailClientProperty() {
		return emailClient;
	}

	public void setEmailClient(StringProperty emailClient) {
		this.emailClient = emailClient;
	}
	
    public String getNomClient() {
        return nomClient.get();
    }

    public void setNomClient(String nomClient) {
        this.nomClient.set(nomClient);
    }
    
    public String getPrenomClient() {
    	return prenomClient.get();
    }
    public void setPrenomClient(String prenomClient) {
        this.prenomClient.set(prenomClient);
    }
    
    public String getEmailClient() {
    	return emailClient.get();
    }
    public void setEmailClient(String emailClient) {
        this.emailClient.set(emailClient);
    }
	public int getAgeClient() {
        return ageClient.get();
    }

    public void setAgeClient(int ageClient) {
        this.ageClient.set(ageClient);
    }
	@Override
	public String toString() {
		return "Client [nomClient=" + nomClient + ", prenomClient=" + prenomClient + ", ageClient=" + ageClient
				+ ", emailClient=" + emailClient + "]";
	}








	

}
