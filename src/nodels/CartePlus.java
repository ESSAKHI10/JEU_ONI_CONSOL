package nodels;

public class CartePlus  extends Carte{
private enumCartePlus plus;

	public CartePlus(Couleur color, enumCartePlus plus) {
	super(color);
	this.plus = plus;
	this.type=plus.toString();
}

	public enumCartePlus getPlus() {
		return plus;
	}

	public void setPlus(enumCartePlus plus) {
		this.plus = plus;
	}


}
