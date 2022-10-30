package com.example.mychess.Pieces;
import com.example.mychess.Position;
import com.example.mychess.Coordinates;
import java.util.ArrayList;
public class Queen extends Piece{

    public Queen(boolean white) {
        super(white);
    }

    @Override
    public ArrayList<Coordinates> AllowedMoves(Coordinates coordinates , Position[][] board , boolean hasKingMoved , boolean Rook0Move , boolean Rook7Move , boolean isKingInDanger){
        ArrayList<Coordinates> allowedMoves = new ArrayList<>();
        Coordinates c;
        allowedMoves.clear();

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

        /*............................*/
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

        //check locations at board
        //work on the coordinates and return the allowed moves
        return allowedMoves;
    }
}