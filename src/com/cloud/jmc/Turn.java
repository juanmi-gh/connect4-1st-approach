package com.cloud.jmc;

public class Turn {

    private int currentTurn = 0;
    
    public Player current(Player[] players) {
        return players[currentTurn];
    }
    
    public Player next(Player[] players) {
        currentTurn = (currentTurn + 1) % 2;
        return players[currentTurn];
    }
    
}
