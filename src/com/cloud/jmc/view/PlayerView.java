package com.cloud.jmc.view;

import static com.cloud.jmc.view.Message.*;

import com.cloud.jmc.model.Game;
import com.cloud.jmc.utils.Console;

class PlayerView {

    private final Game game;
    
    public PlayerView(Game game) {
        this.game = game;
    }
    
    void makePlay() {
                
        final char currentPlayerMark = game.nextPlayer();
        Console.getInstance().writeln(PLAYER_TURN.getValue(), String.valueOf(currentPlayerMark));
        
        final int selectedColumn = selectColumn();
        game.move(currentPlayerMark, selectedColumn);
    }
    
    private int selectColumn() {
        
        int column;
        boolean isValidColumn;
        
        do {
            isValidColumn = true;
            column = Console.getInstance().readInt(PICK_COLUMN.getValue());
            
            if (game.isOutOfIndexes(column) || game.isAlreadyFull(column)) {
                Console.getInstance().write(WRONG_COLUMN.getValue(), String.valueOf(column));
                isValidColumn = false;
            }
            
        } while(!isValidColumn);
        
        return column;
    }

}
