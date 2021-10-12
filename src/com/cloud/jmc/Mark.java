package com.cloud.jmc;

public enum Mark {

    O_MARK('O'),
    X_MARK('X');
    
    public final char value;
    
    Mark(char mark) {
        this.value = mark;
    }

}
