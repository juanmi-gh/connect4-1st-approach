package com.cloud.jmc.model;

import java.util.Random;

class Turn {
    
    private Player[] players;
    private int currentTurn;
    
    public Turn() {
        
        players = Player.createPlayers();
        currentTurn = new Random().nextInt(players.length);
    }
    
    public char currentPlayer() {
        return players[currentTurn].getMarkValue();
    }
    
    public char nextPlayer() {
        currentTurn = (currentTurn + 1) % players.length;
        return players[currentTurn].getMarkValue();
    }
    
}
