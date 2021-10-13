package com.cloud.jmc;

import com.cloud.jmc.controller.Logic;
import com.cloud.jmc.view.View;

public class ConsoleView extends Connect4 {
    
    public static void main(String[] args) {

        new ConsoleView().play();
    }

    @Override
    protected View getView(Logic logic) {
        return new View(logic);
    }
    
}
