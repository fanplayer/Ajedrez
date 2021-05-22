package com.example.ajedrez.models;

import android.content.Context;
import android.widget.ImageView;


public class PiezaNula extends Pieza{

    public PiezaNula(){
        super();
    }

    public PiezaNula(boolean color, Context context) {
        super(color,context);
        this.setImageView(new ImageView(context));
        CargarImagen();
    }

    @Override
    public boolean validoMovimiento(Movimiento mov, Tablero tablero) {
        return false;
    }

    @Override
    public boolean validoMovimiento2(Movimiento mov, Tablero tablero) {
        return false;
    }

    @Override
    public boolean validoMovimiento3(Movimiento mov, Tablero tablero) {
        return false;
    }

    @Override
    public void CargarImagen() {
    }

    @Override
    public int getScoreForPieceType() {
        return 0;
    }
}
