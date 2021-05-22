package com.example.ajedrez.models;


import android.content.Context;

import com.example.ajedrez.R;

public class Rey extends Pieza{

    public Rey() {
        super();
    }

    public Rey(boolean color, Context context) {
        super(color,context);
        CargarImagen();
    }

    @Override
    public boolean validoMovimiento(Movimiento mov, Tablero tablero) {
        boolean a = false;
        if ((mov.saltoHorizontal() == 1 && mov.esHorizontal() || mov.saltoVertical() == 1 && mov.esVertical() || mov.esDiagonal() == true && mov.saltoHorizontal() == mov.saltoVertical() && mov.saltoHorizontal() == 1)
            &&tablero.getTablero()[mov.getPosFinal().getFila()][mov.getPosFinal().getColumna()].getClass().getSimpleName().equals("PiezaNula")
        ) {
            a = true;
        }else if((mov.saltoHorizontal() == 1 && mov.esHorizontal() || mov.saltoVertical() == 1 && mov.esVertical() || mov.esDiagonal() == true && mov.saltoHorizontal() == mov.saltoVertical() && mov.saltoHorizontal() == 1)
                &&tablero.getTablero()[mov.getPosFinal().getFila()][mov.getPosFinal().getColumna()].getColor() != this.getColor()
        ){
            a = true;
        }else if(tablero.getTablero()[0][1] == null  //Enroque IZQ Rey Blanco
                && tablero.getTablero()[0][2] == null
                && tablero.getTablero()[0][3] == null
                && mov.esHorizontal()
                && mov.saltoHorizontal() == 2
                && mov.saltoHorizontalDireccion() == -2
                && tablero.getTablero()[0][0] != null
                && tablero.getTablero()[0][0].getClass().getName().equals("models.Torre")
                && tablero.getTablero()[0][0].getColor() == true
                && tablero.getTablero()[0][0].piezamovida != true
                && tablero.getTablero()[0][4] != null
                && tablero.getTablero()[0][4].getClass().getName().equals("models.Rey")
                && tablero.getTablero()[0][4].piezamovida != true
                && tablero.getTablero()[mov.getPosinicial().getFila()][mov.getPosinicial().getColumna()].getColor() == true
        ){
            a = true;
        }else if(tablero.getTablero()[0][6] == null //Enroque DER Rey Blanco
                && tablero.getTablero()[0][5] == null
                && mov.esHorizontal()
                && mov.saltoHorizontal() == 2
                && mov.saltoHorizontalDireccion() == 2
                && tablero.getTablero()[0][7] != null
                && tablero.getTablero()[0][7].getClass().getName().equals("models.Torre")
                && tablero.getTablero()[0][7].getColor() == true
                && tablero.getTablero()[0][4] != null
                && tablero.getTablero()[0][4].getClass().getName().equals("models.Rey")
                && tablero.getTablero()[0][4].piezamovida != true
                && tablero.getTablero()[mov.getPosinicial().getFila()][mov.getPosinicial().getColumna()].getColor() == true
        ){
            a = true;
        }else if(tablero.getTablero()[7][1] == null  //Enroque IZQ Rey Negro
                && tablero.getTablero()[7][2] == null
                && tablero.getTablero()[7][3] == null
                && mov.esHorizontal()
                && mov.saltoHorizontal() == 2
                && mov.saltoHorizontalDireccion() == -2
                && tablero.getTablero()[7][0] != null
                && tablero.getTablero()[7][0].getClass().getName().equals("models.Torre")
                && tablero.getTablero()[7][0].getColor() == false
                && tablero.getTablero()[7][0].piezamovida != true
                && tablero.getTablero()[7][4] != null
                && tablero.getTablero()[7][4].getClass().getName().equals("models.Rey")
                && tablero.getTablero()[7][4].piezamovida != true
                && tablero.getTablero()[mov.getPosinicial().getFila()][mov.getPosinicial().getColumna()].getColor() == false
        ){
            a = true;
        }else if(tablero.getTablero()[7][6] == null //Enroque DER Rey Blanco
                && tablero.getTablero()[7][5] == null
                && mov.esHorizontal()
                && mov.saltoHorizontal() == 2
                && mov.saltoHorizontalDireccion() == 2
                && tablero.getTablero()[7][7] != null
                && tablero.getTablero()[7][7].getClass().getName().equals("models.Torre")
                && tablero.getTablero()[7][7].getColor() == false
                && tablero.getTablero()[7][4] != null
                && tablero.getTablero()[7][4].getClass().getName().equals("models.Rey")
                && tablero.getTablero()[7][4].piezamovida != true
                && tablero.getTablero()[mov.getPosinicial().getFila()][mov.getPosinicial().getColumna()].getColor() == false
        ){
            a = true;
        }
        return a;
    }

