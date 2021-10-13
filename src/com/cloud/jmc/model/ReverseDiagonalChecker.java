package com.cloud.jmc.model;

public class ReverseDiagonalChecker extends LineChecker {

    ReverseDiagonalChecker(int lineSize) {
        super(lineSize);
    }

    @Override
    protected int lastIndex(Box[][] grid) {
        return grid[0].length - super.lineSize;
    }

    @Override
    protected Box[] setUpInlineBoxes(Box[][] grid, int index) {
        
        
        final int rowSize = grid.length;
        final int columnSize = grid[0].length;
        final int diagonalSize = Math.min(columnSize - index, rowSize);
        Box[] boxesDiagonal = new Box[diagonalSize];
                
        for (int i = 0; i < diagonalSize; i++, index++) {
            boxesDiagonal[i] = grid[i][index];
        }
        
        return boxesDiagonal;
    }

}