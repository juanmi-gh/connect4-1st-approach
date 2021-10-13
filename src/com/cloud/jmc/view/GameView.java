package com.cloud.jmc.view;

import static com.cloud.jmc.view.Message.NEW_GAME;
import static com.cloud.jmc.view.Message.TITLE;

import com.cloud.jmc.controller.Logic;
import com.cloud.jmc.utils.Console;

class GameView {
    
    private final Logic logic;
    
    public GameView(Logic logic) {
        this.logic = logic;
    }

    void resetGame() {
        Console.getInstance().writeln(TITLE.getValue());
        Console.getInstance().writeln(NEW_GAME.getValue());
        logic.resetGame();
    }

    boolean isGameOver() {
        return logic.isGameOver();
    }
    
}
