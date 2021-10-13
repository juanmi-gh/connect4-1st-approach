package com.cloud.jmc.model;

class Player {
    
    private static final int NUMBER_OF_PLAYERS = Mark.values().length;
    
    private Mark mark;
    
    static Player[] createPlayers() {
        Player[] players = new Player[NUMBER_OF_PLAYERS];
        
        for (Mark mark : Mark.values()) {
            players[mark.ordinal()] = new Player(mark);
        }
        
        return players;
    }
    
    private Player(Mark mark) {
        this.mark = mark;
    }

    char getMarkValue() {
        return mark.value;
    }    

}
