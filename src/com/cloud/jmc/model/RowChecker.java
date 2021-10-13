package com.cloud.jmc.model;

public class RowChecker extends LineChecker {

    RowChecker(int lineSize) {
        super(lineSize);
    }

    @Override
    protected int lastIndex(Box[][] grid) {
        return grid.length;
    }

    @Override
    protected Box[] setUpInlineBoxes(Box[][] grid, int index) {
        return grid[index];
    }

}
