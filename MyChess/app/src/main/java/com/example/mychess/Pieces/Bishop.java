package com.example.mychess.Pieces;
import com.example.mychess.Coordinates;
import com.example.mychess.Position;
import java.util.ArrayList;
public class Bishop extends Piece{

    public Bishop(boolean white) {
        super(white);
    }

    @Override
    public ArrayList<Coordinates> AllowedMoves(Coordinates coordinates , Position[][] board , boolean hasKingMoved , boolean Rook0Move , boolean Rook7Move , boolean isKingInDanger){
        ArrayList<Coordinates> allowedMoves = new ArrayList<>();
        allowedMoves.clear();
        Coordinates c;

        for(int i=1 ; i<8 ; i++){
            if((coordinates.getX()+i)<8 && (coordinates.getY()+i)<8){
                if(board[coordinates.getX()+i][coordinates.getY()+i].getPiece() == null){
                    c = new Coordinates(coordinates.getX()+i , coordinates.getY()+i);
                    allowedMoves.add(c);
                }else{
                    if(board[coordinates.getX()+i][coordinates.getY()+i].getPiece().isWhite() != board[coordinates.getX()][coordinates.getY()].getPiece().isWhite()){
                        c = new Coordinates(coordinates.getX()+i , coordinates.getY()+i);
                        allowedMoves.add(c);
                    }
                    break;
                }
            }
        }

        for(int i=1 ; i<8 ; i++){
            if((coordinates.getX()-i)>=0 && (coordinates.getY()+i)<8){
                if(board[coordinates.getX()-i][coordinates.getY()+i].getPiece() == null){
                    c = new Coordinates(coordinates.getX()-i , coordinates.getY()+i);
                    allowedMoves.add(c);
                }else{
                    if(board[coordinates.getX()-i][coordinates.getY()+i].getPiece().isWhite() != board[coordinates.getX()][coordinates.getY()].getPiece().isWhite()){
                        c = new Coordinates(coordinates.getX()-i , coordinates.getY()+i);
                        allowedMoves.add(c);
                    }
                    break;
                }

            }
        }

        for(int i=1 ; i<8 ; i++){
            if((coordinates.getX()-i)>=0 && (coordinates.getY()-i)>=0){
                if(board[coordinates.getX()-i][coordinates.getY()-i].getPiece() == null){
                    c = new Coordinates(coordinates.getX()-i , coordinates.getY()-i);
                    allowedMoves.add(c);
                }else{
                    if(board[coordinates.getX()-i][coordinates.getY()-i].getPiece().isWhite() != board[coordinates.getX()][coordinates.getY()].getPiece().isWhite()){
                        c = new Coordinates(coordinates.getX()-i , coordinates.getY()-i);
                        allowedMoves.add(c);
                    }
                    break;
                }

            }
        }

        for(int i=1 ; i<8 ; i++){
            if((coordinates.getX()+i)<8 && (coordinates.getY()-i)>=0){
                if(board[coordinates.getX()+i][coordinates.getY()-i].getPiece() == null){
                    c = new Coordinates(coordinates.getX()+i , coordinates.getY()-i);
                    allowedMoves.add(c);
                }else{
                    if(board[coordinates.getX()+i][coordinates.getY()-i].getPiece().isWhite() != board[coordinates.getX()][coordinates.getY()].getPiece().isWhite()){
                        c = new Coordinates(coordinates.getX()+i , coordinates.getY()-i);
                        allowedMoves.add(c);
                    }
                    break;
                }

            }
        }


        return allowedMoves;
    }
}
