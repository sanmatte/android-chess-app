package com.example.mychess.Pieces;

import com.example.mychess.Coordinates;
import com.example.mychess.Position;

import java.util.ArrayList;

public class Rook extends Piece{

    public Rook(boolean white) {
        super(white);
    }

    @Override
    public ArrayList<Coordinates> AllowedMoves(Coordinates coordinates , Position[][] board , boolean hasKingMoved , boolean Rook0Move , boolean Rook7Move , boolean isKingInDanger){

        ArrayList<Coordinates> allowedMoves = new ArrayList<>();
        allowedMoves.clear();
        Coordinates c ;

        for(int i=(coordinates.getX()+1) ; i<8 ;i++){
            if(board[i][coordinates.getY()].getPiece() == null){
                c = new Coordinates(i , coordinates.getY());
                allowedMoves.add(c);
            }else{
                if(board[i][coordinates.getY()].getPiece().isWhite() != board[coordinates.getX()][coordinates.getY()].getPiece().isWhite()){
                    c = new Coordinates(i , coordinates.getY());
                    allowedMoves.add(c);
                }
                break;
            }
        }

        for(int i=(coordinates.getX()-1) ; i>=0 ; i--){
            if(board[i][coordinates.getY()].getPiece() == null){
                c = new Coordinates(i , coordinates.getY());
                allowedMoves.add(c);
            }else{
                if(board[i][coordinates.getY()].getPiece().isWhite() != board[coordinates.getX()][coordinates.getY()].getPiece().isWhite()){
                    c = new Coordinates(i , coordinates.getY());
                    allowedMoves.add(c);
                }
                break;
            }
        }

        for(int i=(coordinates.getY()-1) ; i>=0 ; i--){
            if(board[coordinates.getX()][i].getPiece() == null){
                c = new Coordinates( coordinates.getX() , i);
                allowedMoves.add(c);
            }else{
                if(board[coordinates.getX()][i].getPiece().isWhite() != board[coordinates.getX()][coordinates.getY()].getPiece().isWhite()){
                    c = new Coordinates( coordinates.getX() , i);
                    allowedMoves.add(c);
                }
                break;
            }
        }

        for(int i=(coordinates.getY()+1) ; i<8 ;i++){
            if(board[coordinates.getX()][i].getPiece() == null){
                c = new Coordinates(coordinates.getX() , i);
                allowedMoves.add(c);
            }else{
                if(board[coordinates.getX()][i].getPiece().isWhite() != board[coordinates.getX()][coordinates.getY()].getPiece().isWhite()){
                    c = new Coordinates(coordinates.getX() , i);
                    allowedMoves.add(c);
                }
                break;
            }
        }
        return allowedMoves;
    }
}
