package com.cloud.jmc.model;

class Board {

    static final int MIN_COLUMN_INDEX = 1;
    static final int ROWS_SIZE = 6;
    static final int COLUMNS_SIZE = 7;
    private static final int LINE_SIZE = 4;

    private Box[][] boxes;
    private RowChecker rowChecker;
    private ColumnChecker columnChecker;
    private DiagonalChecker diagonalChecker;
    private ReverseDiagonalChecker reverseDiagonalChecker;
    
    Board() {
        
        rowChecker = new RowChecker(LINE_SIZE);
        columnChecker = new ColumnChecker(LINE_SIZE);
        diagonalChecker = new DiagonalChecker(LINE_SIZE);
        reverseDiagonalChecker = new ReverseDiagonalChecker(LINE_SIZE);
        
        boxes = new Box[ROWS_SIZE][COLUMNS_SIZE];
        for (int i = 0; i < ROWS_SIZE; i++) {
            for(int j = 0; j < COLUMNS_SIZE; j++) {
                boxes[i][j] = new Box();
            }
        }
    }

    char getBoxValue(int row, int column) {
        return boxes[row][column].getMark();
    }

    boolean isOutOfIndexes(int column) {
        return column < MIN_COLUMN_INDEX || COLUMNS_SIZE < column;
    }
    
    boolean hasSpaces(int column) {

        final int columnIndex = column - MIN_COLUMN_INDEX;
        
        for (int i = 0; i < ROWS_SIZE; i++) {
            if (boxes[i][columnIndex].isBlank()) {
                return true;
            }
        }
        return false;
    }

    void addMark(int column, char mark) {
                
        final int columnIndex = column - MIN_COLUMN_INDEX;

        for (int i = ROWS_SIZE - 1; 0 <= i; i--) {
            
            if (boxes[i][columnIndex].isBlank()) {
                boxes[i][columnIndex].setMark(mark);
                return;
            }
        }
    }
    
    boolean isSolved() {

        return !containsBlanks() || containsLine();
    }
    
    private boolean containsBlanks() {
        
        for (int i = 0; i < ROWS_SIZE; i++) {
            for (int j = 0; j < COLUMNS_SIZE; j++) {
                if (boxes[i][j].isBlank()) {
                    return true;
                }
            }
        }
        
        return false;
    }

    boolean containsLine() {
        
        return rowChecker.containsLine(boxes) ||
                columnChecker.containsLine(boxes) || 
                diagonalChecker.containsLine(boxes) ||
                reverseDiagonalChecker.containsLine(boxes);
    }
        
    
}
