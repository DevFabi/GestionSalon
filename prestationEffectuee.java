package bean;

public class prestationEffectuee {

	private Client client;
	private Coiffeur coiffeur;
	private Prestations prestations;
	
	public prestationEffectuee(Client client, Coiffeur coiffeur, Prestations prestations) {
		super();
		this.client = client;
		this.coiffeur = coiffeur;
		this.prestations = prestations;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Coiffeur getCoiffeur() {
		return coiffeur;
	}

	public void setCoiffeur(Coiffeur coiffeur) {
		this.coiffeur = coiffeur;
	}

	public Prestations getPrestations() {
		return prestations;
	}

	public void setPrestations(Prestations prestations) {
		this.prestations = prestations;
	}
	
	
}
