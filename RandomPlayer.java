import java.util.List;
import java.util.Random;

public class RandomPlayer extends Player{

	public RandomPlayer(String playerName, Marker playerMarker) {
		super(playerName, playerMarker);
	}

	@Override
	public Player play(GameTree position, Player opponent) {
		System.out.println("Random's turn!");
		List<HexMove> moves = position.getMoves();
		Random myGen = new Random();
		if (moves.isEmpty()) {
			System.out.println(opponent + " won");
			return opponent;
		}
        int chosenMove = myGen.nextInt(moves.size());
		GameTree nextPos = position.getChild(chosenMove);
		System.out.println(nextPos.getBoard());
		return opponent.play(nextPos, this);
	}
	
	public static void main(String args[]) {
		Player next = new RandomPlayer("alice", Marker.WHITE);
		next.play(new GameTree(new HexBoard(3, 3), Marker.WHITE, null), next) ;
	}
}