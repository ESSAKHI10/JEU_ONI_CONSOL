package nodels;

public class CarteJocker extends Carte{
private enumJocker jocker= enumJocker.JOCKER;

	public CarteJocker() {
		this.color=Couleur.NOIRE;
		// System.out.println(this.color +" " +this.jocker);
		 this.type= jocker.toString();
	}

	public CarteJocker(Couleur color) {
		super(color);
	}

	public enumJocker getJocker() {
		return jocker;
	}

	 

	 
}
