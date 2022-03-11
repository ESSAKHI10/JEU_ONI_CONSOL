package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import View.View;
import nodels.Carte;
import nodels.CarteChangemetDesens;
import nodels.Deck;
import nodels.Joueur;

public class GameController {

	enum GameState {
		AddingPlayers, Playe, gameOver, WinnerRevealed;
	}

	Deck deck;
	public List<Joueur> players;
	View view;
	GameState gameState;
	boolean gamesOver = false;
	int playerNumber;
	List<Carte> talon;
	boolean changeSense = false;
	boolean trancheFinie = false;

	public List<Carte> getTalon() {
		return talon;
	}

	public void setTalon(List<Carte> talon) {
		this.talon = talon;
	}

	public List<Joueur> getPlayers() {
		return players;
	}

	public void setPlayers(List<Joueur> players) {
		this.players = players;
	}

	public GameController(Deck deck, View view) {
		super();
		this.deck = deck;
		this.view = view;
		this.players = new ArrayList<Joueur>();
		this.gameState = GameState.AddingPlayers;
		this.playerNumber = 0;
		this.talon = new ArrayList<Carte>();
		this.changeSense = false;
		view.setController(this);
	}

	public void run() {
		
		 
		switch (gameState) {
		case AddingPlayers:
			view.promptNewTranch();
			view.promptForPlayerName();
			break;
		case Playe:
			view.prompteStartGame();
			break;
		case gameOver:
			view.TrancheFini();
			break;
		}

	}

//ajouter les joureur et associer 6 cart a chaque joueur 
	public void addPlayer(String playerName) {

		if (gameState == GameState.AddingPlayers) {
			if (players.size() < 6) {
				players.add(new Joueur(playerName));
				view.showPlayerName(players.size(), playerName);
				System.out.println("pour finir l'addition des joueur cliquer sur /q");
			}

		}
		view.promptForPlayerName();
	}
	// change le senes de jeu

	public void ChnageSenseDeJeux() {
		Collections.reverse(players);
		playerNumber = Math.abs(players.size() - playerNumber);
	}

	public void startGame() {
		if (gameState != GameState.gameOver) {
			deck.shuffle();

			// donner 6 carte pour chaque joueur
			for (Joueur player : players) {

				for (int i = 0; i < 6; i++) {
					player.addCardToHand(deck.removeTopCard());
				}
			}

			gameState = GameState.Playe;
		}
		this.run();
	}

	public void play() {
		if (players.get(playerNumber).getMain().getCards().size() == 0) {
			gameState = GameState.gameOver;
			this.run();
			return;
		}
		while (gameState != GameState.gameOver) {
			NextPlayer();
			view.menu();
			view.showPlayerName(playerNumber + 1, players.get(playerNumber).getName());
			players.get(playerNumber).getMain().afficher();
			view.player();
			playerNumber++;
		}
	}

	public void NextPlayer() {
		if (playerNumber == players.size()) {
			playerNumber = 0;
		}
	}

	public void piocher() {
		System.out.println(players.get(playerNumber).getName() + " pioche une carte ");
		players.get(playerNumber).addCardToHand(deck.removeTopCard());
	}

	public void jouerUneCart(int index) {

		if (talon.size() == 0) {
			view.playerMove(playerNumber, index);
			addCardToTalon(players.get(playerNumber).getMain().removeCardX(index));
			// verification de la carte jouer
			NatureCarteJOuer(index);

		} else {
			// verifier si la carte choise est correspondans au cart de talon
			if (talon.get(talon.size() - 1).getColor() == players.get(playerNumber).getCard(index).getColor()
					|| talon.get(talon.size() - 1).getType() == players.get(playerNumber).getCard(index).getType()) {
				// verification de la carte jouer
				NatureCarteJOuer(index);

				view.playerMove(playerNumber, index);
				addCardToTalon(players.get(playerNumber).getMain().removeCardX(index));
			} else {
				view.player();
			}
		}
	}

	public void NatureCarteJOuer(int index) {
		// si la cart est de type plus deux (a tster)
		carteDutypePlusDeux(index);
		// verifier la carte si une carte de chamger la sens de jeux (a tester) :
		CarteChangerDeSense(index);
		// PASSER LE TOUR (a tester)
		cartePasserTours(index);

	}

	// PASSER LE TOUR (a tester)
	public void cartePasserTours(int index) {

		if (players.get(playerNumber).getCard(index).getType() == "PASSTOUR") {
			System.out.println("Passer le  tour ");
			System.out.println("PASSER LE TOUR ");
			NextPlayer();
			playerNumber++;
			playerNumber++;
		}
	}

	public void CarteChangerDeSense(int index) {
		// verifier la carte si une carte de chamger la sens de jeux (a tester) :

		if (players.get(playerNumber).getCard(index).getType() == "CHANGEMENTSENS") {

			System.out.println("CHANGER LE SENSE DE JEUX");
			ChnageSenseDeJeux();
			afficherLEsJoueur();
		}
	}

	// carte plus deux
	public void carteDutypePlusDeux(int index) {
		if (players.get(playerNumber).getCard(index).getType() == "PlusDeux") {
			System.out.println("plus deux ;-)  :*) ");
			if (playerNumber == players.size()) {
				players.get(0).addCardToHand(deck.removeTopCard());
				players.get(0).addCardToHand(deck.removeTopCard());
			} else {
				players.get(playerNumber + 1).addCardToHand(deck.removeTopCard());
				players.get(playerNumber + 1).addCardToHand(deck.removeTopCard());
			}

		}
	}

	public void addCardToTalon(Carte pc) {
		talon.add(pc);
	}

	public void calculateScore() {
		for (Joueur pl : players) {
			pl.calculeScore();

		}
		for (Joueur pl : players) {

			if (pl.getScore() == 500) {
				view.propteGameOver();
				return;
			}
		}
	}

	public void afficherLEsJoueur() {
		System.out.println("List Player : ");
		for (Joueur jour : players) {
			System.out.println(jour.getName() + " : " + jour.getScore());
		}
	}

}
