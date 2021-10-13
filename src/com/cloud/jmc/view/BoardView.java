package com.cloud.jmc.view;

import static com.cloud.jmc.view.Message.*;

import com.cloud.jmc.controller.BoardController;
import com.cloud.jmc.controller.Logic;
import com.cloud.jmc.utils.Console;

class BoardView {
    
    private static final String HEADER_INIT = "___";
    private static final String HEADER_ITEM = "_%s____";
    private static final String FOOTER_INIT = "\n--";
    private static final String FOOTER_ITEM = "------";
    
    private static final String INIT_SEPARATOR = "\n |  ";
    private static final String MID_SEPARATOR = "  |  ";
    
    private final BoardController boardController;
    
    public BoardView(Logic logic) {
        boardController = logic.getBoardController();
    }
    
    void displayBoard() {
        
        Console.getInstance().write(HEADER_INIT);
        for (int i = boardController.minColumnIndex(); i <= boardController.numberOfColumns(); i++) {
            Console.getInstance().write(HEADER_ITEM, String.valueOf(i));
        }

        for (int i = 0; i < boardController.numberOfRows(); i++) {
            Console.getInstance().write(INIT_SEPARATOR);

            for(int j = 0; j < boardController.numberOfColumns(); j++) {
                Console.getInstance().write(boardController.getBoxValue(i, j));
                Console.getInstance().write(MID_SEPARATOR);
            }

            Console.getInstance().write(FOOTER_INIT);
            for (int j = 0; j < boardController.numberOfColumns(); j++) {
                Console.getInstance().write(FOOTER_ITEM);                
            }
        }
    }

    void showResults() {
        if (boardController.hasLineInBoard()) {
            Console.getInstance().writeln(WINNER.getValue(), boardController.getCurrentPlayerMark());
        
        } else {
            Console.getInstance().writeln(TIE.getValue());
        }
    }
}
