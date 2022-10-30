package com.example.mychess;

import com.example.mychess.Pieces.Piece;

//creato il 31 marzo 2022 ore 19:20

public class Position {
    private Piece piece;


    Position(Piece piece ) {
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }

    void setPiece(Piece piece) {
        this.piece = piece;
    }

}
