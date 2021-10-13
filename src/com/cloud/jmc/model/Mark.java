package com.cloud.jmc.model;

enum Mark {

    O_MARK('O'),
    X_MARK('X');
    
    final char value;
    
    Mark(char mark) {
        this.value = mark;
    }

}
