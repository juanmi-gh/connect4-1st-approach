package com.cloud.jmc;

public class Box {

    private static final char SPACE = ' ';
    private char mark;
    
    public Box() {
        mark = SPACE;
    }
    
    public char value() {
        return mark;
    }
    
    public boolean isBlank() {
        return mark == SPACE;
    }
    
    public void setMark(char mark) {
        this.mark = mark; 
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
          return false;
        }

        Box other = (Box)o;
        return this.mark == other.mark;
    }
    
}
