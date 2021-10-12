package com.cloud.jmc;

public class Board {

    private static final int MIN_COLUMN_INDEX = 0;
    private static final int MAX_COLUMN_INDEX = 2;
    private static final int BOARD_SIDE = 3;
    Box[][] boxes;
    
    public Board() {
        boxes = new Box[BOARD_SIDE][BOARD_SIDE];
        for (int i = 0; i < BOARD_SIDE; i++) {
            for(int j = 0; j < BOARD_SIDE; j++) {
                boxes[i][j] = new Box();
            }
            
        }
    }
    
    public void display() {
        
        System.out.println("____0_____1_____2____");
        for (int i = 0; i < BOARD_SIDE; i++) {
            System.out.print(" |  ");
            for(int j = 0; j < BOARD_SIDE; j++) {
                System.out.print(boxes[i][j].value());
                System.out.print("  |  ");
            }
            System.out.println("\n---------------------");
        }
    }

    public boolean isUnsolved() {

        return containsBlanks() && !containsLine();
    }
    
    private boolean containsBlanks() {
        
        for (int i = 0; i < BOARD_SIDE; i++) {
            for (int j = 0; j < BOARD_SIDE; j++) {
                if (boxes[i][j].isBlank()) {
                    return true;
                }
            }
        }
        
        return false;
    }

    public boolean containsLine() {
        
        return containsRow() || containsColumn() || containsDiagonal();
    }
    
    private boolean containsRow() {
                
        for (int rowIndex = 0; rowIndex < BOARD_SIDE; rowIndex++) {
            if (isRow(boxes[rowIndex])) {
                return true;
            }
        }
        
        return false;
    }
    
    private boolean isRow(Box[] boxesRow) {
        
        Box firstBox = boxesRow[0];

        if (firstBox.isBlank()) {
            return false;
        }

        for (int i = 1; i < BOARD_SIDE; i++) {
            Box currentBox = boxesRow[i];
            if (!firstBox.equals(currentBox)) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean containsColumn() {

        for (int i = 0; i < BOARD_SIDE; i++) {
            if (isColumn(i)) {
                return true;
            }
        }
        
        return false;
    }
    
    private boolean isColumn(int columnIndex) {
        
        Box firstBox = boxes[0][columnIndex];
        
        if (firstBox.isBlank()) {
            return false;
        }
        
        for (int i = 1; i < BOARD_SIDE; i++) {
            Box currentBox = boxes[i][columnIndex];
            if (!firstBox.equals(currentBox)) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean containsDiagonal() {
        return isDiagonal() || isReverseDiagonal();
    }
    
    private boolean isDiagonal() {
        
        Box firstBox = boxes[0][0];
        if (firstBox.isBlank()) {
            return false;
        }
        
        for (int i = 1; i < BOARD_SIDE; i++) {
            Box currentBox = boxes[i][i];
            if (!firstBox.equals(currentBox)) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean isReverseDiagonal() {

        Box firstBox = boxes[0][BOARD_SIDE - 1];
        if (firstBox.isBlank()) {
            return false;
        }

        for (int i = 1, j = BOARD_SIDE - 2; i < BOARD_SIDE; i++, j--) {
            Box currentBox = boxes[i][j];
            if (!firstBox.equals(currentBox)) {
                return false;
            }
        }

        return true;
    }

    
    public boolean isValidColumn(int column) {

        for (int i = 0; i < BOARD_SIDE; i++) {
            if (boxes[i][column].isBlank()) {
                return true;
            }
        }
        return false;
    }

    public boolean addMark(int column, char mark) {
        
        if (column < MIN_COLUMN_INDEX || MAX_COLUMN_INDEX < column) {
            System.out.print(column + " is not a valid column. Try again:");
            return false;
        }
        
        for (int i = BOARD_SIDE - 1; 0 <= i; i--) {
            if (boxes[i][column].isBlank()) {
                boxes[i][column].setMark(mark);
                return true;
            }
        }
        
        System.out.print("Invalid column, already full. Try again:");
        return false;
    }
}
