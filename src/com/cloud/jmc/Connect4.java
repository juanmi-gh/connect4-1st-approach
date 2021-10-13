package com.cloud.jmc;

import com.cloud.jmc.controller.Logic;
import com.cloud.jmc.view.View;

public abstract class Connect4 {

    private final Logic logic;
    private final View view;

    protected abstract View getView(Logic logic);
    
    protected Connect4() {
        logic = new Logic();
        view = getView(logic);
    }

    protected void play() {
        
        do {
            view.playGame();

        } while(view.keepsPlaying());

        view.close();
    }

}
