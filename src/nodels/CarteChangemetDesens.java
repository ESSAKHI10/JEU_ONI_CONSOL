package nodels;

public class CarteChangemetDesens extends Carte{
private CarteChangementSens changementDesens;


	public CarteChangemetDesens(Couleur color, CarteChangementSens changementDesens) {
	super(color);
	this.changementDesens = changementDesens;
	this.type =  changementDesens.toString();
	 
}


	public CarteChangementSens getChangementDesens() {
	return changementDesens;
}


public void setChangementDesens(CarteChangementSens changementDesens) {
	this.changementDesens = changementDesens;
}


	public CarteChangemetDesens(Couleur color) {
		super(color);
		// TODO Auto-generated constructor stub
	}

}
