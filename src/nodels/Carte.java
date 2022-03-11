package nodels;

public abstract class Carte {
protected Couleur color;
protected String type;

public Carte() {
	super();
}


public Carte(Couleur color) {
	super();
	this.color = color;
}
 

public Couleur getColor() {
	return color;
}

public void setColor(Couleur color) {
	this.color = color;
}


public String getType() {
	return type;
}


public void setType(String type) {
	this.type = type;
}


@Override
public String toString() {
	return "Carte [color=" + color + ", type=" + type + "]";
}




}
