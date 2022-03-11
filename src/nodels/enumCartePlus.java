package nodels;

public enum enumCartePlus {
	PlusDeux(2),
	PlusQatre(5);

	int plus;

	
	public int value() {
		return plus;
	}
	private enumCartePlus(int value) {
		plus = value;
	}
}
