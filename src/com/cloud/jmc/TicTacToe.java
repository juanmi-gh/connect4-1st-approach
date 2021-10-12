package com.cloud.jmc;

import static com.cloud.jmc.Mark.*;

public class TicTacToe {
    
    Player[] players;
    Board board;
    Turn turn;
    
    public static void main(String[] args) {

        System.out.println("New Game created!");
        new TicTacToe().play();
    }
    
    public TicTacToe() {
        players = new Player[] {new Player(O_MARK), new Player(X_MARK)};
        board = new Board();
        turn = new Turn();
    }

    public void play() {

        do {
            board.display();
            Player currentPlayer = turn.next(players);
            currentPlayer.move(board);

        } while(board.isUnsolved());

        finishGame();
    }

    private void finishGame() {
        
        board.display();
        
        if (board.containsLine()) {
            System.out.println("Player " + turn.current(players).mark() + " WINS!");            
        
        } else {
            System.out.println("TIE! No more moves available.");
        }       
    }
}
