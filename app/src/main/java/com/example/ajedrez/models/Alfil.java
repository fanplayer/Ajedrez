package com.example.ajedrez.models;

import android.content.Context;

import com.example.ajedrez.R;

public class Alfil extends Pieza{

    public Alfil(){
        super();
    }

    public Alfil(boolean color, Context context) {
        super(color,context);
        CargarImagen();
    }

    @Override
    public boolean validoMovimiento(Movimiento mov, Tablero tablero) {
        boolean a = false;
        if(mov.esDiagonal()==true
            &&!this.hayPiezasentre(mov,tablero)
                &&tablero.getTablero()[mov.getPosFinal().getFila()][mov.getPosFinal().getColumna()].getClass().getSimpleName().equals("PiezaNula")
        ){
            a =true;
        }else if(mov.esDiagonal()==true
                &&!this.hayPiezasentre(mov,tablero)
                &&tablero.getTablero()[mov.getPosFinal().getFila()][mov.getPosFinal().getColumna()].getColor() != this.getColor()
        ){
            a =true;
        }
        return a;
    }

    @Override
    public boolean validoMovimiento2(Movimiento mov, Tablero tablero) {
        boolean a = false;
        if(mov.esDiagonal()==true
                &&tablero.getTablero()[mov.getPosFinal().getFila()][mov.getPosFinal().getColumna()] == null
        ){
            a =true;
        }else if(mov.esDiagonal()==true
                &&tablero.getTablero()[mov.getPosFinal().getFila()][mov.getPosFinal().getColumna()].getColor() != this.getColor()
        ){
            a =true;
        }
        return a;
    }

    @Override
    public boolean validoMovimiento3(Movimiento mov, Tablero tablero) {
        boolean a = false;
        if(mov.esDiagonal()==true
                &&tablero.getTablero()[mov.getPosFinal().getFila()][mov.getPosFinal().getColumna()] == null
        ){
            a =true;
        }else if(mov.esDiagonal()==true
                &&tablero.getTablero()[mov.getPosFinal().getFila()][mov.getPosFinal().getColumna()].getColor() == this.getColor()
        ){
            a =true;
        }
        return a;
    }

    @Override
    public void CargarImagen() {
        if(this.color){
            this.getImageView().setImageResource(R.drawable.wb);
            this.getImageView().setRotation(90);
        }else{
            this.getImageView().setImageResource(R.drawable.bb);
            this.getImageView().setRotation(90);

        }
    }

    @Override
    public int getScoreForPieceType() {
        return 30;
    }
}
