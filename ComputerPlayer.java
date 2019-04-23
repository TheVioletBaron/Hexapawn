import java.util.List;
import java.util.Random;

public class ComputerPlayer extends Player {
	
	static int lossCount = 0;
	
	public ComputerPlayer(String playerName, Marker playerMarker) {
		super(playerName, playerMarker);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Player play(GameTree position, Player opponent) {
		System.out.println("Computer's turn!");
		List<HexMove> moves = position.getMoves();
		Random myGen = new Random();
		if (position.getBoard().checkWin(opponent.getMarker()) || moves.size() == 0) {
			position.trim();
			System.out.println(opponent + " won");
			return opponent;
		}
		if (position.getMoves().size() == 0) {
			if (position.getBoard().checkWin(opponent.getMarker()) == false) {
				System.out.println("Computer is out of moves");
				System.out.println(lossCount);
				System.out.println(position.trimNum);
				System.exit(0);
			}
		}
        int chosenMove = myGen.nextInt(moves.size());
		GameTree nextPos = position.getChild(chosenMove);
		System.out.println(nextPos.getBoard());
		return opponent.play(nextPos, this);
	}
	

	public static void main(String args[]) {
		Player next = new ComputerPlayer("alice", Marker.WHITE);
		Player rand = new RandomPlayer("bob", Marker.BLACK);
		GameTree thisTree = new GameTree(new HexBoard(3, 3), Marker.WHITE, null);
		int playCount = 0;
		for (int i = 0; i < 10000; i++) {
			 rand.play(thisTree, next);
			 playCount++;
			 System.out.println("Played: " + playCount);
		}
		System.out.println(lossCount);
	}
}