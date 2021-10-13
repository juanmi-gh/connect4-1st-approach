package com.cloud.jmc.model;

class Box {

    private static final char SPACE = ' ';
    private char mark;
    
    public Box() {
        mark = SPACE;
    }
    
    char getMark() {
        return mark;
    }
        
    void setMark(char mark) {
        this.mark = mark; 
    }
    
    boolean isBlank() {
        return mark == SPACE;
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
