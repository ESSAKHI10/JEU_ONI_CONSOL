package nodelsmain;

 
import View.View;
import controller.GameController;
import nodels.Deck;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		controller.GameController gc = new GameController(new Deck(), new View());
		gc.run();
	}

}
