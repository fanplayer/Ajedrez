package com.example.ajedrez.models;


import android.content.Context;

import com.example.ajedrez.R;

public class Caballo extends Pieza{

    public Caballo() {
        super();
    }

    public Caballo(boolean color, Context context) {
        super(color,context);
        this.CargarImagen();
    }


    @Override
    public boolean validoMovimiento(Movimiento mov, Tablero tablero) {
        boolean a = false;
        if((mov.saltoHorizontal()==2&&mov.saltoVertical()==1||mov.saltoHorizontal()==1&&mov.saltoVertical()==2)
                &&tablero.getTablero()[mov.getPosFinal().getFila()][mov.getPosFinal().getColumna()].getClass().getSimpleName().equals("PiezaNula")
        ){
            a = true;
        }else if((mov.saltoHorizontal()==2&&mov.saltoVertical()==1||mov.saltoHorizontal()==1&&mov.saltoVertical()==2)
                &&tablero.getTablero()[mov.getPosFinal().getFila()][mov.getPosFinal().getColumna()].getColor() != this.getColor()
        ){
            a = true;
        }
        return a;
    }

    @Override
    public boolean validoMovimiento2(Movimiento mov, Tablero tablero) {
        boolean a = false;
        if((mov.saltoHorizontal()==2&&mov.saltoVertical()==1||mov.saltoHorizontal()==1&&mov.saltoVertical()==2)
                &&tablero.getTablero()[mov.getPosFinal().getFila()][mov.getPosFinal().getColumna()] == null
        ){
            a = true;
        }else if((mov.saltoHorizontal()==2&&mov.saltoVertical()==1||mov.saltoHorizontal()==1&&mov.saltoVertical()==2)
                &&tablero.getTablero()[mov.getPosFinal().getFila()][mov.getPosFinal().getColumna()].getColor() != this.getColor()
        ){
            a = true;
        }
        return a;
    }

    @Override
    public boolean validoMovimiento3(Movimiento mov, Tablero tablero) {
        boolean a = false;
        if((mov.saltoHorizontal()==2&&mov.saltoVertical()==1||mov.saltoHorizontal()==1&&mov.saltoVertical()==2)
                &&tablero.getTablero()[mov.getPosFinal().getFila()][mov.getPosFinal().getColumna()] == null
        ){
            a = true;
        }else if((mov.saltoHorizontal()==2&&mov.saltoVertical()==1||mov.saltoHorizontal()==1&&mov.saltoVertical()==2)
                &&tablero.getTablero()[mov.getPosFinal().getFila()][mov.getPosFinal().getColumna()].getColor() == this.getColor()
        ){
            a = true;
        }
        return a;
    }

    @Override
    public void CargarImagen() {
        if(this.color){
            this.getImageView().setImageResource(R.drawable.wn);
            this.getImageView().setRotation(90);
        }else{
            this.getImageView().setImageResource(R.drawable.bn);
            this.getImageView().setRotation(90);
        }
    }

    @Override
    public int getScoreForPieceType() {
        return 30;
    }
}
