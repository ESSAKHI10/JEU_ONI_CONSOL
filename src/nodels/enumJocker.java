package nodels;

public enum enumJocker {
	JOCKER (1),
	;
	
	int jocker;
	
	private enumJocker(int value) {
		jocker = value;
	}
	
	public int value() {
		return jocker;
	}
}
