package com.example.ajedrez.activities;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ajedrez.R;
import com.example.ajedrez.models.ColorFiltro;
import com.example.ajedrez.models.Movimiento;
import com.example.ajedrez.models.Pieza;
import com.example.ajedrez.models.PiezaNula;
import com.example.ajedrez.models.Posicion;
import com.example.ajedrez.models.Tablero;

public class TercerActivity extends AppCompatActivity {

    private Tablero tablero;
    private LinearLayout parent;
    private TextView turno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercer);

        turno = findViewById(R.id.turno);

        parent = findViewById(R.id.linearlayout);

        tablero = new Tablero(getApplication());

        RellenarTablero();

    }

    public void RellenarTablero(){
        for(int i=0;i<8;i++){
            LinearLayout layout2 =  new LinearLayout(getBaseContext());
            layout2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
            layout2.setOrientation(LinearLayout.VERTICAL);
            LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) layout2.getLayoutParams();
            lp.weight = (float) 100f;
            layout2.setLayoutParams(lp);
            parent.addView(layout2);
            for(int j=0;j<8;j++){

                if(!tablero.devuelvePieza(i,j).getClass().getSimpleName().equals("PiezaNula")
                ){
                    tablero.devuelvePieza(i,j).getImageView().setLayoutParams(lp);

                    tablero.devuelvePieza(i,j).getImageView().setTag(i+"-"+j);
                    int finalI = i;
                    int finalJ = j;
                    tablero.devuelvePieza(i,j).getImageView().setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Pieza pieza = tablero.devuelvePieza(finalI,finalJ);
                            if(pieza.isClicked()
                                && pieza.getColor()
                                    && tablero.isTurno()
                            ){

                                pieza.getImageView().clearColorFilter();
                                tablero.LimpiarmovPosibles(getBaseContext());
                                tablero.DeseleccionarTodo();
                                pieza.setClicked(false);


                                parent.removeAllViews();
                                RellenarTablero();


                            }else{

                                if(pieza.getClass().getSimpleName().equals("PiezaPosible")
                                    && tablero.isTurno()
                                ){
                                    Posicion finnal = new Posicion(finalI,finalJ);
                                    Posicion inicial = tablero.EncontrarlaPiezaAzul();
                                    Movimiento mov = new Movimiento(inicial,finnal);
                                    tablero.devuelvePieza(inicial).PiezaMovida();
                                    tablero.Mover(mov);
                                    tablero.setTurno(false);
                                    tablero.DeseleccionarTodo();
                                    tablero.LimpiarmovPosibles(getBaseContext());
                                    pieza.setClicked(true);

                                }else if(!pieza.getClass().getSimpleName().equals("PiezaNula")
                                        && !pieza.getClass().getSimpleName().equals("PiezaPosible")
                                        && pieza.getColor()
                                        && tablero.isTurno()
                                ){
                                    tablero.DeseleccionarTodo();
                                    tablero.LimpiarmovPosibles(getBaseContext());
                                    pieza.setClicked(true);
                                    pieza.getImageView().setColorFilter(ColorFiltro.BLUE);
                                    tablero.GenerarMovimientosPosibles(finalI,finalJ,getBaseContext());
                                }else if(!pieza.getColor()
                                        &&!pieza.getClass().getSimpleName().equals("PiezaPosible")
                                        &&!pieza.getClass().getSimpleName().equals("PiezaNula")
                                        &&tablero.isTurno()
                                        &&null != tablero.EncontrarlaPiezaAzul()
                                ){
                                    Posicion finnal = new Posicion(finalI,finalJ);
                                    Posicion inicial = tablero.EncontrarlaPiezaAzul();
                                    Movimiento mov = new Movimiento(inicial,finnal);
                                    tablero.devuelvePieza(inicial).PiezaMovida();
                                    tablero.Mover(mov);
                                    tablero.setTurno(false);
                                    tablero.DeseleccionarTodo();
                                    tablero.LimpiarmovPosibles(getBaseContext());

                                }

                                parent.removeAllViews();
                                RellenarTablero();

                            }
                        }
                    });

                }else {
                    Pieza pieza = new PiezaNula(true,getBaseContext());
                    pieza.getImageView().setLayoutParams(lp);
                    tablero.PonPieza(pieza,i,j);
                    layout2.addView(pieza.getImageView());
                }
                if(tablero.devuelvePieza(i,j).getImageView().getParent() != null) {
                    ((ViewGroup) tablero.devuelvePieza(i, j).getImageView().getParent()).removeView(tablero.devuelvePieza(i, j).getImageView());
                }
                layout2.addView(tablero.devuelvePieza(i,j).getImageView());
                parent.setRotation(270);
            }


        }
        if(tablero.isTurno()){
            turno.setText(R.string.turnoblancas);
        }else{
            turno.setText(R.string.turnonegras);
        }
    }


}