    @Override
    public boolean validoMovimiento2(Movimiento mov, Tablero tablero) {
        boolean a = false;
        if ((mov.saltoHorizontal() == 1 && mov.esHorizontal() || mov.saltoVertical() == 1 && mov.esVertical() || mov.esDiagonal() == true && mov.saltoHorizontal() == mov.saltoVertical() && mov.saltoHorizontal() == 1)
                &&tablero.getTablero()[mov.getPosFinal().getFila()][mov.getPosFinal().getColumna()] == null
        ) {
            a = true;
        }else if((mov.saltoHorizontal() == 1 && mov.esHorizontal() || mov.saltoVertical() == 1 && mov.esVertical() || mov.esDiagonal() == true && mov.saltoHorizontal() == mov.saltoVertical() && mov.saltoHorizontal() == 1)
                &&tablero.getTablero()[mov.getPosFinal().getFila()][mov.getPosFinal().getColumna()].getColor() != this.getColor()
        ){
            a = true;
        }else if(tablero.getTablero()[0][1] == null  //Enroque IZQ Rey Blanco
                && tablero.getTablero()[0][2] == null
                && tablero.getTablero()[0][3] == null
                && mov.esHorizontal()
                && mov.saltoHorizontal() == 2
                && mov.saltoHorizontalDireccion() == -2
                && tablero.getTablero()[0][0] != null
                && tablero.getTablero()[0][0].getClass().getName().equals("models.Torre")
                && tablero.getTablero()[0][0].getColor() == true
                && tablero.getTablero()[0][0].piezamovida != true
                && tablero.getTablero()[0][4] != null
                && tablero.getTablero()[0][4].getClass().getName().equals("models.Rey")
                && tablero.getTablero()[0][4].piezamovida != true
                && tablero.getTablero()[mov.getPosinicial().getFila()][mov.getPosinicial().getColumna()].getColor() == true
        ){
            a = true;
        }else if(tablero.getTablero()[0][6] == null //Enroque DER Rey Blanco
                && tablero.getTablero()[0][5] == null
                && mov.esHorizontal()
                && mov.saltoHorizontal() == 2
                && mov.saltoHorizontalDireccion() == 2
                && tablero.getTablero()[0][7] != null
                && tablero.getTablero()[0][7].getClass().getName().equals("models.Torre")
                && tablero.getTablero()[0][7].getColor() == true
                && tablero.getTablero()[0][4] != null
                && tablero.getTablero()[0][4].getClass().getName().equals("models.Rey")
                && tablero.getTablero()[0][4].piezamovida != true
                && tablero.getTablero()[mov.getPosinicial().getFila()][mov.getPosinicial().getColumna()].getColor() == true
        ){
            a = true;
        }else if(tablero.getTablero()[7][1] == null  //Enroque IZQ Rey Negro
                && tablero.getTablero()[7][2] == null
                && tablero.getTablero()[7][3] == null
                && mov.esHorizontal()
                && mov.saltoHorizontal() == 2
                && mov.saltoHorizontalDireccion() == -2
                && tablero.getTablero()[7][0] != null
                && tablero.getTablero()[7][0].getClass().getName().equals("models.Torre")
                && tablero.getTablero()[7][0].getColor() == false
                && tablero.getTablero()[7][0].piezamovida != true
                && tablero.getTablero()[7][4] != null
                && tablero.getTablero()[7][4].getClass().getName().equals("models.Rey")
                && tablero.getTablero()[7][4].piezamovida != true
                && tablero.getTablero()[mov.getPosinicial().getFila()][mov.getPosinicial().getColumna()].getColor() == false
        ){
            a = true;
        }else if(tablero.getTablero()[7][6] == null //Enroque DER Rey Blanco
                && tablero.getTablero()[7][5] == null
                && mov.esHorizontal()
                && mov.saltoHorizontal() == 2
                && mov.saltoHorizontalDireccion() == 2
                && tablero.getTablero()[7][7] != null
                && tablero.getTablero()[7][7].getClass().getName().equals("models.Torre")
                && tablero.getTablero()[7][7].getColor() == false
                && tablero.getTablero()[7][4] != null
                && tablero.getTablero()[7][4].getClass().getName().equals("models.Rey")
                && tablero.getTablero()[7][4].piezamovida != true
                && tablero.getTablero()[mov.getPosinicial().getFila()][mov.getPosinicial().getColumna()].getColor() == false
        ){
            a = true;
        }
        return a;
    }

