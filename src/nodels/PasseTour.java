package nodels;

public class PasseTour extends Carte{
 private PassTour passtour;
	public PasseTour(Couleur color, PassTour passtour) {
	super(color);
	this.passtour = passtour;
	this.type= passtour.toString();
}
	public PassTour getPasstour() {
	return passtour;
}
public void setPasstour(PassTour passtour) {
	this.passtour = passtour;
}
	public PasseTour(Couleur color) {
		super(color);
		// TODO Auto-generated constructor stub
	}

}
