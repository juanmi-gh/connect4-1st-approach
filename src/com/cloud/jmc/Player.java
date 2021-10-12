package com.cloud.jmc;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Player {
    
    private Mark mark;
    
    public Player(Mark mark) {
        this.mark = mark;
    }

    public void move(Board board) {

        System.out.println("Turn for player " + mark);
        System.out.print("Enter your move [0-2]: ");
      
        boolean isValidMove = false;
        do {
            int selectedColumn = selectColumn();
            isValidMove = board.addMark(selectedColumn, mark.value);
            
        } while(!isValidMove);
    }
    
    public Mark mark() {
        return mark;
    }
    
    private int selectColumn() {
        try {
            Scanner scanner = new Scanner(System.in);
            return scanner.nextInt();
            
        } catch (NoSuchElementException e) {
            System.out.println("Invalid input. Enter a number [0-2]. Try again: ");            
            return selectColumn();
        }
    }
}
