package nodels;

import java.util.ArrayList;
import java.util.List;



public class Main {
	private List<Carte> cards;

	public List<Carte> getCards() {
		return cards;
	}

	public void setCards(List<Carte> cards) {
		this.cards = cards;
	}

	public Main() {
		cards = new ArrayList<Carte>();
	}
	
	public void addCard(Carte pc) {
		cards.add(pc);
	}
	
	public Carte getCard(int index) {
		return cards.get(index);
	}
	
	public Carte removeCard() {
		return cards.remove(0);
	}
	public Carte removeCardX(int idex) {
		return cards.remove(idex);
	}
	public void afficher() {
		for (int i = 0 ;i <cards.size() ;i++) {
			System.out.println(cards.get(i).color + " : " +cards.get(i).type + ": X = "+i);
		}
		
	}
}

	
