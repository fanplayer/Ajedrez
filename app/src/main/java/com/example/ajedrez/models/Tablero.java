package com.example.ajedrez.models;


import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;

import java.util.ArrayList;
import java.util.List;

public class Tablero {

    private Pieza[][] tablero ;
    private boolean turno;
    private Context contexto;


    public Tablero(Pieza[][] tablero, boolean turno) {
        this.tablero = tablero;
        this.turno = turno;
    }

    public Tablero(Tablero tablero, boolean turno, Context contexto){
        this.setTablero(tablero.Renovar(contexto));
        this.setTurno(turno);
    }

    public Tablero(Context context) {
        this.contexto = context;
        tablero = new Pieza[8][8];
        // blancas
        tablero[0][0] = new Torre(true,contexto);
        tablero[0][1] = new Caballo(true,contexto);
        tablero[0][2] = new Alfil(true,contexto);
        tablero[0][3] = new Reina(true,contexto);
        tablero[0][4] = new Rey(true,contexto);
        tablero[0][5] = new Alfil(true,contexto);
        tablero[0][6] = new Caballo(true,contexto);
        tablero[0][7] = new Torre(true,contexto);
        for (int i = 0; i < 8; i++) {
            tablero[1][i] = new Peon(true,contexto);
        }

        // negras
        tablero[7][0] = new Torre(false,contexto);
        tablero[7][1] = new Caballo(false,contexto);
        tablero[7][2] = new Alfil(false,contexto);
        tablero[7][3] = new Reina(false,contexto);
        tablero[7][4] = new Rey(false,contexto);
        tablero[7][5] = new Alfil(false,contexto);
        tablero[7][6] = new Caballo(false,contexto);
        tablero[7][7] = new Torre(false,contexto);
        for (int i = 0; i < 8; i++) {
            tablero[6][i] = new Peon(false,contexto);
        }
        RellenarTablero();
        turno = true;
    }

    public Context getContexto() {
        return contexto;
    }

    public void setContexto(Context contexto) {
        this.contexto = contexto;
    }

