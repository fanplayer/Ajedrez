package com.example.ajedrez.models;

import android.content.Context;
import android.widget.ImageView;

public abstract class Pieza {

    protected boolean color;
    protected boolean piezamovida;
    protected boolean clicked;
    protected ImageView imageView;


    public Pieza(){
        color = false;
        piezamovida = false;
        clicked = false;
    }

    public Pieza(boolean color, Context context){
        this.color = color;
        piezamovida = false;
        this.clicked = false;
        imageView = new ImageView(context);
    }

    public boolean getColor() {
        return color;
    }

    public abstract boolean validoMovimiento(Movimiento mov, Tablero tablero);

    public abstract boolean validoMovimiento2(Movimiento mov, Tablero tablero);

    public abstract boolean validoMovimiento3(Movimiento mov, Tablero tablero);

    public boolean isPiezamovida() {
        return piezamovida;
    }

    /*public void Clikar(Color color){
        imageView.setEffect(new DropSombra(30, color));
        clicked = true;
    }*/

    public abstract void CargarImagen();


    public void Deseleccionar(){
        //this.imageView.setEffect(null);
        clicked = false;
    }

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public void PiezaMovida(){
        this.piezamovida = true;
    }

    public boolean hayPiezasentre(Movimiento mov,Tablero tab) {
        Pieza[][] tablero = tab.getTablero();
        boolean a = false;
        if (mov.esHorizontal()) {
            if (mov.getPosinicial().getColumna() < mov.getPosFinal().getColumna()) {
                for (int i = 1; i < mov.saltoHorizontal(); i++) {
                    if (!tablero[mov.getPosinicial().getFila()][mov.getPosinicial().getColumna() + i].getClass().getSimpleName().equals("PiezaNula")
                        &&!tablero[mov.getPosinicial().getFila()][mov.getPosinicial().getColumna() + i].getClass().getSimpleName().equals("PiezaPosible")
                    ) {
                        a = true;
                    }
                }
            }
            if (mov.getPosinicial().getColumna() > mov.getPosFinal().getColumna()) {
                for (int i = 1; i < mov.saltoHorizontal(); i++) {
                    if (!tablero[mov.getPosinicial().getFila()][mov.getPosinicial().getColumna() - i].getClass().getSimpleName().equals("PiezaNula")
                        &&!tablero[mov.getPosinicial().getFila()][mov.getPosinicial().getColumna() - i].getClass().getSimpleName().equals("PiezaPosible")
                    ) {
                        a = true;
                    }
                }
            }
        }
        if (mov.esVertical()) {
            if (mov.getPosinicial().getFila() < mov.getPosFinal().getFila()) {
                for (int i = 1; i < mov.saltoVertical(); i++) {
                    if (!tablero[mov.getPosinicial().getFila() + i][mov.getPosinicial().getColumna()].getClass().getSimpleName().equals("PiezaNula")
                        &&!tablero[mov.getPosinicial().getFila() + i][mov.getPosinicial().getColumna()].getClass().getSimpleName().equals("PiezaPosible")
                    ) {
                        a = true;
                    }
                }
            }
            if (mov.getPosinicial().getFila() > mov.getPosFinal().getFila()) {
                for (int i = 1; i < mov.saltoVertical(); i++) {
                    if (!tablero[mov.getPosinicial().getFila() - i][mov.getPosinicial().getColumna()].getClass().getSimpleName().equals("PiezaNula")
                            &&!tablero[mov.getPosinicial().getFila() - i][mov.getPosinicial().getColumna()].getClass().getSimpleName().equals("PiezaPosible")
                    ) {
                        a = true;
                    }
                }
            }
        }
        if (mov.esDiagonal()) {
            if (mov.getPosFinal().getFila() < mov.getPosinicial().getFila() && mov.getPosFinal().getColumna() > mov.getPosinicial().getColumna()) {
                for (int i = 1; i < mov.saltoHorizontal(); i++) {
                    if (!tablero[mov.getPosinicial().getFila() - i][mov.getPosinicial().getColumna() + i].getClass().getSimpleName().equals("PiezaNula")
                        &&!tablero[mov.getPosinicial().getFila() - i][mov.getPosinicial().getColumna() + i].getClass().getSimpleName().equals("PiezaPosible")
                    ) {
                        a = true;
                    }
                }
            }
            if (mov.getPosFinal().getFila() > mov.getPosinicial().getFila() && mov.getPosFinal().getColumna() < mov.getPosinicial().getColumna()) {
                for (int i = 1; i < mov.saltoHorizontal(); i++) {
                    if (!tablero[mov.getPosinicial().getFila() + i][mov.getPosinicial().getColumna() - i].getClass().getSimpleName().equals("PiezaNula")
                        &&!tablero[mov.getPosinicial().getFila() + i][mov.getPosinicial().getColumna() - i].getClass().getSimpleName().equals("PiezaPosible")
                    ) {
                        a = true;
                    }
                }
            }
            if (mov.getPosFinal().getFila() < mov.getPosinicial().getFila() && mov.getPosFinal().getColumna() < mov.getPosinicial().getColumna()) {
                for (int i = 1; i < mov.saltoHorizontal(); i++) {
                    if (!tablero[mov.getPosinicial().getFila() - i][mov.getPosinicial().getColumna() - i].getClass().getSimpleName().equals("PiezaNula")
                        &&!tablero[mov.getPosinicial().getFila() - i][mov.getPosinicial().getColumna() - i].getClass().getSimpleName().equals("PiezaPosible")
                    ) {
                        a = true;
                    }
                }
            }
            if (mov.getPosFinal().getFila() > mov.getPosinicial().getFila() && mov.getPosFinal().getColumna() > mov.getPosinicial().getColumna()) {
                for (int i = 1; i < mov.saltoHorizontal(); i++) {
                    if (!tablero[mov.getPosinicial().getFila() + i][mov.getPosinicial().getColumna() + i].getClass().getSimpleName().equals("PiezaNula")
                            &&!tablero[mov.getPosinicial().getFila() + i][mov.getPosinicial().getColumna() + i].getClass().getSimpleName().equals("PiezaPosible")
                    ) {
                        a = true;
                    }
                }
            }
        }
        return a;
    }

    public abstract int getScoreForPieceType();

}
