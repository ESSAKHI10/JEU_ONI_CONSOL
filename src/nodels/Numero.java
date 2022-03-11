package nodels;

public enum Numero{
    ZERO(0),
	ONE (1),
	TWO (2),
	THREE (3),
	FOUR (4),
	FIVE (5),
	SIX (6),
	SEVEN (7),
	EIGHT (8),
	NINE (9),
	
	
	;
	
	int numero;
	
	private Numero(int value) {
		numero = value;
	}
	
	public int value() {
		return numero;
	}
}