    public void RellenarTablero(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (null == this.devuelvePieza(i,j)) {
                    Pieza pieza = new PiezaNula();
                    this.PonPieza(pieza,i,j);
                }
            }
        }
    }

    public Pieza[][] getTablero() {
        return tablero;
    }

    public void setTablero(Pieza[][] tablero) {
        this.tablero = tablero;
    }

    public Tablero Deseleccionar() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (null != this.getTablero()[i][j]) {
                    this.getTablero()[i][j].Deseleccionar();
                }
            }
        }
        return this;
    }

    public boolean ComprobarSeleccionados() {
        int contador = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (null != this.getTablero()[i][j]) {
                    if (this.getTablero()[i][j].isClicked()) {
                        contador += 1;
                    }
                }
            }
        }
        return contador >= 1 ? true : false;
    }

    public Pieza devuelvePieza(int fila, int columna) {
        return this.getTablero()[fila][columna];
    }

    public Pieza devuelvePieza(Posicion pos) {
        return this.getTablero()[pos.getFila()][pos.getColumna()];
    }

    public void PonPieza(Pieza pieza,Posicion pos){
        this.getTablero()[pos.getFila()][pos.getColumna()] = pieza;
    }

    public void PonPieza(Pieza pieza,int i,int j){
        Posicion pos = new Posicion(i,j);
        this.getTablero()[pos.getFila()][pos.getColumna()] = pieza;
    }


    public boolean JaqueBlancas(Posicion pos) {
        boolean a = false;
        if (null != pos) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (null != this.devuelvePieza(i, j)
                            && this.devuelvePieza(i, j).getColor() != this.devuelvePieza(pos.getFila(), pos.getColumna()).getColor()
                            && this.devuelvePieza(i, j).validoMovimiento(new Movimiento(new Posicion(i, j), new Posicion(pos.getFila(), pos.getColumna())), this)
                    ) {
                        a = true;
                    }
                }
            }
        }
        return a;
    }

    public boolean JaqueBlancas2(Posicion pos) {
        boolean a = false;
        if (null == this.devuelvePieza(pos)) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (null != this.devuelvePieza(i, j)) {
                        if (!this.devuelvePieza(i, j).getColor()) {
                            if (this.devuelvePieza(i, j).validoMovimiento2(new Movimiento(new Posicion(i, j), pos), this)) {
                                a = true;  //En esta Posicion decimos que la posicion en cuestion esta en Hacke
                            }
                        }
                    }
                }
            }
        }
        return a;
    }

    public boolean JaqueBlancas3(Posicion pos) {
        boolean a = false;
        if (null != this.devuelvePieza(pos)) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (null != this.devuelvePieza(i, j)) {
                        if (!this.devuelvePieza(i, j).getColor()) {
                            if (this.devuelvePieza(i, j).validoMovimiento3(new Movimiento(new Posicion(i, j), pos), this)
                                    && !this.devuelvePieza(pos).getColor()
                            ) {
                                a = true;  //En esta Posicion decimos que la posicion en cuestion esta en Hacke
                            }
                        }
                    }
                }
            }
        }
        return a;
    }

    public boolean JaqueNegras(Posicion pos) {
        boolean a = false;
        if (null != pos) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (null != this.devuelvePieza(i, j)) {
                        if (this.devuelvePieza(pos) != null
                        ) {
                            if (this.devuelvePieza(i, j).getColor()
                                    && this.devuelvePieza(i, j).validoMovimiento(new Movimiento(new Posicion(i, j), pos), this)
                            ) {
                                a = true;
                            }
                        }
                    }
                }
            }
        }

        return a;
    }

    public boolean JaqueNegras2(Posicion pos) {
        boolean a = false;
        if (null == this.devuelvePieza(pos)) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (null != this.devuelvePieza(i, j)) {
                        if (this.devuelvePieza(i, j).getColor()) {
                            if (this.devuelvePieza(i, j).validoMovimiento2(new Movimiento(new Posicion(i, j), pos), this)) {
                                a = true;  //En esta Posicion decimos que la posicion en cuestion esta en Hacke
                            }
                        }
                    }
                }
            }
        }
        return a;
    }

    public boolean JaqueNegras3(Posicion pos) {
        boolean a = false;
        if (null != this.devuelvePieza(pos)) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (null != this.devuelvePieza(i, j)) {
                        if (this.devuelvePieza(i, j).getColor()) {
                            if (this.devuelvePieza(i, j).validoMovimiento3(new Movimiento(new Posicion(i, j), pos), this)
                                    && this.devuelvePieza(pos).getColor()
                            ) {
                                a = true;  //En esta Posicion decimos que la posicion en cuestion esta en Hacke
                            }
                        }
                    }
                }
            }
        }
        return a;
    }

    public Posicion GetreyBlanco(Tablero tablero) {
        Posicion a = null;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (tablero.devuelvePieza(i, j) == null) {
                } else if (tablero.devuelvePieza(i, j).getClass().getSimpleName().equalsIgnoreCase("Rey") && tablero.devuelvePieza(i, j).getColor() == true) {
                    a = new Posicion(i, j);
                }
            }
        }

        return a;
    }

    public Posicion GetreyNegro(Tablero tablero) {
        Posicion a = null;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (tablero.devuelvePieza(i, j) == null) {
                } else if (tablero.devuelvePieza(i, j).getClass().getSimpleName().equalsIgnoreCase("Rey") && tablero.devuelvePieza(i, j).getColor() == false) {
                    a = new Posicion(i, j);
                }
            }
        }

        return a;
    }

    public boolean PosibilidaddeCobertura(Tablero tablero, Posicion posicionrey) {
        boolean respuesta = false;
        Posicion posicionpiezaquehacehacke = GetPiezaQueHaceJaque(posicionrey);
        if (null != posicionpiezaquehacehacke) {
            Movimiento mov = new Movimiento(posicionpiezaquehacehacke, posicionrey);
            List<Posicion> posiciones = GetPosicionesEntreMedias(mov, tablero);
            posiciones.add(posicionpiezaquehacehacke);
            if (null != posiciones) {
                for (int l = 0; l < posiciones.size(); l++) {
                    Posicion posicion = posiciones.get(l);
                    if (null == this.devuelvePieza(posicion)) {
                        for (int i = 0; i < 8; i++) {
                            for (int j = 0; j < 8; j++) {
                                if (null != tablero.devuelvePieza(i, j)
                                        && tablero.devuelvePieza(i, j).getColor() == tablero.devuelvePieza(posicionrey).getColor()
                                        && tablero.devuelvePieza(i, j).validoMovimiento(new Movimiento(new Posicion(i, j), posicion), tablero)
                                        && !tablero.devuelvePieza(i, j).getClass().getSimpleName().equals("Rey")
                                ) {
                                    respuesta = true;
                                }
                            }
                        }
                    } else {
                        for (int i = 0; i < 8; i++) {
                            for (int j = 0; j < 8; j++) {
                                if (null != tablero.devuelvePieza(i, j)
                                        && tablero.devuelvePieza(i, j).getColor() == tablero.devuelvePieza(posicionrey).getColor()
                                        && tablero.devuelvePieza(i, j).validoMovimiento(new Movimiento(new Posicion(i, j), posicion), tablero)
                                        && !tablero.devuelvePieza(i, j).getClass().getSimpleName().equals("Rey")
                                ) {
                                    respuesta = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return respuesta;
    }

    public boolean JaqueMateReyBlanco() {
        boolean bol = false;
        Posicion a = new Posicion(0, 0);
        a = this.GetreyBlanco(this);
        if (null != a) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (!this.devuelvePieza(i, j).getClass().getSimpleName().equals("PiezaNula")
                        &&!this.devuelvePieza(i, j).getClass().getSimpleName().equals("PiezaPosible")
                    ) {
                        if (!this.devuelvePieza(i, j).getColor()
                                && !this.PosibilidaddeCobertura(this, a)
                                && this.GetDistanciaMayorqueUno(new Movimiento(new Posicion(i, j), a))
                                && this.devuelvePieza(new Posicion(i, j)).validoMovimiento(new Movimiento(new Posicion(i, j), a), this)
                                && this.JaqueBlancas(a)
                                && !CalcularSiHayMovimientosPosiblesBlancas(a)
                        ) {
                            bol = true;
                        }
                        if (!this.devuelvePieza(i, j).getColor()
                                && !turno
                                && this.JaqueBlancas(a)
                                && this.devuelvePieza(new Posicion(i, j)).validoMovimiento(new Movimiento(new Posicion(i, j), a), this)
                        ) {
                            bol = true;
                        }
                        if (!this.devuelvePieza(i, j).getColor()
                                && this.devuelvePieza(new Posicion(i, j)).validoMovimiento(new Movimiento(new Posicion(i, j), a), this)
                                && this.JaqueBlancas(a)
                                && turno
                                && !CalcularSiHayMovimientosPosiblesBlancas(a)
                                && !this.PosibilidaddeCobertura(this, a)
                                && this.GetDistanciaMayorqueUno(new Movimiento(new Posicion(i, j), a))
                        ) {
                            bol = true;
                        }
                        if (!this.GetDistanciaMayorqueUno(new Movimiento(new Posicion(i, j), a))
                                && !turno
                                && !this.devuelvePieza(i, j).getColor()
                                && this.devuelvePieza(new Posicion(i, j)).validoMovimiento(new Movimiento(new Posicion(i, j), a), this)
                        ) {
                            bol = true;
                        }
                        if (!this.GetDistanciaMayorqueUno(new Movimiento(new Posicion(i, j), a))
                                && turno
                                && !CalcularSiHayMovimientosPosiblesBlancas(a)
                                && !this.devuelvePieza(i, j).getColor()
                                && this.devuelvePieza(new Posicion(i, j)).validoMovimiento(new Movimiento(new Posicion(i, j), a), this)
                                && !CalcularSiHayMovimimentosPosibles2Blancas(a)
                                && !this.PosibilidaddeCobertura(this, a)
                        ) {
                            bol = true;
                        }

                    }
                }
            }
        }
        return bol;
    }

    public boolean JaqueMateReyNegro() {
        boolean bol = false;
        Posicion a = new Posicion(0, 0);
        a = this.GetreyNegro(this);
        if (null != a) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (!this.devuelvePieza(i, j).getClass().getSimpleName().equals("PiezaNula")
                            &&!this.devuelvePieza(i, j).getClass().getSimpleName().equals("PiezaPosible")
                    ) {
                        if (this.devuelvePieza(i, j).getColor()
                                && !this.PosibilidaddeCobertura(this, a)
                                && this.GetDistanciaMayorqueUno(new Movimiento(new Posicion(i, j), a))
                                && this.devuelvePieza(new Posicion(i, j)).validoMovimiento(new Movimiento(new Posicion(i, j), a), this)
                                && this.JaqueNegras(a)
                                && !CalcularSiHayMovimientosPosiblesNegras(a)
                        ) {
                            bol = true;
                        }
                        if (this.devuelvePieza(i, j).getColor()
                                && turno
                                && this.JaqueNegras(a)
                                && this.devuelvePieza(new Posicion(i, j)).validoMovimiento(new Movimiento(new Posicion(i, j), a), this)
                        ) {
                            bol = true;
                        }
                        if (this.devuelvePieza(i, j).getColor()
                                && this.devuelvePieza(new Posicion(i, j)).validoMovimiento(new Movimiento(new Posicion(i, j), a), this)
                                && this.JaqueNegras(a)
                                && !turno
                                && !CalcularSiHayMovimientosPosiblesNegras(a)
                                && !this.PosibilidaddeCobertura(this, a)
                                && this.GetDistanciaMayorqueUno(new Movimiento(new Posicion(i, j), a))
                        ) {
                            bol = true;
                        }
                        if (!this.GetDistanciaMayorqueUno(new Movimiento(new Posicion(i, j), a))
                                && turno
                                && this.devuelvePieza(i, j).getColor()
                                && this.devuelvePieza(new Posicion(i, j)).validoMovimiento(new Movimiento(new Posicion(i, j), a), this)
                        ) {
                            bol = true;
                        }
                        if (!this.GetDistanciaMayorqueUno(new Movimiento(new Posicion(i, j), a))
                                && !turno
                                && !CalcularSiHayMovimientosPosiblesNegras(a)
                                && this.devuelvePieza(i, j).getColor()
                                && this.devuelvePieza(new Posicion(i, j)).validoMovimiento(new Movimiento(new Posicion(i, j), a), this)
                                && !CalcularSiHayMovimimentosPosibles2Negras(a)
                                && !this.PosibilidaddeCobertura(this, a)
                        ) {
                            bol = true;
                        }

                    }
                }
            }
        }
        return bol;
    }

    public List<Posicion> GetPosicionesEntreMedias(Movimiento mov, Tablero tab) {
        List<Posicion> lista = new ArrayList<>();
        if (mov.getPosinicial() != null) {
            if (mov.esHorizontal() == true && mov.saltoHorizontal() > 1) {
                if (mov.getPosinicial().getColumna() < mov.getPosFinal().getColumna()) {
                    for (int i = 1; i < mov.saltoHorizontal(); i++) {
                        if (tab.getTablero()[mov.getPosinicial().getFila()][mov.getPosinicial().getColumna() + i] == null) {
                            lista.add(new Posicion(mov.getPosinicial().getFila(), mov.getPosinicial().getColumna() + i));
                        }
                    }
                } else if (mov.getPosinicial().getColumna() > mov.getPosFinal().getColumna()) {
                    for (int i = 1; i < mov.saltoHorizontal(); i++) {
                        if (tab.getTablero()[mov.getPosinicial().getFila()][mov.getPosinicial().getColumna() - i] == null) {
                            lista.add(new Posicion(mov.getPosinicial().getFila(), mov.getPosinicial().getColumna() - i));
                        }
                    }
                }
            }
            if (mov.esVertical() == true && mov.saltoVertical() > 1) {
                if (mov.getPosinicial().getFila() < mov.getPosFinal().getFila()) {
                    for (int i = 1; i < mov.saltoVertical(); i++) {
                        if (tab.getTablero()[mov.getPosinicial().getFila() + i][mov.getPosinicial().getColumna()] == null) {
                            lista.add(new Posicion(mov.getPosinicial().getFila() + i, mov.getPosinicial().getColumna()));
                        }
                    }
                }
                if (mov.getPosinicial().getFila() > mov.getPosFinal().getFila()) {
                    for (int i = 1; i < mov.saltoVertical(); i++) {
                        if (tab.getTablero()[mov.getPosinicial().getFila() - i][mov.getPosinicial().getColumna()] == null) {
                            lista.add(new Posicion(mov.getPosinicial().getFila() - i, mov.getPosinicial().getColumna()));
                        }
                    }
                }
            }
            if (mov.esDiagonal() == true && mov.saltoDiagonal() > 1) {
                if (mov.getPosFinal().getFila() < mov.getPosinicial().getFila() && mov.getPosFinal().getColumna() > mov.getPosinicial().getColumna()) {
                    for (int i = 1; i < mov.saltoHorizontal(); i++) {
                        if (tab.getTablero()[mov.getPosinicial().getFila() - i][mov.getPosinicial().getColumna() + i] == null) {
                            lista.add(new Posicion(mov.getPosinicial().getFila() - i, mov.getPosinicial().getColumna() + i));
                        }
                    }
                }
                if (mov.getPosFinal().getFila() > mov.getPosinicial().getFila() && mov.getPosFinal().getColumna() < mov.getPosinicial().getColumna()) {
                    for (int i = 1; i < mov.saltoHorizontal(); i++) {
                        if (tab.getTablero()[mov.getPosinicial().getFila() + i][mov.getPosinicial().getColumna() - i] == null) {
                            lista.add(new Posicion(mov.getPosinicial().getFila() + i, mov.getPosinicial().getColumna() - i));
                        }
                    }
                }
                if (mov.getPosFinal().getFila() < mov.getPosinicial().getFila() && mov.getPosFinal().getColumna() < mov.getPosinicial().getColumna()) {
                    for (int i = 1; i < mov.saltoHorizontal(); i++) {
                        if (tab.getTablero()[mov.getPosinicial().getFila() - i][mov.getPosinicial().getColumna() - i] == null) {
                            lista.add(new Posicion(mov.getPosinicial().getFila() - i, mov.getPosinicial().getColumna() - i));
                        }
                    }
                }
                if (mov.getPosFinal().getFila() > mov.getPosinicial().getFila() && mov.getPosFinal().getColumna() > mov.getPosinicial().getColumna()) {
                    for (int i = 1; i < mov.saltoHorizontal(); i++) {
                        if (tab.getTablero()[mov.getPosinicial().getFila() + i][mov.getPosinicial().getColumna() + i] == null) {
                            lista.add(new Posicion(mov.getPosinicial().getFila() + i, mov.getPosinicial().getColumna() + i));
                        }
                    }
                }
            }
        }
        return lista;
    }

    public Posicion GetPiezaQueHaceJaque(Posicion pos) {
        Posicion a = null;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (null != this.devuelvePieza(i, j)
                        && this.devuelvePieza(i, j).getColor() != this.devuelvePieza(pos).getColor()
                        && this.devuelvePieza(i, j).validoMovimiento(new Movimiento(new Posicion(i, j), pos), this)
                ) {
                    a = new Posicion(i, j);
                }
            }

        }
        return a;
    }

    public int GetDistanciaEntrePiezas(Movimiento movimiento) {
        int respuesta = 0;
        if (movimiento.esHorizontal()) {
            respuesta = movimiento.saltoHorizontal();
        } else if (movimiento.esVertical()) {
            respuesta = movimiento.saltoVertical();
        } else if (movimiento.esDiagonal()) {
            respuesta = movimiento.saltoDiagonal();
        }
        return respuesta;
    }

    public boolean GetDistanciaMayorqueUno(Movimiento movimiento) {
        boolean respuesta = false;
        if (movimiento.esHorizontal()) {
            if (movimiento.saltoHorizontal() > 1) {
                respuesta = true;
            }
        } else if (movimiento.esVertical()) {
            if (movimiento.saltoVertical() > 1) {
                respuesta = true;
            }
        } else if (movimiento.esDiagonal()) {
            if (movimiento.saltoDiagonal() > 1) {
                respuesta = true;
            }
        }
        return respuesta;
    }

    public boolean isTurno() {
        return turno;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
    }

    public boolean CalcularSiHayMovimientosPosiblesNegras(Posicion posicion) {
        boolean respuesta = false;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (this.devuelvePieza(posicion) != null
                        && this.devuelvePieza(new Posicion(i, j)) == null
                ) {
                    if (this.devuelvePieza(posicion).validoMovimiento(new Movimiento(posicion, new Posicion(i, j)), this)) {
                        if (!this.JaqueNegras2(new Posicion(i, j))
                        ) {
                            respuesta = true;
                        }
                    }
                }
            }
        }
        return respuesta;
    }

    public boolean CalcularSiHayMovimientosPosiblesBlancas(Posicion posicion) {
        boolean respuesta = false;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (this.devuelvePieza(posicion) != null
                        && this.devuelvePieza(new Posicion(i, j)) == null
                ) {
                    if (this.devuelvePieza(posicion).validoMovimiento(new Movimiento(posicion, new Posicion(i, j)), this)) {
                        if (!this.JaqueBlancas2(new Posicion(i, j))
                        ) {
                            respuesta = true;
                        }
                    }
                }
            }
        }
        return respuesta;
    }

    public boolean CalcularSiHayMovimimentosPosibles2Negras(Posicion posisionRey) {
        boolean respuesta = false;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (this.devuelvePieza(posisionRey) != null
                        && this.devuelvePieza(new Posicion(i, j)) != null
                ) {
                    if (this.devuelvePieza(posisionRey).validoMovimiento(new Movimiento(posisionRey, new Posicion(i, j)), this)) {
                        if (!this.JaqueNegras3(new Posicion(i, j))
                        ) {
                            respuesta = true;
                        }
                    }
                }
            }
        }
        return respuesta;
    }

    public boolean CalcularSiHayMovimimentosPosibles2Blancas(Posicion posisionRey) {
        boolean respuesta = false;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (this.devuelvePieza(posisionRey) != null
                        && this.devuelvePieza(new Posicion(i, j)) != null
                ) {
                    if (this.devuelvePieza(posisionRey).validoMovimiento(new Movimiento(posisionRey, new Posicion(i, j)), this)) {
                        if (!this.JaqueBlancas3(new Posicion(i, j))
                        ) {
                            respuesta = true;
                        }
                    }
                }
            }
        }
        return respuesta;
    }

    public List<Movimiento> GetTodoslosMovimientosPosibles(boolean color) {
        List<Movimiento> movimientos = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (!this.devuelvePieza(i, j).getClass().getSimpleName().equals("PiezaNula")
                        &&!this.devuelvePieza(i,j).getClass().getSimpleName().equals("PiezaPosible")
                        && this.devuelvePieza(i, j).getColor() == color
                ) {
                    for (int k = 0; k < 8; k++) {
                        for (int l = 0; l < 8; l++) {


                            Movimiento mov = new Movimiento(new Posicion(i, j), new Posicion(k, l));
                            if (this.devuelvePieza(i, j).validoMovimiento(mov, this)) {
                                movimientos.add(mov);
                            }
                        }
                    }
                }
            }
        }
        return movimientos;
    }

    public Pieza MoverIA(Movimiento mov) {
        Pieza pieza = null;
        if(!this.devuelvePieza(mov.getPosFinal()).getClass().getSimpleName().equals("PiezaNula")){
            pieza = this.devuelvePieza(mov.getPosFinal().getFila(),mov.getPosFinal().getColumna());
        }
        this.getTablero()[mov.getPosFinal().getFila()][mov.getPosFinal().getColumna()] = this.getTablero()[mov.getPosinicial().getFila()][mov.getPosinicial().getColumna()];
        this.getTablero()[mov.getPosinicial().getFila()][mov.getPosinicial().getColumna()] = new PiezaNula();
        return pieza;
    }

    public void RevomIA(Movimiento mov,Pieza pieza){
        this.getTablero()[mov.getPosinicial().getFila()][mov.getPosinicial().getColumna()] = this.getTablero()[mov.getPosFinal().getFila()][mov.getPosFinal().getColumna()];
        this.getTablero()[mov.getPosFinal().getFila()][mov.getPosFinal().getColumna()] = new PiezaNula();

        if(null != pieza
            &&!pieza.getClass().getSimpleName().equals("PiezaNula")
        ){
            this.getTablero()[mov.getPosFinal().getFila()][mov.getPosFinal().getColumna()] = pieza;
        }
    }

    public Pieza BorrarPieza(Posicion pos){
        Pieza pieza = null;
        if(!this.devuelvePieza(pos).getClass().getSimpleName().equals("PiezaNula")){
            pieza = this.devuelvePieza(pos);
            tablero[pos.getFila()][pos.getColumna()] = new PiezaNula();
        }
        return pieza;
    }

    public void Mover(Movimiento mov){
        if(!this.devuelvePieza(mov.getPosinicial()).getClass().getSimpleName().equals("PiezaNula")
            && this.devuelvePieza(mov.getPosFinal()).getClass().getSimpleName().equals("PiezaPosible")
        ){
            this.PonPieza(this.BorrarPieza(mov.getPosinicial()),mov.getPosFinal());
        }else if(!this.devuelvePieza(mov.getPosinicial()).getClass().getSimpleName().equals("PiezaNula")
                &&!this.devuelvePieza(mov.getPosFinal()).getClass().getSimpleName().equals("PiezaPosible")
        ){
            this.PonPieza(this.BorrarPieza(mov.getPosinicial()),mov.getPosFinal());
        }
    }

    public void DeseleccionarTodo(){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(!this.devuelvePieza(i,j).getClass().getSimpleName().equals("PiezaNula")){
                    this.devuelvePieza(i,j).getImageView().clearColorFilter();
                    this.devuelvePieza(i,j).setClicked(false);
                }
            }
        }
    }

    public void GenerarMovimientosPosibles(Posicion posicion,Context context){
        for(int i=0;i<8;i++) {
            for (int j = 0; j < 8; j++) {
                if(null != this.devuelvePieza(i,j)){
                    if(this.devuelvePieza(i,j).validoMovimiento(new Movimiento(posicion,new Posicion(i,j)),this)) {
                        if(this.devuelvePieza(i,j) != null) {
                            this.devuelvePieza(i, j).getImageView().setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_ATOP);
                        }else{
                            Pieza pieza = new PiezaNula(true,context);
                            this.PonPieza(pieza,i,j);
                        }
                    }
                }
            }
        }
    }

    public void GenerarMovimientosPosibles(int a,int b,Context context){
        Posicion posicion = new Posicion(a,b);
        for(int i=0;i<8;i++) {
            for (int j = 0; j<8; j++) {
                if(!this.devuelvePieza(posicion).getClass().getSimpleName().equals("PiezaNula")){
                    if(this.devuelvePieza(posicion).validoMovimiento(new Movimiento(posicion,new Posicion(i,j)),this)) {
                        if(!this.devuelvePieza(i,j).getClass().getSimpleName().equals("PiezaNula")
                            &&!this.devuelvePieza(i,j).getClass().getSimpleName().equals("PiezaPosible")
                        ) {
                            this.devuelvePieza(i, j).getImageView().setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_ATOP);
                        }else{
                            Pieza pieza = new PiezaPosible(true,context);
                            this.PonPieza(pieza,i,j);
                        }
                    }
                }
            }
        }
    }

    public void LimpiarmovPosibles(Context context){
        for(int i=0;i<8;i++) {
            for (int j = 0; j < 8; j++) {
                if(this.devuelvePieza(i,j).getClass().getSimpleName().equals("PiezaPosible")){
                    Pieza pieza = new PiezaNula(true,context);
                    this.PonPieza(pieza,i,j);
                }
            }
        }
    }

    public Posicion EncontrarlaPiezaAzul(){
        Posicion posicion = null;
        for(int i=0;i<8;i++) {
            for (int j = 0; j < 8; j++) {
                if(this.devuelvePieza(i,j).isClicked()){
                    posicion = new Posicion(i,j);
                }
            }
        }
        return posicion;
    }

    public Pieza[][] Renovar(Context contexto){
        Pieza[][] piezas = new Pieza[8][8];
        for(int i=0;i<8;i++) {
            for (int j = 0; j < 8; j++) {
                Posicion posicion = new Posicion(i,j);
                Pieza pieza = this.devuelvePieza(posicion);
                if(this.devuelvePieza(posicion).getClass().getSimpleName().equals("Alfil")){
                    piezas[i][j] = new Alfil(pieza.getColor(),contexto);
                    piezas[i][j].piezamovida = pieza.piezamovida;
                }else if(this.devuelvePieza(posicion).getClass().getSimpleName().equals("Caballo")){
                    piezas[i][j] = new Caballo(pieza.getColor(),contexto);
                    piezas[i][j].piezamovida = pieza.piezamovida;
                }else if(this.devuelvePieza(posicion).getClass().getSimpleName().equals("Peon")){
                    piezas[i][j] = new Peon(pieza.getColor(),contexto);
                    piezas[i][j].piezamovida = pieza.piezamovida;
                }else if(this.devuelvePieza(posicion).getClass().getSimpleName().equals("PiezaNula")){
                    piezas[i][j] = new PiezaNula(pieza.getColor(),contexto);
                    piezas[i][j].piezamovida = pieza.piezamovida;
                }else if(this.devuelvePieza(posicion).getClass().getSimpleName().equals("PiezaPosible")){
                    piezas[i][j] = new PiezaPosible(pieza.getColor(),contexto);
                    piezas[i][j].piezamovida = pieza.piezamovida;
                }else if(this.devuelvePieza(posicion).getClass().getSimpleName().equals("Reina")){
                    piezas[i][j] = new Reina(pieza.getColor(),contexto);
                    piezas[i][j].piezamovida = pieza.piezamovida;
                }else if(this.devuelvePieza(posicion).getClass().getSimpleName().equals("Rey")){
                    piezas[i][j] = new Rey(pieza.getColor(),contexto);
                    piezas[i][j].piezamovida = pieza.piezamovida;
                }else if(this.devuelvePieza(posicion).getClass().getSimpleName().equals("Torre")){
                    piezas[i][j] = new Torre(pieza.getColor(),contexto);
                    piezas[i][j].piezamovida = pieza.piezamovida;
                }
            }
        }
        return piezas;
    }
}
