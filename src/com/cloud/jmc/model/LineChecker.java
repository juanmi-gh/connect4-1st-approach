package com.cloud.jmc.model;

public abstract class LineChecker {

    protected final int lineSize;
    
    protected abstract int lastIndex(Box[][] grid);
    
    protected abstract Box[] setUpInlineBoxes(Box[][] grid, int index);
    
    LineChecker(int lineSize) {
        this.lineSize = lineSize;
    }
    
    protected boolean containsLine(Box[][] grid) {
        
        final int lastIndex = lastIndex(grid);
        
        for (int i = 0; i < lastIndex; i++) {
            Box[] boxes = setUpInlineBoxes(grid, i);
            if (isConnect4(boxes)) {
                return true;
            }
        }
        
        return false;
    }
        
    private boolean isConnect4(Box[] grid) {
        
        final int maxIndex = grid.length - lineSize;
        for (int i = 0; i <= maxIndex; i++) {
            if (areConnected(grid, i)) {
                return true;
            }
        }
        
        return false;
    }
    
    private boolean areConnected(Box[] boxesRow, int init) {

        for (int j = 0; j < lineSize - 1; j++) {
            if (boxesRow[init+j].isBlank() || !boxesRow[init+j].equals(boxesRow[init+j+1])) {
                return false;
            }
        }
        return true;
    }

}
