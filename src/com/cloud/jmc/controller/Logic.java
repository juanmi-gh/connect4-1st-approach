package com.cloud.jmc.controller;

import com.cloud.jmc.model.Game;

public class Logic {

    private final Game game;
    private final BoardController boardController;
    private final PlayerController playerController;
    
    
    public Logic() {
        this.game = new Game();
        this.boardController = new BoardController(game);
        this.playerController = new PlayerController(game);
    }
    
    public BoardController getBoardController() {
        return boardController;
    }
    
    public PlayerController getPlayerController() {
        return playerController;
    }
    
    public void resetGame() {
        game.reset();
    }
    
    public boolean isGameOver() {
        return game.isOver();
    }

}
