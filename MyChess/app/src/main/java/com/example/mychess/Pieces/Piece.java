package com.example.mychess.Pieces;

import com.example.mychess.Coordinates;
import com.example.mychess.Position;

import java.util.ArrayList;

/**
 * Creato il 31 marzo 2022 alle 19:15
 */


public class Piece {

    private boolean white;
    //pezzi bianchi e neri
    Piece(boolean white) {
        this.white = white;
    }
    //mosse
    public ArrayList<Coordinates> AllowedMoves(Coordinates coordinates , Position[][] board , boolean hasKingMoved , boolean Rook0Move , boolean Rook7Move , boolean isKingInDanger){
        //vettore dinamico di cordinate
        ArrayList<Coordinates> allowedMoves = new ArrayList<>();
        Coordinates c;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                c = new Coordinates(i,j);
                allowedMoves.add(c);
            }
        }
        return allowedMoves;
    }
    //verifica se il pezzo è bianco o nero
    public boolean isWhite() {
        return white;
    }
}
