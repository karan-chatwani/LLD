import models.Board;
import models.Game;
import models.Piece;
import models.PieceO;
import models.PieceX;
import models.Player;
import models.Symbol;

import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Board board=new Board(3);
        Piece pieceX=new PieceX();
        Piece pieceO=new PieceO();
        Player player1=new Player("1",pieceX);
        Player player2=new Player("2",pieceO);
        Deque<Player> players=new LinkedList<>();
        players.add(player1);
        players.add(player2);
        Game game=new Game(board,players);
        game.gamePlay();
        System.out.println("Hello world!");
    }
}