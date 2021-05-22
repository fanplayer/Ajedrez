package com.example.ajedrez.models;


import android.content.Context;

import com.example.ajedrez.R;

public class Peon extends Pieza{

    public Peon(){
        super();
        this.CargarImagen();
    }

    public Peon(Boolean color, Context context){
        super(color,context);
        this.CargarImagen();
    }

    @Override
    public boolean validoMovimiento(Movimiento mov, Tablero tablero) {
        boolean movimientovalido = false;
        if(this.color == false){
            if(mov.esVertical()==true
                    &&mov.saltoVerticalDireccion()<0
                    && piezamovida==false
                    && mov.saltoVertical()==2
                    && tablero.devuelvePieza(mov.getPosFinal()).getClass().getSimpleName().equals("PiezaNula")
                    &&!this.piezamovida
                    &&!this.hayPiezasentre(mov,tablero)
            ){
                movimientovalido = true;
            } else if(mov.esVertical()==true
                    && mov.saltoVerticalDireccion()<0
                    && mov.saltoVertical()==1
                    && tablero.devuelvePieza(mov.getPosFinal()).getClass().getSimpleName().equals("PiezaNula")
            ){
                movimientovalido = true;
            } else if(mov.esDiagonal()&&
                    mov.saltoHorizontal()==mov.saltoVertical()&&
                    mov.saltoVertical()==1&&
                    mov.saltoVerticalDireccion()<0
                    &&!tablero.devuelvePieza(mov.getPosFinal()).getClass().getSimpleName().equals("PiezaNula")
                    && tablero.devuelvePieza(mov.getPosFinal().getFila(),mov.getPosFinal().getColumna()).getColor()!=color
            ){
                movimientovalido = true;
            }
        }else if(this.color == true){
            if(mov.esVertical()==true
                    &&mov.saltoVerticalDireccion()>0
                    &&piezamovida==false
                    && mov.saltoVertical()==2
                    && tablero.devuelvePieza(mov.getPosFinal()).getClass().getSimpleName().equals("PiezaNula")
                    &&!this.piezamovida
                    &&!this.hayPiezasentre(mov,tablero)
            ){
                movimientovalido = true;
            }else if(mov.esVertical()==true&&
                    mov.saltoVerticalDireccion()>0&&
                    mov.saltoVertical()==1
                    && tablero.devuelvePieza(mov.getPosFinal()).getClass().getSimpleName().equals("PiezaNula")
            ){
                movimientovalido = true;
            }else if(mov.esDiagonal()&&
                    mov.saltoHorizontal()==mov.saltoVertical()&&
                    mov.saltoVertical()==1&&
                    mov.saltoVerticalDireccion()>0
                    &&!tablero.devuelvePieza(mov.getPosFinal()).getClass().getSimpleName().equals("PiezaNula")
                && tablero.devuelvePieza(mov.getPosFinal().getFila(),mov.getPosFinal().getColumna()).getColor()!=color
            ){
                movimientovalido = true;
            }

        }
        return movimientovalido;
    }

