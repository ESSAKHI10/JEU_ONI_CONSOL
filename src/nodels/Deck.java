package nodels;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
	private List<Carte> cards;

	public Deck() {
		cards = new ArrayList<Carte>();
		int k = 1;
		// 18 carte de chaque couleur
		for (int i = 0; i < 2; i++) {

			for (Couleur color : Couleur.values()) {
				// 18 carte de chaque couleur
				for (Numero cart : Numero.values()) {
					if (color.value() != 5 && cart.numero != 0) {
						// System.out.println("Creating card [" + color + "][" + cart + "]" + k);
						cards.add(new CarteDeJeuxNumeroter(color, cart));
						k++;
					}

				}
				// add les carte pass de tours
				for (PassTour passtour : PassTour.values()) {
					if (color.value() != 5) {
						// System.out.println("Creating card [" + color + "][" + passtour + "]" + k);

						cards.add(new PasseTour(color, passtour));
						k++;
					}
				}
				// les cartes changemet des sens
				for (CarteChangementSens changer : CarteChangementSens.values()) {
					if (color.value() != 5) {
						// System.out.println("Creating card [" + color + "][" + changer + "]" + k);

						cards.add(new CarteChangemetDesens(color, changer));
						k++;
					}
				}
				// les catre deux plus

				if (color.value() != 5) {
					// System.out.println("Creating card [" + color + "][" + enumCartePlus.PlusDeux
					// + "]" + k);

					cards.add(new CartePlus(color, enumCartePlus.PlusDeux));
					k++;
				}

			}

		}
		// les quatres jocker
		for (int i1 = 0; i1 < 4; i1++) {
			// System.out.println("carte jokcer"+k);
			cards.add(new CarteJocker());
			k++;
		}

		// les carte UNO
		for (int i1 = 0; i1 < 4; i1++) {
			// System.out.println("carte UNO"+k);
			cards.add(new CartUno());
			k++;
		}

		for (int i1 = 0; i1 < 4; i1++) {
			// System.out.println("carte ZERO"+k);
			cards.add(new CarteDeJeuxNumeroter(Couleur.NOIRE, Numero.ZERO));
			k++;
		}
		// qutre carte plus 4
		for (int i1 = 0; i1 < 4; i1++) {
			// System.out.println("carte +4 "+k);

			cards.add(new CartePlus(Couleur.NOIRE, enumCartePlus.PlusQatre));
			k++;
		}
		shuffle();
		
	}

	public void shuffle() {
		Random random = new Random();
		for (int i = 0; i < cards.size(); ++i) {
			Collections.swap(cards, i, random.nextInt(cards.size()));
		}
	}

	public Carte removeTopCard() {
		return cards.remove(0);
	}

	public void afficherLesCarte() {
		for (Carte carte : cards) {
			System.out.println(carte);
		}
	}

	public List<Carte> getCards() {
		return cards;
	}

	public void setCards(List<Carte> cards) {
		this.cards = cards;
	}

}
