package com.example.mychess.Pieces;
import com.example.mychess.Coordinates;
import com.example.mychess.Position;
import java.util.ArrayList;
public class King extends Piece {

    public King(boolean white) {
        super( white);
    }

    @Override
    public ArrayList<Coordinates> AllowedMoves(Coordinates coordinates , Position[][] board , boolean hasKingMoved , boolean Rook0Move , boolean Rook7Move , boolean isKingInDanger){
        ArrayList<Coordinates> allowedMoves = new ArrayList<>();
        Coordinates c;

        if((coordinates.getX()+1) <8 && (coordinates.getY()+1)<8){
            if(board[coordinates.getX()+1][coordinates.getY()+1].getPiece() == null){
                c = new Coordinates(coordinates.getX()+1 , coordinates.getY()+1);
                allowedMoves.add(c);
            }else{
                if(board[coordinates.getX()+1][coordinates.getY()+1].getPiece().isWhite() != board[coordinates.getX()][coordinates.getY()].getPiece().isWhite()){
                    c = new Coordinates(coordinates.getX()+1 , coordinates.getY()+1);
                    allowedMoves.add(c);
                }
            }
        }

        if((coordinates.getY()+1)<8){
            if(board[coordinates.getX()][coordinates.getY()+1].getPiece() == null){
                c = new Coordinates(coordinates.getX() , coordinates.getY()+1);
                allowedMoves.add(c);
            }else{
                if(board[coordinates.getX()][coordinates.getY()+1].getPiece().isWhite() != board[coordinates.getX()][coordinates.getY()].getPiece().isWhite()){
                    c = new Coordinates(coordinates.getX() , coordinates.getY()+1);
                    allowedMoves.add(c);
                }
            }
        }

        if((coordinates.getX()-1) >=0 && (coordinates.getY()+1)<8){
            if(board[coordinates.getX()-1][coordinates.getY()+1].getPiece() == null){
                c = new Coordinates(coordinates.getX()-1 , coordinates.getY()+1);
                allowedMoves.add(c);
            }else{
                if(board[coordinates.getX()-1][coordinates.getY()+1].getPiece().isWhite() != board[coordinates.getX()][coordinates.getY()].getPiece().isWhite()){
                    c = new Coordinates(coordinates.getX()-1 , coordinates.getY()+1);
                    allowedMoves.add(c);
                }
            }
        }

        if((coordinates.getX()+1) <8 ){
            if(board[coordinates.getX()+1][coordinates.getY()].getPiece() == null){
                c = new Coordinates(coordinates.getX()+1 , coordinates.getY());
                allowedMoves.add(c);
            }else{
                if(board[coordinates.getX()+1][coordinates.getY()].getPiece().isWhite() != board[coordinates.getX()][coordinates.getY()].getPiece().isWhite()){
                    c = new Coordinates(coordinates.getX()+1 , coordinates.getY());
                    allowedMoves.add(c);
                }
            }
        }

        if((coordinates.getX()-1) <8 ){
            if(board[coordinates.getX()-1][coordinates.getY()].getPiece() == null){
                c = new Coordinates(coordinates.getX()-1 , coordinates.getY());
                allowedMoves.add(c);
            }else{
                if(board[coordinates.getX()-1][coordinates.getY()].getPiece().isWhite() != board[coordinates.getX()][coordinates.getY()].getPiece().isWhite()){
                    c = new Coordinates(coordinates.getX()-1 , coordinates.getY());
                    allowedMoves.add(c);
                }
            }
        }

        if((coordinates.getX()+1) <8 && (coordinates.getY()-1)>=0){
            if(board[coordinates.getX()+1][coordinates.getY()-1].getPiece() == null){
                c = new Coordinates(coordinates.getX()+1 , coordinates.getY()-1);
                allowedMoves.add(c);
            }else{
                if(board[coordinates.getX()+1][coordinates.getY()-1].getPiece().isWhite() != board[coordinates.getX()][coordinates.getY()].getPiece().isWhite()){
                    c = new Coordinates(coordinates.getX()+1 , coordinates.getY()-1);
                    allowedMoves.add(c);
                }
            }
        }

        if((coordinates.getY()-1)>=0){
            if(board[coordinates.getX()][coordinates.getY()-1].getPiece() == null){
                c = new Coordinates(coordinates.getX() , coordinates.getY()-1);
                allowedMoves.add(c);
            }else{
                if(board[coordinates.getX()][coordinates.getY()-1].getPiece().isWhite() != board[coordinates.getX()][coordinates.getY()].getPiece().isWhite()){
                    c = new Coordinates(coordinates.getX() , coordinates.getY()-1);
                    allowedMoves.add(c);
                }
            }
        }

        if((coordinates.getX()-1) <8 && (coordinates.getY()-1)>=0){
            if(board[coordinates.getX()-1][coordinates.getY()-1].getPiece() == null){
                c = new Coordinates(coordinates.getX()-1 , coordinates.getY()-1);
                allowedMoves.add(c);
            }else{
                if(board[coordinates.getX()-1][coordinates.getY()-1].getPiece().isWhite() != board[coordinates.getX()][coordinates.getY()].getPiece().isWhite()){
                    c = new Coordinates(coordinates.getX()-1 , coordinates.getY()-1);
                    allowedMoves.add(c);
                }
            }
        }
        if(!hasKingMoved && !isKingInDanger) {
            if (board[coordinates.getX()][coordinates.getY()].getPiece().isWhite()) {

                if ((coordinates.getX() == 4) && (coordinates.getY() == 7) && (board[5][7].getPiece() == null) && board[6][7].getPiece() == null) {
                    if(!Rook7Move) {
                        c = new Coordinates(coordinates.getX() + 2, coordinates.getY());
                        allowedMoves.add(c);
                    }
                }

                if ((coordinates.getX() == 4) && (coordinates.getY() == 7) && (board[3][7].getPiece() == null) && board[2][7].getPiece() == null && board[1][7].getPiece() == null) {
                    if(!Rook0Move) {
                        c = new Coordinates(coordinates.getX() - 2, coordinates.getY());
                        allowedMoves.add(c);
                    }
                }

            } else {

                if ((coordinates.getX() == 4) && (coordinates.getY() == 0) && (board[5][0].getPiece() == null) && board[6][0].getPiece() == null) {
                    if(!Rook7Move) {
                        c = new Coordinates(coordinates.getX() + 2, coordinates.getY());
                        allowedMoves.add(c);
                    }
                }

                if ((coordinates.getX() == 4) && (coordinates.getY() == 0) && (board[3][0].getPiece() == null) && board[2][0].getPiece() == null && board[1][0].getPiece() == null) {
                    if(!Rook0Move) {
                        c = new Coordinates(coordinates.getX() - 2, coordinates.getY());
                        allowedMoves.add(c);
                    }
                }

            }
        }


        return allowedMoves;
    }
}