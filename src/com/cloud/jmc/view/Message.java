package com.cloud.jmc.view;

enum Message {

    TITLE("\r\n" + 
            "  _    _    _     _    _    _     _    _    _  \r\n" + 
            " / \\  / \\  / \\   / \\  / \\  / \\   / \\  / \\  / \\ \r\n" + 
            "( T )( i )( c ) ( T )( a )( c ) ( T )( o )( e )\r\n" + 
            " \\_/  \\_/  \\_/   \\_/  \\_/  \\_/   \\_/  \\_/  \\_/ "),
    NEW_GAME("\t\tN E W  G A M E!\n"),
    WINNER("\nPlayer %s WINS!"),
    TIE("TIE! No more moves available."),
    PLAY_AGAIN("Play again? (Y/N):"),
    PLAYER_TURN("\nTurn for player %s"),
    PICK_COLUMN("Enter your move: "),
    WRONG_COLUMN("%s is not a valid column. Try again:"),
    FAREWELL(" ___            _ \r\n" + 
            "| . > _ _  ___ | |\r\n" + 
            "| . \\| | |/ ._>|_/\r\n" + 
            "|___/`_. |\\___.<_>\r\n" + 
            "     <___'        ")
    ;
    
    private String value;
    
    Message(String message) {
        value = message;
    }
    
    String getValue() {
        return value;
    }
}
