import java.util.Scanner;

public class Hexapawn {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number of rows: ");
	    int numRows = in.nextInt();
	    System.out.println("Enter number of columns: ");
	    int numCols = in.nextInt();
	    HexBoard board = new HexBoard(numCols, numRows);
	    GameTree tree = new GameTree(board, Marker.WHITE, null);
	    System.out.println("Enter player one type: [chr] ");
	    char playerType = in.next().charAt(0);
	    Player Alice = new ComputerPlayer("Alice", Marker.WHITE);
	    if (playerType == 'r') {
	    	Alice = new RandomPlayer("Alice", Marker.WHITE);
	    }
	    if (playerType == 'h') {
	    	Alice = new HumanPlayer("Alice", Marker.WHITE);
	    }
	    System.out.println("Enter player two type [chr] ");
	    playerType = in.next().charAt(0);
	    Player Ada = new ComputerPlayer("Ada", Marker.BLACK);
	    if (playerType == 'r') {
	    	Ada = new RandomPlayer("Ada", Marker.BLACK);
	    }
	    if (playerType == 'h') {
	    	Ada = new HumanPlayer("Ada", Marker.BLACK);
	    }
	    System.out.println("Enter number of games: ");
	    int numGames = in.nextInt();
	    int AliceWins = 0;
	    for (int i = 0; i < numGames; i++) {
	    	System.out.println("New game");
	    	if (Alice.play(tree, Ada) == Alice) {
	    		AliceWins++;
	    	}
	    }
	    System.out.println("Alice won: " + AliceWins);
	    System.out.println("Ada won: " + (numGames - AliceWins));
	    
	    
	}
}