    @Override
    public boolean validoMovimiento3(Movimiento mov, Tablero tablero) {
        boolean a = false;
        if ((mov.saltoHorizontal() == 1 && mov.esHorizontal() || mov.saltoVertical() == 1 && mov.esVertical() || mov.esDiagonal() == true && mov.saltoHorizontal() == mov.saltoVertical() && mov.saltoHorizontal() == 1)
                &&tablero.getTablero()[mov.getPosFinal().getFila()][mov.getPosFinal().getColumna()] == null
        ) {
            a = true;
        }else if((mov.saltoHorizontal() == 1 && mov.esHorizontal() || mov.saltoVertical() == 1 && mov.esVertical() || mov.esDiagonal() == true && mov.saltoHorizontal() == mov.saltoVertical() && mov.saltoHorizontal() == 1)
                &&tablero.getTablero()[mov.getPosFinal().getFila()][mov.getPosFinal().getColumna()].getColor() == this.getColor()
        ){
            a = true;
        }else if(tablero.getTablero()[0][1] == null  //Enroque IZQ Rey Blanco
                && tablero.getTablero()[0][2] == null
                && tablero.getTablero()[0][3] == null
                && mov.esHorizontal()
                && mov.saltoHorizontal() == 2
                && mov.saltoHorizontalDireccion() == -2
                && tablero.getTablero()[0][0] != null
                && tablero.getTablero()[0][0].getClass().getName().equals("models.Torre")
                && tablero.getTablero()[0][0].getColor() == true
                && tablero.getTablero()[0][0].piezamovida != true
                && tablero.getTablero()[0][4] != null
                && tablero.getTablero()[0][4].getClass().getName().equals("models.Rey")
                && tablero.getTablero()[0][4].piezamovida != true
                && tablero.getTablero()[mov.getPosinicial().getFila()][mov.getPosinicial().getColumna()].getColor() == true
        ){
            a = true;
        }else if(tablero.getTablero()[0][6] == null //Enroque DER Rey Blanco
                && tablero.getTablero()[0][5] == null
                && mov.esHorizontal()
                && mov.saltoHorizontal() == 2
                && mov.saltoHorizontalDireccion() == 2
                && tablero.getTablero()[0][7] != null
                && tablero.getTablero()[0][7].getClass().getName().equals("models.Torre")
                && tablero.getTablero()[0][7].getColor() == true
                && tablero.getTablero()[0][4] != null
                && tablero.getTablero()[0][4].getClass().getName().equals("models.Rey")
                && tablero.getTablero()[0][4].piezamovida != true
                && tablero.getTablero()[mov.getPosinicial().getFila()][mov.getPosinicial().getColumna()].getColor() == true
        ){
            a = true;
        }else if(tablero.getTablero()[7][1] == null  //Enroque IZQ Rey Negro
                && tablero.getTablero()[7][2] == null
                && tablero.getTablero()[7][3] == null
                && mov.esHorizontal()
                && mov.saltoHorizontal() == 2
                && mov.saltoHorizontalDireccion() == -2
                && tablero.getTablero()[7][0] != null
                && tablero.getTablero()[7][0].getClass().getName().equals("models.Torre")
                && tablero.getTablero()[7][0].getColor() == false
                && tablero.getTablero()[7][0].piezamovida != true
                && tablero.getTablero()[7][4] != null
                && tablero.getTablero()[7][4].getClass().getName().equals("models.Rey")
                && tablero.getTablero()[7][4].piezamovida != true
                && tablero.getTablero()[mov.getPosinicial().getFila()][mov.getPosinicial().getColumna()].getColor() == false
        ){
            a = true;
        }else if(tablero.getTablero()[7][6] == null //Enroque DER Rey Blanco
                && tablero.getTablero()[7][5] == null
                && mov.esHorizontal()
                && mov.saltoHorizontal() == 2
                && mov.saltoHorizontalDireccion() == 2
                && tablero.getTablero()[7][7] != null
                && tablero.getTablero()[7][7].getClass().getName().equals("models.Torre")
                && tablero.getTablero()[7][7].getColor() == false
                && tablero.getTablero()[7][4] != null
                && tablero.getTablero()[7][4].getClass().getName().equals("models.Rey")
                && tablero.getTablero()[7][4].piezamovida != true
                && tablero.getTablero()[mov.getPosinicial().getFila()][mov.getPosinicial().getColumna()].getColor() == false
        ){
            a = true;
        }
        return a;
    }

    @Override
    public void CargarImagen() {
        if(this.color){
            this.getImageView().setImageResource(R.drawable.wk);
            this.getImageView().setRotation(90);
        }else{
            this.getImageView().setImageResource(R.drawable.bk);
            this.getImageView().setRotation(90);
        }
    }

    @Override
    public int getScoreForPieceType() {
        return 99999;
    }
}
