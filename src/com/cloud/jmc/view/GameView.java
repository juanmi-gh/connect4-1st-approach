package com.cloud.jmc.view;

import com.cloud.jmc.model.Game;

class GameView {

    private final Game game;
    
    public GameView(Game game) {
        this.game = game;
    }
    
    void resetGame() {
        game.reset();
    }

    boolean isGameOver() {
        return game.isOver();
    }
    
}
