package nodels;

public class Joueur {
	private String name;
	private Main main;
	private int Score;

	public int getScore() {
		return Score;
	}

	public void setScore(int score) {
		Score = score;
	}

	public Joueur(String name) {
		this.name = name;
		main = new Main();
	}

	public Main getMain() {
		return main;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public Carte getCard(int index) {
		return main.getCard(index);
	}

	public Carte removeCard() {
		return main.removeCard();
	}

	public String getName() {
		return name;
	}

	public void addCardToHand(Carte pc) {
		main.addCard(pc);
	}

	public void calculeScore() {
		for (int i = 0; i < this.main.getCards().size(); i++) {
			switch (this.main.getCard(i).getType()) {
			case "ZERO":
				setScore(getScore() + 0);
				break;
			case "ONE":
				setScore(getScore() + 1);
				break;
			case "TWO":
				setScore(getScore() + 2);
				break;
			case "THREE":
				setScore(getScore() + 3);
				break;
			case "FOOR":
				setScore(getScore() + 4);
				break;
			case "FIVE":
				setScore(getScore() + 5);
				break;
			case "SIX":
				setScore(getScore() + 6);
				break;
			case "SEVEN":
				setScore(getScore() + 7);
				break;
			case "EIGHT":
				setScore(getScore() + 8);
				break;
			case "NINE":
				setScore(getScore() + 9);
				break;
			case "PlusDeux":
				setScore(getScore() + 20);
				break;
			case "CHANGEMENTSENS":
				setScore(getScore() + 20);
				break;

			case "PASSTOUR":
				setScore(getScore() + 20);
				break;
			case "JOCKER":
				setScore(getScore() + 50);
				break;
			case "PlusQatre":
				setScore(getScore() + 50);
				break;
			case "UNO":
				setScore(getScore() + 50);
				break;
			}
		}
		System.out.println( "joueur : "+this.getName()+" score : " +this.getScore() );
	}

}
