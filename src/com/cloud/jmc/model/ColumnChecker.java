package com.cloud.jmc.model;

public class ColumnChecker extends LineChecker {

    ColumnChecker(int lineSize) {
        super(lineSize);
    }

    @Override
    protected int lastIndex(Box[][] grid) {
        return grid[0].length;
    }

    @Override
    protected Box[] setUpInlineBoxes(Box[][] grid, int index) {
        
        final int rowsSize = grid.length;
        Box[] boxesRow = new Box[rowsSize];
        
        for (int i = 0; i < rowsSize; i++) {
            boxesRow[i] = grid[i][index];
        }
        
        return boxesRow;
    }

}
