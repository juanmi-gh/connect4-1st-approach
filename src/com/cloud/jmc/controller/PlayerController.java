package com.cloud.jmc.controller;

import com.cloud.jmc.model.Game;

public class PlayerController {

    private final Game game;

    public PlayerController(Game game) {
        this.game = game;
    }
        
    public char nextPlayer() {
        return game.nextPlayer();
    }
    
    public void move(char mark, int column) {
        game.move(mark, column);
    }
    
    public boolean isInvalidColumn(int column) {
        return game.isOutOfIndexes(column) || game.isAlreadyFull(column);
    }
}
