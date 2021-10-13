package com.cloud.jmc.view;

import static com.cloud.jmc.view.Message.*;

import com.cloud.jmc.model.Game;
import com.cloud.jmc.utils.Console;

class BoardView {
    
    private static final String HEADER_INIT = "___";
    private static final String HEADER_ITEM = "_%s____";
    private static final String FOOTER_INIT = "\n--";
    private static final String FOOTER_ITEM = "------";
    
    private static final String INIT_SEPARATOR = "\n |  ";
    private static final String MID_SEPARATOR = "  |  ";
    
    private final Game game;
    
    public BoardView(Game game) {
        this.game = game;
    }

    void displayBoard() {
        
        Console.getInstance().write(HEADER_INIT);
        for (int i = game.minColumnIndex(); i <= game.numberOfColumns(); i++) {
            Console.getInstance().write(HEADER_ITEM, String.valueOf(i));
        }

        for (int i = 0; i < game.numberOfRows(); i++) {
            Console.getInstance().write(INIT_SEPARATOR);

            for(int j = 0; j < game.numberOfColumns(); j++) {
                Console.getInstance().write(game.getBoxValue(i, j));
                Console.getInstance().write(MID_SEPARATOR);
            }

            Console.getInstance().write(FOOTER_INIT);
            for (int j = 0; j < game.numberOfColumns(); j++) {
                Console.getInstance().write(FOOTER_ITEM);                
            }
        }
    }

    void showResults() {
        if (game.hasLineInBoard()) {
            Console.getInstance().writeln(WINNER.getValue(), String.valueOf(game.getCurrentPlayerMark()));
        
        } else {
            Console.getInstance().writeln(TIE.getValue());
        }
    }
}
