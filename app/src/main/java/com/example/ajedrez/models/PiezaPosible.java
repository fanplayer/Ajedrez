package com.example.ajedrez.models;

import android.content.Context;

import com.example.ajedrez.R;

public class PiezaPosible extends Pieza{

    public PiezaPosible() {
    }

    public PiezaPosible(boolean color, Context context) {
        super(color, context);
        this.CargarImagen();
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
        this.getImageView().setImageResource(R.drawable.circulo);
    }

    @Override
    public int getScoreForPieceType() {
        return 0;
    }
}
