package com.example.ajedrez.models;

public class Movimiento {

    private Posicion posInicial;
    private Posicion posFinal;

    public Movimiento() {
    }

    public Movimiento(Posicion posInicial, Posicion posFinal) {
        this.posInicial = posInicial;
        this.posFinal = posFinal;
    }

    public boolean esVertical(){
        boolean a = false;
        if(posInicial.getColumna()==posFinal.getColumna()&&posInicial.getFila()!=posFinal.getFila()){
            a = true;
        }
        return a;
    }

    public boolean esHorizontal(){
        boolean a = false;
        if(posInicial.getFila()==posFinal.getFila()&&posInicial.getColumna()!=posFinal.getColumna()){
            a = true;
        }
        return a;
    }

    public boolean esDiagonal(){
        boolean a =false;
        if(posInicial.getFila()!=posFinal.getFila()&&posInicial.getColumna()!=posFinal.getColumna()&&Math.abs(posFinal.getColumna()-posInicial.getColumna())==Math.abs(posFinal.getFila()-posInicial.getFila())){
            a = true;
        }
        return a;
    }

    public int saltoHorizontal(){
        return Math.abs(posFinal.getColumna()-posInicial.getColumna());
    }

    public int saltoVertical(){
        return Math.abs(posFinal.getFila()-posInicial.getFila());
    }

    public Posicion getPosinicial(){
        return posInicial;
    }

    public Posicion getPosFinal(){
        return posFinal;
    }

    public int saltoHorizontalDireccion(){
        return posFinal.getColumna()-posInicial.getColumna();
    }

    public int saltoVerticalDireccion(){
        return posFinal.getFila()-posInicial.getFila();
    }

    public int saltoDiagonal(){
        int a = 0;
        if(this.esDiagonal()
            && this.saltoVertical() == this.saltoHorizontal()
        ){
            a = this.saltoHorizontal();
        }
        return a;
    }

    @Override
    public String toString() {
        return "Movimiento{" +
                "posInicial=" + posInicial +
                ", posFinal=" + posFinal +
                '}';
    }
}
