package View;

import java.util.Scanner;

import controller.GameController;

public class View {
	GameController controller;
	Scanner keyboard = new Scanner(System.in);

	public void setController(GameController gc) {
		this.controller = gc;
	}

	public void promptNewTranch() {

		System.out.println("     **************************UNI GAME*********************");
		System.out.println("       ************************NEW TRANCHE **************");
		System.out.println("\n");
	}

	public void promptForPlayerName() {
		System.out.print("Enter Player Name: ");
		String name = keyboard.nextLine();
		if ((name.equals("q")) || controller.players.size() == 6) {
			System.out.println("end adding player");
			controller.startGame();
		} else {
			controller.addPlayer(name);
		}
	}

	public void showPlayerName(int playerIndex, String playerName) {
		System.out.println("Joueur : " + playerIndex + " : " + playerName);
	}

	public void prompteStartGame() {
		System.err.println("********************game begin***********************        ");
		controller.play();
	}

	public void menu() {
		System.out.println("                   ----------------------------------menu-------------------");
		System.out.println("                                          Piocher une carte  :  P");
		System.out
				.println("                                          Jouer une carte  :  j X (X : numero de la carte )");
		System.out.println("                   ---------------------------------------------------------------");

		if (controller.getTalon().size() != 0) {
			System.err.println("             carte TALON :"
					+ controller.getTalon().get(controller.getTalon().size() - 1).getColor() + ":"
					+ controller.getTalon().get(controller.getTalon().size() - 1).getType());
		} else {
			System.err.println("                  carte TALON : VIDE  ");
		}

	}

	public void player() {
		String move;
		System.out.print("Entrer :");
		keyboard.nextLine();
		do {
		
		System.out.print("Saisir votre choix (p/j):");
		 move = keyboard.nextLine();
		}
	while(!move.equals("p") && !move.equals("j"))	;
		
		 
//		while (move == "p" && move == "j") {

		switch (move) {
		case "p":
			controller.piocher();
			break;
		case "j":
			System.out.println("Saisir votre Carte a jouer :");

			int index = keyboard.nextInt();
			controller.jouerUneCart(index);
			break;
		default:
			System.out.println("choix incorecte");
		}

	}

	// carte jouer
	public void playerMove(int playerIndex, int indexCarte) {
		System.err.println(controller.players.get(playerIndex).getName() + " joue un  "
				+ controller.players.get(playerIndex).getCard(indexCarte).toString());
	}

	// tranche finie
	public void TrancheFini() {
		System.out.println("Tranche  Fini");
		System.out.println("calculate the score ");
		controller.calculateScore();
	}

	// game Over
	public void propteGameOver() {
		System.out.println("GAME OVER ");
		controller.afficherLEsJoueur();
	}
}
