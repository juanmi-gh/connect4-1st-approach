package com.cloud.jmc.model;

public class Game {
    
    private Board board;
    private Turn turn;
    
    public Game() {
        board = new Board();
        turn = new Turn();
    }
    
    public void reset() {
        if (board.isSolved()) {
            board = new Board();
            turn = new Turn();
        }
    }
    
    public int minColumnIndex() {
        return Board.MIN_COLUMN_INDEX;
    }
    
    public int numberOfRows() {
        return Board.ROWS_SIZE;
    }
        
    public int numberOfColumns() {
        return Board.COLUMNS_SIZE;
    }
    
    public boolean isOutOfIndexes(int columnIndex) {
        return board.isOutOfIndexes(columnIndex);
    }
    
    public boolean isAlreadyFull(int columnIndex) {
        return !board.hasSpaces(columnIndex);
    }
    
    public char getBoxValue(int row, int column) {
        return board.getBoxValue(row, column);
    }
    
    public void move(char mark, int column) {
        board.addMark(column, mark);    
    }
    
    public boolean isOver() {
        return board.isSolved();
    }
    
    public boolean hasLineInBoard() {
        return board.containsLine();
    }

    public char getCurrentPlayerMark() {
        return turn.currentPlayer();
    }
    
    public char nextPlayer() {
        return turn.nextPlayer();
    }

}
