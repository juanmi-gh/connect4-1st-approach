package com.cloud.jmc.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Console {

    private static Console instance;
    
    public static Console getInstance() {
        if (instance == null) {
            instance = new Console();
        }
        return instance;
    }
    
    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public String readString(String title) {
        
        try {
            this.write(title);
            return this.bufferedReader.readLine();
        
        } catch (Exception e) { 
            return "";
        }
    }
    
    public String readString() {
        return this.readString("");
    }

    public int readInt(String title) {

        try {
            return Integer.parseInt(this.readString(title));

        } catch (Exception ex) {
            this.writeError("integer");
            return readInt(title);
        }
    }

    public char readChar(String title) {

        String input = this.readString(title);
        if (input.length() == 1) {
            return input.charAt(0);
        }
        
        this.writeError("character");
        return readChar(title);
    }
    
    public void write(String string) {
        System.out.print(string);
    }
    
    public void write(int integer) {
        System.out.print(integer);
    }

    public void write(char character) {
        System.out.print(character);
    }

    public void writeln() {
        System.out.println();
    }

    public void writeln(String string) {
        this.write(string);
        this.writeln();
    }
    
    public void writeln(int integer) {
        this.write(integer);
        this.writeln();
    }

    public void writeln(String template, String value) {
        this.writeln(String.format(template,  value));
    }
    
    public void write(String template, String value) {
        this.write(String.format(template,  value));
    }
    
    public void writeError(String format) {
        this.write("FORMAT ERROR! Enter a " + format + " formatted value.");
        this.writeln();
    }

}
