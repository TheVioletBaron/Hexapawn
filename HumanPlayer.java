import java.util.List;
import java.util.Scanner;

public class HumanPlayer extends Player{
	
	public HumanPlayer(String playerName, Marker playerMarker) {
		super(playerName, playerMarker);
	}
	@Override
	public Player play(GameTree position, Player opponent) {
			Scanner in = new Scanner(System.in);
			System.out.println(position.getBoard());
			System.out.println("Your turn!");
			List<HexMove> moves = position.getMoves();
			if (moves.isEmpty()) {
				return opponent;
			}
			int moveNum = 0;
	        for (HexMove move : moves) {
	            System.out.println(move + ". Move from " + move);
	            moveNum++;
	        }
	        int chosenMove;
	        do {
		          System.out.print("Enter your move choice: ");
		          chosenMove = in.nextInt();
		    } while (chosenMove < 0 || chosenMove >= moves.size());
			GameTree nextPos = position.getChild(chosenMove);
			System.out.println(nextPos.getBoard());
			return opponent.play(nextPos, this);
	}
	
	public static void main(String args[]) {
		Player next = new HumanPlayer("alice", Marker.WHITE);
		next.play(new GameTree(new HexBoard(3, 3), Marker.WHITE, null), next) ;
	}
}
