package com.cloud.jmc.controller;

import com.cloud.jmc.model.Game;

public class BoardController {

    private final Game game;
    
    public BoardController(Game game) {
        this.game = game;
    }
    
    public int minColumnIndex() {
        return game.minColumnIndex();
    }
    
    public int numberOfRows() {
        return game.numberOfRows();
    }
    
    public int numberOfColumns() {
        return game.numberOfColumns();
    }
    
    public char getBoxValue(int row, int column) {
        return game.getBoxValue(row, column);
    }
    
    public boolean hasLineInBoard() {
        return game.hasLineInBoard();
    }
    
    public String getCurrentPlayerMark() {
        return String.valueOf(game.getCurrentPlayerMark());
    }

}
