package com.cloud.jmc.view;

import static com.cloud.jmc.view.Message.*;

import com.cloud.jmc.controller.Logic;
import com.cloud.jmc.utils.Console;

public class View {

    private final BoardView boardView;
    private final GameView gameView;
    private final PlayerView playerView;

    public View(Logic logic) {
        boardView = new BoardView(logic);
        gameView = new GameView(logic);
        playerView = new PlayerView(logic);
    }

    public void playGame() {

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
