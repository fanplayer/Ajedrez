package com.example.ajedrez.models;


import android.content.Context;

import com.example.ajedrez.R;

public class Reina extends Pieza{

    public Reina(){
        super();
    }

    public Reina(boolean color, Context context) {
        super(color,context);
        CargarImagen();
    }


    @Override
    public boolean validoMovimiento(Movimiento mov, Tablero tablero) {
        boolean a = false;
        if ((mov.esHorizontal() == true || mov.esVertical() == true || mov.esDiagonal() == true)
                && !this.hayPiezasentre(mov, tablero)
                && tablero.getTablero()[mov.getPosFinal().getFila()][mov.getPosFinal().getColumna()].getClass().getSimpleName().equals("PiezaNula")
                && !tablero.getTablero()[mov.getPosFinal().getFila()][mov.getPosFinal().getColumna()].getClass().getSimpleName().equals("PiezaPosible")
        ) {
            a = true;
        } else if ((mov.esHorizontal() == true || mov.esVertical() == true || mov.esDiagonal() == true)
                && !this.hayPiezasentre(mov, tablero)
                && tablero.getTablero()[mov.getPosFinal().getFila()][mov.getPosFinal().getColumna()].getColor() != this.getColor()
                && !tablero.getTablero()[mov.getPosFinal().getFila()][mov.getPosFinal().getColumna()].getClass().getSimpleName().equals("PiezaNula")
                && !tablero.getTablero()[mov.getPosFinal().getFila()][mov.getPosFinal().getColumna()].getClass().getSimpleName().equals("PiezaPosible")
        ) {
            a = true;
        }
        return a;
    }

    @Override
    public boolean validoMovimiento2(Movimiento mov, Tablero tablero) {
        boolean a = false;
        if((mov.esHorizontal()==true||mov.esVertical()==true||mov.esDiagonal()==true)
                &&tablero.getTablero()[mov.getPosFinal().getFila()][mov.getPosFinal().getColumna()] == null
        ){
            a = true;
        }else if((mov.esHorizontal()==true||mov.esVertical()==true||mov.esDiagonal()==true)
                &&tablero.getTablero()[mov.getPosFinal().getFila()][mov.getPosFinal().getColumna()].getColor() != this.getColor()
        ){
            a = true;
        }
        return a;
    }

    @Override
    public boolean validoMovimiento3(Movimiento mov, Tablero tablero) {
        boolean a = false;
        if((mov.esHorizontal()==true||mov.esVertical()==true||mov.esDiagonal()==true)
                &&tablero.getTablero()[mov.getPosFinal().getFila()][mov.getPosFinal().getColumna()] == null
        ){
            a = true;
        }else if((mov.esHorizontal()==true||mov.esVertical()==true||mov.esDiagonal()==true)
                &&tablero.getTablero()[mov.getPosFinal().getFila()][mov.getPosFinal().getColumna()].getColor() == this.getColor()
        ){
            a = true;
        }
        return a;
    }

    @Override
    public void CargarImagen() {
        if(this.color){
            this.getImageView().setImageResource(R.drawable.wq);
            this.getImageView().setRotation(90);
        }else{
            this.getImageView().setImageResource(R.drawable.bq);
            this.getImageView().setRotation(90);
        }
    }

    @Override
    public int getScoreForPieceType() {
        return 90;
    }
}
