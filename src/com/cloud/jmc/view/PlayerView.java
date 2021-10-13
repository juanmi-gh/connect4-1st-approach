package com.cloud.jmc.view;

import static com.cloud.jmc.view.Message.*;

import com.cloud.jmc.controller.Logic;
import com.cloud.jmc.controller.PlayerController;
import com.cloud.jmc.utils.Console;

class PlayerView {
    
    private final PlayerController playerController;
    
    public PlayerView(Logic logic) {
        this.playerController = logic.getPlayerController();
    }

    void makePlay() {
                
        final char currentPlayerMark = playerController.nextPlayer();
        Console.getInstance().writeln(PLAYER_TURN.getValue(), String.valueOf(currentPlayerMark));
        final int selectedColumn = selectColumn();
        
        playerController.move(currentPlayerMark, selectedColumn);
    }
    
    private int selectColumn() {
        
        int column;
        boolean isValidColumn;
        
        do {
            isValidColumn = true;
            column = Console.getInstance().readInt(PICK_COLUMN.getValue());
            
            if (playerController.isInvalidColumn(column)) {
                Console.getInstance().write(WRONG_COLUMN.getValue(), String.valueOf(column));
                isValidColumn = false;
            }
            
        } while(!isValidColumn);
        
        return column;
    }

}
