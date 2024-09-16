package models;

import java.util.Deque;
import java.util.Scanner;

public class Game {
    private Board board;
    Deque<Player> players;

    public Game(Board board, Deque<Player> players) {
        this.board = board;
        this.players = players;
    }

    public void gamePlay() {
        boolean winner = false;
        while (!winner) {
            if(board.isDraw()){
                System.out.println("its draw");
                break;
            }
            Player player = players.getFirst();

            System.out.println("Enter x and y");
            Scanner scanner = new Scanner(System.in);
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if (!board.validate(x, y)) {
                System.out.println("Incorrect, please try again");
                continue;
            }
            players.removeFirst();
            players.addLast(player);
            board.addPiece(x, y, player.getPiece());
            winner=board.checkWinner(player.getPiece());
            if(winner){
                System.out.println("Player {} is winner"+player.getPlayerId());
            }
        }
    }



}