    @Override
    public boolean validoMovimiento2(Movimiento mov, Tablero tablero) {
        boolean movimientovalido = false;
        if(this.color == false){
            if(mov.esVertical()==true&&
                    mov.saltoVerticalDireccion()<0&&
                    piezamovida==false&&
                    mov.saltoVertical()==2
                    && tablero.devuelvePieza(mov.getPosFinal().getFila(),mov.getPosFinal().getColumna())==null
                    && !this.piezamovida
            ){
                movimientovalido = true;
            } else if(mov.esVertical()==true&&
                    mov.saltoVerticalDireccion()<0&&
                    mov.saltoVertical()==1
                    && tablero.devuelvePieza(mov.getPosFinal().getFila(),mov.getPosFinal().getColumna())==null
            ){
                movimientovalido = true;
            } else if(mov.esDiagonal()&&
                    mov.saltoHorizontal()==mov.saltoVertical()&&
                    mov.saltoVertical()==1&&
                    mov.saltoVerticalDireccion()<0
                    && tablero.devuelvePieza(mov.getPosFinal().getFila(),mov.getPosFinal().getColumna()) != null
                    && tablero.devuelvePieza(mov.getPosFinal().getFila(),mov.getPosFinal().getColumna()).getColor()!=color
            ){
                movimientovalido = true;
            }
        }else if(this.color == true){
            if(mov.esVertical()==true
                    &&mov.saltoVerticalDireccion()>0
                    &&piezamovida==false
                    && mov.saltoVertical()==2
                    && tablero.devuelvePieza(mov.getPosFinal().getFila(),mov.getPosFinal().getColumna())==null
                    && !this.piezamovida
            ){
                movimientovalido = true;
            }else if(mov.esVertical()==true&&
                    mov.saltoVerticalDireccion()>0&&
                    mov.saltoVertical()==1
                    && tablero.devuelvePieza(mov.getPosFinal().getFila(),mov.getPosFinal().getColumna())==null
            ){
                movimientovalido = true;
            }else if(mov.esDiagonal()&&
                    mov.saltoHorizontal()==mov.saltoVertical()&&
                    mov.saltoVertical()==1&&
                    mov.saltoVerticalDireccion()>0
                    && tablero.devuelvePieza(mov.getPosFinal().getFila(),mov.getPosFinal().getColumna()) != null
                    && tablero.devuelvePieza(mov.getPosFinal().getFila(),mov.getPosFinal().getColumna()).getColor()!=color
            ){
                movimientovalido = true;
            }

        }
        return movimientovalido;
    }

    @Override
    public boolean validoMovimiento3(Movimiento mov, Tablero tablero) {
        boolean movimientovalido = false;
        if(this.color == false){
            if(mov.esVertical()==true&&
                    mov.saltoVerticalDireccion()<0&&
                    piezamovida==false&&
                    mov.saltoVertical()==2
                    && tablero.devuelvePieza(mov.getPosFinal().getFila(),mov.getPosFinal().getColumna())==null
                    && !this.piezamovida
            ){
                movimientovalido = true;
            } else if(mov.esVertical()==true&&
                    mov.saltoVerticalDireccion()<0&&
                    mov.saltoVertical()==1
                    && tablero.devuelvePieza(mov.getPosFinal().getFila(),mov.getPosFinal().getColumna())==null
            ){
                movimientovalido = true;
            } else if(mov.esDiagonal()&&
                    mov.saltoHorizontal()==mov.saltoVertical()&&
                    mov.saltoVertical()==1&&
                    mov.saltoVerticalDireccion()<0
                    && tablero.devuelvePieza(mov.getPosFinal().getFila(),mov.getPosFinal().getColumna()) != null
                    && tablero.devuelvePieza(mov.getPosFinal().getFila(),mov.getPosFinal().getColumna()).getColor()==color
            ){
                movimientovalido = true;
            }
        }else if(this.color == true){
            if(mov.esVertical()==true
                    &&mov.saltoVerticalDireccion()>0
                    &&piezamovida==false
                    && mov.saltoVertical()==2
                    && tablero.devuelvePieza(mov.getPosFinal().getFila(),mov.getPosFinal().getColumna())==null
                    && !this.piezamovida
            ){
                movimientovalido = true;
            }else if(mov.esVertical()==true&&
                    mov.saltoVerticalDireccion()>0&&
                    mov.saltoVertical()==1
                    && tablero.devuelvePieza(mov.getPosFinal().getFila(),mov.getPosFinal().getColumna())==null
            ){
                movimientovalido = true;
            }else if(mov.esDiagonal()&&
                    mov.saltoHorizontal()==mov.saltoVertical()&&
                    mov.saltoVertical()==1&&
                    mov.saltoVerticalDireccion()>0
                    && tablero.devuelvePieza(mov.getPosFinal().getFila(),mov.getPosFinal().getColumna()) != null
                    && tablero.devuelvePieza(mov.getPosFinal().getFila(),mov.getPosFinal().getColumna()).getColor()==color
            ){
                movimientovalido = true;
            }

        }
        return movimientovalido;
    }

    @Override
    public void CargarImagen() {
        if(this.color){
            this.getImageView().setImageResource(R.drawable.wp);
            this.getImageView().setRotation(90);
        }else{
            this.getImageView().setImageResource(R.drawable.bp);
            this.getImageView().setRotation(90);
        }
    }

    @Override
    public int getScoreForPieceType() {
        return 10;
    }


}
