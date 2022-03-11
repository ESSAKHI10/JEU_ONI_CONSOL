package nodels;

public enum Couleur   {
	BLEU(1), ROUGE(2), JAUNE(3), VERTE(4),NOIRE (5);

	int couleur;

	private Couleur(int value) {
		couleur = value;
	}

	public int value() {
		return couleur;
	}
}

