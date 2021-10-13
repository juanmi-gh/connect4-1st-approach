package com.cloud.jmc.view;

import static com.cloud.jmc.view.Message.*;

import com.cloud.jmc.model.Game;
import com.cloud.jmc.utils.Console;

public class View {

    private final BoardView boardView;
    private final GameView gameView;
    private final PlayerView playerView;

    public View(Game game) {
        boardView = new BoardView(game);
        gameView = new GameView(game);
        playerView = new PlayerView(game);
    }

    public void playGame() {

        Console.getInstance().writeln(TITLE.getValue());
        Console.getInstance().writeln(NEW_GAME.getValue());
        gameView.resetGame();

        do {
            boardView.displayBoard();
            playerView.makePlay();
        } while(!gameView.isGameOver());

        boardView.displayBoard();
        boardView.showResults();
    }

    public boolean keepsPlaying() {
        
        String response = Console.getInstance().readString(PLAY_AGAIN.getValue());

        return "Y".equalsIgnoreCase(response);
    }

    public void close() {
        Console.getInstance().writeln(FAREWELL.getValue());
    } 

}
