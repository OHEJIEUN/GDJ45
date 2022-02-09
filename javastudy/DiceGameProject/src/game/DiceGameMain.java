package game;

public class DiceGameMain {

	public static void main(String[] args) {
		
		DiceGame game = new DiceGame(3);
		
		game.join(new Player("호랑이"));
		game.join(new Player("코뿔소"));
		game.join(new Player("도마뱀"));
		
		game.play();

	}

}
