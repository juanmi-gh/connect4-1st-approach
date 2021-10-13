package com.cloud.jmc;

import com.cloud.jmc.model.Game;
import com.cloud.jmc.view.View;

public class TicTacToe {
    
    private final View view;
    
    public static void main(String[] args) {

        new TicTacToe().play();
    }
    
    public TicTacToe() {
        view = new View(new Game());
    }

    private void play() {
        
        do {
            view.playGame();

        } while(view.keepsPlaying());

        view.close();
    }
    

}
