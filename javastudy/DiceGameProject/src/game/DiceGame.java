package game;

public class DiceGame {

	private Player[] players;
	private int idx;
	
	public DiceGame(int count) {
		players = new Player[count];
	}
	
	public void join(Player player) {
		if(idx == players.length) {
			System.out.println("더 이상 참여할 수 없습니다.");
			return;
		}
		players[idx++] = player;
	}
	
	
	
	
	
	
	
	
	
}
