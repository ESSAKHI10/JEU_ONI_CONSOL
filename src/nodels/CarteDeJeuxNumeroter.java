package nodels;

public class CarteDeJeuxNumeroter extends Carte {
	 
	 private Numero cart ;
	public CarteDeJeuxNumeroter(Couleur color, Numero cart) {
		super(color);
		this.color = color;
		this.cart = cart;
		this.type = cart.toString();
	}
	public Couleur getColor() {
		return color;
	}
	public Numero getCart() {
		return cart;
	}
	public void setColor(Couleur color) {
		this.color = color;
	}
	public void setCart(Numero cart) {
		this.cart = cart;
	}
	 
	 
}
